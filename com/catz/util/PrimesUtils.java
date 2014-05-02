/**
 * Class with util functions about prime numbers
 * Author: Carlos Palacios (@Ito_pr)
 */
package com.catz.util;

import java.util.ArrayList;

public class PrimesUtils {
    public static boolean isPrime(long number){
        if (number<=1) return false;
        int counter = 2;
        while (counter!=number){
            if (counter<=2 ||(counter>2 && counter%2!=0)) { // We don't check even numbers, they are for sure not prime
                if (number % counter == 0) return false;
            }
            counter++;
        }
        return true;
    }

    public static ArrayList getPrimes(long startValue, long endValue) {
        ArrayList<Long> result = new ArrayList<Long>();
        for (long i=startValue;i<=endValue;i++) {
            if (isPrime(i)) result.add(i);
        }
        return result;
    }

    public static ArrayList getPrimesUnder(long endValue) {
        return getPrimes(2, endValue);
    }

    public static ArrayList getPrimeFactors(long number) {
        ArrayList<Long> result = new ArrayList<Long>();
        long auxNumber = number;
        for(long i=2;i<number;i++){
            while(auxNumber%i==0){
                auxNumber=auxNumber/i;
                result.add(i);
            }
        }
        return result;
    }

    public static int getNumberOfPrimesBetween(long startValue, long endValue) {
        return getPrimes(startValue, endValue).size();
    }
}
