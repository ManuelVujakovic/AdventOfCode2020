package firstDay;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class firstDay {
    public static void main(String[] args) {

        ArrayList<Integer> expenses = new ArrayList<>();

        try {
            File myObj = new File("../AdventOfCode_2020/src/firstDay/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                expenses.add(Integer.valueOf(myReader.nextLine()));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Func1: " + func1(expenses) + "\nFunc2: " + func2(expenses));

    }

    static int func1(ArrayList<Integer> expenses) {

        ArrayList<Integer> solution = new ArrayList<>();

        for (Integer i : expenses) {
            for (Integer j : expenses) {
                if (i + j == 2020 && solution.size() == 0) {
                    solution.add(i);
                    solution.add(j);
                    break;
                }
            }
        }

        return solution.get(0) * solution.get(1);
    }

    static int func2(ArrayList<Integer> expenses) {
        ArrayList<Integer> solution = new ArrayList<>();

        for (Integer i : expenses) {
            for (Integer j : expenses) {
                for (Integer k : expenses) {
                    if (i + j + k == 2020 && solution.size() == 0) {
                        solution.add(i);
                        solution.add(j);
                        solution.add(k);
                        break;
                    }
                }
            }
        }

        return solution.get(0) * solution.get(1) * solution.get(2);
    }
}
