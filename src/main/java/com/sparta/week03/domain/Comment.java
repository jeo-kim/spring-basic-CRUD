package com.sparta.week03.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Comment(Long postId, String username, String contents) {
        this.postId = postId;
        this.username = username;
        this.contents = contents;
    }

    public Comment(CommentRequestDto requestDto) {
        this.postId = requestDto.getPostId();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(CommentRequestDto requestDto) {
        this.postId = requestDto.getPostId();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }



}
