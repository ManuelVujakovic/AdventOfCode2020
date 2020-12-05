package fifthDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class fifthDay {

    public static void main(String[] args) {

        ArrayList<String> zones = new ArrayList<>();

        try {
            File myObj = new File("../AdventOfCode2020/src/fifthDay/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                zones.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Highest id: " + func12(zones));
    }


    static int func12(ArrayList<String> zones) {

        ArrayList<Integer> arr = new ArrayList<>();

        int highestID = 0;

        double idUp = 127, idDw = 0;
        double cUp = 7, cDw = 0;


        for (String s : zones) {
            for (char c : s.toCharArray()) {
                if (c == 'F') {
                    idUp = Math.floor((idUp + idDw) / 2);
                } else if (c == 'B') {
                    idDw = Math.ceil((idUp + idDw) / 2);
                } else {
                    break;
                }
            }

            for (int i = s.length() - 3; i < s.length(); i++) {
                if (s.charAt(i) == 'L') {
                    cUp = Math.floor((cUp + cDw) / 2);
                } else if (s.charAt(i) == 'R') {
                    cDw = Math.ceil((cUp + cDw) / 2);
                }
            }
            arr.add((int) (idUp * 8 + cUp));
            if (highestID < idUp * 8 + cUp) highestID = (int) (idUp * 8 + cUp);
            idUp = 127;
            idDw = 0;
            cUp = 7;
            cDw = 0;

        }

        Iterator<Integer> i = arr.iterator();

        while (i.hasNext()) {
            int current = i.next();
            if (arr.contains(current + 2) && !arr.contains(current + 1)) {
                System.out.println("Current seat: " + (current + 1));
                break;
            }
        }

        return highestID;
    }

}
