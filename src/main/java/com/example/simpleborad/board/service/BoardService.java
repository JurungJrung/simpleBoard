package com.example.simpleborad.board.service;

import com.example.simpleborad.board.db.BoardEntity;
import com.example.simpleborad.board.db.BoardRepository;
import com.example.simpleborad.board.model.BoardDto;
import com.example.simpleborad.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;


    public BoardDto create(
            BoardRequest boardRequest)
    {
        var entity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .statues("REGISTERED")
                .build()
                ;

        var saveEntity = boardRepository.save(entity);

        return boardConverter.toDto(saveEntity);
    }


    public BoardDto view(Long id){

        var entity = boardRepository.findById(id).get();

        return boardConverter.toDto(entity);
    }

}
