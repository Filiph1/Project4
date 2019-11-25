import java.util.*;
import java.io.*;


public class Keypad {
    private String currLine;
    private String value;
    private String key;
    private HashSet<String> set = new HashSet<>();
    private HashMap<String, Set<String>> map = new HashMap<>();
    private Scanner input = new Scanner(System.in);
    private boolean check = false;

    public Keypad() {

    }

    public void find() {
        String file = Keypad.class.getResource("sampleFICT.txt").getFile();

        try (BufferedReader read = new BufferedReader(new FileReader(new File(file)))) {

            while ((currLine = read.readLine()) != null) {

                String[] test = currLine.split(" ");

                for (int i = 0; i < test.length; i++) {
                    key = "";

                    for (int j = 0; j < test[i].length(); j++) {

                        char charac = Character.toUpperCase(test[i].charAt(j));
                        if (Character.isLetter(charac)) {
                            int num = convert(charac);
                            key = key + num;
                        }
                    }
                    value = test[i];

                    if (map.isEmpty()) {
                        map.put(key, set);
                    }

                    if (map.get(key) != null) {
                        map.get(key).add(value);

                    } else {
                        Set<String> values = new HashSet<>();
                        values.add(value);
                        map.put(key, values);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.toString());
        }

        print();

    }

    public void print() {
        System.out.print("Enter digits to find keypad matching words: ");
        String in = input.nextLine();

        for (String i : map.keySet()) {
            if (i.equals(in))
                System.out.println(map.get(i));
        }

        System.out.print("Do you want to enter more digits? (y/n): ");
        String in2 = input.nextLine();
        while (in2.equals("y")) {
            System.out.print("Enter digits to find keypad matching words: ");
            in = input.nextLine();

            for (String entry : map.keySet()) {
                if (entry.equals(in))
                    System.out.println(map.get(entry));
            }
            System.out.print("Do you want to enter more digits? (y/n): ");
            in2 = input.nextLine();
        }
    }

    public  int convert(char letter) {

        if (letter == 'A' || letter == 'B' || letter == 'C')

            return 2;

        else if (letter == 'D' || letter == 'E' || letter == 'F')

            return 3;

        else if (letter == 'G' || letter == 'H' || letter == 'I')

            return 4;

        else if (letter == 'J' || letter == 'K' || letter == 'L')

            return 5;

        else if (letter == 'M' || letter == 'N' || letter == 'O')

            return 6;

        else if (letter == 'P' || letter == 'Q' || letter == 'R' || letter == 'S')

            return 7;

        else if (letter == 'T' || letter == 'U' || letter == 'V')

            return 8;

        else if (letter == 'W' || letter == 'X' || letter == 'Y' || letter == 'Z')

            return 9;

        else

            return 0;
    }

}
