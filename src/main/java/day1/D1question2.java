package day1;


import java.util.ArrayList;
import java.util.Arrays;
import day0.ArrayListFromFile;

public class question2 {
    public static void main(String[] args){
        ArrayList<int[]> a = new ArrayListFromFile<int[]>("src/main/java/day1/numbers.txt", (String s) 
        -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()).toArrayList();
        
        int sm = 0;
        for (int[] i :a){
            int passed = checkWithout(i, -1);
            if (passed != -1){
                if (checkWithout(i, passed) == -1 || checkWithout(i, passed-1) == -1){
                    sm++;
                }
            }
            else{sm++;}
            
        }
        System.out.println(sm);
    }

    private static int[] removeIndex(int[] arr, int index){
        int[] a = new int[arr.length-1];
        int count=0;
        for (int i=0;i<arr.length;i++){
            if (i!=index){
                a[count] = arr[i];
                count++;
            }
        }
        return a;

    }

    private static int checkWithout(int[] arr, int ignore){
        int i[];
        if (ignore ==-1){i = arr;}
        else{i = removeIndex(arr, ignore);}

            boolean inc = i[0] < i[1];
            for (int x=1;x<i.length ;x++){
                if (!inc && i[x] < i[x-1] && 3>=i[x-1]-i[x]){
                }
                else if (inc && i[x] > i[x-1] && 3>=i[x]-i[x-1]){
                }
                else{
                    return x;
                }
            }
        return -1;
    }

}

