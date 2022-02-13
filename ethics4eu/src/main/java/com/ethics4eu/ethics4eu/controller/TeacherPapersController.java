package com.ethics4eu.ethics4eu.controller;

import com.ethics4eu.ethics4eu.entity.TeacherPapers;
import com.ethics4eu.ethics4eu.service.TeacherPapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bib")
public class TeacherPapersController{

    private final TeacherPapersService teacherPapersService;

    @Autowired
    public TeacherPapersController(TeacherPapersService teacherPapersService) {
        this.teacherPapersService = teacherPapersService;
    }

    @GetMapping
    public List<String> getTeacherPapers(){
        System.out.println("Pido la informacion");
        List<String> teacherPapersList = teacherPapersService.getTeacherPapers();
        return teacherPapersList;
    }

    @GetMapping(path="/byname/{name}")
    public String teacherPapersByName(@PathVariable("name") String name){
        System.out.println("This is the name: " + name);
        return "This is the name: " + name;
    }
}
