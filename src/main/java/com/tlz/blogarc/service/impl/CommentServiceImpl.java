package com.tlz.blogarc.service.impl;

import com.tlz.blogarc.dto.CommentDTO;
import com.tlz.blogarc.entity.Comment;
import com.tlz.blogarc.entity.Post;
import com.tlz.blogarc.entity.User;
import com.tlz.blogarc.mapper.CommentMapper;
import com.tlz.blogarc.repository.CommentRepository;
import com.tlz.blogarc.repository.PostRepository;
import com.tlz.blogarc.repository.UserRepository;
import com.tlz.blogarc.service.CommentService;
import com.tlz.blogarc.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository,
                              UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDTO commentDTO) {

        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDTO);
        comment.setPost(post);
        commentRepository.save(comment);

    }

    @Override
    public List<CommentDTO> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentMapper::mapToCommentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDTO> findCommentByPosts() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Comment> comments = commentRepository.findCommentsByPost(userId);
        return comments.stream()
                .map((comment) -> CommentMapper.mapToCommentDTO(comment))
                        .collect(Collectors.toList());
    }
}
