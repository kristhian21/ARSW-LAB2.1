package edu.eci.arsw.primefinder;

import java.util.Scanner;

public class prueba {
    public static void main(String[] args) throws InterruptedException {
        boolean bandera = true;
        while (bandera){
            System.out.println("xd");
            Scanner input = new Scanner(System.in);
            String texto = input.next();
            long tiempo = System.currentTimeMillis();
            if (texto.equals("x")){
                System.out.println(String.valueOf(tiempo));
            }
        }
    }
}
