/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asteras.asteras.files;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author ipitr
 */
public class Researcher {

    private String name;
    private List<Publication> publications;

    public Researcher(String name) {
        this.name = name;
        publications = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    @Override
    public String toString() {
        StringBuilder builder =  new StringBuilder();
        builder.append("{\n\tname : ").append(name).append("\n\tpublications : [\n");
        publications.forEach(builder::append);
        builder.append( "\t]\n}\n");
        
        return builder.toString();
    }    

}
