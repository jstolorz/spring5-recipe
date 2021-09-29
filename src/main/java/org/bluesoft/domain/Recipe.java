package org.bluesoft.domain;

import javax.persistence.*;
import java.util.Set;

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

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

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

    Set<Ingredient> getIngredients() {
        return ingredients;
    }

    void setIngredients(final Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    Difficulty getDifficulty() {
        return difficulty;
    }

    void setDifficulty(final Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    Set<Category> getCategories() {
        return categories;
    }

    void setCategories(final Set<Category> categories) {
        this.categories = categories;
    }
}
