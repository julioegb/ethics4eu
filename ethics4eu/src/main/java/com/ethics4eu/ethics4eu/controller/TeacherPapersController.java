package com.ethics4eu.ethics4eu.controller;


import com.ethics4eu.ethics4eu.service.PapersAttributeService;
import com.ethics4eu.ethics4eu.service.TeacherPapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bib")
public class TeacherPapersController{

    private final TeacherPapersService teacherPapersService;
    private final PapersAttributeService papersAttributeService;

    @Autowired
    public TeacherPapersController(TeacherPapersService teacherPapersService, PapersAttributeService papersAttributeService) {
        this.teacherPapersService = teacherPapersService;
        this.papersAttributeService = papersAttributeService;
    }

    @GetMapping
    public List<String> getTeacherPapers(){
        List<String> teacherPapersList = teacherPapersService.getTeacherPapers();
        return teacherPapersList;
    }

    @GetMapping(path="/byname/{name}")
    public List<String> teacherPapersByName(@PathVariable("name") String name){
        List<String> teacherPapersList = teacherPapersService.getTeacherPapersByName(name.substring(1, name.length() - 1));
        return teacherPapersList;
    }

    @PostMapping
    public void insertNewDocument(@RequestBody String arguments){
        papersAttributeService.insertNewDocument(arguments);
    }

    @DeleteMapping(path = "{idTeacherPaper}")
    public void deleteTeacherPapers(@PathVariable("idTeacherPaper") Long idTeacherPaper){
        teacherPapersService.deleteTeacherPapers(idTeacherPaper);
    }



}
