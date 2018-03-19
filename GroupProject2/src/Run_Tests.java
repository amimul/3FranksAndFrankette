import java.util.ArrayList;

public class Run_Tests {

	public static void main(String[] args) {
//		int[][] test1 = {{0,1,0,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0}};										// weakly connected, no cycle
//		int[][] test2 = {{0,1,1,1,0}, {0,0,0,1,0}, {0,1,0,0,0}, {0,0,0,0,1}, {0,1,0,0,0}};					// weakly connected, cycle
//		int[][] test3 = {{0,1,1,1,0,0,0},{0,0,0,1,1,0,0},{0,0,0,0,0,1,0},{0,0,1,0,0,1,1},{0,0,0,1,0,0,1},{0,0,0,0,0,0,0},{0,0,0,0,0,1,0}};	// weakly connected, no cycle
//		int[][] test4 = {{0,1,0,1}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}};										// strongly connected, cycle
//		int[][] test5 = {{0,1,0,0}, {0,0,0,0}, {0,0,0,1}, {0,0,0,0}};										// disconnected, no cycles
		int[][] test6 = {{0,1,0,0}, {1,0,0,0}, {0,0,0,1}, {0,0,1,0}};										// disconnected, cycle
//		AdjacencyMatrix matrix1 = new AdjacencyMatrix(4, test1);
//		AdjacencyMatrix matrix2 = new AdjacencyMatrix(5, test2);
//		AdjacencyMatrix matrix3 = new AdjacencyMatrix(7, test3);
//		AdjacencyMatrix matrix4 = new AdjacencyMatrix(4, test4);
//		AdjacencyMatrix matrix5 = new AdjacencyMatrix(4, test5);
		AdjacencyMatrix matrix6 = new AdjacencyMatrix(4, test6);
//		AdjacencyList list1 = new AdjacencyList(4, matrix1);
//		AdjacencyList list2 = new AdjacencyList(5, matrix2);
//		AdjacencyList list3 = new AdjacencyList(7, matrix3);
//		AdjacencyList list4 = new AdjacencyList(4, matrix4);
//		AdjacencyList list5 = new AdjacencyList(4, matrix5);
		AdjacencyList list6 = new AdjacencyList(4, matrix6);
		printMatrix(matrix6.getV(), matrix6.getMatrix());
		System.out.println();
		printList(list6.getV(), list6.getList());
		System.out.println();
		matrix6.findDistance();
		printMatrix(matrix6.getV(), matrix6.getDistance());
		System.out.println();
		System.out.println("Cycle: " + matrix6.hasCycle());
		System.out.println();
		AdjacencyMatrix MFL = new AdjacencyMatrix(list6.getV(), list6.getList());
		printMatrix(MFL.getV(), MFL.getMatrix());
	}
	
	public static void printMatrix(int V, int[][] matrix) {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printList(int V, ArrayList<ArrayList<Integer>> list) {
		int i = 1;
		for (ArrayList<Integer> node: list) {
			System.out.print("Node " + i + ": ");
			for (Integer connection: node) {
				System.out.print(connection + 1 + "->");
			}
			System.out.println();
			i++;
		}
	}
}

