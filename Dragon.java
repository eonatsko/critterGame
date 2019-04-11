import java.awt.Color;

public class Dragon extends Critter {
    
    int foodCount = 0;
    private int horMoveCount = 5;
    private int vertMoveCount = 0;
    Attack currentAttack;
    Direction currentDirection;
    private Direction currentVerticalDirection, currentHorizontalDirection;
    private final Attack[] attacks = {Attack.POUNCE, 
                                      Attack.ROAR, 
                                      Attack.SCRATCH};
    
    public Dragon() {
        int startingAttackIndex = (int)(Math.random() * 3);
        currentAttack = attacks[startingAttackIndex];  
        currentDirection = Direction.WEST;
        
        
    }
    
    private boolean nextMoveIsVertical() {
        if (currentDirection == Direction.WEST 
                || currentDirection == Direction.EAST) {
            return true;
        } else {
            return false;
        }
    }
    
    public Color getColor() {
        if (foodCount == 0) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }

    public boolean eat() {
        foodCount = (foodCount + 1) % 2;
        
        return true;
    }
            
    public Critter.Direction getMove() {
        Direction thisMove = currentDirection;
        
        if(vertMoveCount < 10 && nextMoveIsVertical() == false) {
            vertMoveCount++;
        } else {
            turn();
        }
        
        if(horMoveCount < 10 && nextMoveIsVertical() == true) {
            horMoveCount++;
        } else {
            turn();
        }
        
        setNextDirection();
        
        return thisMove;
    }

    public Critter.Attack fight(String opponent) {
        Attack attack = this.currentAttack;
        
        if(opponent == "B") {
            currentAttack = Attack.ROAR;
        } else if (opponent == "L") {
            currentAttack = Attack.POUNCE;
        } else {
            currentAttack = Attack.SCRATCH;
        }
        
        return attack;
    }
    
    private void turn() {
        if (vertMoveCount > 9) {
            vertMoveCount = 0;
            if(currentVerticalDirection == Direction.SOUTH) {
                currentVerticalDirection = Direction.NORTH;
            } else {
                currentVerticalDirection = Direction.SOUTH;
            }
        }
        
        if (horMoveCount > 9) {
            horMoveCount = 0;
            if(currentHorizontalDirection == Direction.WEST) {
                currentHorizontalDirection = Direction.EAST;
            } else {
                currentHorizontalDirection = Direction.WEST;
            }
        }
    }
    
    private void setNextDirection() {
        if (nextMoveIsVertical()) {
            currentDirection = currentVerticalDirection;         
        } else {
            currentDirection = currentHorizontalDirection;
        }
    }
    
    public String toString() {
        return "D";
    }

}
