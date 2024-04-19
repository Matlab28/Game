package com.example.game.controller;

import com.example.game.dto.RspDto;
import com.example.game.service.RspService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequiredArgsConstructor
public class RspController {

    private final RspService service;

    @PostMapping("/play-game")
    public String play(@RequestBody RspDto dto) {
        return service.play(dto);
    }
}
