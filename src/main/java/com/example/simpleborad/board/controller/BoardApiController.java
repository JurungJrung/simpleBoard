package com.example.simpleborad.board.controller;

import com.example.simpleborad.board.db.BoardEntity;
import com.example.simpleborad.board.db.BoardRepository;
import com.example.simpleborad.board.model.BoardDto;
import com.example.simpleborad.board.model.BoardRequest;
import com.example.simpleborad.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Repository
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("")
    public BoardDto create(
            @Valid
            @RequestBody BoardRequest boardRequest
            ){
        return boardService.create(boardRequest);
    }

    @GetMapping("id/{id}")
    public BoardDto view(
        @PathVariable Long id
    ){
        var entity = boardService.view(id);
        log.info("result : {}",entity);
        return entity;
    }

    @GetMapping("ids/{id}")
    public List<BoardEntity> all(
            @PathVariable Long id
    ){
        return boardRepository.findAll();
    }
}
