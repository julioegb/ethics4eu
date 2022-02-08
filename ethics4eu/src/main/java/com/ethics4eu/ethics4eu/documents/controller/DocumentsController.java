package com.ethics4eu.ethics4eu.documents.controller;

import com.ethics4eu.ethics4eu.documents.Documents;
import com.ethics4eu.ethics4eu.documents.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/allrawbibs")
public class DocumentsController {

    private final DocumentsService documentsService;

    @Autowired
    public DocumentsController(DocumentsService documentsService) {
        this.documentsService = documentsService;
    }

    @GetMapping
    public List<Documents> getDocuments() {
        return documentsService.getDocuments();
    }
}
