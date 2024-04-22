package com.example.tdd.board.controller;

import com.example.tdd.board.dto.BoardDTO;
import com.example.tdd.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @GetMapping("/")
    public String findAll(Model model) {

        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";


    }

    // https://www.youtube.com/watch?v=2XEEPdQBKfs
}
