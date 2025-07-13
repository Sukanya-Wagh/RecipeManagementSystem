# 🍰 RECIPE MANAGEMENT SYSTEM

*A Clean, Console-Based Java Application for Managing Recipes Using Hibernate JPA and PostgreSQL.

---

 🚀 Features

- ➕ Add new recipes (name, description, instructions, ingredients)
- 📋 View all stored recipes
- ❌ Delete a recipe by ID
- 🧭 Console-based interactive menu system

---

 🛠️ Technologies Used

 Tool / Technology             Version       
 ☕ Java                        17+            
 🔗 Hibernate ORM               7.0.5.Final    
 📦 Jakarta Persistence API     3.2.0       
 🐘 PostgreSQL                  15+           
 🧰 Maven                        Project Manager 
 🖥️ Eclipse IDE                 Development     

---

 🗂️ Project Structure
 
RecipeManagementSystem/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/recipe/
│   │   │   ├── config/JPAUtil.java
│   │   │   ├── dao/{RecipeDAO.java, IngredientDAO.java}
│   │   │   ├── model/{Recipe.java, Ingredient.java, Main.java}
│   │   └── resources/META-INF/persistence.xml

 ## Database Table Schema

#Table: 'recipes'
| Column        | Type         |
|---------------|------------------ |
| id            | int (Primary Key) |    
| name          | varchar           |
| description   | varchar           |
| instructions  | text              |

#Table: 'ingredients'
| Column        | Type             |
|---------------|------------------|
| id            | int (Primary Key)|
| name          | varchar          |
| recipe_id     | int (FK)         |

---

# How to Run ?

1. Clone the repository  
2. Import into Eclipse or any IDE  
3. Configure PostgreSQL database ('recipe_db')  
4. Run 'Main.java'  
5. Interact with the console menu

---

# 📸 Sample Output



---
📌 Contact Details  
────────────────────────────  
📝 Name   : Sukanya Govardhan Wagh  
✉️ Email  : waghsukanya153@gmail.com  
🔗 GitHub : https://github.com/Sukanya-Wagh



