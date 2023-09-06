package com.example.kakao_clone.feature.participant.entity;

import com.example.kakao_clone.feature.room.entity.Room;
import com.example.kakao_clone.feature.user.domain.User;
import com.example.kakao_clone.global.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PARTICIPANT")
public class Participant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room roomId;
    @Column(nullable = false)
    private String roomName;
    @Column(nullable = false)
    private Integer notReadChat;
    @Column
    private Integer lastReadChatId;
}
