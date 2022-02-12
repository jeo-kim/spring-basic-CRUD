package com.sparta.week03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentRequestDto {
    private final Long postId;
    private final String username;
    private final String contents;
}
