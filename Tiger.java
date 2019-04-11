import java.awt.*; // for Color
import java.util.Random;

public class Tiger extends Critter {
    
    private int max_hunger = 0;
    private int current_hunger = 0;
    private Direction[] directions = { Direction.NORTH, 
                                        Direction.SOUTH, 
                                        Direction.EAST,
                                        Direction.WEST } ;
    private int moveCount = 0;
    private Direction currentDirection;
    Random numberGenerator = new Random();
    

    public Tiger(int hunger) {
        max_hunger = hunger;
        this.setNextDirection();
        
    }
    
    public Color getColor() {
        return Color.YELLOW;
    }
    
    private boolean willEat() {
        if (current_hunger < max_hunger) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean eat() {        
        if (willEat() == true) {
            current_hunger++;
            return true;
        } else {
            return false;
        }
    }
    
    public Attack fight(String opponent) {
        if (willEat() == true) {
            return Attack.SCRATCH;
        } else {
            return Attack.POUNCE;
        }
    }

    public Direction getMove() {
        if (moveCount < 3) {
            moveCount++;           
        } else {
            moveCount = 1;
            setNextDirection();
        }
        return currentDirection;
    }
    
    private void setNextDirection() {
        int newDirectionIndex = numberGenerator.nextInt(4);
       
        currentDirection = directions[newDirectionIndex];
    }

    public String toString() {
        return Integer.toString(max_hunger - current_hunger);
    }
    
}
