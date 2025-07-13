package com.recipe.model;

import com.recipe.config.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try 
        {
            boolean running = true;
            while (running) 
            {
                System.out.println("\n====== Recipe Management System ======");
                System.out.println("1. Add Recipe");
                System.out.println("2. View Recipes");
                System.out.println("3. Delete Recipe");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine();

                switch (choice) 
                {
                    case "1":
                        addRecipe(em);
                        break;
                    case "2":
                        viewRecipes(em);
                        break;
                    case "3":
                        deleteRecipe(em);
                        break;
                    case "4":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
                System.out.println("\nThank you for using Recipe Management System. Visit again!");
            }
            
            
        }
        finally
        {
            em.close();
            JPAUtil.shutdown();
            scanner.close();
        }
    }

    private static void addRecipe(EntityManager em) 
    {
        System.out.println("\n-- Add New Recipe --");

        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();

        System.out.print("Enter recipe description: ");
        String description = scanner.nextLine();

        System.out.print("Enter recipe instructions: ");
        String instructions = scanner.nextLine();

        System.out.print("\nHow many ingredients to add? ");
        int ingCount = 0;
        while (true)
        {
            String ingCountStr = scanner.nextLine();
            try
            {
                ingCount = Integer.parseInt(ingCountStr);
                if (ingCount < 0) 
                {
                    System.out.print("Please enter a positive number: ");
                    continue;
                }
                break;
            } 
            catch (NumberFormatException e) 
            {
                System.out.print("Invalid number. Enter again: ");
            }
        }

        Set<Ingredient> ingredients = new HashSet<>();
        for (int i = 1; i <= ingCount; i++)
        {
            System.out.print("Enter ingredient " + i + " name: ");
            String ingredientName = scanner.nextLine();
            ingredients.add(new Ingredient(ingredientName));
        }

        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setInstructions(instructions);

   
        for (Ingredient ing : ingredients)
        {
            ing.setRecipe(recipe);
        }
        recipe.setIngredients(ingredients);

        EntityTransaction tx = em.getTransaction();
        try 
        {
            tx.begin();
            em.persist(recipe);
            tx.commit();
            System.out.println("Recipe added successfully.");
        } 
        catch (Exception e) 
        {
            if (tx.isActive()) tx.rollback();
            System.err.println("Error saving recipe: " + e.getMessage());
        }
    }

    private static void viewRecipes(EntityManager em)
    {
        System.out.println("\n-- All Recipes --");

        TypedQuery<Recipe> query = em.createQuery("SELECT r FROM Recipe r", Recipe.class);
        List<Recipe> recipes = query.getResultList();

        if (recipes.isEmpty()) 
        {
            System.out.println("No recipes found.");
            return;
        }

        for (Recipe r : recipes)
        {
            System.out.println("ID: " + r.getId());
            System.out.println("Name: " + r.getName());
            System.out.println("Description: " + r.getDescription());
            System.out.println("Instructions: " + r.getInstructions());
            System.out.println("Ingredients:");
            if (r.getIngredients() == null || r.getIngredients().isEmpty()) {
                System.out.println("  None");
            }
            else
            {
                for (Ingredient ing : r.getIngredients())
                {
                    System.out.println("  - " + ing.getName());
                }
            }
            System.out.println("---------------------------");
        }
    }

    private static void deleteRecipe(EntityManager em)
    {
        System.out.print("\nEnter Recipe ID to delete: ");
        String idStr = scanner.nextLine();

        try 
        {
            int id = Integer.parseInt(idStr);
            Recipe recipe = em.find(Recipe.class, id);
            if (recipe == null) {
                System.out.println("Recipe not found with ID " + id);
                return;
            }

            EntityTransaction tx = em.getTransaction();
            try
            {
                tx.begin();
                em.remove(recipe);
                tx.commit();
                System.out.println("Recipe deleted successfully.");
            } 
            catch (Exception e) 
            {
                if (tx.isActive()) tx.rollback();
                System.err.println("Error deleting recipe: " + e.getMessage());
            }
            
        } 
        catch (NumberFormatException e)
        {
            System.out.println("Invalid ID format.");
        }
    }
}
