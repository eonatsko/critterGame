import java.awt.*;

public class Lion extends Critter {

    public boolean isHungry;
    private int moveCount;
    public int trace = 0;
    private Direction currentDirection;

    public Lion() {
        isHungry = false;
        moveCount = 0;
        currentDirection = Direction.SOUTH;
    }

    public Color getColor() {
        return Color.RED;
    }

    public boolean eat() {
        if (this.isHungry == true) {
            this.isHungry = false;
            return true;
        } else {
            return false;
        }
    }
            
    public Direction getMove() {
        trace++;
        if (moveCount < 5) {
            moveCount++;           
        } else {
            moveCount = 1;
            setNextDirection();
        }
        return currentDirection;
    }

    public Attack fight(String opponent) {
        this.isHungry = true;
        
        if(opponent == "B") {
            return Attack.ROAR;
        } else {
            return Attack.POUNCE;
        }
    }
    
    private void setNextDirection() {
        if (null != currentDirection) {
            switch (currentDirection) {
                case SOUTH:
                    currentDirection = Direction.WEST;
                    break;
                case WEST:
                    currentDirection = Direction.NORTH;
                    break;
                case NORTH:
                    currentDirection = Direction.EAST;
                    break;
                default:
                    currentDirection = Direction.SOUTH;
                    break;
            }
        }
    }
    
    public String toString() {
        return "L";
    }

}
