package day2;

import java.util.regex.Pattern;

import day0.ArrayListFromFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;

public class D2question2 {
    public static void main(String[] args){
        ArrayList<String[]> a = new ArrayListFromFile<String[]>("src/main/java/day2/data.txt", (String s) 
        -> (s.split("m"))).toArrayList();
        int sm = 0;
        boolean doMul = true;
        for (String[] row:a){
            for (String sub:row){
                String[] controlSub = sub.split("d");
                System.out.println(sub);
                if (doMul &&mulMatcher(sub)){
                    sm+=doMul(sub);
                    System.out.println(sub);
                }
                for (String i:controlSub){
                    if (doMatcher(i)){doMul=true;}
                    if (dontMatcher(i)){doMul=false;}
                }

            }
        }
        System.out.println(sm);
    }

    public static boolean mulMatcher(String s){
        String regex = "ul\\([0-9]{1,3},[0-9]{1,3}\\).*";
        return Pattern.compile(regex).matcher(s).matches();
    }
    public static boolean doMatcher(String s){
        String regex = "o\\(\\).*";
        return Pattern.compile(regex).matcher(s).matches();
    }
    public static boolean dontMatcher(String s){
        String regex = "on't\\(\\).*";
        return Pattern.compile(regex).matcher(s).matches();
    }

    public static int doMul(String s){
        int a = 0;
        int b = 0;
        boolean comma = false;
        boolean unseena = true;
        boolean unseenb = true;
        for (int i=3;i<s.length();i++){
            char c = s.charAt(i);  
            if (c == ')'){
                if (unseena||unseenb){throw new IllegalArgumentException("values should validated before input to be of the form ul([0-9]{1,3}, [0-9]{1,3})");}
                return a*b;}
            if (c == ','){
                comma=true; 
            }
            else if (Character.isDigit(c)){
                if (comma){
                    b=b*10;
                    b+=(int) c-'0';
                    unseenb=false;
                }
                else{
                    a=a*10;
                    a+=(int) c-'0';
                    unseena = false;
                }
            }
            else{
                throw new IllegalArgumentException("values should validated before input to be of the form ul([0-9]{1,3}, [0-9]{1,3})");

            }
        }
        throw new IllegalArgumentException("values should validated before input to be of the form ul([0-9]{1,3}, [0-9]{1,3})");
    }
}
