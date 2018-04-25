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
    private int gridSize;
    public Tile[][] tiles;
    public Edge[][][] tileEdges;
    public Tile[][][] tileNeighbors;

    public MapWithArray(Tile[][] tiles){
        gridSize = tiles[0].length;
        this.tiles = tiles;
    }

    public Tile getTile(Tuple position){
        int x = (int) Math.floor(position.getX());
        int y = (int) Math.floor(position.getY());
        return this.tiles[x][y];
    }
    @Override
    public String toString(){ //ikke brugbar siden alle tiles fik 4 edges. skal FIXES
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
    public void stringRep(){ //printer samtlige tiles uden nogle edges
        for(Tile[] ta : tiles){
            for(Tile t : ta){
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }
}
