package com.anys34.tripcord.controller.follow;

import com.anys34.tripcord.domain.follow.Follow;
import com.anys34.tripcord.service.follow.DeleteFollowService;
import com.anys34.tripcord.service.follow.GetFromUserFollowService;
import com.anys34.tripcord.service.follow.GetToUserFollowService;
import com.anys34.tripcord.service.follow.PostFollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {
    private final PostFollowService addFollowService;
    private final GetToUserFollowService getToUserFollowService;
    private final GetFromUserFollowService getFromUserFollowService;
    private final DeleteFollowService deleteFollowService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addFollow(@RequestParam("email") String email) { addFollowService.execute(email); }

    @GetMapping("/to")
    public Optional<List<Follow>> getToUserFollow(@RequestParam("email") String email) {
        return getToUserFollowService.execute(email);
    }

    @GetMapping("/from")
    public Optional<List<Follow>> getFromUserFollow(@RequestParam("email") String email) {
        return getFromUserFollowService.execute(email);
    }

    @DeleteMapping
    public void deleteFollow(@RequestParam("email") String email) {
        deleteFollowService.execute(email);
    }
}