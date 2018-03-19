import java.util.ArrayList;

public class AdjacencyList {
	private int V;
	private ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	AdjacencyList (int V, AdjacencyMatrix matrix) {
		setV(V);
		setList(matrix.getMatrix());
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public ArrayList<ArrayList<Integer>> getList() {
		return list;
	}

	public void setList(int[][] matrix) {
		for (int i = 0; i < V; i++) {
			list.add(new ArrayList<Integer>());
			for (int j = 0; j < V; j++) {
				if (matrix[i][j] != 0) {
					list.get(i).add(j);
				}
			}
		}
	}
}

