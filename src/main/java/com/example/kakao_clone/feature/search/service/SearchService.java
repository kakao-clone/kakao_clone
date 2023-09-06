package com.example.kakao_clone.feature.search.service;

import com.example.kakao_clone.feature.friend.domain.Friend;
import com.example.kakao_clone.feature.friend.domain.repository.FriendRepository;
import com.example.kakao_clone.feature.search.dto.SearchDetailsDto;
import com.example.kakao_clone.feature.user.domain.User;
import com.example.kakao_clone.feature.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SearchService {

    private FriendRepository friendRepository;
    private UserRepository userRepository;


    //@Transactional(readOnly = true)
    public Page<Friend> findFriend(User id, int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return friendRepository.findAllByKakaoId(id, pageable);
    }
    public List<SearchDetailsDto> friendResponse(List<Friend> friend){
        List<SearchDetailsDto> list=new ArrayList<>();
        for (Friend friends : friend) {
            SearchDetailsDto dto = new SearchDetailsDto();
            dto.setId(friends.getId());
            dto.setFriendName(friends.getFriendName());
            Optional<User> user = userRepository.findById(friends.getId());
            if (user != null) {
                dto.setProfileImageUrl(user.get().getProfileImageUrl());
            }
            list.add(dto);
        }
        return list;
    }
}
