/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import util.*;
import java.awt.Graphics2D;
/**
 *
 * @author Jens
 */
public class Tile {
    private int x,y,width,height;
    private TileType type;
    
    public Tile(int x, int y, int width, int height, TileType type){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
