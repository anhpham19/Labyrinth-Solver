/**
 * This is the interface for the general Graph data structure.
 * 
 * @author Anh Pham
 * @version Aprl 13
 */
public interface Graph {

    // add bi-directional edge to the graph
    public void addEdge(int from, int to);

    // delete bi-directional edge from the graph
    public void deleteEdge(int from, int to);

    // getEdge returns true if edge exists
    // and false if edge does not exist
    public boolean getEdge(int from, int to);

    // getAdjacent returns array filled with
    // vertices adjacent to the given node
    public int[] getAdjacent(int from);

    // getVertexCount returns count of
    // vertices in the graph
    public int getVertexCount();
}
