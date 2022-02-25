package com.ethics4eu.ethics4eu.component;

import com.ethics4eu.ethics4eu.entity.TeacherPapers;
import com.ethics4eu.ethics4eu.repository.PapersAttributeRepository;
import com.ethics4eu.ethics4eu.repository.TeacherPapersRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Component class with the business logic for the API paths
 */
@Component
public class TeacherPapersService {

    /**
     * Instances of the Repository Interfaces
     */
    private final TeacherPapersRepository teacherPapersRepository;
    private final PapersAttributeRepository papersAttributeRepository;

    @Autowired
    public TeacherPapersService(TeacherPapersRepository teacherPapersRepository, PapersAttributeRepository papersAttributeRepository) {
        this.teacherPapersRepository = teacherPapersRepository;
        this.papersAttributeRepository = papersAttributeRepository;
    }

    /**
     * Return all the BiTeX references
     * @return JSON with a list of all the references in BibTex format
     */
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

    /**
     * Return BiTeX reference by name
     * @param name of the reference
     * @return the reference in BibTeX format if exist, error message if don't
     */
    public List<String> getTeacherPapersByName(String name){
        List<TeacherPapers> teacherPapersList = teacherPapersRepository.getTeacherPapersByName(name);
        if(teacherPapersList.size() == 0){
            return List.of("Register " + name + " does not exist.");
        }else{
            List<String> papersList = new ArrayList<>();
            if(teacherPapersList.size() == 1){
                for(TeacherPapers paper:teacherPapersList){
                    papersList.add(paper.paperBibTex());
                }
            }
            return papersList;
        }
    }

    /**
     * Delete BibTeX reference
     * @param name of the reference
     * @return deletion confirmation, error message if don't
     */
    public String deleteTeacherPapers(String name){
        List<TeacherPapers> teacherPapersList = teacherPapersRepository.getTeacherPapersByName(name);
        if(teacherPapersList.size() == 0){
            return "Register " + name + " does not exist.";
        }else{
            Long idTeacherPapers = teacherPapersList.get(0).getId();
            boolean exists = teacherPapersRepository.existsById(idTeacherPapers);
            if(!exists){
                return "The document " + idTeacherPapers + " does not exist.";
            }
            papersAttributeRepository.deleteById(idTeacherPapers);
            return "Register " + name + " was deleted.";
        }
    }
}
