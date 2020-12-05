package fourthDay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class fourthDay {

    public static void main(String[] args) {

        ArrayList<String> passowrds = new ArrayList<>();

        try {
            File myObj = new File("../AdventOfCode2020/src/fourthDay/input.txt");
            Scanner myReader = new Scanner(myObj);
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();

            while (myReader.hasNextLine()) {
                while (myReader.hasNextLine() && !(line = myReader.nextLine()).isEmpty()) {
                    stringBuilder.append(line).append(" ");
                }
                passowrds.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Valid passwords: " + func1(passowrds));
        System.out.println("Valid passwords with func2: " + func2(passowrds));

    }

    static int func1(ArrayList<String> passwords) {

        int validCounter = 0;

        for (String p : passwords) {

            if (p.contains("cid")) {
                if ((p.length() - p.replaceAll(":", "").length()) > 7) {
                    validCounter++;
                }
            } else if (p.length() - p.replaceAll(":", "").length() == 7) {
                validCounter++;
            }
        }

        return validCounter;
    }

    static int func2(ArrayList<String> passwords) {
        int validCounter = 0;
        int partValidCounter = 0;
        String[] toCheck;

        for (String p : passwords) {
            toCheck = p.split("[^\\w*:|#]");

            if (toCheck.length < 7) {
                //password is false
            } else if (p.contains("cid") && toCheck.length == 7) {
                //password is false
            } else {

                for (int i = 0; i < toCheck.length; i++) {

                    if (toCheck[i].contains("byr")) {

                        int birthYear = Integer.parseInt(toCheck[i].substring(4, 8));

                        if (birthYear >= 1920 && birthYear <= 2002) {
                            partValidCounter++;
                        }

                    } else if (toCheck[i].contains("iyr")) {

                        int issueYear = Integer.parseInt(toCheck[i].substring(4, 8));

                        if (issueYear >= 2010 && issueYear <= 2020) {
                            partValidCounter++;
                        }

                    } else if (toCheck[i].contains("eyr")) {

                        int expirationYear = Integer.parseInt(toCheck[i].substring(4, 8));

                        if (expirationYear >= 2020 && expirationYear <= 2030) {
                            partValidCounter++;
                        }

                    } else if (toCheck[i].contains("hgt")) {

                        if (toCheck[i].charAt(toCheck[i].length() - 1) == 'n') {
                            int height = Integer.parseInt(toCheck[i].substring(4, toCheck[i].length() - 2));
                            if (height >= 59 && height <= 76) {
                                partValidCounter++;
                            }

                        } else if (toCheck[i].charAt(toCheck[i].length() - 1) == 'm') {
                            int height = Integer.parseInt(toCheck[i].substring(4, toCheck[i].length() - 2));
                            if (height >= 150 && height <= 193) {
                                partValidCounter++;
                            }

                        }

                    } else if (toCheck[i].contains("hcl")) {
                        if (toCheck[i].matches(".*#[0-9a-f]{6}")) {
                            partValidCounter++;
                        }

                    } else if (toCheck[i].contains("ecl")) {
                        if (toCheck[i].matches(".*(amb|blu|brn|gry|grn|hzl|oth)")) {
                            partValidCounter++;
                        }
                    } else if (toCheck[i].contains("pid")) {
                        if (toCheck[i].matches("^\\D*\\d{9}")) {
                            partValidCounter++;
                        }
                    } else if (toCheck[i].contains("cid")) {
                        partValidCounter++;
                    }

                }
            }

            if ( toCheck.length <= partValidCounter) {
                validCounter++;
            }

            partValidCounter = 0;
        }

        return validCounter;
    }

}
