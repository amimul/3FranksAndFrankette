import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem_Set_Graph_Theory {

    //problem 1
    public static boolean cycles(int[][] a){
        boolean ret = false;
        for (int len = 0; len < a.length; len++){
            if(ret == false)
                ret = cycles(a, new ArrayList<Integer>(), len);
        }
        return ret;
    }

    //problem 1 helper
    private static boolean cycles(int[][] a, ArrayList<Integer> record, int step) {
        record.add(step);
        for (int i = 0; i < a.length; i++) {
            if (a[step][i] == 1 && step != i) {
                record.add(i);
                if (record.size() > 5 && (record.get(1) != record.get(record.size() - 2)) &&
                        (record.get(0) == record.get(record.size() - 1))) {
                    return true;
                } else if (step + 1 < a.length) {
                    return cycles(a, record, i);
                }
            }
        }
        return false;
    }

    //problem 2
    public static ArrayList<Integer>[] toAdjacencyList(int[][] a){
        ArrayList<Integer>[] ret = new ArrayList[a.length];
        for (int i = 0; i < a.length; i++){
            ret[i] = new ArrayList<Integer>();
            for(int j = 0; j < a.length; j++){
                if(a[i][j] == 1){
                    ret[i].add(j);
                }
            }
        }
        return ret;
    }

    //problem 3
    public static int[][] to2DArray(ArrayList<Integer>[] a){
        int[][] ret = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++){
            ArrayList<Integer> use = a[i];
            for(int j = 0; j < use.size(); j++){
                if(use.get(j) == 1){
                    ret[i][i] = 1;
                }
            }
        }
        return ret;
    }

    //problem 4
    public static int connectionStatus(int[][] a){
        ArrayList<Integer>[] ret = new ArrayList[a.length];
        for (int i = 0; i < a.length; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int[] visitedRows = new int[a.length];
            visitedRows[i]++;
            ret[i] = connectionStatus(a, temp, visitedRows, i, 0);
        }
        boolean atLeastThree = false;
        int connections = 0;
        for (int i = 0; i < a.length; i++) {
            connections += ret[i].size();
            if(ret[i].size() > 2){
                atLeastThree = true;
            }
        }
        System.out.println(a.length);
        System.out.println(connections);
        if(connections == 0 || atLeastThree == false){
            return 0;
        }else if(connections == a.length*a.length){
            return 2;
        }else{
            return 1;
        }
    }

    //problem 4 helper
    private static ArrayList<Integer> connectionStatus(int[][] a, ArrayList<Integer> list, int[] visitedRows, int x, int y) {
        if (a.length != list.size()-1 && y < a.length) {
            if (a[x][y] == 1 && x != y) {
                if(list.indexOf(y) == -1) {
                    list.add(y);
                }
                if(visitedRows[y] != 1){
                    visitedRows[y]++;
                    list = connectionStatus(a, list, visitedRows, y, 0);
                }
            }
            list = connectionStatus(a, list, visitedRows, x, y + 1);
        }
        return list;
    }

    public static void main(String[] args){
        int[][] testA = {{0,1,0,0}, {1,0,0,0}, {0,0,0,1}, {0,0,1,0}};
        System.out.println(connectionStatus(testA));
    }
}
