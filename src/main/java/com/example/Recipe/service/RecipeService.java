package com.example.Recipe.service;
import java.util.List;
import com.example.Recipe.entity.Recipe;

public interface RecipeService {
	 public List<Recipe> retrieveRecipies();
	 
	 public Recipe getRecipe(Long recipeId);
	 
	 public void saveRecipe(Recipe recipe);
	 
	 public void deleteRecipe(Long recipeId);
	 
	 public void updateRecipe(Recipe recipe);
	 
	 
}
