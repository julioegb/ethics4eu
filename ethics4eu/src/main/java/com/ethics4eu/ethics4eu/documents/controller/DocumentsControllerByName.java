package com.ethics4eu.ethics4eu.documents.controller;

import com.ethics4eu.ethics4eu.documents.Documents;
import com.ethics4eu.ethics4eu.documents.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bib")
public class DocumentsControllerByName {

    private final DocumentsService documentsService;

    @Autowired
    public DocumentsControllerByName(DocumentsService documentsService) {
        this.documentsService = documentsService;
    }

    @GetMapping(path="/byname/{name}")
    public String getDocumentsByName(@PathVariable("name") String name){
        return documentsService.getDocumentsByName(name);
    }
}
