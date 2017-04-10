package by.mmjava.sandbox;

import com.sun.org.apache.regexp.internal.RE;

public class Fuck {
	public static void main(String[]  args) {
		hello("Dick Grayson");
        hello("Chelik");
        hello("Emptyness");
Square var =new Square(5);

        double azaza =5;
        System.out.println("Area of square with " +var.l+ " side"+ " is = "  + area(var) + " metrov");
        Rectangle rekted = new Rectangle(4,44);
        System.out.println("Area of pentagon with sides " + rekted.a +" and " + rekted.b +  " = " + area(rekted)+" metrov");
    }
	public static void hello(String smb){

        //System.out.println ("Hell MR "+ smb + "!");
    }
    public static double area (Square var){
		    return var.l*var.l;

    }
    public static double area (Rectangle rekted){
        return rekted.a*rekted.b;
    }

}
