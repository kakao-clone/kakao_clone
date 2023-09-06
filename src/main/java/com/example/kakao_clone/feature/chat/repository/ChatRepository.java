package com.example.kakao_clone.feature.chat.repository;

import com.example.kakao_clone.feature.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
}
