package org.bluesoft.services;

import lombok.extern.slf4j.Slf4j;
import org.bluesoft.domain.Recipe;
import org.bluesoft.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public
class RecipeServiceForH2 implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceForH2(final RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.info("Get all recipes...");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
