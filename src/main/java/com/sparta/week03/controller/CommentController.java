package com.sparta.week03.controller;


import com.sparta.week03.domain.Comment;
import com.sparta.week03.domain.CommentRepository;
import com.sparta.week03.domain.CommentRequestDto;
import com.sparta.week03.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    @GetMapping("/api/comments/{postid}")
    public Optional<List<Comment>> readComment(@PathVariable Long postid) {
        Sort sort = sortByDate();
        return commentRepository.findByPostId(postid, sort);
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }

    private Sort sortByDate() {
        return Sort.by(Sort.Direction.DESC, "modifiedAt");
    }

}
