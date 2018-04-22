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
public class MapWithArray {
    private int gridSize = 4;
    public Tile[][] tiles = new Tile[gridSize][gridSize];
    public Edge[][][] tileEdges = new Edge[gridSize][gridSize][2];
    public Tile[][][] tileNeighbors = new Tile [gridSize][gridSize][4];
    
    public MapWithArray(){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                tiles[i][j] = new Tile(i, j, 20, 20, getRandomType());
                tileEdges[i][j][0] = new Edge(false);
                tileEdges[i][j][1] = new Edge(false);
            }
        }
        for(int i = 0; i < gridSize; i++){
            tileEdges[0][i][1].setWall(true);
            tileEdges[1][i][1].setWall(true);
            tileEdges[2][i][1].setWall(true);
            tileEdges[3][i][1].setWall(true);
        }
    }

    private TileType getRandomType(){
        int ran = (int) Math.ceil(Math.random()*100);
        if(ran < 20){
            return TileType.EMPTY;
        }else if (ran < 40){
            return TileType.GROUND;
        }else if (ran < 60){
            return TileType.WATER;
        }else if (ran < 80){
            return TileType.FIRE;
        }else{
            return TileType.POISON;
        }
    }
    
    private void setNeighbors(){
        for(int i = 1; i < gridSize-1; i++){
            for(int j = 0; j < gridSize-1; j++){
                    tileNeighbors[i][j][0] = tiles[i-1][j];
                    tileNeighbors[i][j][1] = tiles[i][j+1];
                    tileNeighbors[i][j][2] = tiles[i+1][j];
                    tileNeighbors[i][j][3] = tiles[i][j-1];
                }

            }
        }
    public Tile getTile(Tuple position){
        int x = (int) Math.floor(position.getX());
        int y = (int) Math.floor(position.getY());
        return this.tiles[x][y];
    }
    @Override
    public String toString(){
        StringBuilder mapString = new StringBuilder();
        StringBuilder tileString = new StringBuilder();
        StringBuilder verticalEdgeString = new StringBuilder();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if(tileEdges[i][j][0].isWall()){
                    tileString.append("| ");
                }else{
                    tileString.append("  ");
                }
                if(tileEdges[i][j][1].isWall()){
                    verticalEdgeString.append("  _ ");
                }else{
                    verticalEdgeString.append("   ");
                }
                tileString.append(tiles[i][j].toString().substring(0, 1)).append(" ");
            }
            mapString.append(tileString.append("\n"));
            mapString.append(verticalEdgeString.append("\n"));
            verticalEdgeString = new StringBuilder();
            tileString = new StringBuilder();

        }
        return mapString.toString();
    }
}
