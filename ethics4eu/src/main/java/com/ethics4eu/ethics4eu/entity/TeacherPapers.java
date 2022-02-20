package com.ethics4eu.ethics4eu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherPapers {

    @Id
    @SequenceGenerator(
            name = "teacher_rol_id_seq",
            sequenceName = "teacher_rol_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_rol_id_seq"
    )
    private Long id;

    private String title;
    private String p_id;
    private String authors;
    private String file;
    private String category;
    private String keywords;

    @OneToOne(
        mappedBy = "teacherPapers"
    )
    private PapersAttribute papersAttribute;

    public String paperBibTex(){
        String bibTex = "";
        bibTex = "@" + papersAttribute.getFieldType() + "{" + getP_id() + ", ";
        if(papersAttribute.getAddress() != null) bibTex = bibTex + "address={" + papersAttribute.getAddress() + "}, ";
        if(getTitle() != null) bibTex = bibTex + "title={" + getTitle() + "}, ";
        if(getAuthors() != null) bibTex = bibTex + "author={" + getAuthors() + "}, ";
        if(papersAttribute.getBooktitle() != null) bibTex = bibTex + "booktitle={" + papersAttribute.getBooktitle() + "}, ";
        if(papersAttribute.getChapter() != null) bibTex = bibTex + "chapter={" + papersAttribute.getChapter() + "}, ";
        if(papersAttribute.getEdition() != null) bibTex = bibTex + "edition={" + papersAttribute.getEdition() + "}, ";
        if(papersAttribute.getEditor() != null) bibTex = bibTex + "editor={" + papersAttribute.getEditor() + "}, ";
        if(papersAttribute.getHowpublished() != null) bibTex = bibTex + "howpublished={" + papersAttribute.getHowpublished() + "}, ";
        if(papersAttribute.getInstitution() != null) bibTex = bibTex + "institution={" + papersAttribute.getInstitution() + "}, ";
        if(papersAttribute.getJournal() != null) bibTex = bibTex + "journal={" + papersAttribute.getJournal() + "}, ";
        if(papersAttribute.getMonth() != null) bibTex = bibTex + "month={" + papersAttribute.getMonth() + "}, ";
        if(papersAttribute.getNote() != null) bibTex = bibTex + "note={" + papersAttribute.getNote() + "}, ";
        if(papersAttribute.getNumber() != null) bibTex = bibTex + "number={" + papersAttribute.getNumber() + "}, ";
        if(papersAttribute.getOrganization() != null) bibTex = bibTex + "organization={" + papersAttribute.getOrganization() + "}, ";
        if(papersAttribute.getIsbn() != null) bibTex = bibTex + "isbn={" + papersAttribute.getIsbn() + "}, ";
        if(papersAttribute.getIssn() != null) bibTex = bibTex + "issn={" + papersAttribute.getIssn() + "}, ";
        if(papersAttribute.getUrl() != null) bibTex = bibTex + "url={" + papersAttribute.getUrl() + "}, ";
        if(papersAttribute.getUrn() != null) bibTex = bibTex + "urn={" + papersAttribute.getUrn() + "}, ";
        if(papersAttribute.getDoi() != null) bibTex = bibTex + "doi={" + papersAttribute.getDoi() + "}, ";
        if(papersAttribute.getPages() != null) bibTex = bibTex + "pages={" + papersAttribute.getPages() + "}, ";
        if(papersAttribute.getPublisher() != null) bibTex = bibTex + "publisher={" + papersAttribute.getPublisher() + "}, ";
        if(papersAttribute.getSchool() != null) bibTex = bibTex + "school={" + papersAttribute.getSchool() + "}, ";
        if(papersAttribute.getSeries() != null) bibTex = bibTex + "series={" + papersAttribute.getSeries() + "}, ";
        if(papersAttribute.getVolume() != null) bibTex = bibTex + "volume={" + papersAttribute.getVolume() + "}, ";
        if(papersAttribute.getYear() != null) bibTex = bibTex + "year={" + papersAttribute.getYear() + "}, ";
        if(papersAttribute.getKey() != null) bibTex = bibTex + "key={" + papersAttribute.getKey() + "}, ";
        if(papersAttribute.getFile() != null) bibTex = bibTex + "file={" + papersAttribute.getFile() + "}, ";
        if(papersAttribute.getEe() != null) bibTex = bibTex + "ee={" + papersAttribute.getEe() + "}, ";
        if(papersAttribute.getCrossref() != null) bibTex = bibTex + "crossref={" + papersAttribute.getCrossref() + "}, ";
        if(papersAttribute.getBibsource() != null) bibTex = bibTex + "bibsource={" + papersAttribute.getBibsource() + "}, ";
        if(papersAttribute.getIssueDate() != null) bibTex = bibTex + "issue_date={" + papersAttribute.getIssueDate() + "}, ";
        if(papersAttribute.getAbstractInfo() != null) bibTex = bibTex + "abstract={" + papersAttribute.getAbstractInfo()  + "}, ";
        if(papersAttribute.getNumpages() != null) bibTex = bibTex + "numpages={" + papersAttribute.getNumpages() + "}, ";
        if(papersAttribute.getEditors() != null) bibTex = bibTex + "editors={" + papersAttribute.getEditors() + "}, ";
        if(papersAttribute.getLocation() != null) bibTex = bibTex + "location={" + papersAttribute.getLocation() + "}, ";
        if(papersAttribute.getCollection() != null) bibTex = bibTex + "collection={" + papersAttribute.getCollection() + "}, ";
        if(papersAttribute.getPmid() != null) bibTex = bibTex + "pmid={" + papersAttribute.getPmid() + "}, ";
        if(papersAttribute.getEthics4EU() != null) bibTex = bibTex + "ethics4EU={" + papersAttribute.getEthics4EU() + "}, ";
        bibTex = bibTex.substring(0, bibTex.length() - 2) + "}";
        return bibTex;
    }
}
