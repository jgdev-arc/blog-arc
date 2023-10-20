package com.tlz.blogarc.service.impl;

import com.tlz.blogarc.dto.PostDTO;
import com.tlz.blogarc.entity.Post;
import com.tlz.blogarc.mapper.PostMapper;
import com.tlz.blogarc.repository.PostRepository;
import com.tlz.blogarc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDTO> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::mapToPostDTO)
                .collect(Collectors.toList());
    }
}