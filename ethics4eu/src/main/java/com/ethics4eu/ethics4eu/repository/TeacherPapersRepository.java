package com.ethics4eu.ethics4eu.repository;

import com.ethics4eu.ethics4eu.entity.TeacherPapers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPapersRepository extends JpaRepository<TeacherPapers, Long> {
}
