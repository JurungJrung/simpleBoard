package com.example.simpleborad.board.service;

import com.example.simpleborad.board.db.BoardEntity;
import com.example.simpleborad.board.model.BoardDto;
import com.example.simpleborad.post.service.PostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardConverter {

    private final PostConverter postConverter;

    public BoardDto toDto(BoardEntity boardEntity){

        var postList = boardEntity.getPostList()
                .stream()
                .map(postEntity -> postConverter.toDto(postEntity))
                .collect(Collectors.toList())
                ;


        return BoardDto.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatues())
                .postList(postList)
                .build()
                ;
    }
}
