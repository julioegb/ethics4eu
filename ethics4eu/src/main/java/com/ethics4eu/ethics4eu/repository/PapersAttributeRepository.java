package com.ethics4eu.ethics4eu.repository;

import com.ethics4eu.ethics4eu.entity.PapersAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapersAttributeRepository extends JpaRepository<PapersAttribute, Long> {
}
