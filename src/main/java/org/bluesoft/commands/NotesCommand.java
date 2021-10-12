package org.bluesoft.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class NotesCommand {
    private Long id;
    private String recipeNotes;
}
