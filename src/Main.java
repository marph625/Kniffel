import java.util.*;

public class Main {

    static ArrayList<Integer> eyes = new ArrayList<>();
    static ArrayList<Integer> kept = new ArrayList<>();
    static ArrayList<Integer> rerolled = new ArrayList<>();
    static LinkedHashMap<String, Integer> column = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);
    static Dice d1 = new Dice();
    static boolean isHappy;
    static int attempt, rollScore, scoreUpperHalf, scoreBottomHalf, finalScore, upperHalfSum;

    public static void main(String[] args) {
        // TODO: Exception Handling, Multiplayer, Multiple Columns, Make cell scores immutable

        defaultTable();
        welcomeOutput();

        // there are 13 rows so there will be 13 rolls
        for (int i = 0; i < 13; i++) {
            firstRound();
            secondRound(rerolled);
            confirmRoll();
            currentTable();
        }
    }

    private static void defaultTable() {
        column.put("Einer", 0);
        column.put("Zweier", 0);
        column.put("Dreier", 0);
        column.put("Vierer", 0);
        column.put("Fünfer", 0);
        column.put("Sechser", 0);
        column.put("Gesamt", scoreUpperHalf);
        column.put("Bonus", 0);
        column.put("Oberer Teil", scoreUpperHalf);
        column.put("Dreierpasch", 0);
        column.put("Viererpasch", 0);
        column.put("Full House", 0);
        column.put("Kleine Straße", 0);
        column.put("Große Straße", 0);
        column.put("Kniffel", 0);
        column.put("Chance", 0);
        column.put("Unterer Teil", scoreBottomHalf);
        column.put("Endsumme", finalScore);
    }
    private static void currentTable() {

        System.out.format("+---------+%n");
        System.out.format("| Spiel 1 |%n");
        System.out.format("+---------+%n");

        String leftAlignment = "| %-2s |%n";
        for (String single : column.keySet()) {
            System.out.format(leftAlignment, single + ": " + column.get(single));
            //System.out.format("+---------+ %n");
        }

    }
    private static void confirmRoll() {

        ArrayList<Integer> confirmedRoll = new ArrayList<>();
        rollScore = 0;

        // bonus will never be changed
        final int bonus = 35;
        // points must be mutable
        int points;

        currentTable();
        System.out.println("Welches Feld willst du eintragen?");

        // this scanner is local while the other is class wide so I should change that
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch (input) {
            case "1":
                points = 1;

                // loop iterates through elements of kept and adds all the ones to another arraylist
                for (Integer integer : kept) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }

                // for every found one in confirmedRoll 1 is added to rollScore
                for (Integer ignored : confirmedRoll) {
                    rollScore += points;
                }

                // rollScore is added to the score
                upperHalfSum += rollScore;
                scoreUpperHalf += rollScore;

                // column integer will be set from 0 to rollScore
                column.put("Einer", rollScore);

                // same for 2 - 6
                break;
            case "2":
                points = 2;
                for (Integer integer : kept) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    rollScore += points;
                }
                upperHalfSum += rollScore;
                scoreUpperHalf += rollScore;
                column.put("Zweier", rollScore);
                break;
            case "3":
                points = 3;
                for (Integer integer : kept) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    rollScore += points;
                }
                upperHalfSum += rollScore;
                scoreUpperHalf += rollScore;
                column.put("Dreier", rollScore);
                break;
            case "4":
                points = 4;
                for (Integer integer : kept) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    rollScore += points;
                }
                upperHalfSum += rollScore;
                scoreUpperHalf += rollScore;
                column.put("Vierer", rollScore);
                break;
            case "5":
                points = 5;
                for (Integer integer : kept) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    rollScore += points;
                }
                upperHalfSum += rollScore;
                scoreUpperHalf += rollScore;
                column.put("Fünfer", rollScore);
                break;
            case "6":
                points = 6;
                for (Integer integer : kept) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    rollScore += points;
                }
                upperHalfSum += rollScore;
                scoreUpperHalf += rollScore;
                column.put("Sechser", rollScore);
                break;
            case "dp":

                // kept being sorted is critical for the following if statement as this makes things much easier
                kept.sort(null);

                // when the array is sorted and if there are three identical integers in kept, there are three
                // different possible scenarios and one of them must be true for meeting the condition of a Dreierpasch
                if ((kept.get(0) == kept.get(1) & kept.get(1) == kept.get(2)) ||
                        (kept.get(1) == kept.get(2) & kept.get(2) == kept.get(3)) ||
                        (kept.get(2) == kept.get(3) & kept.get(3) == kept.get(4)))  {
                    // if the condition is met, all integers will be added to rollScore
                    confirmedRoll.addAll(kept);
                    for (Integer ignored : confirmedRoll) {
                        rollScore += ignored;
                    }
                    scoreBottomHalf += rollScore;
                    column.put("Dreierpasch", rollScore);
                } else {
                    System.out.println("Kein Dreierpasch");
                }
                break;
            case "vp":
                kept.sort(null);
                // like above but with only 2 scenarios
                if ((kept.get(0) == kept.get(1) & kept.get(1) == kept.get(2) & kept.get(2) == kept.get(3)) ||
                        (kept.get(1) == kept.get(2) & kept.get(2) == kept.get(3) & kept.get(3) == kept.get(4)))  {
                    confirmedRoll.addAll(kept);
                    for (Integer ignored : confirmedRoll) {
                        rollScore += ignored;
                    }
                    scoreBottomHalf += rollScore;
                    column.put("Viererpasch", rollScore);
                } else {
                    System.out.println("Kein Viererpasch");
                }
                break;
            case "fh":
                kept.sort(null);
                // like above, when sorted there are two possible scenarios
                if (((kept.get(0) == kept.get(1)) & (kept.get(2) == kept.get(3) & kept.get(3) == kept.get(4))) ||
                        (kept.get(0) == kept.get(1) & kept.get(1) == kept.get(2)) & (kept.get(3) == kept.get(4)) ) {
                    confirmedRoll.addAll(kept);
                    points = 25;
                    rollScore += points;
                    scoreBottomHalf += rollScore;
                    column.put("Full House", rollScore);
                } else {
                    System.out.println("Kein Full House");
                }
                break;
            case "ks":
                // I tried to simplify the conditions and use arrayLists
                ArrayList<Integer> control1 = new ArrayList<>(
                        Arrays.asList(1, 2, 3, 4));
                ArrayList<Integer> control2 = new ArrayList<>(
                        Arrays.asList(2, 3, 4, 5));
                ArrayList<Integer> control3 = new ArrayList<>(
                        Arrays.asList(3, 4, 5, 6));

                kept.sort(null);
                // after being sort, there are three scenarios and one must be true for the if-block to execute
                if (kept.containsAll(control1) || kept.containsAll(control2) || kept.containsAll(control3)) {

                    // I don't think this line is needed here
                    confirmedRoll.addAll(kept);

                    // points are added to the score and scoresheet
                    points = 30;
                    rollScore += points;
                    scoreBottomHalf += rollScore;
                    column.put("Kleine Straße", rollScore);
                } else {
                    System.out.println("Keine kleine Straße");
                }
                break;
            case "gs":
                // like above but more simple
                ArrayList<Integer> control4 = new ArrayList<>(
                        Arrays.asList(1, 2, 3, 4, 5));
                ArrayList<Integer> control5 = new ArrayList<>(
                        Arrays.asList(2, 3, 4, 5, 6));

                kept.sort(null);
                if (kept.containsAll(control4) || kept.containsAll(control5)) {
                    confirmedRoll.addAll(kept);
                    points = 40;
                    rollScore += points;
                    scoreBottomHalf += rollScore;
                    column.put("Große Straße", rollScore);
                } else {
                    System.out.println("Keine große Straße");
                }
                break;
            case "kn":
                // every integer must be of the same value
                if (kept.get(0) == kept.get(1) && kept.get(1) == kept.get(2) &&
                        kept.get(2) == kept.get(3) && kept.get(3) == kept.get(4)) {

                    confirmedRoll.addAll(kept);
                    points = 50;
                    rollScore += points;
                    scoreBottomHalf += rollScore;
                    column.put("Kniffel", rollScore);
                } else {
                    System.out.println("Kein Kniffel");
                }
                break;
            case "ch":
                // every integer in confirmedRoll will be added to the score
                confirmedRoll.addAll(kept);
                for (Integer ignored : confirmedRoll) {
                    rollScore += ignored;
                }
                scoreBottomHalf += rollScore;
                column.put("Chance", rollScore);
                break;
            default:
                System.out.println("Ungültige Eingabe");
                confirmRoll();
        }
        kept.clear();
        System.out.println(confirmedRoll);

        // bonus is added if the score from 1 - 6 is at least 63 which is achieved
        // by rolling at least 3 same integers for every number:
        // 3 * 1 + 3 * 2 + 3 * 3 + 4 * 3 + 5 * 3 + 6 * 3 = 3 + 6 + 9 + 12 + 15 + 18 = 63
        if (upperHalfSum >= 63) {
            scoreUpperHalf = upperHalfSum + bonus;
            column.put("Bonus", bonus);
            column.put("Oberer Teil", scoreUpperHalf);
        }
        finalScore = scoreUpperHalf + scoreBottomHalf;
        column.put("Gesamt", upperHalfSum);
        column.put("Oberer Teil", scoreUpperHalf);
        column.put("Unterer Teil", scoreBottomHalf);
        column.put("Endsumme", finalScore);
    }
    private static void firstRound() {
        // boolean is set to true when a certain condition is met
        isHappy = false;
        // you can roll three times. attempt is incremented by 1 after every roll
        attempt = 0;
        firstRoll();
        attempt++;

        System.out.println("\n" + attempt + ". Wurf: " + eyes);

        // while loop runs until isHappy is set to true
        while (!isHappy) {
            System.out.println("Welche Würfel behalten?\nGib 5 ein, wenn du zufrieden bist.");
            // I want to reuse this scanner in other methods
            int input = sc.nextInt();

            if (input == 5) {
                // next line took me a few hours
                // this prevents rerolled from being empty when the first input is 5
                rerolled = eyes;
                // while loop ends at this point
                isHappy = true;
            } else {
                // elements will be switched between arrayLists
                kept.add(eyes.get(input));
                eyes.remove(eyes.get(input));
                rerolled = eyes;
                System.out.println("Behalten: " + kept);
                System.out.println("Neu würfeln: " + rerolled);
            }
        }
    }
    private static void secondRound(ArrayList<Integer> al) {
        for (int round = 1; round < 3; round++) {
            isHappy = false;

            if (!eyes.isEmpty()) {
                eyes = reroll(al);
            }
            attempt++;

            System.out.println("\n" + attempt + ". Wurf");
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

            if (round < 2) {
                boolean wantsToRerollKept = false;

                // after the first roll you can reroll dices you kept previously if feel like it
                System.out.println("Willst du behaltene Würfel neu würfeln? [y/n]");
                // another local scanner, when I should only need one
                Scanner sc2 = new Scanner(System.in);
                String yesNo = sc2.nextLine().toLowerCase();

                if (yesNo.equals("y")) {
                    while (!wantsToRerollKept) {
                        System.out.println("Welche behaltenen Würfel sollen neu gewürfelt werden?\nGib 5 ein, wenn du zufrieden bist.");
                        int input2 = sc.nextInt();

                        if (input2 == 5) {
                            wantsToRerollKept = true;
                        } else {
                            eyes.add(kept.get(input2));
                            kept.remove(kept.get(input2));
                            System.out.println("Behalten: " + kept);
                            System.out.println("Neu würfeln: " + eyes);
                        }
                    }
                }
            }
        }

        if (kept.size() < 5) {
            System.out.println("Restliche Würfel werden hinzugefügt...");
            kept.addAll(eyes);
            System.out.println("Behalten: " + kept);
        }
    }
    private static ArrayList<Integer> firstRoll() {
        // if eyes has elements they will be removed
        if (!eyes.isEmpty())
            eyes.clear();
        // eyes will be given pseudo-random integers if they are not zero until eyes has five elements
        while (eyes.size() < 5) {
            int result = d1.roll();
            if (result != 0) eyes.add(result);
        }
        return eyes;
    }
    private static ArrayList<Integer> reroll(ArrayList<Integer> al) {
        // size of a given arrayList will be saved
        int elements = al.size();
        // arrayList will be cleared
        al.clear();

        // given arrayList will be filled with pseudo-random integers until the arrayList has the size of elements
        while (al.size() < elements) {
            int result = d1.roll();
            if (result != 0) al.add(result);
        }
        // rerolled arrayList will be returned
        return al;
    }
    private static void welcomeOutput() {
        System.out.println("###################################");
        System.out.println("############# KNIFFEL #############");
        System.out.println("###################################");
    }
    private static void userManual() {

        System.out.println("Sofern die Kniffel-Regeln bekannt sind, wird die Anwendung wie folgend bedient:");
        System.out.println("\n########################");
        System.out.println("Einer: 1 ###############");
        System.out.println("Zweier: 2 ##############");
        System.out.println("Dreier: 3 ##############");
        System.out.println("Vierer: 4 ##############");
        System.out.println("Fünfer: 5 ##############");
        System.out.println("Sechser: 6 #############");

        System.out.println("Dreierpasch: dp ########");
        System.out.println("Viererpasch: vp ########");
        System.out.println("Full House: fh #########");
        System.out.println("Kleine Straße: ks ######");
        System.out.println("Große Straße: gs #######");
        System.out.println("Kniffel: kn ############");
        System.out.println("Chance: ch #############");
        System.out.println("########################\n");

    }
}
