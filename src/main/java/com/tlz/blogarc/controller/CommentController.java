package com.tlz.blogarc.controller;

import com.tlz.blogarc.dto.CommentDTO;
import com.tlz.blogarc.dto.PostDTO;
import com.tlz.blogarc.service.CommentService;
import com.tlz.blogarc.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping("/{postUrl}/comments")
    public String createComment(@PathVariable("postUrl") String postUrl,
                                @Valid @ModelAttribute("comment") CommentDTO commentDTO,
                                BindingResult result,
                                Model model) {

        PostDTO postDTO = postService.findPostByUrl(postUrl);
        if (result.hasErrors()) {
            model.addAttribute("post", postDTO);
            model.addAttribute("comment", commentDTO);
            return "blog/blog_post";
        }

        commentService.createComment(postUrl, commentDTO);
        return "redirect:/post/" + postUrl;


    }

}
