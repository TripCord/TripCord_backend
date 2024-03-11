package com.anys34.tripcord.domain.user;

import com.anys34.tripcord.domain.follow.Follow;
import com.anys34.tripcord.type.user.Provider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String nickname;

    @JsonIgnore
    private String password;

    @Column(name = "profile_img")
    private String profileImg;

    private Provider provider;

    @JsonIgnore
    @OneToMany(mappedBy = "fromUser", cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Follow> toFromList;

    @Builder
    public User(String email, String nickname, String password, String profileImg, Provider provider) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.profileImg = profileImg;
        this.provider = provider;
    }
}
