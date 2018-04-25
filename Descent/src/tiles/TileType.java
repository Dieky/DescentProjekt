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
public enum TileType {
    EMPTY('E'),
    GROUND('G'),
    WATER('W'),
    FIRE('F'),
    POISON('p'),
    PIT('P')
    ;
    private final char representativeChar;
    TileType(char c){
        representativeChar = c;
    }
}
