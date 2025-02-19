package com.example.simpleborad.reply.controller;

import com.example.simpleborad.reply.db.ReplyEntity;
import com.example.simpleborad.reply.model.ReplyRequest;
import com.example.simpleborad.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController {

    private final ReplyService replyService;


    @PostMapping("")
    public ReplyEntity create(
            @Valid
            @RequestBody ReplyRequest replyRequest
            )
    {
        return replyService.create(replyRequest);
    }
}
