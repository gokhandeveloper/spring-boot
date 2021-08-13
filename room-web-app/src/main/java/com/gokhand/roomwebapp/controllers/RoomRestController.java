package com.gokhand.roomwebapp.controllers;

import com.gokhand.roomwebapp.models.Room;
import com.gokhand.roomwebapp.services.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

    private final RoomService roomservice;

    public RoomRestController(RoomService roomservice) {
        this.roomservice = roomservice;
    }


    @GetMapping
    public List<Room> getAllrooms() {
        return roomservice.getAllRooms();
    }
}
