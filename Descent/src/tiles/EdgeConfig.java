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
public enum EdgeConfig {
    NORTH('0'), EAST('1'), SOUTH('2'), WEST('3'),
    
    NORTHEAST('4'),NORTHSOUTH('5'),NORTHWEST('6'),
    EASTSOUTH('7'),EASTWEST('8'),SOUTHWEST('9'),
    
    NORTHEASTSOUTH('a'),NORTHEASTWEST('b'),
    NORTHSOUTHWEST('c'),EASTSOUTHWEST('d'),
    
    NONE('e'),ALL('f')
    ;
    public final char val;
    EdgeConfig(char val){
        this.val = val;
    }
}
