package com.example.kakao_clone.feature.participant.repository;

import com.example.kakao_clone.feature.participant.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
