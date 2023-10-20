package com.tlz.blogarc.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostDTO {
    private Long id;
    private String title;
    private String url;
    private String content;
    private String shortDesc;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
