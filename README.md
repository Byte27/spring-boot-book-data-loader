# Overview

This is a very simple Spring Boot command-line application that indexes a CSV dataset of books to a relational
database.

# How to run?

1. Create a `books` schema in your local MySQL database: `CREATE SCHEMA books;`
2. Create a Liquibase user: `CREATE USER 'books_admin' IDENTIFIED BY '<password>';`
3. Grant permissions to Liquibase user: `GRANT CREATE, SELECT, DELETE, INSERT, UPDATE, ALTER ON books.* TO 'books_admin';`
4. Create a user for the indexer: `CREATE USER 'book_indexer' IDENTIFIED BY '<password>';`
5. Grant permissions to indexer user: `GRANT SELECT, INSERT, UPDATE ON books.* TO book_indexer;`
6. Download the Goodreads books dataset from Kaggle (<https://www.kaggle.com/datasets/jealousleopard/goodreadsbooks/code?resource=download>)
7. Remove records that can't be easily parsed by Commons CSV: `sed '1571d' books.csv | sed '4513d' | sed '9965d' | sed '10867d' > books.csv`
8. Build the JAR file using `mvn clean package`
9. Run the JAR file using `INDEXER_BOOKS_CSV_PATH=file://<path-to-file> SPRING_DATASOURCE_PASSWORD=<indexer-password> SPRING_LIQUIBASE_PASSWORD=<liquibase-password> java -jar spring-boot-book-data-loader-0.0.1-SNAPSHOT.jar`

You can configure something similar in your IDE of choice.