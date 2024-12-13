package day1;

import java.util.ArrayList;
import java.util.Arrays;
import day0.ArrayListFromFile;

public class D1question1 {
    public static void main(String[] args){
        ArrayList<int[]> a = new ArrayListFromFile<int[]>("src/main/java/day1/numbers.txt", (String s) 
        -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()).toArrayList();
        
        int sm = 0;
        boolean inc;
        boolean candidate;
        for (int[] i :a){
            inc = i[0] < i[1];
            candidate = true;
            for (int x=1;x<i.length ;x++){
                if (!inc && i[x] < i[x-1] && 3>=i[x-1]-i[x]){
                }
                else if (inc && i[x] > i[x-1] && 3>=i[x]-i[x-1]){
                }
                else{
                    candidate=false;
                    break;
                }
            }
            sm += candidate ? 1:0;
            
        }
        System.out.println(sm);
    }


}

