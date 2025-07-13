# 🍰 RECIPE MANAGEMENT SYSTEM

*A Clean, Console-Based Java Application for Managing Recipes Using Hibernate JPA and PostgreSQL.
*A console-based application to manage and organize your favorite recipes efficiently.
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
 
 <img width="454" height="379" alt="Image" src="https://github.com/user-attachments/assets/218dae63-d9df-4d0e-bb36-3926b0b6b825" />

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
<img width="1162" height="497" alt="Image" src="https://github.com/user-attachments/assets/15e5de7b-a9c9-4826-a165-384f24f8f298" />


---
📌 Contact Details  
────────────────────────────  
📝 Name   : Sukanya Govardhan Wagh  
✉️ Email  : waghsukanya153@gmail.com  
🔗 GitHub : https://github.com/Sukanya-Wagh



