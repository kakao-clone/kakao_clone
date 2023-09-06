package com.example.kakao_clone.feature.friend.domain;

import com.example.kakao_clone.feature.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kakao_id")
    private User kakaoId;

    private String friendKakaoId;

    private String friendName;

}