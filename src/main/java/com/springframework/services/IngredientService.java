package com.springframework.services;

import com.springframework.commands.IngredientCommand;
import reactor.core.publisher.Mono;

public interface IngredientService {

    //    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);
    Mono<IngredientCommand> findByRecipeIdAndIngredientId(String recipeId, String ingredientId);

    //    IngredientCommand saveIngredientCommand(IngredientCommand command);
    Mono<IngredientCommand> saveIngredientCommand(IngredientCommand command);

    Mono<Void> deleteById(String recipeId, String idToDelete);
}
