package SelectedSolution;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	
	
	 //problem 1
    public boolean cycles(int[][] matrix){
    	ModifiedFloyedWarshal(matrix);
		for(int i=0;i<matrix.length;i++)
			if(matrix[i][i]==1)
				return true;
		return false;
    }
    //problem 2
    public AdjacencyList ConvertToList(int[][] matrix) {
		return new AdjacencyList(matrix.length,new AdjacencyMatrix(matrix.length,matrix));
    	
    }
    
    //problem 3
    public AdjacencyMatrix ConvertToMatrix(AdjacencyList list) {
    	return new AdjacencyMatrix(list.getV(),list.getList());
    }
	
	
	//problem 4
	public int isConnected(int[][] matrix) {
		ModifiedFloyedWarshal(matrix);
		if(countConnections(matrix)==matrix.length*matrix.length) 
			return 2;
		OrTranspose(matrix);
		ModifiedFloyedWarshal(matrix);
		if(countConnections(matrix)==matrix.length*matrix.length)
			return 1;	
		return 0;
	}

	private int[][] OrTranspose(int[][] input){
		int[][] output=input;
		for(int x=0;x<input.length;x++) {
			for(int y=x;y<input.length;y++) {
				output[x][y]=output[y][x]=input[x][y]|input[y][x];
			}
		}
		return output;
	}
	public int[][] ModifiedFloyedWarshal(int[][] matrix) {
		int dim=matrix.length;
		for(int i=0;i<dim;i++) {
			for(int k=0;k<dim;k++) {
				for(int j=0;j<dim;j++) {
					if(matrix[j][k]==0&&matrix[j][i]==1&&matrix[i][k]==1) {
						matrix[j][k]=1;
					}
				}
			}
		}
		return matrix;
	}
	private int countConnections(int[][] matrix) {
		return Arrays.stream(matrix).mapToInt(row->Arrays.stream(row).reduce((x,y)->x+y).getAsInt()).reduce((x,y)->x+y).getAsInt();
	}
	

}
