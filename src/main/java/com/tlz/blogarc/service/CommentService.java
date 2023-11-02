package com.tlz.blogarc.service;

import com.tlz.blogarc.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    void createComment(String postUrl, CommentDTO commentDTO);

    List<CommentDTO> findAllComments();

    void deleteComment(Long commentId);

    List<CommentDTO> findCommentByPosts();
}
