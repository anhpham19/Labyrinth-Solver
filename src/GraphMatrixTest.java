import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class contains JUnit tests for the Graph Matrix classes. 
 * Test on two vertex full and empty and three vertex graph.
 */
public class GraphMatrixTest {
	
	// create test graphs
    GraphMatrix twoVertexEmptyGraph;
    GraphMatrix twoVertexFullGraph;
    GraphMatrix testGraph;
    
    @Before
    public void setUp() {
        twoVertexEmptyGraph = new GraphMatrix(2);
        twoVertexFullGraph  = new GraphMatrix(2);
        testGraph = new GraphMatrix(3);
        twoVertexFullGraph.vertexMatrix[0][1] = true;
        twoVertexFullGraph.vertexMatrix[1][0] = true;
    }

    @Test
    public void constructor() {
        assertNotNull(twoVertexEmptyGraph);
        assertNotNull(twoVertexFullGraph);
    }

    @Test
    public void addEdge() {
        twoVertexEmptyGraph.addEdge(0,1);
        assertTrue(twoVertexEmptyGraph.vertexMatrix[0][1]);
        assertTrue(twoVertexEmptyGraph.vertexMatrix[1][0]);
    }

    @Test
    public void deleteEdge() {
        twoVertexEmptyGraph.vertexMatrix[0][1] = true;
        assertTrue(twoVertexEmptyGraph.vertexMatrix[0][1]);
        twoVertexEmptyGraph.deleteEdge(0,1);
        assertFalse(twoVertexEmptyGraph.vertexMatrix[0][1]);
        assertFalse(twoVertexEmptyGraph.vertexMatrix[1][0]);

        twoVertexFullGraph.deleteEdge(1,0);
        assertFalse(twoVertexFullGraph.vertexMatrix[1][0]);
    }

    @Test
    public void getEdge() {
        twoVertexFullGraph.vertexMatrix[0][1] = true;
        assertTrue(twoVertexFullGraph.getEdge(0,1));

        assertTrue(twoVertexFullGraph.getEdge(0,1));
        assertTrue(twoVertexFullGraph.getEdge(1,0));
    }
    
    @Test
    public void getVertexCount()
    {
    	assertEquals(2, twoVertexFullGraph.getVertexCount());
    	assertEquals(2, twoVertexEmptyGraph.getVertexCount());
    }
    
    @Test
    public void getAdjacent()
    {
    	testGraph.addEdge(1, 0);
    	testGraph.addEdge(1, 2);
    	int[] expected = new int[3];
    	expected[0] = 0;
    	expected[1] = 2;
    	expected[2] = 0;
    	assertEquals(expected[0], testGraph.getAdjacent(1)[0]);
    	assertEquals(expected[1], testGraph.getAdjacent(1)[1]);
    	assertEquals(expected[2], testGraph.getAdjacent(1)[2]);
    }
}