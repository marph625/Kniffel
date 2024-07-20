import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> eyes = new ArrayList();
    static ArrayList<Integer> kept = new ArrayList();
    static ArrayList<Integer> rerolled = new ArrayList();
    static Scanner sc = new Scanner(System.in);
    static Dice d1 = new Dice();
    static boolean isHappy;

    public static void main(String[] args) {
        System.out.println("###################################");
        System.out.println("############# KNIFFEL #############");
        System.out.println("###################################");
        firstRound();

        secondRound(rerolled);
//        System.out.println("Behalten: " + kept);
//        System.out.println("Neu würfeln: " + rerolled);

//        System.out.println(firstRoll());
//        System.out.println(reroll(eyes));
    }

    private static void secondRound(ArrayList<Integer> al) {


        for (int round = 1; round < 3; round++) {
            isHappy = false;
            eyes = reroll(al);

            System.out.println("Neu gewürfelt: " + round);
            System.out.println("Behalten: " + kept);
            System.out.println("Gewürfelt: " + eyes);

            while (!isHappy) {
                System.out.println("Welche Würfel behalten?\nGib 5 ein, wenn du zufrieden bist.");

                int input = sc.nextInt();

                if (input == 5) {
                    isHappy = true;
                } else {
                    kept.add(eyes.get(input));
                    eyes.remove(eyes.get(input));
                    rerolled = eyes;
                    System.out.println("Behalten: " + kept);
                    System.out.println("Neu würfeln: " + rerolled);
                }
            }
        }
    }



    public static void firstRound() {
        isHappy = false;

        firstRoll();

        System.out.println("Gewürfelt: " + eyes);

        while (!isHappy) {
            System.out.println("Welche Würfel behalten?\nGib 5 ein, wenn du zufrieden bist.");
            int input = sc.nextInt();

            if (input == 5) {
                isHappy = true;
            } else {
                kept.add(eyes.get(input));
                eyes.remove(eyes.get(input));
                rerolled = eyes;
                System.out.println("Behalten: " + kept);
                System.out.println("Neu würfeln: " + rerolled);
            }
        }
    }
    public static ArrayList<Integer> firstRoll() {
        while (eyes.size() < 5) {
            int result = d1.roll();
            if (result != 0) eyes.add(result);
        }
        return eyes;
    }

    public static ArrayList<Integer> reroll(ArrayList al) {
        int elements = al.size();
        al.clear();
        while (al.size() < elements) {
            int result = d1.roll();
            if (result != 0) al.add(result);
        }
        return al;
    }
}
