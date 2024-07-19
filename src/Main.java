import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList eyes = new ArrayList();
    static ArrayList kept = new ArrayList();
    static ArrayList rerolled = new ArrayList();
    static Scanner sc = new Scanner(System.in);
    static Dice d1 = new Dice();
    static boolean isHappy;

    public static void main(String[] args) {
//        playerRound();
//        System.out.println("Behalten: " + kept);
//        System.out.println("Neu würfeln: " + rerolled);
//        playerRound();
//        System.out.println("Behalten: " + kept);
//        System.out.println("Neu würfeln: " + rerolled);

        System.out.println(firstRoll());
        System.out.println(reroll(eyes));
    }

    public static ArrayList<Integer> firstRoll() {
        while (eyes.size() < 5) {
            int result = d1.roll();
            if (result != 0) eyes.add(result);
        }
        return eyes;
    }

    public static ArrayList<Integer> reroll(ArrayList al) {
        al.clear();
        while (al.size() < 5) {
            int result = d1.roll();
            if (result != 0) al.add(result);
        }
        return al;
    }

    public static void playerRound() {
        isHappy = false;

        firstRoll();

        System.out.println("Gewürfelt: " + eyes);

        while (!isHappy) {
            System.out.println("Welche Würfel behalten? Gib 5 ein, wenn du zufrieden bist.");
            int input = sc.nextInt();

            if (input == 5) {
                isHappy = true;
            } else {
                kept.add(eyes.get(input));
                eyes.remove(eyes.get(input));
                rerolled = eyes;
                reroll(rerolled);
                System.out.println("Behalten: " + kept);
                System.out.println("Neu würfeln: " + rerolled);
            }
        }

    }

}
