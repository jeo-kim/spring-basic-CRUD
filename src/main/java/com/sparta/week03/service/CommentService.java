package com.sparta.week03.service;

import com.sparta.week03.domain.Comment;
import com.sparta.week03.domain.CommentRepository;
import com.sparta.week03.domain.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long update(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()  -> new IllegalArgumentException("comment id가 존재하지 않습니다.")
        );
        comment.update(commentRequestDto);
        return comment.getId();
    }

}
