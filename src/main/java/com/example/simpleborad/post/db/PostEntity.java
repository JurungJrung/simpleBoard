package com.example.simpleborad.post.db;

import com.example.simpleborad.board.db.BoardEntity;
import com.example.simpleborad.reply.db.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "post")
public class PostEntity {
    // 게시판 내 게시글을 구성하는 요소

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime postedAt;

    @OneToMany(mappedBy = "post")
    @Builder.Default
    private List<ReplyEntity> replyList = new ArrayList<>();

}
