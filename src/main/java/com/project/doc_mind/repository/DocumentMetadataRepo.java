package com.project.doc_mind.repository;


import com.project.doc_mind.entity.DocumentMetadata;
import com.project.doc_mind.entity.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentMetadataRepo extends JpaRepository<DocumentMetadata, UUID> {

    List<DocumentMetadata> findByStatus(DocumentStatus status);

    List<DocumentMetadata> findAllByOrderByCreatedAtDesc();


//    List<DocumentMetadata> findByUserOrderByCreatedAtDesc(User user);
//
//    Optional<DocumentMetadata> findByIdAndUser(UUID id, User user);

}
