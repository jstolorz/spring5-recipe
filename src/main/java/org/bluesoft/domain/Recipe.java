package org.bluesoft.domain;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    Integer getPrepTime() {
        return prepTime;
    }

    void setPrepTime(final Integer prepTime) {
        this.prepTime = prepTime;
    }

    Integer getCookTime() {
        return cookTime;
    }

    void setCookTime(final Integer cookTime) {
        this.cookTime = cookTime;
    }

    Integer getServings() {
        return servings;
    }

    void setServings(final Integer servings) {
        this.servings = servings;
    }

    String getSource() {
        return source;
    }

    void setSource(final String source) {
        this.source = source;
    }

    String getUrl() {
        return url;
    }

    void setUrl(final String url) {
        this.url = url;
    }

    String getDirections() {
        return directions;
    }

    void setDirections(final String directions) {
        this.directions = directions;
    }

    Byte[] getImage() {
        return image;
    }

    void setImage(final Byte[] image) {
        this.image = image;
    }

    Notes getNotes() {
        return notes;
    }

    void setNotes(final Notes notes) {
        this.notes = notes;
    }
}
