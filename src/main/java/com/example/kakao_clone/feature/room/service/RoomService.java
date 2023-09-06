package com.example.kakao_clone.feature.room.service;

import com.example.kakao_clone.feature.participant.entity.Participant;
import com.example.kakao_clone.feature.participant.mapper.ParticipantMapper;
import com.example.kakao_clone.feature.participant.repository.ParticipantRepository;
import com.example.kakao_clone.feature.room.entity.Room;
import com.example.kakao_clone.feature.room.repository.RoomRepository;
import com.example.kakao_clone.feature.user.domain.User;
import com.example.kakao_clone.feature.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final ParticipantRepository participantRepository;
    private final UserRepository userRepository;
    private final ParticipantMapper participantMapper;

    public void createRoom(List<Long> CheckedList){
        Room room = new Room();
        room.setType("numerous");
        StringBuilder roomNameBuilder = new StringBuilder();
        for (int i = 0; i < CheckedList.size() - 1; i++) {
            User user = userRepository.findById(CheckedList.get(i)).orElse(null);
            if (user != null) {
                roomNameBuilder.append(user.getName()).append(", ");
            }
        }
        if (!CheckedList.isEmpty()) {
            User lastUser = userRepository.findById(CheckedList.get(CheckedList.size() - 1)).orElse(null);
            if (lastUser != null) {
                roomNameBuilder.append(lastUser.getName());
            }
        }
        String roomName = roomNameBuilder.toString();
        for (Long id : CheckedList){
            User user = userRepository.findById(id).orElse(null);
            if (user != null) {
                Participant participant=new Participant();
                participant.setUserId(user);
                participant.setRoomId(room);
                participant.setRoomName(roomName);
                participant.setNotReadChat(0);
                //Participant participant = participantMapper.participantToParticipantResponseDto(user, room, roomName);
                //participantRepository.save(participant);
                user.addParticipant(participant);
                userRepository.save(user);
                room.addParticipant(participant);
                participantRepository.save(participant);
            }
        }
        roomRepository.save(room);
    }
}
