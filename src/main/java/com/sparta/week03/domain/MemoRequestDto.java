package com.sparta.week03.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Getter
public class MemoRequestDto {
    private final String username;
    private final String title;
    private final String contents;
}
