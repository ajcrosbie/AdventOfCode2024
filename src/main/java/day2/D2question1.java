package day2;

import java.util.regex.Pattern;

import day0.ArrayListFromFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

public class D2question1 {
    public static void main(String[] args){
        ArrayList<String[]> a = new ArrayListFromFile<String[]>("src/main/java/day2/data.txt", (String s) 
        -> (s.split("m"))).toArrayList();
        int sm = 0;
        for (String[] row:a){
            for (String sub:row){
                System.out.println(sub);
                if (mulMatcher(sub)){sm+=doMul(sub);}
            }
        }
        System.out.println(sm);
    }

    public static boolean mulMatcher(String s){
        String regex = "ul\\([0-9]{1,3},[0-9]{1,3}\\).*";
        return Pattern.compile(regex).matcher(s).matches();
    }
    public static int doMul(String s){
        int a = 0;
        int b = 0;
        boolean comma = false;
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);  
            if (c == ')'){return a*b;}
            if (c == ','){comma=true;}
            else if (Character.isDigit(c)){
                if (comma){
                    b=b*10;
                    b+=(int) c-'0';
                }
                else{
                    a=a*10;
                    a+=(int) c-'0';
                }
            }
        }
        throw new IllegalArgumentException("values should return by having trailing ) from the regex");
    }
}
