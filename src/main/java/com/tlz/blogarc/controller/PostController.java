package com.tlz.blogarc.controller;

import com.tlz.blogarc.dto.PostDTO;
import com.tlz.blogarc.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    // this handler method deals with new POST request
    @GetMapping("admin/posts/newpost")
    public String newPostForm(Model model) {
        PostDTO postDTO = new PostDTO();
        model.addAttribute("post", postDTO);
        return "admin/create_post";
    }

    // this handler method deals with form submit request
    @PostMapping("/admin/posts")
    public String createPost(@Valid @ModelAttribute("post") PostDTO postDTO,
                             BindingResult result,
                             Model model) {
        if(result.hasErrors()) {
            model.addAttribute("post", postDTO);
            return "admin/create_post";
        }

        postDTO.setUrl(getUrl(postDTO.getTitle()));
        postService.createPost(postDTO);
        return "redirect:/admin/posts";
    }

    private static  String getUrl(String postTitle) {
        // OOP concepts explained in Java
        String title = postTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s+", "-");
        url = url.replaceAll("[^A-Za-z0-9]", "-");
        return url;
    }


}
