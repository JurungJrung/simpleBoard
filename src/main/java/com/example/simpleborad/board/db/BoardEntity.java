package com.example.simpleborad.board.db;

import com.example.simpleborad.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String boardName;

    private String statues;

    @OneToMany
    @Builder.Default
    @Where(clause = "status = 'REGISTERED'")
    @OrderBy("id desc")
    private List<PostEntity> postList = List.of();

}
