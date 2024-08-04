import java.util.*;

public class OOP {

    static LinkedHashMap<String, Integer> column = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);
    static Dice d1 = new Dice();
    static boolean isHappy;
    static int attempt;

    static void test_two_rolls() {
        Player p1 = new Player("Blue");
        Player p2 = new Player("Red");

        ArrayList<Integer> a1 = oopFirstRoll(p1);
        ArrayList<Integer> a2 = oopFirstRoll(p2);
        HashSet<Integer> a3 = new HashSet<>();


        for (int i = 0; i < a1.size(); i++) {
            if (!a2.contains(a1.get(i))) {
                a3.add(a1.get(i));
            }
        }
        for (int i = 0; i < a2.size(); i++) {
            if (!a1.contains(a2.get(i))) {
                a3.add(a2.get(i));
            }
        }

        a1.sort(null);
        a2.sort(null);

        System.out.println(p2.getColor() + ": " + a1);
        System.out.println(p1.getColor() + ": " + a2);
        System.out.println("Einzigartig: " + a3);
        System.out.println("Anzahl: " + a3.size());
    }
    static void defaultTable(Player player) {
        column.put("Einer", 0);
        column.put("Zweier", 0);
        column.put("Dreier", 0);
        column.put("Vierer", 0);
        column.put("Fünfer", 0);
        column.put("Sechser", 0);
        column.put("Gesamt", player.getUpperHalfSum());
        column.put("Bonus", 0);
        column.put("Oberer Teil", player.getScoreUpperHalf());
        column.put("Dreierpasch", 0);
        column.put("Viererpasch", 0);
        column.put("Full House", 0);
        column.put("Kleine Straße", 0);
        column.put("Große Straße", 0);
        column.put("Kniffel", 0);
        column.put("Chance", 0);
        column.put("Unterer Teil", player.getScoreBottomHalf());
        column.put("Endsumme", player.getFinalScore());
    }
    static void currentTable(Player player) {

        System.out.format("+---------+%n");
        System.out.format("| Spiel 1 |%n");
        System.out.format("+---------+%n");

        String leftAlignment = "| %-2s |%n";
        for (String single : player.getColumn().keySet()) {
            System.out.format(leftAlignment, single + ": " + player.getColumn().get(single));
            //System.out.format("+---------+ %n");
        }

    }
    static void confirmRoll(Player player) {

        ArrayList<Integer> confirmedRoll = new ArrayList<>();
        player.setRollScore(0);

        // bonus will never be changed
        final int bonus = 35;
        // points must be mutable
        int points;

        currentTable(player);
        System.out.println("Welches Feld willst du eintragen?");

        // this scanner is local while the other is class wide so I should change that
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch (input) {
            case "1":
                points = 1;

                // loop iterates through elements of kept and adds all the ones to another arraylist
                for (Integer integer : player.getKept()) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }

                // for every found one in confirmedRoll 1 is added to rollScore
                for (Integer ignored : confirmedRoll) {
                    player.setRollScore(player.getRollScore() + points);
                }

                // rollScore is added to the score

                player.setUpperHalfSum(player.getUpperHalfSum() + player.getRollScore());
                player.setScoreUpperHalf(player.getScoreUpperHalf() + player.getRollScore());

                // column integer will be set from 0 to rollScore
                column.put("Einer", player.getRollScore());

                // same for 2 - 6
                break;
            case "2":
                points = 2;
                for (Integer integer : player.getKept()) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    player.setRollScore(player.getRollScore() + points);
                }
                player.setUpperHalfSum(player.getUpperHalfSum() + player.getRollScore());
                player.setScoreUpperHalf(player.getScoreUpperHalf() + player.getRollScore());
                column.put("Zweier", player.getRollScore());
                break;
            case "3":
                points = 3;
                for (Integer integer : player.getKept()) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    player.setRollScore(player.getRollScore() + points);
                }
                player.setUpperHalfSum(player.getUpperHalfSum() + player.getRollScore());
                player.setScoreUpperHalf(player.getScoreUpperHalf() + player.getRollScore());
                column.put("Zweier", player.getRollScore());
                break;
            case "4":
                points = 4;
                for (Integer integer : player.getKept()) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    player.setRollScore(player.getRollScore() + points);
                }
                player.setUpperHalfSum(player.getUpperHalfSum() + player.getRollScore());
                player.setScoreUpperHalf(player.getScoreUpperHalf() + player.getRollScore());
                column.put("Zweier", player.getRollScore());
                break;
            case "5":
                points = 5;
                for (Integer integer : player.getKept()) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    player.setRollScore(player.getRollScore() + points);
                }
                player.setUpperHalfSum(player.getUpperHalfSum() + player.getRollScore());
                player.setScoreUpperHalf(player.getScoreUpperHalf() + player.getRollScore());
                column.put("Zweier", player.getRollScore());
                break;
            case "6":
                points = 6;
                for (Integer integer : player.getKept()) {
                    if (integer == points) {
                        confirmedRoll.add(integer);
                    }
                }
                for (Integer ignored : confirmedRoll) {
                    player.setRollScore(player.getRollScore() + points);
                }
                player.setUpperHalfSum(player.getUpperHalfSum() + player.getRollScore());
                player.setScoreUpperHalf(player.getScoreUpperHalf() + player.getRollScore());
                column.put("Zweier", player.getRollScore());
                break;
            case "dp":

                // kept being sorted is critical for the following if statement as this makes things much easier
                player.getKept().sort(null);

                // when the array is sorted and if there are three identical integers in kept, there are three
                // different possible scenarios and one of them must be true for meeting the condition of a Dreierpasch
                if ((player.getKept().get(0) == player.getKept().get(1) & player.getKept().get(1) == player.getKept().get(2)) ||
                        (player.getKept().get(1) == player.getKept().get(2) & player.getKept().get(2) == player.getKept().get(3)) ||
                        (player.getKept().get(2) == player.getKept().get(3) & player.getKept().get(3) == player.getKept().get(4)))  {
                    // if the condition is met, all integers will be added to rollScore
                    confirmedRoll.addAll(player.getKept());
                    for (Integer ignored : confirmedRoll) {
                        player.setRollScore(player.getRollScore() + ignored);
                    }
                    player.setScoreBottomHalf(player.getScoreBottomHalf() + player.getRollScore());
                    column.put("Dreierpasch", player.getRollScore());
                } else {
                    System.out.println("Kein Dreierpasch");
                }
                break;
            case "vp":
                player.getKept().sort(null);
                // like above but with only 2 scenarios
                if ((player.getKept().get(0) == player.getKept().get(1) & player.getKept().get(1) == player.getKept().get(2) & player.getKept().get(2) == player.getKept().get(3)) ||
                        (player.getKept().get(1) == player.getKept().get(2) & player.getKept().get(2) == player.getKept().get(3) & player.getKept().get(3) == player.getKept().get(4)))  {
                    confirmedRoll.addAll(player.getKept());
                    for (Integer ignored : confirmedRoll) {
                        player.setRollScore(player.getRollScore() + ignored);
                    }
                    player.setScoreBottomHalf(player.getScoreBottomHalf() + player.getRollScore());
                    column.put("Viererpasch", player.getRollScore());
                } else {
                    System.out.println("Kein Viererpasch");
                }
                break;
            case "fh":
                player.getKept().sort(null);
                // like above, when sorted there are two possible scenarios
                if (((player.getKept().get(0) == player.getKept().get(1)) & (player.getKept().get(2) == player.getKept().get(3) & player.getKept().get(3) == player.getKept().get(4))) ||
                        (player.getKept().get(0) == player.getKept().get(1) & player.getKept().get(1) == player.getKept().get(2)) & (player.getKept().get(3) == player.getKept().get(4)) ) {
                    confirmedRoll.addAll(player.getKept());
                    points = 25;
                    player.setRollScore(player.getRollScore() + points);
                    player.setScoreBottomHalf(player.getScoreBottomHalf() + player.getRollScore());
                    column.put("Full House", player.getRollScore());
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

                player.getKept().sort(null);
                // after being sort, there are three scenarios and one must be true for the if-block to execute
                if (player.getKept().containsAll(control1) || player.getKept().containsAll(control2) || player.getKept().containsAll(control3)) {

                    // I don't think this line is needed here
                    confirmedRoll.addAll(player.getKept());

                    // points are added to the score and scoresheet
                    points = 30;
                    player.setRollScore(player.getRollScore() + points);
                    player.setScoreBottomHalf(player.getScoreBottomHalf() + player.getRollScore());
                    column.put("Kleine Straße", player.getRollScore());
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

                player.getKept().sort(null);
                if (player.getKept().containsAll(control4) || player.getKept().containsAll(control5)) {
                    confirmedRoll.addAll(player.getKept());
                    points = 40;
                    player.setRollScore(player.getRollScore() + points);
                    player.setScoreBottomHalf(player.getScoreBottomHalf() + player.getRollScore());
                    column.put("Große Straße", player.getRollScore());
                } else {
                    System.out.println("Keine große Straße");
                }
                break;
            case "kn":
                // every integer must be of the same value
                if (player.getKept().get(0) == player.getKept().get(1) && player.getKept().get(1) == player.getKept().get(2) &&
                        player.getKept().get(2) == player.getKept().get(3) && player.getKept().get(3) == player.getKept().get(4)) {

                    confirmedRoll.addAll(player.getKept());
                    points = 50;
                    player.setRollScore(player.getRollScore() + points);
                    player.setScoreBottomHalf(player.getScoreBottomHalf() + player.getRollScore());
                    column.put("Kniffel", player.getRollScore());
                } else {
                    System.out.println("Kein Kniffel");
                }
                break;
            case "ch":
                // every integer in confirmedRoll will be added to the score
                confirmedRoll.addAll(player.getKept());
                for (Integer ignored : confirmedRoll) {
                    player.setRollScore(player.getRollScore() + ignored);
                }
                player.setScoreBottomHalf(player.getScoreBottomHalf() + player.getRollScore());
                column.put("Chance", player.getRollScore());
                break;
            default:
                System.out.println("Ungültige Eingabe");
                confirmRoll(player);
        }
        player.getKept().clear();
        System.out.println(confirmedRoll);

        // bonus is added if the score from 1 - 6 is at least 63 which is achieved
        // by rolling at least 3 same integers for every number:
        // 3 * 1 + 3 * 2 + 3 * 3 + 4 * 3 + 5 * 3 + 6 * 3 = 3 + 6 + 9 + 12 + 15 + 18 = 63
        if (player.getUpperHalfSum() >= 63) {
            player.setScoreUpperHalf(player.getUpperHalfSum() + bonus);
            column.put("Bonus", bonus);
            column.put("Oberer Teil", player.getScoreUpperHalf());
        }
        player.setFinalScore(player.getScoreUpperHalf() + player.getScoreBottomHalf());
        column.put("Gesamt", player.getUpperHalfSum());
        column.put("Oberer Teil", player.getScoreUpperHalf());
        column.put("Unterer Teil", player.getScoreBottomHalf());
        column.put("Endsumme", player.getFinalScore());
    }
    static void firstRound(Player player) {
        // boolean is set to true when a certain condition is met
        isHappy = false;
        // you can roll three times. attempt is incremented by 1 after every roll
        attempt = 0;
        oopFirstRoll(player);
        attempt++;

        System.out.println("Spieler:" + player.getColor() + "\n" + attempt + ". Wurf: " + player.getEyes());

        // while loop runs until isHappy is set to true
        while (!isHappy) {
            System.out.println("Welche Würfel behalten?\nGib 5 ein, wenn du zufrieden bist.");
            // I want to reuse this scanner in other methods
            int input = sc.nextInt();

            if (input == 5) {
                // next line took me a few hours
                // this prevents rerolled from being empty when the first input is 5
                player.setRerolled(player.getEyes());
                // while loop ends at this point
                isHappy = true;
            } else {
                // elements will be switched between arrayLists

                player.getKept().add(player.getEyes().get(input));
                player.getEyes().remove(player.getEyes().get(input));
                player.setRerolled(player.getEyes());

                System.out.println("Behalten: " + player.getKept());
                System.out.println("Neu würfeln: " + player.getRerolled());
            }
        }
    }
    static void secondRound(Player player) {
        for (int round = 1; round < 3; round++) {
            isHappy = false;

            if (!player.getEyes().isEmpty()) {
                player.setEyes(reroll(player.getRerolled()));
            }
            attempt++;

            System.out.println("Spieler:" + player.getColor() + "\n" + attempt + ". Wurf");
            System.out.println("Behalten: " + player.getKept());
            System.out.println("Gewürfelt: " + player.getEyes());

            while (!isHappy) {
                System.out.println("Welche Würfel behalten?\nGib 5 ein, wenn du zufrieden bist.");

                int input = sc.nextInt();

                if (input == 5) {
                    isHappy = true;
                } else {

                    player.getKept().add(player.getEyes().get(input));
                    player.getEyes().remove(player.getEyes().get(input));
                    player.setRerolled(player.getEyes());

                    System.out.println("Behalten: " + player.getKept());
                    System.out.println("Gewürfelt: " + player.getRerolled());
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
                            player.getEyes().add(player.getKept().get(input2));
                            player.getKept().remove(player.getKept().get(input2));
                            System.out.println("Behalten: " + player.getKept());
                            System.out.println("Gewürfelt: " + player.getEyes());
                        }
                    }
                }
            }
        }

        if (player.getKept().size() < 5) {
            System.out.println("Restliche Würfel werden hinzugefügt...");
            player.getKept().addAll(player.getEyes());
            System.out.println("Behalten: " + player.getKept());
        }
    }
    static ArrayList<Integer> oopFirstRoll(Player player) {
        // if eyes has elements they will be removed
        if (!player.getEyes().isEmpty())
            player.getEyes().clear();
        // eyes will be given pseudo-random integers if they are not zero until eyes has five elements
        while (player.getEyes().size() < 5) {
            int result = d1.roll();
            if (result != 0) player.getEyes().add(result);
        }
        return player.getEyes();
    }
    static ArrayList<Integer> reroll(ArrayList<Integer> al) {
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
    static void welcomeOutput() {
        System.out.println("###################################");
        System.out.println("############# KNIFFEL #############");
        System.out.println("###################################");
    }
    static void userManual() {

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

