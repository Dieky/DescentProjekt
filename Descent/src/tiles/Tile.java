/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;
import util.*;
/**
 *
 * @author Jens
 */
public class Tile {
    public Edge[] edges; //0:nord, 1:øst, 2:syd, 3: vest
    public Tile[] neighbors; //0:nord, 1:øst, 2:syd, 3: vest
    private final Tuple position;
    private int width,height;
    private TileType type;
    
    public Tile(int x, int y, int width, int height, TileType type){
        this.position = new Tuple(x,y);
        this.width = width;
        this.height = height;
        this.type = type;
        this.edges = new Edge[4];
        this.neighbors = new Tile[4];
        for(int i = 0; i < edges.length; i++){
            edges[i] = new Edge();
        }
    }
    
    public Tuple getPosition(){
        return position;
    }
    
    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public TileType getType(){
        return type;
    }
    
    public Tile returnNeighbor(Direction direction){
        return neighbors[direction.toInt()];
    }
    @Override
    public String toString(){
        switch(this.type){
            case GROUND:
                return "Ground";
            case WATER:
                return "Water";
            case EMPTY:
                return "Empty";
            case FIRE:
                return "Fire";
            case POISON:
                return "Poison";
            default:
                return "No type";
        }
    }
}
