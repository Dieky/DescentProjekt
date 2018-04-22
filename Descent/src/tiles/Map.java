/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;
import java.io.*;
import java.util.HashMap;
import util.Tuple;
/**
 *
 * @author Jens
 */
public class Map {
    int gridSize;
    public HashMap<Integer, Tile> tiles = new HashMap<>();
    public int[][] tiles2 = new int[2][2];
    
    public Map(){
        Tuple test = new Tuple(0,0);
        tiles.put(test.hashCode(), new Tile(TileType.GROUND));
        test.set(0, 1);
        tiles.put(test.hashCode(), new Tile(TileType.FIRE));
        test.set(0, 2);
        tiles.put(test.hashCode(), new Tile(TileType.GROUND));
        test.set(1, 0);
        tiles.put(test.hashCode(), new Tile(TileType.EMPTY));
        test.set(1, 1);
        tiles.put(test.hashCode(), new Tile(TileType.GROUND));
        test.set(1, 2);
        tiles.put(test.hashCode(), new Tile(TileType.WATER));
        
    }
    
    public void generateMap(String mapFile){
        
    }
    public Tile getTile(Tuple position){
        Tile test = tiles.get(position.hashCode());
        return test;
    }
}
