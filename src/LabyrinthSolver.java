import java.awt.Frame;
import java.util.*;

/**
 * This class includes methods use to solve any Labyrinth using BREADFirstSearch
 * algorithm by converting a labyrinth to a graph and find the passable nodes.
 */
public class LabyrinthSolver {

	/**
	 * Create enum of color for the color of the nodes
	 */
	public static enum Color {
		// all color needed for BreadFirstSearch
		WHITE, GRAY, BLACK;
	}

	/**
	 * Converts a maze position to graph vertex number,, i.e (0,0) will be node
	 * 0.
	 */
	public static int labyrinthToNodeNumber(int l, int w, int labwidth) {
		// some mathy, scary stuffs
		int nodeNumber = l * labwidth + w;
		return nodeNumber;
	}

	/**
	 * Converts the labyrinth into a graph representation by adding the
	 * appropriate edges.
	 */
	public static Graph labyrinthToGraph(Labyrinth lab, Graph mazeGraph) {
		// loop through each nodes in the labyritnh
		for (int i = 0; i < lab.getLength(); i++) {
			for (int j = 0; j < lab.getWidth(); j++) {
				// if it's passable
				if (lab.getNode(i, j).isPassable()) {
					// create 2 arrays
					int[] arr1 = { i + 1, i, i - 1, i + 1 };
					int[] arr2 = { j, j - 1, j, j };

					// loop through each elements in array
					for (int v = 0; v < arr1.length; v++) {
						// current nodes in the array
						int n = arr1[v];
						int m = arr2[v];

						// get the labyrinth node
						LabyrinthNode labyrinthNode = lab.getNode(n, m);

						// if it's passable then add edges
						if (labyrinthNode != null && labyrinthNode.isPassable()) {
							// from and to nodes
							int from = labyrinthToNodeNumber(i, j,
									lab.getWidth());
							int to = labyrinthToNodeNumber(n, m, lab.getWidth());

							// add edge
							mazeGraph.addEdge(from, to);
						}
					}
				}
			}
		}
		return mazeGraph;
	}

	/**
	 * The BREAD first search algorithm to search for the shortest path bw two
	 * nodes in a graph.
	 */
	public static int[] breadFirstSearch(Graph mazeGraph) {

		// Color array
		Color[] color = new Color[mazeGraph.getVertexCount()];

		// distance array
		int[] d = new int[mazeGraph.getVertexCount()];

		// path array
		int[] pi = new int[mazeGraph.getVertexCount()];

		// loop thru each vertex
		for (int u = 1; u < mazeGraph.getVertexCount(); u++) {

			// change all nodes color to white
			color[u] = Color.WHITE;

			// d set to -1
			d[u] = -1;

			// pi set to -1
			pi[u] = -1;
		}

		// the entrance node
		int start = 0;

		// set color gray to entrance
		color[start] = Color.GRAY;

		// entrance's d is 0
		d[start] = 0;

		// pi of entrance is -1
		pi[start] = -1;

		// create a queue to hold the nodes for the algorithm
		Queue<Integer> vertexQueue = new LinkedList();

		// add entrance into queue
		vertexQueue.add(start);

		// while queue is not empty
		while (!vertexQueue.isEmpty()) {

			// get & remove the first node in queue, put in u
			int u = vertexQueue.remove();

			// the adjacency array of u, start with entrance
			int[] adjArray = mazeGraph.getAdjacent(u);

			// loop thru each neighbors of u
			for (int v = 0; v < adjArray.length; v++) {

				// if it's "undiscovered"
				if (color[adjArray[v]] == Color.WHITE) {

					// then now it's "discovered"
					color[adjArray[v]] = Color.GRAY;

					// increase d
					d[adjArray[v]] = d[u] + 1;

					// assign u to pi of v
					pi[adjArray[v]] = u;

					// add v in the queue
					vertexQueue.add(adjArray[v]);
				}
			}

			// u color is now black
			color[u] = Color.BLACK;
		}

		// the last node of the maze graph's pi sent to v
		int v = pi[mazeGraph.getVertexCount() - 1];

		// path counter
		int pathCount = 1;

		// while it's not -1
		while (v >= 0) {

			// increase path count
			pathCount++;

			// assign pi of v to v
			v = pi[v];
		}

		// create an array of the passable path, length path count
		int[] path = new int[pathCount];

		// the last node of the maze graph's pi sent to v
		v = pi[mazeGraph.getVertexCount() - 1];

		// last node of path is the last node of maze graph
		path[pathCount - 1] = mazeGraph.getVertexCount() - 1;

		// while its not -1
		while (v >= 0) {

			// second to last node in path is v
			path[pathCount - 2] = v;

			// decrease path count
			pathCount--;

			// assign pi of v to v
			v = pi[v];
		}

		// return the array of passable path
		return path;
	}

	public static void main(String[] args) {
		// Design the Labyrinth
		Labyrinth testLab = new Labyrinth();
		System.out.println("The Starting Labyrinth");
		System.out.println(testLab.drawMap());

		// Convert the Labyrinth to a graph
		Graph mazeGraph = new GraphMatrix(testLab.getLength()
				* testLab.getWidth());
		labyrinthToGraph(testLab, mazeGraph);
		System.out.println(mazeGraph);

		// Draw the final path
		int[] path = breadFirstSearch(mazeGraph);
		if (path == null)
			System.out.println("There is no solution path");
		else
			System.out.println(Arrays.toString(path));
	}
}
