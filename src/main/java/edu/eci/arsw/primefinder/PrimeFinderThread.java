package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	
	int a,b;
	
	private List<Integer> primes;
    private PrimeFinderThread pft[];
	
	public PrimeFinderThread(int a, int b, PrimeFinderThread pft[]) {
		super();
		this.primes = new LinkedList<>();
		this.a = a;
		this.b = b;
		this.pft = pft;
	}

        @Override
	public void run(){
	    synchronized (pft){
            for (int i= a;i < b;i++){
                long tFinal = System.currentTimeMillis();
                int tiempo = (int)(tFinal - Main.tInicio);
                if (tiempo < Control.TMILISECONDS + 50 && tiempo > Control.TMILISECONDS - 50){
                    try {
                        pft.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                }
                else{
                    if (isPrime(i)){
                        primes.add(i);
                        System.out.println(i);
                    }
                }
            }

        }
	}
	
	boolean isPrime(int n) {
	    boolean ans;
            if (n > 2) { 
                ans = n%2 != 0;
                for(int i = 3;ans && i*i <= n; i+=2 ) {
                    ans = n % i != 0;
                }
            } else {
                ans = n == 2;
            }
	    return ans;
	}

	public List<Integer> getPrimes() {
		return primes;
	}
	
}
