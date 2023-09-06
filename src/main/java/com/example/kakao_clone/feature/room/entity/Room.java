package com.example.kakao_clone.feature.room.entity;

import com.example.kakao_clone.feature.chat.entity.Chat;
import com.example.kakao_clone.feature.participant.entity.Participant;
import com.example.kakao_clone.global.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ROOM")
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "roomId")
    private List<Participant> participant=new ArrayList<>();
    public void addParticipant(Participant participants) {participant.add(participants);}
    @OneToMany(mappedBy = "roomId")
    private List<Chat> chat=new ArrayList<>();
    public void addChat(Chat chats) {chat.add(chats);}
    @Column(nullable = false,columnDefinition = "VARCHAR(15)")
    private String type;
    @Column
    private String lastChat;
}
