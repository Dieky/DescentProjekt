/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package descent;

import java.awt.BorderLayout;
import java.util.Scanner;
import tiles.*;
import util.Tuple;

public class Descent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MapWithArray map = new MapWithArray();
        Tuple tuple = new Tuple(1,0);
        System.out.println(map.toString());
        while(true){
            switch(sc.next()){
                case "w":
                    tuple = tryMove(map, tuple, new Tuple(0,1));
                    break;
                case "a":
                    tuple = tryMove(map, tuple, new Tuple(-1,0));
                    break;
                case "s":
                    tuple = tryMove(map, tuple, new Tuple(0,-1));
                    break;
                case "d":
                    tuple = tryMove(map, tuple, new Tuple(1,0));
                    break;
                default:
                    break;
            }
            System.out.println(tuple.toString());
            System.out.println(map.getTile(tuple));
        }
    }
    
    public static Tuple tryMove(MapWithArray map, Tuple position, Tuple direction){
        int x, y, dX, dY;
        x = position.getX();
        y = position.getY();
        dX = direction.getX();
        dY = direction.getY();
        
        if(dX == 0 && dY == 1){
            if(!map.tileEdges[x][y+dY][1].isWall()){ //go up
                return new Tuple(x+dX, y+dY);
            }else{
                return position;
            }
        }else if(dX == 1 && dY == 0){
            if(!map.tileEdges[x+dX][y][0].isWall()){ //go right
                return new Tuple(x+dX, y+dY);
            }else{
                return position;
            }
        }else if(dX == 0 && dY == -1){
            if(!map.tileEdges[x][y][1].isWall()){ //go down
                return new Tuple(x+dX, y+dY);
            }else{
                return position;
            }
        }else if(dX == -1 && dY == 0){
            if(!map.tileEdges[x][y][0].isWall()){ //go left
                return new Tuple(x+dX, y+dY);
            }else{
                return position;
            }
        }else{
            return position;
        }
        
    }
    
}
