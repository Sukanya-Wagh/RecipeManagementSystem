package com.recipe.dao;

import com.recipe.model.Ingredient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class IngredientDAO
{
    private EntityManager entityManager;

    public IngredientDAO()
    {
        entityManager = Persistence.createEntityManagerFactory("recipe_unit").createEntityManager();
    }

    public void addIngredient(Ingredient ingredient) 
    {
        EntityTransaction transaction = entityManager.getTransaction();
        try 
        {
            transaction.begin();
            entityManager.persist(ingredient);
            transaction.commit();
        } 
        catch (Exception e)
        {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        }
    }
}
