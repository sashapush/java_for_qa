package by.mmjava.sandbox;

public class Fuck {
	public static void main(String[]  args) {
		double l=78;
		double s=l*l;
	hello("Dick Grayson");
        hello("Chelik");
        hello("Emptyness");

		//System.out.println("something " + l + " other thing " + s);
        double azaza =5;
        System.out.println("Area of square with " +azaza+ " side"+ " is = "  + area(azaza) + " metrov");
        double a=4;
        double b=44;
        System.out.println("Area of pentagon= " + area(a,b)+" metrov");
    }
	public static void hello(String smb){

        System.out.println ("Hell MR "+ smb + "!");
    }
    public static double area (double len){
		    return len*len;

    }
    public static double area (double a,double b){
        return a*b;
    }
}
