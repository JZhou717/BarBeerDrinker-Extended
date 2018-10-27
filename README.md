# BarBeerDrinker-Extended
Creating a mock database. Covering ER diagram and relational schema design, random data generation, pattern implementation, and front end interface

First update involving the creation of an ER diagram and relational schema

Second update involving creating csvs of mostly randomized tuples from set lists. This was done using Java. Patterns on the mock data will be implemented using SQL queries.

Lastly, we expect to create a front end web interface where the database may be reviewed and where queries may be ran.

Current step:
Second Update.

So far, we have create a random tuple generator using Java. We have found an online census of first names and we created a file reader that pulls from a txt version of this file to populate our drinkers database. We have also created the AWS instance with which we will be hosting our project. We have already uploaded the drinkers table.

We will continue by uploading our Items, and Bars CSVs into the proper tables. We will then create data for: Frequents, Sells, On, Bills, and Billed_To. We will upload these into our database and then use queries to ensure that certain patterns, like drinkers only frequenting bars in their own states, will be true for our database.
