import java.util.HashMap;
import java.util.Scanner;

public class Cyborg extends Humanoid {
    HashMap<String, int[]> inventory = new HashMap<>();

    public Cyborg(int x, int y) {
        this.position = new int[]{x, y};
        Land.setTile(this,new int[]{x, y});
    }
    public String getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which direction would you like to move? (w, a, s, d)");
        try {
            return scan.nextLine();
        } catch (Exception e) {
            return "";
        }
    }
    @Override
    public void takeTurn() {
        this.move(getInput());
    }
    @Override
    public String toString() {
        return "C";
    }

    public void pickUpDrop(String key, int[] stats) {
        inventory.put(key, stats);
        this.health += stats[0];
        this.strength += stats[1];
    }
}
