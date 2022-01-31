/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import java.util.Scanner;

/**
 *
 */
public class Control extends Thread {
    
    private final static int NTHREADS = 3;
    private final static int MAXVALUE = 30000000;
    public final static int TMILISECONDS = 5000;
    private final int NDATA = MAXVALUE / NTHREADS;
    public static long tInicio = System.currentTimeMillis();

    private PrimeFinderThread pft[];
    
    private Control() {
        super();
        this.pft = new  PrimeFinderThread[NTHREADS];

        int i;
        for(i = 0;i < NTHREADS - 1; i++) {
            PrimeFinderThread elem = new PrimeFinderThread(i*NDATA, (i+1)*NDATA, pft);
            pft[i] = elem;
        }
        pft[i] = new PrimeFinderThread(i*NDATA, MAXVALUE + 1, pft);
    }
    
    public static Control newControl() {
        return new Control();
    }

    @Override
    public void run() {
        for(int i = 0;i < NTHREADS;i++ ) {
            pft[i].start();
        }
        while (true) {
             Scanner input = new Scanner(System.in);
             String validar = input.nextLine();
             synchronized (pft){
                 if (validar.isEmpty()) {
                     pft.notifyAll();
                     Main.tInicio = System.currentTimeMillis();
                 }
             }
        }
    }

}
