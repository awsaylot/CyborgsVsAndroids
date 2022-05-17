import java.lang.Math;

public class Android extends Humanoid {

    public Android(int x, int y) {
        this.position = new int[]{x, y};
        Land.setTile(this,new int[]{x, y});
    }
    private Humanoid closestTarget() {
        double shortest = 14;
        int index = 0;
        for (int i = 0; i < Land.cyborgs.size(); i ++) {
            int[] targetPosition = Land.cyborgs.get(i).getPosition();
            double xDifference = Math.pow(targetPosition[0] - this.position[0], 2);
            double yDifference = Math.pow(targetPosition[1] - this.position[1], 2);
            double distance = Math.sqrt(xDifference + yDifference);
            if (distance < shortest) {
                shortest = distance;
                index = i;
            }
        }
        return Land.cyborgs.get(index);
    }
    private String moveTowardsTarget(Humanoid target) {
        int[] targetPosition = target.getPosition();
        int xDifference = (targetPosition[0] - this.position[0]);
        int yDifference = (targetPosition[1] - this.position[1]);
        if (Math.abs(xDifference) >= Math.abs(yDifference)) {
            if (xDifference > 0) {
                return "d";
            }
            return "a";
        }
        if (yDifference > 0) {
            return "s";
        }
        return "w";
    }
    @Override
    public void takeTurn() {
        System.out.println("Android takes turn");
        Humanoid closestTarget = closestTarget();
        this.move(moveTowardsTarget(closestTarget));
    }
    @Override
    public String toString() {
        return "A";
    }
}
