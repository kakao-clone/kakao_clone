package com.example.kakao_clone.feature.participant.mapper;

import com.example.kakao_clone.feature.participant.entity.Participant;
import com.example.kakao_clone.feature.room.entity.Room;
import com.example.kakao_clone.feature.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParticipantMapper {
    default Participant participantToParticipantResponseDto(User user, Room room, String RoomName) {
        Participant participant=new Participant();
        participant.setUserId(user);
        participant.setRoomId(room);
        participant.setRoomName(RoomName);
        participant.setNotReadChat(0);
        //participantRepository.save(participant);
        return participant;
    }
}
