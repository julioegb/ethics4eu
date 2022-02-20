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
    private final PapersAttributeRepository papersAttributeRepository;

    @Autowired
    public TeacherPapersService(TeacherPapersRepository teacherPapersRepository, PapersAttributeRepository papersAttributeRepository) {
        this.teacherPapersRepository = teacherPapersRepository;
        this.papersAttributeRepository = papersAttributeRepository;
    }

    public List<String> getTeacherPapers(){
        List<TeacherPapers> teacherPapersList = teacherPapersRepository.findAll();
        List<String> papersList = new ArrayList<>();
        if(teacherPapersList.size() >= 1){
            for(TeacherPapers paper:teacherPapersList){
                papersList.add(paper.paperBibTex());
            }
        }
        return papersList;
    }

    public List<String> getTeacherPapersByName(String name){
        List<TeacherPapers> teacherPapersList = teacherPapersRepository.getTeacherPapersByName(name);
        List<String> papersList = new ArrayList<>();
        if(teacherPapersList.size() == 1){
            System.out.println("Encontramos el paper");
            for(TeacherPapers paper:teacherPapersList){
                papersList.add(paper.paperBibTex());
            }
        }
        return papersList;
    }

    public void deleteTeacherPapers(Long idTeacherPapers){
        boolean exists = teacherPapersRepository.existsById(idTeacherPapers);
        if(!exists){
            throw new IllegalStateException(
                    "The document " + idTeacherPapers + " does not exist.");
        }
        papersAttributeRepository.deleteById(idTeacherPapers);
    }

}
