package Graph;

import org.junit.Test;

public class Test1 {
	@Test
	public void test3() {
		GraphByMatrix g = new GraphByMatrix(GraphByMatrix.DIRECTED_GRAPH, GraphByMatrix.ADJACENCY_MATRIX, 6);
		g.addVertex("1");
		g.addVertex("2");
		g.addVertex("3");
		g.addVertex("4");
		g.addVertex("5");
		g.addVertex("6");

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 1);
		g.addEdge(2, 4);
		g.addEdge(3, 5);
		g.addEdge(2, 4);
		g.addEdge(4, 5);

		g.DFS();
		System.out.println();
		g.DFS2();
		System.out.println();
		g.DFS("2");

		System.out.println();
		g.BFS();
	}
}
