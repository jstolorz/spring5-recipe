package org.bluesoft.services;

import org.bluesoft.converters.RecipeCommandToRecipe;
import org.bluesoft.converters.RecipeToRecipeCommand;
import org.bluesoft.domain.Recipe;
import org.bluesoft.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceForH2Test {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceForH2(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    void getRecipesTest() throws Exception {

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipeHashSet = new HashSet<>();
        recipeHashSet.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeHashSet);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(),1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findAllById(Collections.singleton(anyLong()));
    }

    @Test
    void findByIdTest() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        Recipe returnedRecipe = recipeService.findById(1L);

        assertEquals(1L, returnedRecipe.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository,never()).findAll();

    }
}