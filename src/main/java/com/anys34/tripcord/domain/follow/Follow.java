package com.anys34.tripcord.domain.follow;

import com.anys34.tripcord.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "to_user")
    private String toUser;

    @ManyToOne
    @JoinColumn(name = "from_user", referencedColumnName = "email")
    private User fromUser;

    @Builder
    public Follow(String toUser, User fromUser) {
        this.toUser = toUser;
        this.fromUser = fromUser;
    }
}