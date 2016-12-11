package main;

/**
 * Outer.this
 * @author Kzo
 *
 */
public class Outer {
class Inner {
public Outer getParent(){
return Outer.this;
}
}
public static void main(String...args){
Outer o = new Outer();
Inner i = o.new Inner();
System.out.println(o == i.getParent());
}
}
