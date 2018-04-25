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
        MapGenerator mapGen = new MapGenerator();
        MapWithArray newMap = mapGen.getMap();
        Tile tile = newMap.tiles[1][1];
        newMap.stringRep();
        while(true){
            switch(sc.next()){
                case "w":
                   //tuple = tryMove(map, tuple, new Tuple(0,1));
                    tile = newNewTryMove(tile, Direction.NORTH);
                    break;
                case "a":
                   //tuple = tryMove(map, tuple, new Tuple(-1,0));
                    tile = newNewTryMove(tile, Direction.WEST);
                    break;
                case "s":
                    //tuple = tryMove(map, tuple, new Tuple(0,-1));
                    tile = newNewTryMove(tile, Direction.SOUTH);
                    break;
                case "d":
                    //tuple = tryMove(map, tuple, new Tuple(1,0));
                    tile = newNewTryMove(tile, Direction.EAST);
                    break;
                default:
                    break;
            }
            System.out.println(tile.getPosition().toString() + ", " + tile.toString()); //printer den tile 'spilleren' står på, samt typen af tilen. 
        }
    }
    
    public static Tuple tryMove(MapWithArray map, Tuple position, Tuple direction){ //GAMMELT, men lad stå just in case
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
    public static Tile newTryMove(Tile currentTile, Direction direction){ //oudated lort, ignorer for now :D
        int index = direction.toInt();
        if(currentTile.edges[index].isWall()){
            return currentTile;
        }else{
            return currentTile.neighbors[index];
        }
    }
    public static Tile newNewTryMove(Tile currentTile, Direction direction){
        int index = direction.toInt();
        Tile neighborTile = currentTile.neighbors[index];
        if(neighborTile != null){
            return neighborTile;
        }
        return currentTile;
    }
    
}
