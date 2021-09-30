package org.bluesoft.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipeSet = new HashSet<>();

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

    Set<Recipe> getRecipeSet() {
        return recipeSet;
    }

    void setRecipeSet(final Set<Recipe> recipeSet) {
        this.recipeSet = recipeSet;
    }
}
