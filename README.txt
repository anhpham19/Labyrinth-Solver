---------------PSA 7: MAZE GRAPH----------------
+ Name: Anh Chau Pham - pham29a@mtholyoke.edu 
+ Name of assignment - PSA 7: Maze Graph
+ Used of late days? : 1 late day 
+ Bonus? : No
+ Attribute to sources:
	- TA: Deepshika + Jessica 
	- http://stackoverflow.com/
	- Algorithms book
	- Professor Peter F. Klemperer - Powerpoint slides_CS211
	- Java API
+ Descriptions of files: (7 java files, 1 txt file)
	- Graph.java: This is the interface for the general Graph data structure.

	- GraphMatrix.java: This class represents the Graph (bidirectional) data structure with an
   	adjacency matrix. Have instance variable of an 2D array boolean and the
  	number of vertices in the graph.

   - GraphMatrixTest.java: This class contains JUnit tests for the Graph Matrix classes. 
   Test on two vertex full and empty and three vertex graph.

   - Labyrinth.java: This class constructs a labyrinth (a maze) that contains the entrance, the
   exit, the passable way and the wall. Construct a 5x6 labyrinth manually.

   - LabyrinthNode.java: Construct a single labyrinth node made out of enum. Contains properties
   passable, entrance and exit.

 	- LabyrinthSolver.java: This class includes methods use to solve any Labyrinth using BREADFirstSearch
  	algorithm by converting a labyrinth to a graph and find the passable nodes.

 	- LabyrinthSolverTest.java: This class contains JUnit test that test the methods of Labyrinth Solver class.

 	- README.txt: The readme and descriptons.