# crudrepository-example
Simple example that shows how the Spring Data CrudRepository works

CrudRepository is a Spring Data interface for generic CRUD operations on a repository of a specific type. This code source is a simple example that shows how to make use of CrudRepository. The CRUD operations are performed on a Mysql database with two tables: product and 
category (there is a One to Many relationship between the two tables).

# Run the app

Just download the zip files of the of the application, import them as existing Maven projects into eclipse, create the crudrepository_db database in your Mysql DBMS, add some example data and you are good to go.

The application can be run using Postman rest client. You guys can also interact with the API via the Swagger API development tool which you can access buy this  link: http://localhost:8080/
