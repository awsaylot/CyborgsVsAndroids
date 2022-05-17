public class Humanoid {
    int health;
    int strength;
    int[] position = new int[2];

    public Humanoid() {
        this.health = 100;
        this.strength = 20;
    }
    public int[] getPosition(){
        return this.position;
    }
    public int getStrength() {
        return this.strength;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    public void takeTurn(){
        System.out.println("Take turn");
    }
    public void move(String direction) {
        switch(direction) {
            case "w":
                this.position = Land.checkMove(this, new int[]{this.position[0], this.position[1] - 1});
                break;
            case "a":
                this.position = Land.checkMove(this, new int[]{this.position[0] - 1, this.position[1] });
                break;
            case "s":
                this.position = Land.checkMove(this, new int[]{this.position[0], this.position[1] + 1});
                break;
            case "d":
                this.position = Land.checkMove(this, new int[]{this.position[0] + 1, this.position[1] });
                break;
            default:
                System.out.println("You did not move");
        }
    }
}
