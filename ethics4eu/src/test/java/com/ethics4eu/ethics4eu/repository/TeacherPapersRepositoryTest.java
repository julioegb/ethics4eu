package com.ethics4eu.ethics4eu.repository;

import com.ethics4eu.ethics4eu.entity.TeacherPapers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherPapersRepositoryTest {

    @Autowired
    private TeacherPapersRepository repository;

    @Test
    public void printTeacherPaper(){
        List<TeacherPapers> teacherPapersList = repository.findAll();
        System.out.println("Papers = " + teacherPapersList);
    }

}