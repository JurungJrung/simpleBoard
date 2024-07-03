package com.example.simpleborad.post.controller;

import com.example.simpleborad.post.db.PostEntity;
import com.example.simpleborad.post.model.PostRequest;
import com.example.simpleborad.post.model.PostViewRequest;
import com.example.simpleborad.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("")
    public PostEntity create(
            @Valid
        @RequestBody PostRequest postRequest
            ){
        return postService.create(postRequest);
    }

    @GetMapping("/view")
    public PostEntity view(
            @Valid
            @RequestBody PostViewRequest postViewRequest
            )
    {
        var entity = postService.view(postViewRequest);
        return entity;
    }

}
