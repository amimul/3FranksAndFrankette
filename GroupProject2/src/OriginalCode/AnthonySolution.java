package OriginalCode;
import java.util.Arrays;
import java.util.List;

public class AnthonySolution implements Solution{ 
	public void init() {
		
	}
	private int[][] OrTranspose(int[][] input){
		int[][] output=input;//new int[input.length][input.length];
		for(int x=0;x<input.length;x++) {
			for(int y=x;y<input.length;y++) {
				output[x][y]=output[y][x]=input[x][y]|input[y][x];
			}
		}
		return output;
	}
	private void populateDiagnol(int[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			matrix[i][i]=1;
		}
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
	
	
	@Override
	public boolean part1(int[][] matrix) {
		ModifiedFloyedWarshal(matrix);
		for(int i=0;i<matrix.length;i++)
			if(matrix[i][i]==1)
				return true;
		return false;
	}
	@Override
	public List<Integer>[] part2(int[][] matrix) {
		//List<Integer>[] ajacency=new List<Integer>[];
		
		
		
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int[][] part3(List<List<Integer>> ajacencyList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int part4(int[][] matrix) {
		ModifiedFloyedWarshal(matrix);
		if(countConnections(matrix)==matrix.length*matrix.length) 
			return 2;
		OrTranspose(matrix);
		ModifiedFloyedWarshal(matrix);
		if(countConnections(matrix)==matrix.length*matrix.length)
			return 1;	
		return 0;
	}

}