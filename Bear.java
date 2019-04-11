import java.awt.*;

public class Bear extends Critter {

    boolean isGrizzly;
    Direction currentDirection = Direction.SOUTH;

    public Bear(boolean isGrizzly) {
        // if not grizzly has to be polar bear
        this.isGrizzly = isGrizzly;
    }

    public Color getColor() {
        if (this.isGrizzly == true) {
            return new Color(190, 110, 50);
        } else {
            return Color.WHITE;
        }        
    }

    public boolean eat() {
        return true;
    }

    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }

    public Direction getMove() {
        Direction moveThisWay = this.currentDirection;
        
        if (this.currentDirection == Direction.SOUTH) {
            currentDirection = Direction.EAST;
        } else if (this.currentDirection == Direction.EAST) {
            currentDirection = Direction.SOUTH;
        }
        
        return moveThisWay;
    }

    public String toString() {
        return "B";
    }
}
