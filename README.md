InterJob
========

#### Steps to run it:
1. Run the __database.sql__ script in your MySQL-installation to create the necessary database __dbinterjob__. You can find the SQL-script in the __utils__-folder.
2. Use the __data.sql__ script to insert some example data in the database.
3. Set the username and password of your MySQL-installation in the __glassfish-resources.xml__ file (InterJob-ejb -> Server Resources).
4. Run __InterJob-ejb__ and __Interjob-war__.
5. Run __InterJob__ (triangle).
   * Only running the __Interjob-war__ doesnt't work!
6. Test everything in your browser.
   * The address should be: http://localhost:8080/InterJob-war
