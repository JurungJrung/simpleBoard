package com.example.simpleborad.post.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId = 1L;
    // 1L : 초기값

    @NotBlank
    private String userName;
    @NotBlank
    @Size(min = 4, max = 4)
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
