package com.asteras.asteras.files;

/**
 *
 * @author ipitr
 */
public class Publication {

    private String author, title, booktitle, journal;
    private String pages, publisher, year, url, volume;
    private String doi, timestamp, biburl, bibsource;
    private String number;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getPages() {
        return pages;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBiburl() {
        return biburl;
    }

    public void setBiburl(String biburl) {
        this.biburl = biburl;
    }

    public String getBibsource() {
        return bibsource;
    }

    public void setBibsource(String bibsource) {
        this.bibsource = bibsource;
    }

    @Override
    public String toString() {
        StringBuilder builder=  new StringBuilder();
        builder.append("{\n\t\t" + PublicationFields.AUTHOR + " : ").append(author);
        builder.append("\n\t\t" + PublicationFields.TITLE + " : ").append(title);
        builder.append("\n\t\t" + PublicationFields.BOOKTITLE + " : ").append(booktitle);
        builder.append("\n\t\t" + PublicationFields.JOURNAL + " : ").append(journal);
        builder.append("\n\t\t" + PublicationFields.BOOKTITLE + " : ").append(booktitle);
        builder.append("\n\t\t" + PublicationFields.PAGES + " : ").append(pages);
        builder.append("\n\t\t" + PublicationFields.PUBLISHER + " : ").append(publisher);
        builder.append("\n\t\t" + PublicationFields.URL + " : ").append(url);
        builder.append("\n\t\t" + PublicationFields.YEAR + " : ").append(year);
        builder.append("\n\t\t" + PublicationFields.DOI + " : ").append(doi);
        builder.append("\n\t\t" + PublicationFields.TIMESTAMP + " : ").append(timestamp);
        builder.append("\n\t\t" + PublicationFields.BIBURL + " : ").append(biburl);
        builder.append("\n\t\t" + PublicationFields.BIBSOURCE + " : ").append(bibsource);
        builder.append("\n}");
        
        return builder.toString();
    }

}
