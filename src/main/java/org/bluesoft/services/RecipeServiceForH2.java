package org.bluesoft.services;

import lombok.extern.slf4j.Slf4j;
import org.bluesoft.commands.RecipeCommand;
import org.bluesoft.converters.RecipeCommandToRecipe;
import org.bluesoft.converters.RecipeToRecipeCommand;
import org.bluesoft.domain.Recipe;
import org.bluesoft.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public
class RecipeServiceForH2 implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceForH2(final RecipeRepository recipeRepository, final RecipeCommandToRecipe recipeCommandToRecipe, final RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.info("Get all recipes...");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(final Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe not Found!");
        }

        return recipeOptional.get();
    }

    @Override
    public RecipeCommand saveRecipeCommand(final RecipeCommand recipeCommand) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
