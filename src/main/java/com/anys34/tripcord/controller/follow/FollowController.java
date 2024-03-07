package com.anys34.tripcord.controller.follow;

import com.anys34.tripcord.dto.follow.AddFollowRequest;
import com.anys34.tripcord.dto.follow.FollowResponse;
import com.anys34.tripcord.service.follow.DeleteFollowService;
import com.anys34.tripcord.service.follow.GetFromUserFollowService;
import com.anys34.tripcord.service.follow.GetToUserFollowService;
import com.anys34.tripcord.service.follow.PostFollowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void addFollow(@RequestBody @Valid AddFollowRequest request) { addFollowService.execute(request.getEmail()); }

    @GetMapping("/to")
    public List<FollowResponse> getToUserFollow(@RequestBody @Valid AddFollowRequest request) {
        return getToUserFollowService.execute(request.getEmail());
    }

    @GetMapping("/from")
    public List<FollowResponse> getFromUserFollow(@RequestBody @Valid AddFollowRequest request) {
        return getFromUserFollowService.execute(request.getEmail());
    }

    @DeleteMapping
    public void deleteFollow(@RequestBody @Valid AddFollowRequest request) {
        deleteFollowService.execute(request.getEmail());
    }
}