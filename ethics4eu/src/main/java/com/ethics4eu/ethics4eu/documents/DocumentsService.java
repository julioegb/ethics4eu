package com.ethics4eu.ethics4eu.documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DocumentsService {

    private final DocumentsRepository documentsRepository;

    @Autowired
    public DocumentsService(DocumentsRepository documentsRepository) {
        this.documentsRepository = documentsRepository;
    }

    public List<Documents> getDocuments() {
        return documentsRepository.findAll();
    }

    public String getDocumentsByName(String name) {
        Documents response = documentsRepository.findDocumentsByName(name);
        return response.bibtexGenerator();



    }
}
