package com.tlz.blogarc.service;

import com.tlz.blogarc.dto.CommentDTO;

public interface CommentService {
    void createComment(String postUrl, CommentDTO commentDTO);
}
