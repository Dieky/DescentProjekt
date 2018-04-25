/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens
 */
public class MapGenerator {
    String mapTxt;
    String[] tileStrings;
    String[] edgeStrings;
    Tile[][] mapTiles;
    public MapGenerator(){
        readMapTxt("mapfiles/test.txt");
        System.out.println("map tile layout hentet af MapGenerator: ");
        for(String s : tileStrings){
            System.out.println(s);            
        }
        System.out.println("tile edge layout hentet af MapGenerator: ");
        for(String s : edgeStrings){
            System.out.println(s);            
        }
        mapTiles = tileStringsToTiles(tileStrings, edgeStrings);
        setNeighbors();

    }
    
    private void readMapTxt(String filepath){
        try {
            BufferedReader bufRead;
            int mapSize;
            bufRead = new BufferedReader(new FileReader(filepath));
            mapSize = (int) bufRead.readLine().charAt(11) - 48; //læser character på første linje i mapfilen. lige nu læser den kun én character. skal udviddes til at læse substring fra plads 11 istedetfor
            tileStrings = new String[mapSize]; //holder på strings der har med maptiles at gøre
            edgeStrings = new String[mapSize]; //holder på strings der har med edges til maptiles at gøre
            for(int i = 0; i < mapSize; i++){
                tileStrings[i] = clearWhitespace(bufRead.readLine());
            }
            for(int i = 0; i < mapSize; i++){
                edgeStrings[i] = clearWhitespace(bufRead.readLine());
            }
            bufRead.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MapGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MapGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Tile[][] tileStringsToTiles(String[] tiles, String[] edges){
        Tile[][] tilesToBeMade;
        tilesToBeMade = new Tile[tileStrings.length][tileStrings[0].length()];
        for(int i = 0; i < tileStrings.length; i++){
            for(int j = 0; j < tileStrings[i].length(); j++){
                char tileChar = tiles[i].charAt(j);
                char edgeChar = edges[i].charAt(j);
                TileType tileType = charToTile(tileChar);
                Edge[] tileEdges = charToEdge(edgeChar);
                tilesToBeMade[i][j] = new Tile(i, j, 20, 20, tileType);
                tilesToBeMade[i][j].edges = tileEdges;
            }
        }
        return tilesToBeMade;
    }
    
    private TileType charToTile(char c){ //cases skal nok ændres til at repræsentere det endelige tileset.
        switch(c){
            case 'G':
                return TileType.GROUND;
            case 'P':
                return TileType.POISON;
            case 'F':
                return TileType.FIRE;
            case 'W':
                return TileType.WATER;
            default:
                return TileType.EMPTY;
        }
    }
    
    private Edge[] charToEdge(char c){ //skal udviddes til at understøtte samtlige edge konfigurationer.
        switch(c){
            case ('e'):
                return new Edge[]{
                    new Edge(),
                    new Edge(),
                    new Edge(),
                    new Edge()};          
            default:
                return new Edge[]{
                    new Edge(true),
                    new Edge(true),
                    new Edge(true),
                    new Edge(true)};

        }
    }
    
    private void setNeighbors(){ //finder naboer til samtlige tiles i mapTiles ved at tjekke deres edges.
        Tile neighborTile;
        for(int i = 0; i < mapTiles.length; i++){
            for(int j = 0; j < mapTiles[i].length; j++){
                if(!mapTiles[i][j].edges[0].isWall()){ //tjekker nord
                    neighborTile = mapTiles[i-1][j];
                    if(!neighborTile.edges[2].isWall()){ //tjekker omvendt retning (syd) på nabotile
                        mapTiles[i][j].neighbors[0] = mapTiles[i-1][j];
                    }
                }
                if(!mapTiles[i][j].edges[1].isWall()){ //tjekker øst
                    neighborTile = mapTiles[i][j+1];
                    if(!neighborTile.edges[3].isWall()){ //tjekker omvendt retning (vest) på nabotile
                        mapTiles[i][j].neighbors[1] = mapTiles[i][j+1];
                    }
                }
                if(!mapTiles[i][j].edges[2].isWall()){ //you get the point
                    neighborTile = mapTiles[i+1][j];
                    if(!neighborTile.edges[0].isWall()){ //...
                        mapTiles[i][j].neighbors[2] = mapTiles[i+1][j];
                    }
                }
                if(!mapTiles[i][j].edges[3].isWall()){
                    neighborTile = mapTiles[i][j-1];
                    if(!neighborTile.edges[1].isWall()){
                        mapTiles[i][j].neighbors[3] = mapTiles[i][j-1];
                    }
                }
            }
        }
    }
    
    private String clearWhitespace(String s){ //fjerne whitespace characters fra en given string. burde nok lægges i Util packagen
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ' '){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public MapWithArray getMap(){ //giver et bygget map tilbage.
        MapWithArray newMap = new MapWithArray(mapTiles);
        return newMap;
    }
}
