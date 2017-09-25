/**
 * This class represents the Graph (bidirectional) data structure with an
 * adjacency matrix. Have instance variable of an 2D array boolean and the
 * number of vertices in the graph.
 */
public class GraphMatrix implements Graph {
	protected boolean[][] vertexMatrix;
	protected int vertexCount;

	/**
	 * Constructor for the graph represented by adjacency matrix Takes in the
	 * number of vertices as a parameter
	 */
	public GraphMatrix(int vertexCount) {
		// number of vertices
		this.vertexCount = vertexCount;

		// 2D array of rows and columns of vertices numbers
		vertexMatrix = new boolean[vertexCount][vertexCount];
	}

	/**
	 * Add bi-directional edge to the graph
	 */
	public void addEdge(int from, int to) {
		// set boolean to true if there is an edge
		if (from >= 0 && from < vertexCount && to >= 0 && to < vertexCount) {
			vertexMatrix[from][to] = true;
			vertexMatrix[to][from] = true;
		}
	}

	/**
	 * Delete bi-directional edge from the graph
	 */
	public void deleteEdge(int from, int to) {
		// set boolean to false if there isnt an edge
		if (from >= 0 && from < vertexCount && to >= 0 && to < vertexCount) {
			vertexMatrix[from][to] = false;
			vertexMatrix[to][from] = false;
		}
	}

	/**
	 * GetEdge returns true if edge exists and false if edge does not exist
	 */
	public boolean getEdge(int from, int to) {
		if (from >= 0 && from < vertexCount && to >= 0 && to < vertexCount) {
			return vertexMatrix[from][to];
		}

		else {
			return false;
		}
	}

	/**
	 * getAdjacent returns array filled with vertices adjacent to the given node
	 */
	public int[] getAdjacent(int from) {
		// array of adjacent vertices
		int[] neighbors = new int[vertexCount];

		// index for the array
		int j = 0;

		// loop through each vertices in graph
		for (int i = 0; i < vertexCount; i++) {
			// if there is an edge between those
			if (vertexMatrix[from][i]) {
				// then add that vertices in the array
				neighbors[j] = i;

				// update index
				j++;
			}
		}
		return neighbors;
	}

	/**
	 * getVertexCount returns count of vertices in the graph
	 */
	public int getVertexCount() {
		return vertexCount;
	}
}
