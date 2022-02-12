package com.sparta.week03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @GetMapping("/comments/{postId}")
    public String comments(Model model, @PathVariable Long postId) {
        model.addAttribute("data",postId);
        System.out.println("postId = " + postId);
        return "comments";
    }

}
