/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author cavr0
 */
public class punto {
    private Integer x;
    private Integer y;
    
    public punto(Integer x, Integer y){
        this.x = x;
        this.y=y;
    }

    public String toString(){
        return String.format("(%d,%d)",x,y);
    }
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
    
}
