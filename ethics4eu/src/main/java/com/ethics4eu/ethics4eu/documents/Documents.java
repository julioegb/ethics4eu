package com.ethics4eu.ethics4eu.documents;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Documents {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long idDcos;
    private String name;
    private LocalDate creationDate;
    private Integer idUser;
    private String categories;
    private String keywords;
    private String ethics4EU;

    // Bibtex fields http://newton.ex.ac.uk/tex/pack/bibtex/btxdoc/node6.html
    private String address;
    private String author;
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
    private String title;
    private String type;
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
    // End Bibtex fields

    public Documents() {
    }

    /**
     * Constructor without the id because it's self generated
     * @param name
     * @param creationDate
     * @param idUser
     * @param categories
     * @param keywords
     * @param ethics4EU
     * @param address
     * @param author
     * @param booktitle
     * @param chapter
     * @param edition
     * @param editor
     * @param howpublished
     * @param institution
     * @param journal
     * @param month
     * @param note
     * @param number
     * @param organization
     * @param isbn
     * @param issn
     * @param url
     * @param urn
     * @param doi
     * @param pages
     * @param publisher
     * @param school
     * @param series
     * @param title
     * @param type
     * @param volume
     * @param year
     * @param key
     * @param file
     * @param ee
     * @param crossref
     * @param bibsource
     * @param issueDate
     * @param abstractInfo
     * @param numpages
     * @param editors
     * @param location
     * @param collection
     * @param pmid
     * @param fieldType
     */
    public Documents(String name, LocalDate creationDate, Integer idUser, String categories, String keywords, String ethics4EU, String address, String author, String booktitle, String chapter, String edition, String editor, String howpublished, String institution, String journal, String month, String note, String number, String organization, String isbn, String issn, String url, String urn, String doi, String pages, String publisher, String school, String series, String title, String type, String volume, String year, String key, String file, String ee, String crossref, String bibsource, String issueDate, String abstractInfo, String numpages, String editors, String location, String collection, String pmid, String fieldType) {
        this.name = name;
        this.creationDate = creationDate;
        this.idUser = idUser;
        this.categories = categories;
        this.keywords = keywords;
        this.ethics4EU = ethics4EU;
        this.address = address;
        this.author = author;
        this.booktitle = booktitle;
        this.chapter = chapter;
        this.edition = edition;
        this.editor = editor;
        this.howpublished = howpublished;
        this.institution = institution;
        this.journal = journal;
        this.month = month;
        this.note = note;
        this.number = number;
        this.organization = organization;
        this.isbn = isbn;
        this.issn = issn;
        this.url = url;
        this.urn = urn;
        this.doi = doi;
        this.pages = pages;
        this.publisher = publisher;
        this.school = school;
        this.series = series;
        this.title = title;
        this.type = type;
        this.volume = volume;
        this.year = year;
        this.key = key;
        this.file = file;
        this.ee = ee;
        this.crossref = crossref;
        this.bibsource = bibsource;
        this.issueDate = issueDate;
        this.abstractInfo = abstractInfo;
        this.numpages = numpages;
        this.editors = editors;
        this.location = location;
        this.collection = collection;
        this.pmid = pmid;
        this.fieldType = fieldType;
    }

    public Documents(Long idDcos, String name, LocalDate creationDate, Integer idUser, String categories, String keywords, String ethics4EU, String address, String author, String booktitle, String chapter, String edition, String editor, String howpublished, String institution, String journal, String month, String note, String number, String organization, String isbn, String issn, String url, String urn, String doi, String pages, String publisher, String school, String series, String title, String type, String volume, String year, String key, String file, String ee, String crossref, String bibsource, String issueDate, String abstractInfo, String numpages, String editors, String location, String collection, String pmid, String fieldType) {
        this.idDcos = idDcos;
        this.name = name;
        this.creationDate = creationDate;
        this.idUser = idUser;
        this.categories = categories;
        this.keywords = keywords;
        this.ethics4EU = ethics4EU;
        this.address = address;
        this.author = author;
        this.booktitle = booktitle;
        this.chapter = chapter;
        this.edition = edition;
        this.editor = editor;
        this.howpublished = howpublished;
        this.institution = institution;
        this.journal = journal;
        this.month = month;
        this.note = note;
        this.number = number;
        this.organization = organization;
        this.isbn = isbn;
        this.issn = issn;
        this.url = url;
        this.urn = urn;
        this.doi = doi;
        this.pages = pages;
        this.publisher = publisher;
        this.school = school;
        this.series = series;
        this.title = title;
        this.type = type;
        this.volume = volume;
        this.year = year;
        this.key = key;
        this.file = file;
        this.ee = ee;
        this.crossref = crossref;
        this.bibsource = bibsource;
        this.issueDate = issueDate;
        this.abstractInfo = abstractInfo;
        this.numpages = numpages;
        this.editors = editors;
        this.location = location;
        this.collection = collection;
        this.pmid = pmid;
        this.fieldType = fieldType;
    }

    public Long getIdDcos() {
        return idDcos;
    }

    public void setIdDcos(Long idDcos) {
        this.idDcos = idDcos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getEthics4EU() {
        return ethics4EU;
    }

    public void setEthics4EU(String ethics4EU) {
        this.ethics4EU = ethics4EU;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getHowpublished() {
        return howpublished;
    }

    public void setHowpublished(String howpublished) {
        this.howpublished = howpublished;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getEe() {
        return ee;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }

    public String getCrossref() {
        return crossref;
    }

    public void setCrossref(String crossref) {
        this.crossref = crossref;
    }

    public String getBibsource() {
        return bibsource;
    }

    public void setBibsource(String bibsource) {
        this.bibsource = bibsource;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getAbstractInfo() {
        return abstractInfo;
    }

    public void setAbstractInfo(String abstractInfo) {
        this.abstractInfo = abstractInfo;
    }

    public String getNumpages() {
        return numpages;
    }

    public void setNumpages(String numpages) {
        this.numpages = numpages;
    }

    public String getEditors() {
        return editors;
    }

    public void setEditors(String editors) {
        this.editors = editors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getPmid() {
        return pmid;
    }

    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String bibtexGenerator(){
        String result = "";
        result = ("@" + getFieldType() + "{" + getName() + ", ");
        if(address != null) result = result + "address={" + address + "}, ";
        if(author != null) result = result + "author={" + author + "}, ";
        if(booktitle != null) result = result + "booktitle={" + booktitle + "}, ";
        if(chapter != null) result = result + "chapter={" + chapter + "}, ";
        if(edition != null) result = result + "edition={" + edition + "}, ";
        if(editor != null) result = result + "editor={" + editor + "}, ";
        if(howpublished != null) result = result + "howpublished={" + howpublished + "}, ";
        if(institution != null) result = result + "institution={" + institution + "}, ";
        if(journal != null) result = result + "journal={" + journal + "}, ";
        if(month != null) result = result + "month={" + month + "}, ";
        if(note != null) result = result + "note={" + note + "}, ";
        if(number != null) result = result + "number={" + number + "}, ";
        if(organization != null) result = result + "organization={" + organization + "}, ";
        if(isbn != null) result = result + "isbn={" + isbn + "}, ";
        if(issn != null) result = result + "issn={" + issn + "}, ";
        if(url != null) result = result + "url={" + url + "}, ";
        if(urn != null) result = result + "urn={" + urn + "}, ";
        if(doi != null) result = result + "doi={" + doi + "}, ";
        if(pages != null) result = result + "pages={" + pages + "}, ";
        if(publisher != null) result = result + "publisher={" + publisher + "}, ";
        if(school != null) result = result + "school={" + school + "}, ";
        if(series != null) result = result + "series={" + series + "}, ";
        if(title != null) result = result + "title={" + title + "}, ";
        if(type != null) result = result + "type={" + type + "}, ";
        if(volume != null) result = result + "volume={" + volume + "}, ";
        if(year != null) result = result + "year={" + year + "}, ";
        if(key != null) result = result + "key={" + key + "}, ";
        if(file != null) result = result + "file={" + file + "}, ";
        if(ee != null) result = result + "ee={" + ee + "}, ";
        if(crossref != null) result = result + "crossref={" + crossref + "}, ";
        if(bibsource != null) result = result + "bibsource={" + bibsource + "}, ";
        if(issueDate != null) result = result + "issue_date={" + issueDate + "}, ";
        if(abstractInfo != null) result = result + "abstract={" + abstractInfo + "}, ";
        if(numpages != null) result = result + "numpages={" + numpages + "}, ";
        if(editors != null) result = result + "editors={" + editors + "}, ";
        if(location != null) result = result + "location={" + location + "}, ";
        if(collection != null) result = result + "collection={" + collection + "}, ";
        if(pmid != null) result = result + "pmid={" + pmid + "}, ";
        if(ethics4EU != null) result = result + "ethics4EU={" + ethics4EU + "}, ";
        result = result.substring(0, result.length() - 2) + "}";
        return result;
    }
}
