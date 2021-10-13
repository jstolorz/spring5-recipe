package org.bluesoft.services;

import org.bluesoft.commands.RecipeCommand;
import org.bluesoft.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
