package day0;

public class question2 {
    public static void main(String[] args) {

        ArrayListFromFile<Integer> alist = new ArrayListFromFile<Integer>("day0/numsList.txt",
                (String s) -> Integer.parseInt(s.split("   ")[0]));
        ArrayListFromFile<Integer> blist = new ArrayListFromFile<Integer>("day0/numsList.txt",
                (String s) -> Integer.parseInt(s.split("   ")[1]));
        Counter<Integer> bcounter = new Counter<Integer>(blist);
        int sum = 0;
        for (Integer a : alist) {
            sum += bcounter.getCount(a) * a;
        }
        System.out.println(sum);

    }
}
