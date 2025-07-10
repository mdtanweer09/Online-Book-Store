# 📚 Online Book Store

This is a simple web-based **Online Book Store** web application built using **Java (Servlets & JSP)**, **MySQL**, and **HTML/CSS**. 

>  **Purpose**: This project was created to test and demonstrate what I’ve learned so far in Java web development, including:
> - Backend with Java Servlets and JSP.
> - Frontend with HTML, and basic of CSS.
> - Connecting to and interacting with a MySQL database.
> - Implementing CRUD(Create, Read, Update, Delete) operations in a real-world use case.


## 🚀 Features

- ➕ Add new books with details:
  - Book Name
  - Book Author Name
  - Book Price
- 📋 View a list of all added books
- ✏️ Edit existing book details
- 🗑️ Delete books from the list

## 🖥️ User Interface

### ➕ Add Book Page (Initial View)

When the application loads, it shows a form to add a new book with the following input fields:

- An input field for the 📖 **Book Name**
- An input field for the ✍️**Author**
- An input field for the 💲**Price**
- A **Save** button to store the book in the database.
  
At the top, there's also a **"List All Books"** option.

![Add Book](https://github.com/mdtanweer09/Online-Book-Store/blob/main/AddBook.png)

---

### 📋 List All Books

Clicking on **"List All Books"** displays a table of all books currently stored in the database.

Each book entry includes:
- Book Name
- Author
- Price
- ✏️ **Edit** button
- 🗑️ **Delete** button

At the top of this page, there's a option **"Add New Book"** to return to the book entry page.

![ListOfBook](https://github.com/mdtanweer09/Online-Book-Store/blob/main/ListOfBook.png)

---

### ✏️ Edit Book

Clicking the **Edit** button on a book row opens a form pre-filled with that book's data, allowing users to update the information.

![Edit Book](https://github.com/mdtanweer09/Online-Book-Store/blob/main/EditBook.png)

---

### 🗑️ Delete Book

Clicking the **Delete** button triggers a **confirmation popup** asking the user:

> **Are you sure?**

Only if the user confirms will the book be removed from the database.

![Delete Book](https://github.com/mdtanweer09/Online-Book-Store/blob/main/DeleteBook.png)

---


## 🛠️ Technologies Used

- **Backend**: Java (Servlets & JSP)
- **Frontend**: HTML, CSS
- **Database**: MySQL
- **Server**: Apache Tomcat

---

## 🧰 Database Setup

1. Create a MySQL database (e.g., `bookstore`).
2. Run the following SQL to create the `books` table:

```sql
CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);
```

## 🧠 What I Learned

Working on this Online Book Store project helped me strengthen my understanding of:

- Setting up and using **Servlets** and **JSP** for web applications
- Performing **CRUD operations** with **MySQL**
- Connecting frontend and backend logic effectively

 This project was not just a technical task but also an exercise in building something from scratch and applying all the concepts I’ve studied so far.

---
