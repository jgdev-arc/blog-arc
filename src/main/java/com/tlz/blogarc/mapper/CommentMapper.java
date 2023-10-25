package com.tlz.blogarc.mapper;

import com.tlz.blogarc.dto.CommentDTO;
import com.tlz.blogarc.entity.Comment;

public class CommentMapper {

    public static CommentDTO mapToCommentDTO(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .name(comment.getName())
                .email(comment.getEmail())
                .content(comment.getContent())
                .createdOn(comment.getCreatedOn())
                .updatedOn(comment.getUpdatedOn())
                .build();
    }

    public static Comment mapToComment(CommentDTO commentDTO) {
        return Comment.builder()
                .id(commentDTO.getId())
                .name(commentDTO.getName())
                .email(commentDTO.getEmail())
                .content(commentDTO.getContent())
                .createdOn(commentDTO.getCreatedOn())
                .updatedOn(commentDTO.getUpdatedOn())
                .build();
    }


}
