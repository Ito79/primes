package com.catz.primes;

import com.catz.util.PrimesUtils;
import com.catz.util.TimeUtils;

import java.io.*;
import java.util.ArrayList;

public class Primes {
    private static final String INCREMENT_PROPERTY_NAME = "increment";
    private static final String DATAFILE_PROPERTY_NAME = "data";
    private static final Long START_NUMBER = (long) 2;

    private static final String DEFAULT_FILE_PATH = "primes.dat";
    private static final int DEFAULT_INCREMENT = 50000;

    public static void main(String[] args) {
        int increment;
        String dataFile;
        PrintWriter pw = null;

        try {
            increment = Integer.parseInt(System.getProperty(INCREMENT_PROPERTY_NAME));
            if (increment<1) increment = DEFAULT_INCREMENT;
        } catch(NumberFormatException nfe) {
            increment = DEFAULT_INCREMENT;
        }

        try {
            dataFile = System.getProperty(DATAFILE_PROPERTY_NAME);
            if (dataFile==null || "".equals(dataFile)) dataFile = DEFAULT_FILE_PATH;
        } catch(Exception e) {
            dataFile = DEFAULT_FILE_PATH;
        }

        try {
           long tiempoInicial = TimeUtils.getTime();
           ArrayList primeNumbers;
           String last ="";
           try {
               BufferedReader input = new BufferedReader(new FileReader(dataFile));
               String line;
               while ((line = input.readLine()) != null) { last = line; }
               input.close();
           } catch(FileNotFoundException fnf)  {
               System.out.println("File not found, a new one will be created: "+new File(dataFile).getAbsolutePath());
           }
           pw = new PrintWriter(new FileWriter(dataFile, true));

           if ("".equals(last)) {
               pw.println("### SEARCHING FOR PRIME NUMBERS ###");
               pw.println("### AUTHOR: Carlos Palacios (@Ito_pr) ###");
               pw.println("");
               pw.println("### Following numbers are primes: ");
           }
           Long startNumber = "".equals(last)?START_NUMBER:Long.valueOf(last)+1;
           Long endNumber = startNumber+increment;
           primeNumbers = PrimesUtils.getPrimes(startNumber, endNumber);
           for (Object primeNumber : primeNumbers) {
               Long numero = (Long) primeNumber;
               pw.println(numero);
               pw.flush();
           }

           pw.close();
           long tiempoFinal = TimeUtils.getTime();
           System.out.println(primeNumbers.size()+" new prime numbers appended!");
           TimeUtils.showElapsedTime(tiempoInicial, tiempoFinal);
        } catch (Exception ioe) {
           ioe.printStackTrace();
        } finally {
           if (pw!=null) {
               pw.flush();
               pw.close();
           }
       }
    }

}
