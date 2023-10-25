package com.tlz.blogarc.service.impl;

import com.tlz.blogarc.dto.CommentDTO;
import com.tlz.blogarc.entity.Comment;
import com.tlz.blogarc.entity.Post;
import com.tlz.blogarc.mapper.CommentMapper;
import com.tlz.blogarc.repository.CommentRepository;
import com.tlz.blogarc.repository.PostRepository;
import com.tlz.blogarc.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDTO commentDTO) {

        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDTO);
        comment.setPost(post);
        commentRepository.save(comment);

    }
}
