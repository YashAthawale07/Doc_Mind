package com.project.doc_mind.controllers;

import com.project.doc_mind.dto.ApiResponse;
import com.project.doc_mind.dto.DocumentResponseDto;
import com.project.doc_mind.service.DocumentMetadataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Slf4j
@RestController()
@RequestMapping("/api/v1/documents")
@Tag(
        name = "Document Management",
        description = "Endpoints for uploading, listing and managing documents and their vectors embeddings."
)
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentMetadataService documentService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
            summary = "Upload and index a document(PDF, DOCX, TEXT, MD, CSV)",
            description = "This api is used to upload and index documents files."

    )
    public ResponseEntity<ApiResponse<DocumentResponseDto>> uploadDocument(
            @RequestParam("file") MultipartFile file

    ) {

        log.info("document uploading started:");
//        User user = (User) authentication.getPrincipal();
//        System.out.println(user.getUsername());
//        System.out.println(user.getEmail());
//        System.out.println(user.getId());
//


//    ,    Authentication authentication

//        process the files
        DocumentResponseDto documentResponseDto = this.documentService.uploadAndProcess(file);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.<DocumentResponseDto>builder()
                        .success(true)
                        .data(documentResponseDto)
                        .timestamp(LocalDateTime.now())
                        .message("Documents uploaded and indexed successfully")
                        .build());
    }
}
