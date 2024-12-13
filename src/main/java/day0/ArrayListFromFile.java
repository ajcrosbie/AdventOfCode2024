package day0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListFromFile<T> implements Iterable<T> {
    @FunctionalInterface
    public interface AnnonymousClass<T> {
        T extract(String a);
    }

    private ArrayList<T> array = new ArrayList<T>();
    private File myObj;
    private AnnonymousClass<T> generator;
    private Scanner myReader;

    public ArrayListFromFile(String filename, AnnonymousClass<T> a) {
        generator = a;
        try {
            myObj = new File(filename);
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            System.out.println("file does not exist");
            if (myReader != null) {
                myReader.close();
            }
        } catch (Exception e) {
            System.out.println("unsure of the error");
            if (myReader != null) {
                myReader.close();
            }
        }
    }

    public Iterator<T> iterator() {
        readAll();
        return array.iterator();
    }

    public boolean notDone() {
        return myReader.hasNextLine();
    }

    public void readAll() {
        while (notDone()) {
            readData();
        }
    }

    private void readData() {
        if (notDone()) {
            array.add(generator.extract((myReader.nextLine())));
        }
    }
}