package com.example.kakao_clone.feature.user.domain;

//import com.example.kakao_clone.feature.chat.domain.Chat;
//import com.example.kakao_clone.feature.friend.domain.Friend;
import com.example.kakao_clone.feature.friend.domain.Friend;
import com.example.kakao_clone.global.auth.domain.Role;

import com.example.kakao_clone.feature.participant.entity.Participant;
import com.example.kakao_clone.global.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Role role;

    private String userId;

    private String password;

    private String name;

    private String statusMessage;

    private String profileImageUrl;

    private String backgroundImageUrl;

    private LocalDateTime lastLoginDate;


    @OneToMany(mappedBy = "kakaoId")
    private List<Friend> friendList = new ArrayList<>();

    @OneToMany(mappedBy = "userId")
    private List<Participant> participant=new ArrayList<>();
    public void addParticipant(Participant participants) {
        participant.add(participants);
    }
}