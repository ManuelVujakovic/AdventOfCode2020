package secondDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SecondDay {

    public static void main(String[] args) {

        ArrayList<String> passwords = new ArrayList<>();

        try {
            File myObj = new File("../AdventOfCode_2020/src/secondDay/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                passwords.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Valid passwords: " + func1(passwords));
        System.out.println("Valid passwords with other logic: " + func2(passwords));

    }

    static int func1(ArrayList<String> passwords) {

        int min, max;
        String letter;
        String password;

        int offset = 0;
        int valid = 0;
        int count;

        for (String s : passwords) {

            offset = s.indexOf('-');
            min = Integer.parseInt(s.substring(0, offset));
            max = Integer.parseInt(s.substring(offset + 1, s.indexOf(' ')));

            letter = s.substring(s.indexOf(' ') + 1, s.indexOf(':'));

            password = s.substring(s.indexOf(':') + 1);

            count = password.length() - password.replaceAll(letter, "").length();
            if (count >= min && count <= max) {
                valid++;
            }
        }

        return valid;
    }

    static int func2(ArrayList<String> passwords) {
        int pos1, pos2;
        char letter;
        String password;

        int offset = 0;
        int valid = 0;

        for (String s : passwords) {

            offset = s.indexOf('-');
            pos1 = Integer.parseInt(s.substring(0, offset));
            pos2 = Integer.parseInt(s.substring(offset + 1, s.indexOf(' ')));

            letter = s.substring(s.indexOf(' ') + 1, s.indexOf(':')).charAt(0);

            password = s.substring(s.indexOf(':') + 1);

            if (password.charAt(pos1) == letter ^ password.charAt(pos2) == letter) {
                valid++;
            }
        }

        return valid;
    }
}
