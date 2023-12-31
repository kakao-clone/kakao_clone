package com.example.kakao_clone.feature.participant.domain;

import com.example.kakao_clone.global.common.BaseEntity;
import com.example.kakao_clone.feature.room.domain.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Participant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private String roomName;

    private Integer notReadChat;

    private Long lastChatId;


}
