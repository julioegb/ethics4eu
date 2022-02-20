package com.ethics4eu.ethics4eu.repository;

import com.ethics4eu.ethics4eu.entity.TeacherPapers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherPapersRepository extends JpaRepository<TeacherPapers, Long> {

    @Query("SELECT s FROM TeacherPapers s WHERE s.p_id = ?1")
    List<TeacherPapers> getTeacherPapersByName(String name);
}
