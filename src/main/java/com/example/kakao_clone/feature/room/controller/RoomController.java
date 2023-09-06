package com.example.kakao_clone.feature.room.controller;

import com.example.kakao_clone.feature.room.service.RoomService;
import com.example.kakao_clone.feature.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@Validated
@Slf4j
public class RoomController {
    private RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/newChat/create")
    public ResponseEntity postRoom(@RequestBody List<Long> CheckedList) {
        roomService.createRoom(CheckedList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
