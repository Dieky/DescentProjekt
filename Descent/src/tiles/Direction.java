/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import util.Tuple;

/**
 *
 * @author Jens
 */
public enum Direction { //enum til bevægelsesretninger
    NORTH(new Tuple(0,1)),
    EAST(new Tuple(1,0)),
    SOUTH(new Tuple(0,-1)),
    WEST(new Tuple(-1, 0)),
    ;
    private final Tuple direction;
    Direction(Tuple direction){
        this.direction = direction;
    }
    public Tuple getDirection(){
        return direction;
    }
    public int toInt(){
        if(direction.equals(new Tuple(0,1))){
            return 0;
        }else if(direction.equals(new Tuple(1,0))){
            return 1;
        }else if(direction.equals(new Tuple(0,-1))){
            return 2;
        }else{
            return 3;
        }
    }
}
