package day0;

import java.util.Comparator;
import java.util.ArrayList;


public class D0question1{
    public static void main(String[] args){
        ArrayList<Integer> alist = new ArrayListFromFile<Integer>("src/main/java/day0/numsList.txt",
        (String s) -> Integer.parseInt(s.split("   ")[0])).toArrayList();
        ArrayList<Integer> blist = new ArrayListFromFile<Integer>("src/main/java/day0/numsList.txt",
        (String s) -> Integer.parseInt(s.split("   ")[1])).toArrayList();        
        alist.sort(Comparator.naturalOrder());
        blist.sort(Comparator.naturalOrder());
        
        int sm=0;
        for (int i=0;i<alist.size();i++){
            sm += abs(alist.get(i) - blist.get(i));
        }
        System.out.print(sm);
    }
    public static int abs(int a){
        return a<0? -a : a;
    }
}