# BarBeerDrinker-Extended
Creating a mock database. Covering ER diagram and relational schema design, random data generation, pattern implementation, and front end interface

First update involving the creation of an ER diagram and relational schema

Second update involving creating csvs of mostly randomized tuples from set lists. This was done using Java. Patterns on the mock data will be implemented using SQL queries.

Lastly, we expect to create a front end web interface where the database may be reviewed and where queries may be ran.

Current step:
Second Update.

So far, we have create a random tuple generator using Java. We have found an online census of first names and we created a file reader that pulls from a txt version of this file to populate our drinkers database. We have also created the AWS instance with which we will be hosting our project. We have already uploaded the drinkers table.

We will continue by uploading our Items, and Bars CSVs into the proper tables. We will then create data for: Frequents, Sells, On, Bills, and Billed_To. We will upload these into our database and then use queries to ensure that certain patterns, like drinkers only frequenting bars in their own states, will be true for our database.

For the frequents portion of the Second Update, our randomized code generated 36,000 random tuples. We are hoping that the 1/20 chance of each drinker being in state A and 1/20 chance of each bar being in state A means that there is a 1/400 chance that each tuple can exist together. This would bring down the total number of tuples in the frequents table that are valid to our pattern greatly.

After the many hours it took to add the Frequents CSV to the database and running the query to check for matching, we found that an ideal 1393 tuples are valid. This has been reduced greatly from the 36,000 random tuples. 

The next update we committed to github was a big one. We completed the remaining Java code to generate the data. We have also created the CSVS for the remaining entities and relations. We will be uploading the CSVs to the database now to run our queries on in the next step.

We realized that one of our values in our bars list has a comma in the name of the bar. This is problematic since this messes up how we are importing from our CSV. As a precaution, we generate all new CSVs. We also had a hard time with the Import Wizard in MySQL Workbench since it would take hours to load in our data. Because of this, we wrote a python script that loads in the CSVs for us.

After many more hours and many lines of inefficient but easy to understand and reliable code, the generator java file is now complete and the data should have now issues. We resolved issues with duplicate info in primary keys in the data. We implemented patterns such as:
    1. if beer A is sold cheaper than beer B at one bar, it must be sold cheaper than beer B at all bars
    2. also bills will not be issued when bars are closed
    3. items will only be on a bill if it is sold by that bar
    4. bills now have total_price already generated from summing up the prices of all items on the bill
    
We should now have our final data. The only thing left to do is to run the SQL query that ensures frequents[drinker, bar] only includes bars that are in the same state as the drinker. Other than that, we are all done with our data!
