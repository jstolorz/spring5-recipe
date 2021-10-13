package org.bluesoft.controllers;


import org.bluesoft.commands.RecipeCommand;
import org.bluesoft.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model){
       model.addAttribute("recipe",new RecipeCommand());
       return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        final RecipeCommand saveRecipeCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/show/" + saveRecipeCommand.getId();
    }
}
