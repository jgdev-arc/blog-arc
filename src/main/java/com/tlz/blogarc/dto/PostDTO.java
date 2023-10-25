package com.tlz.blogarc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;

    @NotEmpty(message = "Must enter a post title.")
    private String title;

    private String url;

    @NotEmpty(message = "Must enter text in the content field.")
    private String content;

    @NotEmpty(message = "Please enter a short description.")
    private String shortDescription;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private Set<CommentDTO> comments;
}
