package com.tlz.blogarc.controller;

import com.tlz.blogarc.dto.PostDTO;
import com.tlz.blogarc.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // this handler method deals with GET request and returns model/view
    @GetMapping("/admin/posts")
    public String posts(Model model) {
        List<PostDTO> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "/admin/posts";
    }





}
