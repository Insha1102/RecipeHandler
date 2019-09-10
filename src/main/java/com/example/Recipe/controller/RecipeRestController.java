package com.example.Recipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Recipe.entity.Recipe;
import com.example.Recipe.service.RecipeService;
import com.example.Recipe.exception.RecordNotFoundException;

@RestController

public class RecipeRestController {
	 @Autowired
	 private RecipeService recipeService;
	 
	 public void setRecipeService(RecipeService recipeService) {
	  this.recipeService = recipeService;
	 }

	 
	 
	 @GetMapping("/api/recipies")
	 public List<Recipe> getRecipies() {
	  List<Recipe> recipies = recipeService.retrieveRecipies();
	  return recipies;
	 }
	 
	 @RequestMapping(value="/api/recipies/retrieveall", method = RequestMethod.GET , produces= MimeTypeUtils.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Recipe>> retrieveRecipies() {
	  try {
		  return new ResponseEntity<List<Recipe>>(recipeService.retrieveRecipies(), HttpStatus.OK);
	  }catch(Exception e) {
		  return new ResponseEntity<List<Recipe>>(HttpStatus.BAD_REQUEST);
	  }
	 }
	 
	 @GetMapping("/api/recipies/{recipeId}")
	 public Recipe getRecipe(@PathVariable(name="recipeId")Long recipeId) {
	  return recipeService.getRecipe(recipeId);
	 }
	 
	 @PostMapping("/api/recipies")
	 public void saveRecipe(Recipe recipe){
	  recipeService.saveRecipe(recipe);
	  System.out.println("Recipe Saved Successfully");
	 }
	 
	 @DeleteMapping(path="/delete/{recipeId}")
	 public String deleteRecipe(@PathVariable(name="recipeId")Long recipeId){
	  recipeService.deleteRecipe(recipeId);
	  return "redirect:recipelist.html";
	 }

	 @PutMapping("/api/recipies/{recipeId}")
	 public void updateRecipe(@RequestBody Recipe recipe,
	   @PathVariable(name="recipeId")Long recipeId){
	  Recipe rcp = recipeService.getRecipe(recipeId);
	  if(rcp != null){
	   recipeService.updateRecipe(recipe);
	  }
	 }
	
}
