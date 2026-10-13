# Library Management System (Java)

A desktop library management application built with Java and Swing dialogs. It manages a book catalog, library members, and loans, including late-return fines.

University final project for the Java course (2025 Q2), Universidad Fidélitas. Built by a team of three.

## Features

**Catalog**
- Add new books (title, author, publisher, genre, publication year, status)
- Edit book information and change a book's status (available, borrowed, in repair, lost)
- Display the full catalog as a formatted table

**Loans**
- Register a loan by member ID and book ID, with an automatic return date
- Register a return: the loan is marked as returned on time or late, a fine is calculated per day of delay, and the book becomes available again
- Look up any loan by its ID

**Members**
- Register new members and look up their data
- Update member status (active, delinquent, suspended, inactive)
- View and pay accumulated fines

**Test data**
- Generate random books (up to 50) and random members (up to 30) to try the system without manual entry

**Reports:** planned, not implemented yet.

## Tech

- Java (project configured for JDK 24)
- Swing (`JOptionPane`) for the user interface
- NetBeans / Apache Ant project
- Data is stored in memory (arrays), so it resets every time the program closes

## How to run

1. Clone the repository.
2. Open the `Proyecto Final Java` folder as a project in NetBeans.
3. Run the main class `main.Main`.

From the command line, inside `Proyecto Final Java`:

```
javac -encoding UTF-8 -d build src/main/*.java
java -cp build main.Main
```

On startup the program asks how many random books to generate, then opens the main menu.

## Project structure

```
Proyecto Final Java/
  src/main/
    Main.java       Menus and all application logic (catalog, loans, members)
    Libro.java      Book model (ID, genre and status enums)
    Socio.java      Member model (status, fines, borrowed-book count)
    Prestamo.java   Loan model (dates, status, fine)
  nbproject/        NetBeans project configuration
```

## Team

- Halian Rosse Gaitan Chavarria
- Jose Santos Martinez Hostis
- Emmanuel Rios Castro

### My contribution
<!-- Fill in with what you personally built. Example format: "Book model and catalog module (add, edit, change status, display), random book generator." Be specific and only list what you can explain in an interview. -->

## Possible improvements

- Persistent storage (file or database) instead of in-memory arrays
- The reports module
- Unit tests for the loan and fine calculations
- Replace the fixed-size arrays with collections
