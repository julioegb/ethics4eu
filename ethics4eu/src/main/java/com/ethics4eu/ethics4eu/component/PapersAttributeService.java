package com.ethics4eu.ethics4eu.component;

import com.ethics4eu.ethics4eu.entity.PapersAttribute;
import com.ethics4eu.ethics4eu.entity.TeacherPapers;
import com.ethics4eu.ethics4eu.repository.PapersAttributeRepository;
import com.ethics4eu.ethics4eu.repository.TeacherPapersRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * Component class with the business logic for the API paths
 */
@Component
public class PapersAttributeService {

    /**
     * Instances of the Repository Classes
     */
    private final PapersAttributeRepository papersAttributeRepository;
    private final TeacherPapersRepository teacherPapersRepository;

    @Autowired
    public PapersAttributeService(PapersAttributeRepository papersAttributeRepository, TeacherPapersRepository teacherPapersRepository) {
        this.papersAttributeRepository = papersAttributeRepository;
        this.teacherPapersRepository = teacherPapersRepository;
    }

    /**
     * Method to verify if a TeacherPaper exist
     * @param name of the reference
     * @return true if the reference exist and false if don't
     */
    public boolean existTeacherPapersByName(String name){
        List<TeacherPapers> teacherPapersList = teacherPapersRepository.getTeacherPapersByName(name);
        if(teacherPapersList.size() >= 1){
            return true;
        }
        return false;
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
    public String insertNewDocument(String arguments){
        JSONObject rawJson = new JSONObject(arguments);
        //Validate if Paper already exist
        if(!existTeacherPapersByName(rawJson.getString("name"))){
            // Creating the two instances
            TeacherPapers teacherPapers = TeacherPapers.builder()
                    .p_id(rawJson.getString("name"))
                    .build();
            PapersAttribute papersAttribute = PapersAttribute.builder()
                    .fieldType(rawJson.getString("type"))
                    .build();
            // Iterate the JSON to obtain all the values
            Iterator<String> keys = rawJson.keys();
            while(keys.hasNext()) {
                String key = keys.next();
                if(!key.equals("name") && !key.equals("type")){
                    if(key.equals("author")) teacherPapers.setAuthors((String) rawJson.get(key));
                    if(key.equals("title")) teacherPapers.setTitle((String) rawJson.get(key));
                    if(key.equals("address")) papersAttribute.setAddress((String) rawJson.get(key));
                    if(key.equals("booktitle")) papersAttribute.setBooktitle((String) rawJson.get(key));
                    if(key.equals("chapter")) papersAttribute.setChapter((String) rawJson.get(key));
                    if(key.equals("edition")) papersAttribute.setEdition((String) rawJson.get(key));
                    if(key.equals("editor")) papersAttribute.setEditor((String) rawJson.get(key));
                    if(key.equals("howpublished")) papersAttribute.setHowpublished((String) rawJson.get(key));
                    if(key.equals("institution")) papersAttribute.setInstitution((String) rawJson.get(key));
                    if(key.equals("journal")) papersAttribute.setJournal((String) rawJson.get(key));
                    if(key.equals("month")) papersAttribute.setMonth((String) rawJson.get(key));
                    if(key.equals("note")) papersAttribute.setNote((String) rawJson.get(key));
                    if(key.equals("number")) papersAttribute.setNumber((String) rawJson.get(key));
                    if(key.equals("organization")) papersAttribute.setOrganization((String) rawJson.get(key));
                    if(key.equals("isbn")) papersAttribute.setIsbn((String) rawJson.get(key));
                    if(key.equals("issn")) papersAttribute.setIssn((String) rawJson.get(key));
                    if(key.equals("url")) papersAttribute.setUrl((String) rawJson.get(key));
                    if(key.equals("urn")) papersAttribute.setUrn((String) rawJson.get(key));
                    if(key.equals("doi")) papersAttribute.setDoi((String) rawJson.get(key));
                    if(key.equals("pages")) papersAttribute.setPages((String) rawJson.get(key));
                    if(key.equals("publisher")) papersAttribute.setPublisher((String) rawJson.get(key));
                    if(key.equals("school")) papersAttribute.setSchool((String) rawJson.get(key));
                    if(key.equals("series")) papersAttribute.setSeries((String) rawJson.get(key));
                    if(key.equals("volume")) papersAttribute.setVolume((String) rawJson.get(key));
                    if(key.equals("year")) papersAttribute.setYear((String) rawJson.get(key));
                    if(key.equals("key")) papersAttribute.setKey((String) rawJson.get(key));
                    if(key.equals("file")) papersAttribute.setFile((String) rawJson.get(key));
                    if(key.equals("ee")) papersAttribute.setEe((String) rawJson.get(key));
                    if(key.equals("crossref")) papersAttribute.setCrossref((String) rawJson.get(key));
                    if(key.equals("bibsource")) papersAttribute.setBibsource((String) rawJson.get(key));
                    if(key.equals("issue_date")) papersAttribute.setIssueDate((String) rawJson.get(key));
                    if(key.equals("abstract")) papersAttribute.setAbstractInfo((String) rawJson.get(key));
                    if(key.equals("numpages")) papersAttribute.setNumpages((String) rawJson.get(key));
                    if(key.equals("editors")) papersAttribute.setEditors((String) rawJson.get(key));
                    if(key.equals("location")) papersAttribute.setLocation((String) rawJson.get(key));
                    if(key.equals("collection")) papersAttribute.setCollection((String) rawJson.get(key));
                    if(key.equals("pmid")) papersAttribute.setPmid((String) rawJson.get(key));
                    if(key.equals("ethics4EU")) papersAttribute.setEthics4EU((String) rawJson.get(key));
                }
            }
            papersAttribute.setTeacherPapers(teacherPapers);
            papersAttributeRepository.save(papersAttribute);
            List<TeacherPapers> teacherPapersList = teacherPapersRepository.getTeacherPapersByName(rawJson.getString("name"));
            if(teacherPapersList.size() == 1){
                return "Register " + rawJson.getString("name") + " was inserted.";
            }else{
                return "Error inserting register.";
            }
        }else{
            return "The document " + rawJson.getString("name") + " already exists.";
        }
    }
}
