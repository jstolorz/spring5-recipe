package org.bluesoft.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne
    private UnitOfMeasure unitOfMeasure;

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

    BigDecimal getAmount() {
        return amount;
    }

    void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    Recipe getRecipe() {
        return recipe;
    }

    void setRecipe(final Recipe recipe) {
        this.recipe = recipe;
    }

    UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    void setUnitOfMeasure(final UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
