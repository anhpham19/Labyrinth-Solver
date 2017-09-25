import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * This class contains JUnit test that test the methods of Labyrinth Solver class.
 */
public class LabyrinthSolverTest {

	// test labyrinth and graph
    Labyrinth testLab;
    Graph g;

    @Before
    public void setup() {
        testLab = new Labyrinth();
        g       = new GraphMatrix(testLab.getLength()*testLab.getWidth());
        g       = LabyrinthSolver.labyrinthToGraph(testLab,g);
    }

    @Test
    public void labyrinthToNodeNumber() {
        int node = LabyrinthSolver.labyrinthToNodeNumber(6,7,10);

        assertEquals(67, node);
    }

    @Test
    public void labyrinthToGraph() {
        int trueCount = 0;

        for(int i = 0; i < g.getVertexCount(); i++) {
            for( int j = 0; j < g.getVertexCount(); j++ ) {
                if( g.getEdge(i, j) )
                    trueCount++;
            }
        }

        assertEquals( 40, trueCount);
    }

    @Test
    public void breadFirstSearch() {
        assertArrayEquals(new int[]{0, 6, 12, 13, 19, 25, 26, 27, 28, 29}, LabyrinthSolver.breadFirstSearch(g));
    }

}