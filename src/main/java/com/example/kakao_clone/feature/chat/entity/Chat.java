package com.example.kakao_clone.feature.chat.entity;

import com.example.kakao_clone.feature.room.entity.Room;
import com.example.kakao_clone.global.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CHAT")
public class Chat extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room roomId;
    @Column(nullable = false)
    private Integer sendUserId;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private Integer notRead;
}
