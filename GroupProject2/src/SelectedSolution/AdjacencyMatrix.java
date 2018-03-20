package SelectedSolution;
import java.util.ArrayList;

public class AdjacencyMatrix {
	private int V;
	private int[][] matrix;
	private int[][] distance;
	
	AdjacencyMatrix(int V, int[][] matrix) {
		setV(V);
		setMatrix(matrix);
	}
	
	AdjacencyMatrix(int V, ArrayList<ArrayList<Integer>> list) {
		setV(V);
		matrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				matrix[i][j] = 0;
			}
		}
		int i = 0;
		for (ArrayList<Integer> node: list) {
			for (Integer connection: node) {
				matrix[i][connection] = 1;
			}
			i++;
		}
	}
	
	public int getV() {
		return V;
	}

	public void setV(int V) {
		this.V = V;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public void findDistance() {
		distance = matrix.clone();
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (distance[i][j] == 0) {
					distance[i][j] = V + 1;
				}
			}
		}
		for (int i = 0; i < V; i++) {
			for (int row = 0; row < V; row++) {
				for (int col = 0; col < V; col++) {
					distance[row][col] = Math.min(distance[row][col], distance[row][i] + distance[i][col]);
				}
			}
		}
	}

	public int[][] getDistance() {
		if (distance == null) {
			findDistance();
		}
		return distance;
	}
	
	public Boolean hasCycle() {
		if (distance == null) {
			findDistance();
		}
		Boolean cycle = false;
		for (int i = 0; i < V; i++) {
			if (distance[i][i] < V + 1) {
				cycle = true;
			}
		}
		return cycle;
	}
	
	public int hasConnection() {
		return 0;
	}
}

