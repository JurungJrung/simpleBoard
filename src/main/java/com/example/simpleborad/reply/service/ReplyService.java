package com.example.simpleborad.reply.service;

import com.example.simpleborad.post.db.PostRepository;
import com.example.simpleborad.reply.db.ReplyEntity;
import com.example.simpleborad.reply.db.ReplyRepository;
import com.example.simpleborad.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;


    public ReplyEntity create(
            ReplyRequest replyRequest
    ){
        var optionalPostEntity = postRepository.findById(replyRequest.getPostId());

        if(optionalPostEntity.isEmpty()){
            throw new RuntimeException("게시물이 존재 하지 않습니다 : "+replyRequest.getPostId());
        }

        var entity = ReplyEntity.builder()
                .post(optionalPostEntity.get())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status("REGISTERED")
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .repliedAt(LocalDateTime.now())
                .build()
                ;

        return replyRepository.save(entity);
    }

    public List<ReplyEntity> findByAllByPostId(Long postId){
        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId,"REGISTERED");
    }
}
