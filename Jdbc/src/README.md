# PostgreSQL JDBC Connection and Query Example

This Java program demonstrates how to connect to a PostgreSQL database using JDBC, execute a simple SQL query, and print the results.

## Prerequisites

- Java Development Kit (JDK) installed on your machine
- PostgreSQL database installed and running
- PostgreSQL JDBC driver (usually included in the JDBC library)

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/Researcher0619/PostgreSQL-JDBC-Example.git

Open the project in your favorite Java IDE or compile and run using the command line.

Make sure to update the database connection details in the main method:


   ...bash
connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental", "your_username", "your_password");


3. Run the program and observe the console output.

## Explanation

. The Main.java file contains the main Java program.

. The try-catch-finally block is used to handle database connection, query execution, and resource closing.

. Change the database connection details, such as URL, username, and password, based on your PostgreSQL setup.

. The program connects to the "dvdrental" database and retrieves the first 10 records from the "actor" table.

. The results are printed to the console.
Feel free to use and modify the code according to your needs.

