package com.tlz.blogarc.service;

import com.tlz.blogarc.dto.PostDTO;

import java.util.List;


public interface PostService {

    List<PostDTO> findAllPosts();

    void createPost(PostDTO postDTO);

    PostDTO findPostById(Long postId);

    void updatePost(PostDTO postDTO);

    void deletePost(Long postId);

}
