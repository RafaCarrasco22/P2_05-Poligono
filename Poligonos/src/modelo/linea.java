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
public class linea {
    private punto a;
    private punto b;

    public linea(punto a, punto b) {
        this.a = a;
        this.b = b;
    }

    public linea(Integer x1, Integer y1,Integer x2, Integer y2){
        a = new punto(x1,y1);
        b = new punto(x2,y2);
    }
    public String toString(){
        return String.format("%s : %s",a.toString(),b.toString());
    }
    public Orientacion orientacion(punto p){
        //considerando el origen al putno a, el segemeto ab y ap
        //
        //angulo de a,b,p
        //det   | xb    xp|
        //      | yb    yp|
        Integer resultado = (b.getX()-a.getX()) * (p.getY()-a.getY()) -
                (p.getX()-a.getX()) * (b.getY()-a.getY());
        if(resultado ==0){
            return Orientacion.COLINEAL;
        }else if(resultado>0){
            return Orientacion.CLOCKWISE;
        }else {
            return Orientacion.COUNTERCLOCKWISE;
        }
        
    }
    
    public punto getA() {
        return a;
    }

    public void setA(punto a) {
        this.a = a;
    }

    public punto getB() {
        return b;
    }

    public void setB(punto b) {
        this.b = b;
    }
    
    
    public boolean Interseccion(linea l){
        //p1(x,y)-p2(x,y)    p3(x,y)-p4(x,y)  1. (p3,p4,p1) 2.(p3,p4,p2) 3.(p1, p2, p3) 4. (p1, p2, p4)
        int d1 = direction(l.getA(), l.getB(), this.getA());
        int d2 = direction(l.getA(), l.getB(), this.getB());
        int d3 = direction(this.getA(), this.getB(), l.getA());
        int d4 = direction(this.getA(), this.getB(), l.getB());
        
        
        if((d1>0 && d2<0)||(d1<0 && d2>0) && (d3>0 && d4<0) || (d3<0 && d4>0)){
            return true;
        }else if ((d1==0)&&(segment(l.getA(), l.getB(), this.getA()))) {
            return true;
        }else if ((d2==0)&&(segment(l.getA(), l.getB(), this.getB()))) {
            return true;
        }else if ((d3==0)&&(segment(this.getA(), this.getB(), l.getA()))) {
            return true;
        }else return (d4==0)&&(segment(this.getA(), this.getB(), l.getB()));
        
    }
    public int direction(punto p0, punto p2, punto p1){
        //(p1-p0) x (p2-p0) = (x1-x0)(y2-y0)-(x2-x0)(y1-y0)
        //(pk-pi)x(pj-pi)
        return (((p1.getX()-p0.getX())*(p2.getY()-p0.getY()))-((p2.getX()-p0.getX())*(p1.getY()-p0.getY())));
    }
    public boolean segment(punto pi, punto pj, punto pk){
        int ax = min(pi.getX(), pj.getX());
        int bx = max(pi.getX(), pj.getX());
        int c = min(pi.getY(), pj.getY());
        int d = max(pi.getY(), pj.getY());
        return ((ax <= pk.getX()) && (pk.getX()<= bx ))&& ((c <= pk.getY())&& (pk.getY()<= d));
        //1<2<3 if(1<2)&&(2<3)
    }
    public int min(Integer a, Integer b){
        if(a<=b){
            return a;
        }else{
            return b;
        }
    }
     public int max(Integer c, Integer d){
        if(c>=d){
            return c;
        }else{
            return d;
        }
    }
    
}
