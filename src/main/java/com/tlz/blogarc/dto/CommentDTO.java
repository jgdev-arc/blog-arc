package com.tlz.blogarc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Long id;

    @NotEmpty(message = "Must enter a name.")
    private String name;

    @NotEmpty(message = "Must enter an email address.")
    @Email
    private String email;

    @NotEmpty(message = "Please enter a comment.")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
