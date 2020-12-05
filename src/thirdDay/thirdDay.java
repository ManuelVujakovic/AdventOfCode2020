package thirdDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class thirdDay {

    public static void main(String[] args) {

        ArrayList<String> map = new ArrayList<>();

        try {
            File myObj = new File("../AdventOfCode2020/src/thirdDay/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                map.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Trees encountered: " + func1(map, 3, 1));
        System.out.println("Trees encountered entire slope: " + func2(map));

    }

    static int func1(ArrayList<String> map, int x, int y) {
        int treeCounter = 0;
        int loopCounter = 0;

        for (int i = 0; i < map.size(); i += y) {
            if (map.get(i).charAt(loopCounter * x % map.get(i).length()) == '#') {
                treeCounter++;
            }
            loopCounter++;
        }
        return treeCounter;
    }

    static long func2(ArrayList<String> map){
        long treeCounter = (func1(map, 1, 1) * func1(map, 3, 1) * func1(map, 5, 1) * func1(map, 7, 1) * func1(map, 1, 2));
        return treeCounter;
    }

}
