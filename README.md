InterJob
========

#### Steps to run it:
1. Run __database.sql__ script in your MySQL-Installation and insert a entry/user in the USER-table.
2. Check/Change the root password of MySQL in the __glassfish-resources.xml__ file (InterJob-ejb -> Server Resources).
3. Run __InterJob-ejb__ and __Interjob-war__.
4. Run __InterJob__ (triangle).
   * Only running the __Interjob-war__ doesnt't work!
5. Test everything in your browser.
   * The address should be: http://localhost:8080/InterJob-war
