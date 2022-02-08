package com.ethics4eu.ethics4eu.documents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentsRepository
        extends JpaRepository<Documents, Long> {

    @Query("SELECT s FROM Documents s WHERE s.name = ?1")
    Documents findDocumentsByName(String name);

}
