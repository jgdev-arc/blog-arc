package com.tlz.blogarc.controller;

import com.tlz.blogarc.dto.CommentDTO;
import com.tlz.blogarc.dto.PostDTO;
import com.tlz.blogarc.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    // handles view post request
    @GetMapping("/post/{postUrl}")
    public String showPost(@PathVariable("postUrl") String postUrl,
                           Model model) {
        PostDTO post = postService.findPostByUrl(postUrl);

        CommentDTO commentDTO = new CommentDTO();

        model.addAttribute("comment", commentDTO);
        model.addAttribute("post", post);
        return "blog/blog_post";

    }

    // handles blog post search request
    @GetMapping("/page/search")
    public String searchPosts(@RequestParam(value = "query") String query,
                              Model model) {
        List<PostDTO> postsResponse = postService.searchPosts(query);
        model.addAttribute("postsResponse", postsResponse);
        return "blog/view_posts";
    }



}
