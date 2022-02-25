package com.ethics4eu.ethics4eu.controller;

import com.ethics4eu.ethics4eu.service.PapersAttributeService;
import com.ethics4eu.ethics4eu.service.TeacherPapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class that attend the API request from the clients
 */
@RestController
@RequestMapping(path = "api/v1/docs")
public class TeacherPapersController{

    /**
     * Instances of the Service Classes
     */
    private final TeacherPapersService teacherPapersService;
    private final PapersAttributeService papersAttributeService;

    @Autowired
    public TeacherPapersController(TeacherPapersService teacherPapersService, PapersAttributeService papersAttributeService) {
        this.teacherPapersService = teacherPapersService;
        this.papersAttributeService = papersAttributeService;
    }

    /**
     * Return all the BiTeX references
     * @return JSON with a list of all the references in BibTex format
     */

    @GetMapping
    public List<String> getTeacherPapers(){
        List<String> teacherPapersList = teacherPapersService.getTeacherPapers();
        return teacherPapersList;
    }

    /**
     * Return BiTeX reference by name
     * @param name of the reference
     * @return the reference in BibTeX format if exist, error message if don't
     */
    @GetMapping(path="/byname/{name}")
    public List<String> teacherPapersByName(@PathVariable("name") String name){
        List<String> teacherPapersList = teacherPapersService.getTeacherPapersByName(name);
        return teacherPapersList;
    }

    /**
     * Insert BibTeX reference
     * @param arguments JSON with all the fields for a BibTeX reference, name and type are mandatories:
     *                  Name: without spaces or special characters, name is unique
     *                  type: correspond to the entry type field @article, @book, @inproceedings, etc.
     *                  title
     *                  address
     *                  booktitle
     *                  chapter
     *                  edition
     *                  editor
     *                  howpublished
     *                  institution
     *                  journal
     *                  month
     *                  note
     *                  number
     *                  organization
     *                  isbn
     *                  issn
     *                  url
     *                  urn
     *                  doi
     *                  pages
     *                  publisher
     *                  school
     *                  series
     *                  volume
     *                  year
     *                  key
     *                  file
     *                  ee
     *                  crossref
     *                  bibsource
     *                  issue_date
     *                  abstract
     *                  numpages
     *                  editors
     *                  location
     *                  collection
     *                  pmid
     *                  ethics4EU (This is a specific field that indicates the section of the reference for the Ethics4EU document)
     * @return insertion confirmation, error message if don't
     */
    @PostMapping
    public String insertNewDocument(@RequestBody String arguments){
        return papersAttributeService.insertNewDocument(arguments);
    }

    /**
     * Delete BibTeX reference
     * @param name of the reference
     * @return deletion confirmation, error message if don't
     */
    @DeleteMapping(path = "/deletebyname/{name}")
    public String deleteTeacherPapers(@PathVariable("name") String name){
        return teacherPapersService.deleteTeacherPapers(name);
    }
}
