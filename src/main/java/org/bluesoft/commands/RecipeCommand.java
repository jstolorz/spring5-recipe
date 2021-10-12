package org.bluesoft.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bluesoft.domain.Difficulty;
import org.bluesoft.domain.Notes;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Set<CategoryCommand> categories = new HashSet<>();
}
