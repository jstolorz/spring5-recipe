package org.bluesoft.services;

import org.bluesoft.domain.Recipe;
import org.bluesoft.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
class RecipeServiceForH2 implements RecipeService {

    private final RecipeRepository recipeRepository;

    RecipeServiceForH2(final RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
