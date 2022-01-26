package edu.eci.arsw.primefinder;

public class Main {

    public static long tInicio;

    public static void main(String[] args) {
        Control control = Control.newControl();
        
        control.start();
        Main.tInicio = System.currentTimeMillis();
    }
	
}
