package com.ethics4eu.ethics4eu.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "teacherPapers")
public class PapersAttribute {

    @Id
    @SequenceGenerator(
            name = "attribute_rol_id_seq",
            sequenceName = "attribute_rol_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "attribute_rol_id_seq"
    )
    private Long idAttribute;

    /**
     * Below all the parameters of Latex for a Bibtex register
     */
    private String address;
    private String booktitle;
    private String chapter;
    private String edition;
    private String editor;
    private String howpublished;
    private String institution;
    private String journal;
    private String month;
    private String note;
    private String number;
    private String organization;
    private String isbn;
    private String issn;
    private String url;
    private String urn;
    private String doi;
    private String pages;
    private String publisher;
    private String school;
    private String series;
    private String volume;
    private String year;
    private String key;
    private String file;
    private String ee;
    private String crossref;
    private String bibsource;
    private String issueDate;
    private String abstractInfo;
    private String numpages;
    private String editors;
    private String location;
    private String collection;
    private String pmid;
    private String fieldType;
    private String ethics4EU;

    /**
     * One to One relationship with Teacher Papers table
     */
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "id_teacher_papers",
            referencedColumnName = "id"
    )
    private TeacherPapers teacherPapers;

}
