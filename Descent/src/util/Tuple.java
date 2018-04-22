/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Jens
 * @param <Integer>
 */
public class Tuple<Integer> {
    private int t1,t2;
    public Tuple (int x, int y){
		t1 = x;
		t2 = y;
    }

    public void set(int t1, int t2){
            this.t1 = t1;
            this.t2 = t2;
    }
    
    public void add(int t1, int t2){
        this.t1 += t1;
        this.t2 += t2;
    }

    public int getX(){
            return t1;
    }

    public int getY(){
            return t2;
    }
    
    @Override
    public int hashCode(){
        String toBeHashed = this.t1 + ", " + this.t2;
        return toBeHashed.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tuple<?> other = (Tuple<?>) obj;
        if (this.t1 != other.t1) {
            return false;
        }
        if (this.t2 != other.t2) {
            return false;
        }
        return true;
    }
    @Override
    public String toString(){
        return this.t1 + ", " + this.t2;
    }
}
