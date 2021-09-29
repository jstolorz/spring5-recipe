package org.bluesoft.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    Recipe getRecipe() {
        return recipe;
    }

    void setRecipe(final Recipe recipe) {
        this.recipe = recipe;
    }

    String getRecipeNotes() {
        return recipeNotes;
    }

    void setRecipeNotes(final String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
