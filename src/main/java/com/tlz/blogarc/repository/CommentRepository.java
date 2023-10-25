package com.tlz.blogarc.repository;

import com.tlz.blogarc.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {

}
