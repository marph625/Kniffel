import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Player {

    private ArrayList<Integer> eyes = new ArrayList<>();
    private ArrayList<Integer> kept = new ArrayList<>();
    private ArrayList<Integer> rerolled = new ArrayList<>();
    private LinkedHashMap<String, Integer> column;
    private int id, attempt, rollScore, scoreUpperHalf, scoreBottomHalf, finalScore, upperHalfSum;
    private String color;

    public Player() {
        id++;
    }

    public Player(String color) {
        this.color = color;
        id++;
        column = new LinkedHashMap<>();
        column.put("Einer", 0);
        column.put("Zweier", 0);
        column.put("Dreier", 0);
        column.put("Vierer", 0);
        column.put("Fünfer", 0);
        column.put("Sechser", 0);
    }

    public LinkedHashMap<String, Integer> getColumn() {
        return column;
    }

    public void setColumn(LinkedHashMap<String, Integer> column) {
        this.column = column;
    }

    public ArrayList<Integer> getEyes() {
        return eyes;
    }

    public void setEyes(ArrayList<Integer> eyes) {
        this.eyes = eyes;
    }

    public ArrayList<Integer> getKept() {
        return kept;
    }

    public void setKept(ArrayList<Integer> kept) {
        this.kept = kept;
    }

    public ArrayList<Integer> getRerolled() {
        return rerolled;
    }

    public void setRerolled(ArrayList<Integer> rerolled) {
        this.rerolled = rerolled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getRollScore() {
        return rollScore;
    }

    public void setRollScore(int rollScore) {
        this.rollScore = rollScore;
    }

    public int getScoreUpperHalf() {
        return scoreUpperHalf;
    }

    public void setScoreUpperHalf(int scoreUpperHalf) {
        this.scoreUpperHalf = scoreUpperHalf;
    }

    public int getScoreBottomHalf() {
        return scoreBottomHalf;
    }

    public void setScoreBottomHalf(int scoreBottomHalf) {
        this.scoreBottomHalf = scoreBottomHalf;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public int getUpperHalfSum() {
        return upperHalfSum;
    }

    public void setUpperHalfSum(int upperHalfSum) {
        this.upperHalfSum = upperHalfSum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", attempt=" + attempt +
                ", rollScore=" + rollScore +
                ", scoreUpperHalf=" + scoreUpperHalf +
                ", scoreBottomHalf=" + scoreBottomHalf +
                ", finalScore=" + finalScore +
                ", upperHalfSum=" + upperHalfSum +
                ", color='" + color + '\'' +
                '}';
    }
}
