package com.codercracker.codecracker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class BruteForceAttack {

    public static int pin = 9878789;

    public static String getTimeTaken() {
        return timeTaken;
    }

    public static String timeTaken = "";

    public static void main(String[] args) {
        // Enter 5-digit testPin here
         //pin = 123452;

        // Perform brute force attack
        //bruteForce(pin);
    }


    public BruteForceAttack(int pin){
        this.pin = pin;
        bruteForce(this.pin);
    }

    private static void bruteForce(int pin) {
        final int NUM_THREADS = 4;
        final int NUM_DIGITS = String.valueOf(pin).length();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        int pinRange = (int) Math.pow(10, NUM_DIGITS) / NUM_THREADS;

        // Start the timer
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_THREADS; i++) {
            final int start = i * pinRange;
            final int end = (i + 1) * pinRange;

            executor.submit(() -> {
                for (int currentPin = start; currentPin < end; currentPin++) {
                    if (currentPin == pin) {
                        long endTime = System.currentTimeMillis();
                        long duration = endTime - startTime;
                        double durationInSeconds = duration / 1000.0;
                        System.out.println("PIN found: " + currentPin);
                        System.out.println("Time taken: " + durationInSeconds + " seconds");
                        timeTaken = durationInSeconds + " seconds";
                        executor.shutdownNow();
                        return;
                    }
                }
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("PIN not found within the given time limit.");
            }
        } catch (InterruptedException e) {
            System.out.println("PIN cracking interrupted.");
        }
    }



}
