package com.example.tdd.board.controller;

import com.example.tdd.board.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {


    @PostMapping("/save")
    public @ResponseBody String save(@ModelAttribute CommentDTO commentDTO) {
        System.out.println("commentDTO = " + commentDTO);
        return "요청 성공";

    }

}