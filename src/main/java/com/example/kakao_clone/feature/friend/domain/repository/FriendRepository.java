package com.example.kakao_clone.feature.friend.domain.repository;

import com.example.kakao_clone.feature.friend.domain.Friend;
import com.example.kakao_clone.feature.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
    Page<Friend> findAllByKakaoId(User kakaoId, Pageable pageable);
}
