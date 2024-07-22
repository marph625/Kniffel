import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import sun.java2d.pipe.AAShapePipe;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> eyes = new ArrayList();
    static ArrayList<Integer> kept = new ArrayList();
    static ArrayList<Integer> rerolled = new ArrayList();
    static Scanner sc = new Scanner(System.in);
    static Dice d1 = new Dice();
    static boolean isHappy;
    static int attempt;
    static int scoreUpperHalf;
    static int scoreBottomHalf;
    static int finalScore;

    public static void main(String[] args) {
        welcomeOutput();
        firstRound();
        secondRound(rerolled);
        confirmRoll();
    }

    private static ArrayList<Integer> confirmRoll() {

        ArrayList<Integer> confirmedRoll = new ArrayList<>();

        scoreBoardOutput();
        System.out.println("Welches Feld willst du eintragen?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch (input) {
            case "1":
                for (Integer integer : kept) {
                    if (integer == 1) {
                        confirmedRoll.add(integer);
                    }
                }

                for (Integer ignored : confirmedRoll) {
                    scoreUpperHalf += 1;
                }

                break;
            case "2":
                for (Integer integer : kept) {
                    if (integer == 2) {
                        confirmedRoll.add(integer);
                    }
                }

                for (Integer ignored : confirmedRoll) {
                    scoreUpperHalf += 2;
                }

                break;
            case "3":
                for (Integer integer : kept) {
                    if (integer == 3) {
                        confirmedRoll.add(integer);
                    }
                }

                for (Integer ignored : confirmedRoll) {
                    scoreUpperHalf += 3;
                }

                break;
            case "4":
                for (Integer integer : kept) {
                    if (integer == 4) {
                        confirmedRoll.add(integer);
                    }
                }

                for (Integer ignored : confirmedRoll) {
                    scoreUpperHalf += 4;
                }

                break;
            case "5":
                for (Integer integer : kept) {
                    if (integer == 5) {
                        confirmedRoll.add(integer);
                    }
                }

                for (Integer ignored : confirmedRoll) {
                    scoreUpperHalf += 5;
                }

                break;
            case "6":
                for (Integer integer : kept) {
                    if (integer == 6) {
                        confirmedRoll.add(integer);
                    }
                }

                for (Integer ignored : confirmedRoll) {
                    scoreUpperHalf += 6;
                }

                break;
            case "dp":
                kept.sort(null);
                if ((kept.get(0) == kept.get(1) & kept.get(1) == kept.get(2)) ||
                        (kept.get(1) == kept.get(2) & kept.get(2) == kept.get(3)) ||
                        (kept.get(2) == kept.get(3) & kept.get(3) == kept.get(4)))  {
                    confirmedRoll.addAll(kept);
                    for (Integer ignored : confirmedRoll) {
                        scoreUpperHalf += ignored;
                    }
                } else {
                    System.out.println("Kein Dreierpasch");
                }

                break;
            case "vp":
                kept.sort(null);
                if ((kept.get(0) == kept.get(1) & kept.get(1) == kept.get(2) & kept.get(2) == kept.get(3)) ||
                        (kept.get(1) == kept.get(2) & kept.get(2) == kept.get(3) & kept.get(3) == kept.get(4)))  {
                    confirmedRoll.addAll(kept);
                    for (Integer ignored : confirmedRoll) {
                        scoreUpperHalf += ignored;
                    }
                } else {
                    System.out.println("Kein Viererpasch");
                }

                break;
            case "fh":
                kept.sort(null);

                if ((kept.get(0) == kept.get(1)) & (kept.get(2) == kept.get(3) & kept.get(3) == kept.get(4))) {
                    scoreUpperHalf += 25;
                } else {
                    System.out.println("Kein Full House");
                }

                break;
            case "ks":
                ArrayList<Integer> control1 = new ArrayList<>(
                        Arrays.asList(1, 2, 3, 4));
                ArrayList<Integer> control2 = new ArrayList<>(
                        Arrays.asList(2, 3, 4, 5));
                ArrayList<Integer> control3 = new ArrayList<>(
                        Arrays.asList(3, 4, 5, 6));

                kept.sort(null);
                if (kept.containsAll(control1) || kept.containsAll(control2) || kept.containsAll(control3)) {
                    scoreUpperHalf += 30;
                } else {
                    System.out.println("Keine kleine Straße");
                }

                break;
            case "gs":
                kept.sort(null);
                if (kept.get(0) == 1 && kept.get(1) == 2 && kept.get(2) == 3 && kept.get(3) == 4 && kept.get(4) == 5 ||
                        kept.get(0) == 2 && kept.get(1) == 3 && kept.get(2) == 4 && kept.get(3) == 5 && kept.get(4) == 6) {
                    scoreUpperHalf += 40;
                }

                break;
            case "kn":

                if (kept.get(0) == kept.get(1) && kept.get(1) == kept.get(2) &&
                        kept.get(2) == kept.get(3) && kept.get(3) == kept.get(4)) {
                    scoreUpperHalf += 50;
                } else {
                    System.out.println("Kein Kniffel");
                }

                break;
            case "ch":
                confirmedRoll.addAll(kept);

                for (Integer ignored : confirmedRoll) {
                    scoreUpperHalf += ignored;
                }

                break;
            default:
                System.out.println("Ungültige Eingabe");
        }
        System.out.println(confirmedRoll);
        System.out.println("Score: " + scoreUpperHalf);
        return confirmedRoll;
    }
    private static void secondRound(ArrayList<Integer> al) {


        for (int round = 1; round < 3; round++) {
            isHappy = false;
            eyes = reroll(al);
            attempt++;

            System.out.println(attempt + ". Wurf");
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
        if (kept.size() < 5) {
            System.out.println("Restliche Würfel werden hinzugefügt...");
            kept.addAll(eyes);
            System.out.println("Behalten: " + kept);
        }
    }
    private static void firstRound() {
        isHappy = false;
        attempt = 0;
        firstRoll();
        attempt++;

        System.out.println(attempt + ". Wurf: " + eyes);

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
    private static ArrayList<Integer> firstRoll() {
        while (eyes.size() < 5) {
            int result = d1.roll();
            if (result != 0) eyes.add(result);
        }
        return eyes;
    }
    private static ArrayList<Integer> reroll(ArrayList al) {
        int elements = al.size();
        al.clear();
        while (al.size() < elements) {
            int result = d1.roll();
            if (result != 0) al.add(result);
        }
        return al;
    }
    private static void welcomeOutput() {
        System.out.println("###################################");
        System.out.println("############# KNIFFEL #############");
        System.out.println("###################################");
    }
    private static void scoreBoardOutput() {
        System.out.println("Geben Sie eine der rechts stehenden Optionen ein:");
        System.out.println("Einer: 1");
        System.out.println("Zweier: 2");
        System.out.println("Dreier: 3");
        System.out.println("Vierer: 4");
        System.out.println("Fünfer: 5");
        System.out.println("Sechser: 6");

        System.out.println("Dreierpasch: dp");
        System.out.println("Viererpasch: vp");
        System.out.println("Full House: fh");
        System.out.println("Kleine Straße: ks");
        System.out.println("Große Straße: gs");
        System.out.println("Kniffel: kn");
        System.out.println("Chance: ch");
    }
}
