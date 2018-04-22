/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

/**
 *
 * @author Jens
 */
public class Edge {
    private boolean wall;
    public Edge(boolean b){
        wall = b;
    }
    
    public void setWall(boolean b){
        wall = b;
    }
    public boolean isWall(){
        return wall;
    }
}
