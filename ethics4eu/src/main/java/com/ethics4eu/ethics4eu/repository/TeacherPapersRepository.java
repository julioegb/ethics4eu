package com.ethics4eu.ethics4eu.repository;

import com.ethics4eu.ethics4eu.entity.TeacherPapers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface to exchange data with the table teacher_papers via DATA JPA
 */
@Repository
public interface TeacherPapersRepository extends JpaRepository<TeacherPapers, Long> {

    /**
     * Query to obtain a specific reference from the reference name
     * @param name of the reference
     * @return List with the result of the query
     */
    @Query("SELECT s FROM TeacherPapers s WHERE s.p_id = ?1")
    List<TeacherPapers> getTeacherPapersByName(String name);

}
