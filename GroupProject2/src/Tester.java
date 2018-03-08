import java.util.Arrays;

public class Tester {
	public static final int[][] TEST1;
	public static final int[][] TEST2;
	public static final int[][] TEST3;
	static {
		TEST1=makeSquare(toArray("[[0,1,0,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]"),0);
		TEST2=makeSquare(toArray("[[0,1,1,1,0],[0,0,0,1,0],[0,1,0,0,0],[0,0,0,0,1],[0,1,0,0,0]]"),0);
		TEST3=makeSquare(toArray("[[0,1,1,1,0,0,0],[0,0,0,1,1,0,0],[0,0,0,0,0,1,0],[0,0,1,0,0,1,1],[0,0,0,1,0,0,1],[0,0,0,0,0,0,0],[0,0,0,0,0,1,0]]"),0);
	}
	
	
	/**
	 * too lazy to manually type these in
	 * @return
	 */
	public static int[] toArray(String input) {
		//Arrays.stream(new int[] {1,2,3}).reduce((x,y)->x+y).getAsInt()
		return Arrays.stream(input.replaceAll("[\\[\\]]", "").split(",")).mapToInt(s->Integer.parseInt(s)).toArray();
	}
	/**
	 * if you give too small alist of values, any extra will be zero. 
	 * if too large it will be truncated
	 * @param values
	 * @param dim dim of new array, if <=0 then it tries to pick the right size
	 * @return
	 */
	public static int[][] makeSquare(int[] values,int dim){
		if(dim<=0) {
			dim=(int)Math.ceil(Math.sqrt(values.length));
		}
		int[][] matrix=new int[dim][dim];
		for(int i=0;i<values.length&&i<dim*dim;i++) {
			matrix[i/dim][i%dim]=values[i];
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		System.out.printf("%d x %d matrix:\n", matrix.length,matrix.length);
		for(int[] row:matrix) {
			System.out.println(Arrays.toString(row));
		}
	}/*
	public static int[][] copyMatrix(int[][] matrix){
		int[][]copy=new
	}
	*/
	
	public static void main(String[] arg) {
		Solution sol=new AnthonySolution();
		testPart1(sol);
		/*
		printMatrix(TEST1);
		//printMatrix(TEST2);
		//printMatrix(TEST3);
		printMatrix(new AnthonySolution().ModifiedFloyedWarshal(TEST1));
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		printMatrix(TEST2);
		printMatrix(new AnthonySolution().ModifiedFloyedWarshal(TEST2));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		printMatrix(TEST3);
		printMatrix(new AnthonySolution().ModifiedFloyedWarshal(TEST3));*/
	}
	public static void testPart1(Solution sol) {
		int[][]matrix=makeSquare(new int[] {
				1,1,0,0,0,
				0,1,1,0,0,
				0,0,1,1,0,
				0,0,0,1,1,
				1,0,0,0,1},0);
		printMatrix(matrix);
		System.out.println(sol.part1(matrix));
		printMatrix(matrix);
		printMatrix(TEST1);
		System.out.println(sol.part1(TEST1));
		printMatrix(TEST1);
		printMatrix(TEST2);
		System.out.println(sol.part1(TEST2));
		printMatrix(TEST2);
		printMatrix(TEST3);
		System.out.println(sol.part1(TEST3));
		printMatrix(TEST3);
	}
	
	
	public static void testPart4(Solution sol) {
		int[][]matrix=makeSquare(new int[] {
				1,1,0,0,0,
				0,1,1,0,0,
				0,0,1,1,0,
				0,0,0,1,1,
				1,0,0,0,1},0);
		printMatrix(matrix);
		System.out.println(sol.part4(matrix));
		printMatrix(matrix);
		printMatrix(TEST1);
		System.out.println(sol.part4(TEST1));
		printMatrix(TEST1);
		printMatrix(TEST2);
		System.out.println(sol.part4(TEST2));
		printMatrix(TEST2);
		printMatrix(TEST3);
		System.out.println(sol.part4(TEST3));
		printMatrix(TEST3);
	}

}
