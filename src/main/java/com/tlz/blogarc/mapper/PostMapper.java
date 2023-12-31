package com.tlz.blogarc.mapper;

import com.tlz.blogarc.dto.PostDTO;
import com.tlz.blogarc.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {

    // Post entity to PostDTO
    public static PostDTO mapToPostDTO(Post post) {
       return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
               .comments(post.getComments().stream()
                       .map((comment) -> CommentMapper.mapToCommentDTO(comment))
                       .collect(Collectors.toSet()))
                .build();
    }

    // PostDTO to Post entity
    public static Post mapToPost(PostDTO postDTO) {
        return Post.builder()
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .url(postDTO.getUrl())
                .shortDescription(postDTO.getShortDescription())
                .createdOn(postDTO.getCreatedOn())
                .updatedOn(postDTO.getUpdatedOn())
                .build();
    }
}
