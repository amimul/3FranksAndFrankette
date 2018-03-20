package SelectedSolution;
import java.util.ArrayList;
import java.util.Arrays;
public class Tester {
	public static int[][] TEST1;
	public static int[][] TEST2;
	public static int[][] TEST3;
	static void init() {
		TEST1=makeSquare(toArray("[[0,1,0,0],[0,0,0,0],[0,1,0,1],[1,0,0,0]]"),0);
		TEST2=makeSquare(toArray("[[0,1,1,1,0],[0,0,0,1,0],[0,1,0,0,0],[0,0,0,0,1],[0,1,0,0,0]]"),0);
		TEST3=makeSquare(toArray("[[0,1,1,1,0,0,0],[0,0,0,1,1,0,0],[0,0,0,0,0,1,0],[0,0,1,0,0,1,1],[0,0,0,1,0,0,1],[0,0,0,0,0,0,0],[0,0,0,0,0,1,0]]"),0);
	}
	public static ArrayList<int[][]> cases=new ArrayList<int[][]>();
	
	
	/**
	 * too lazy to manually type these in
	 * @return
	 */
	public static int[] toArray(String input) {
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
	}
	
	
	
	
	
	
	
	
	public static void main(String[] arg) {
		Solution sol=new Solution();
		testPart1(sol);
		testPart23(sol);
		testPart4(sol);
	}
	
	
	
	private static void testPart23(Solution sol) {
		init();
		printMatrix(TEST3);
		int[][] res=sol.ConvertToMatrix(sol.ConvertToList(TEST3)).getMatrix();
		printMatrix(res);
		
		
		
	}
	public static void testPart1(Solution sol) {init();
		int[][]matrix=makeSquare(new int[] {
				1,1,0,0,0,
				0,1,1,0,0,
				0,0,1,1,0,
				0,0,0,1,1,
				1,0,0,0,1},0);
		int[][] test4 = {{0,1,0,1}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}};										// strongly connected, cycle
		int[][] test5 = {{0,1,0,0}, {0,0,0,0}, {0,0,0,1}, {0,0,0,0}};										// disconnected, no cycles
		int[][] test6 = {{0,1,0,0}, {1,0,0,0}, {0,0,0,1}, {0,0,1,0}};	
		int[][] test7 = {
				{0,0,1,1},
				{0,1,0,1},
				{0,0,0,1},
				{0,0,1,0}};	
		System.out.println(sol.cycles(matrix));
		System.out.println(sol.cycles(TEST1));
		System.out.println(sol.cycles(TEST2));
		System.out.println(sol.cycles(TEST3));
		System.out.println(sol.cycles(test4));
		System.out.println(sol.cycles(test5));
		System.out.println(sol.cycles(test6));
		System.out.println(sol.cycles(test7));

	}
	
	public static void testPart4(Solution sol) {
		init();
		int[][]matrix=makeSquare(new int[] {
				1,1,0,0,0,
				0,1,1,0,0,
				0,0,1,1,0,
				0,0,0,1,1,
				1,0,0,0,1},0);
		int[][] test4 = {{0,1,0,1}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}};										// strongly connected, cycle
		int[][] test5 = {{0,1,0,0}, {0,0,0,0}, {0,0,0,1}, {0,0,0,0}};										// disconnected, no cycles
		int[][] test6 = {{0,1,0,0},
						 {1,0,0,0},
						 {0,0,0,1},
						 {0,0,1,0}};
		int[][] test7 = {
					{0,0,1,1},
					{0,1,0,1},
					{0,0,0,1},
					{0,0,1,0}};	
		System.out.println(sol.isConnected(matrix));
		System.out.println(sol.isConnected(TEST1));
		System.out.println(sol.isConnected(TEST2));
		System.out.println(sol.isConnected(TEST3));
		System.out.println(sol.isConnected(test4));
		System.out.println(sol.isConnected(test5));
		System.out.println(sol.isConnected(test6));
		System.out.println(sol.isConnected(test7));
	}

}
