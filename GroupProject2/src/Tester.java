import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		Solution anthony=new AnthonySolution();
		Solution kevin=new Solution() {
			@Override
			public boolean part1(int[][] matrix) {
				return Problem_Set_Graph_Theory.cycles(matrix);
			}

			@Override
			public List<Integer>[] part2(int[][] matrix) {
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
				// TODO Auto-generated method stub
				return Problem_Set_Graph_Theory.connectionStatus(matrix);
			}
			
		};
		Solution jeff=new Solution() {

			@Override
			public boolean part1(int[][] matrix) {
				return new AdjacencyMatrix(matrix.length,matrix).hasCycle();
			}

			@Override
			public List<Integer>[] part2(int[][] matrix) {
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
				// TODO Auto-generated method stub
				return new AdjacencyMatrix(matrix.length,matrix).hasConnection();
			}
			
		};
		
		
		System.out.println("kevin");
		testPart1(kevin);
		System.out.println("jeff");
		testPart1(jeff);
		System.out.println("anthony");
		testPart1(anthony);
		
		System.out.println("jeff");
		testPart4(jeff);
		System.out.println("anthony");
		testPart4(anthony);
		System.out.println("kevin");
		testPart4(kevin);
		
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
		long time =System.nanoTime();
		//printMatrix(matrix);
		System.out.println(sol.part1(matrix));
		//printMatrix(matrix);
		//printMatrix(TEST1);
		System.out.println(sol.part1(TEST1));
		//printMatrix(TEST1);
		//printMatrix(TEST2);
		System.out.println(sol.part1(TEST2));
		//printMatrix(TEST2);
		//printMatrix(TEST3);
		System.out.println(sol.part1(TEST3));
		System.out.println(sol.part1(test4));
		System.out.println(sol.part1(test5));
		System.out.println(sol.part1(test6));
		//printMatrix(TEST3);
		System.out.println(System.nanoTime()-time);
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
		int[][] test6 = {{0,1,0,0}, {1,0,0,0}, {0,0,0,1}, {0,0,1,0}};	
		long time =System.nanoTime();
		//printMatrix(matrix);
		System.out.println(sol.part4(matrix));
		//printMatrix(matrix);
		//printMatrix(TEST1);
		System.out.println(sol.part4(TEST1));
		//printMatrix(TEST1);
		//printMatrix(TEST2);
		System.out.println(sol.part4(TEST2));
		//printMatrix(TEST2);
		//printMatrix(TEST3);
		System.out.println(sol.part4(TEST3));
		System.out.println(sol.part4(test4));
		System.out.println(sol.part4(test5));
		System.out.println(sol.part4(test6));
		//printMatrix(TEST3);
		System.out.println(System.nanoTime()-time);
	}

}
