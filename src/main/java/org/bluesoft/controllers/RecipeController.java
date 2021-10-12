package org.bluesoft.controllers;


import org.bluesoft.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class RecipeController {

    private final RecipeService recipeService;

    RecipeController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable Long id, Model model){
        model.addAttribute("recipe", recipeService.findById(id));
        return "recipe/show";
    }
}
