package com.example.kakao_clone.feature.search.controller;

import com.example.kakao_clone.feature.friend.domain.Friend;
import com.example.kakao_clone.feature.search.service.SearchService;
import com.example.kakao_clone.feature.user.domain.User;
import com.example.kakao_clone.global.auth.application.UserDetailsImpl;
import com.example.kakao_clone.global.response.MultiResponseDto;
import com.example.kakao_clone.global.response.SingleResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;



@RestController
@RequestMapping
@Validated
@Slf4j
public class SearchController {
    private SearchService searchService;
    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }
    @PostMapping("/search/friends")
    public ResponseEntity postFriends(@Positive@RequestParam int page, @Positive @RequestParam int size) {
        //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //UserDetailsImpl principalDetails = (UserDetailsImpl)principal;
        //Long id=principalDetails.getUser().getId();
        int a=0;

        User user = new User();
        user.setId(1L);
        //Integer id=1;
        Page<Friend> pageFriend = searchService.findFriend(user, page -1, size);
        List<Friend> friend = pageFriend.getContent();
        return new ResponseEntity<>(new MultiResponseDto<>(searchService.friendResponse(friend), pageFriend), HttpStatus.OK);
        //return new ResponseEntity<>(new SingleResponseDto<>(a), HttpStatus.CREATED);
    }
}
