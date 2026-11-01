package com.project.doc_mind.dto;

import com.project.doc_mind.entity.DocumentStatus;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentResponseDto {
    private UUID id;
    private   String fileName;
    private  Long fileSize;
    private DocumentStatus status;
    private  Integer chunksCreated;
    private  String message;
    private Long userId;
}
