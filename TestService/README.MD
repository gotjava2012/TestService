**Java Developer Service Test**

Modify the code by adding four resources/endpoints that: 
#1  create an order
#2  read   an order
#3  update an order
#4  delete an order

An order is something that tracks the sale of an item.  Feel free to add columns/objects as you see fit.  
The service starts up, listening on port 7005 by running

  ./startup.sh -b script

Cygwin, Git Bash or MINGW can be used if you're using a Windows machine.
You may need to install maven in order to build the project.  The project was originally created with Eclipse and can be 
imported as an existing maven project.  The service utilizes an embedded H2 database.

**FAQ**
Q:  Does the service need to actually start up.
A:  It doesn't need to start up since we're interested more in the code but it doesn't hurt either.