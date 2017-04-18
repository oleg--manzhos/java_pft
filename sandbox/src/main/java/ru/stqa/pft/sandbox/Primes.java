package ru.stqa.pft.sandbox;

/**
 * Created by omanzhos on 4/14/2017.
 */
public class Primes {

    public static boolean isPrime(int n){

        for (int i=2; i<n; i++){
            System.out.println(n % i);
            if (n % i == 0){
                System.out.println(n);
                return false;
            }
        }
        return true;
    }

}
