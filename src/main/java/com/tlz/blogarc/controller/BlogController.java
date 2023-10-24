package com.tlz.blogarc.controller;

import com.tlz.blogarc.dto.PostDTO;
import com.tlz.blogarc.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    // handles root("/") request
    @GetMapping("/")
    public String viewBlogPosts(Model model) {
        List<PostDTO> postResponse = postService.findAllPosts();
        model.addAttribute("postsResponse", postResponse);
        return "blog/view_posts";
    }
}
