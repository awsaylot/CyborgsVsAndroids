public class Main {
    public static void main(String[] args) {
        Land.createGrid();
        Cyborg player = new Cyborg(0, 7);
        Land.addCyborg(player);
        Cyborg player2 = new Cyborg(1, 7);
        Land.addCyborg(player2);
        Land.addAndroid(new Android(7, 0));
        Land.drawGrid();
        while (Land.cyborgs.size() > 0 && Land.androids.size() > 0) {
            for (int x = 0; x < Land.cyborgs.size(); x++) {
                Land.cyborgs.get(x).takeTurn();
                Land.drawGrid();
            }
            for (int x = 0; x < Land.androids.size(); x++) {
                Land.androids.get(x).takeTurn();
                Land.drawGrid();
            }
        }
    }
}
