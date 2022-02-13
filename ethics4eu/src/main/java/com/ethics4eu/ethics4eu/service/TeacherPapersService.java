package com.ethics4eu.ethics4eu.service;

import com.ethics4eu.ethics4eu.entity.TeacherPapers;
import com.ethics4eu.ethics4eu.repository.PapersAttributeRepository;
import com.ethics4eu.ethics4eu.repository.TeacherPapersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherPapersService {

    private final TeacherPapersRepository teacherPapersRepository;

    @Autowired
    public TeacherPapersService(TeacherPapersRepository teacherPapersRepository) {
        this.teacherPapersRepository = teacherPapersRepository;
    }

    public List<String> getTeacherPapers(){
        System.out.println("Aqui estoy en el Service");
        List<TeacherPapers> teacherPapersList = teacherPapersRepository.findAll();
        System.out.println("Esta cantidad recibo: " + teacherPapersList.size());
        List<String> papersList = new ArrayList<>();
        for(TeacherPapers paper:teacherPapersList){
            papersList.add(paper.paperBibTex());
        }
        return papersList;
    }
}
