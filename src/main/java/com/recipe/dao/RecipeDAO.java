package com.recipe.dao;

import com.recipe.model.Recipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class RecipeDAO 
{
    private EntityManager entityManager;

    public RecipeDAO() 
    {
        entityManager = Persistence.createEntityManagerFactory("recipe_unit").createEntityManager();
    }

    public void addRecipe(Recipe recipe) 
    {
        EntityTransaction transaction = entityManager.getTransaction();
        try 
        {
            transaction.begin();
            entityManager.persist(recipe);
            transaction.commit();
        } 
        catch (Exception e)
        {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Recipe> getAllRecipes()
    {
        return entityManager.createQuery("SELECT r FROM Recipe r", Recipe.class).getResultList();
    }

    public Recipe findRecipeById(int id)
    {
        return entityManager.find(Recipe.class, id);
    }

    public void deleteRecipe(int id)
    {
        EntityTransaction transaction = entityManager.getTransaction();
        try
        {
            transaction.begin();
            Recipe r = entityManager.find(Recipe.class, id);
            if (r != null)
            {
                entityManager.remove(r);
            }
            transaction.commit();
        }
        catch (Exception e) 
        {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
    }
}
