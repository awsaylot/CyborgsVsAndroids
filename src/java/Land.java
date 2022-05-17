import java.util.ArrayList;
import java.util.Random;

public class Land {
    static int gridSize = 8;
    static ArrayList<ArrayList<Object>> grid = new ArrayList<>();
    static ArrayList<Humanoid> cyborgs = new ArrayList<>();
    static ArrayList<Humanoid> androids = new ArrayList<>();

    static void createGrid(){
        for (int y = 0; y < gridSize; y++) {
            ArrayList<Object> gridRow = new ArrayList<>();
            for (int x = 0;x < gridSize; x++) {
                gridRow.add("_");
            }
            grid.add(gridRow);
        }
//        addHumansAndCyborgs();
    }
    static void drawGrid(){
        grid.forEach(row-> {
            row.forEach(square->{
                System.out.print(square+ " ");
            });
            System.out.println();
        });
    }
    static void setTile(Object object, int[] coordinates){
        grid.get(coordinates[1]).set(coordinates[0], object);
    }
    static void addAndroid(Humanoid humanoid) {
        androids.add(humanoid);
    }
    static void addCyborg(Humanoid humanoid) {
        cyborgs.add(humanoid);
    }
    static void clearTile(int[] coordinates) {
        grid.get(coordinates[1]).set(coordinates[0], "_");
    }
    static int[] checkMove(Humanoid object, int[] coordinates){
        if (coordinates[0] >= gridSize || coordinates[0] < 0 || coordinates[1] >= gridSize || coordinates[1] < 0) {
            return object.getPosition();
        }
        boolean isOccupied = !grid.get(coordinates[1]).get(coordinates[0]).equals("_");
        if (isOccupied) {
            System.out.println("Combat!!!!!!!");
            if(wonCombat(object, coordinates)) {
                setTile(object, coordinates);
                clearTile(object.getPosition());
                return coordinates;
            }
            return object.getPosition();
        }
        setTile(object, coordinates);
        clearTile(object.getPosition());
        return coordinates;
    }
    private static boolean wonCombat(Humanoid object, int[] coordinates){
        Random rand = new Random();
        int attackRoll = rand.nextInt(20);
        int defenseRoll = rand.nextInt(10);
        Humanoid target = (Humanoid) grid.get(coordinates[1]).get(coordinates[0]);
        if (attackRoll > defenseRoll) {
            int newHealth = target.getHealth()-object.getStrength();
            if (newHealth <= 0) {
                System.out.println("Opponent has been defeated");
                if (target.getClass().getSimpleName() == "Cyborg") {
                    cyborgs.remove(target);
                } else {
                    androids.remove(target);
                }
                return true;
            }
            target.setHealth(target.getHealth()-object.getStrength());
            System.out.println("Opponent took damage for " + object.getStrength() + " damage.");
            return false;
        }
        System.out.println("Opponent dodged your attack");
        return false;
    }
}
