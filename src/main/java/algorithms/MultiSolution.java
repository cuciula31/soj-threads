package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiSolution {

    private volatile static int maxDivisorCount = 0;

    private volatile static int intWithMaxDivisorCount;

    synchronized private static void report(int maxCountFromThread, int intWithMaxFromThread) {
        if (maxCountFromThread > maxDivisorCount) {
            maxDivisorCount = maxCountFromThread;
            intWithMaxDivisorCount = intWithMaxFromThread;
        }
    }

    private static class CountDivisorsThread extends Thread {
        int min, max;

        public CountDivisorsThread(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public void run() {

            int maxDivisors = 0;
            int whichInt = 0;
            for (int i = min; i < max; i++) {
                int divisors = countDivisors(i);
                if (divisors > maxDivisors) {
                    maxDivisors = divisors;
                    whichInt = i;
                }
            }
            report(maxDivisors, whichInt);
        }
    }

    public static void run() {
        List<CountDivisorsThread> countDivisorsThreads = new ArrayList<>();

        int start = 1;
        int end = 1;
        for (int i = 0; i < 10; i++) {
            if (i == 10 - 1) {
                end = 100000;
            }
            countDivisorsThreads.add(new CountDivisorsThread(start, end));
            start = end + 1;
            end = 1;
        }
        maxDivisorCount = 0;
        for (CountDivisorsThread c : countDivisorsThreads)
            c.start();
        for (CountDivisorsThread c : countDivisorsThreads) {


            while (c.isAlive()) {
                try {
                    c.join();
                } catch (InterruptedException e) {
                }
            }
        }

        System.out.println("\nCei mai multi divizori " +
                "pentru un numar cuprins intre 1 si 100000 este " + maxDivisorCount + "\nNumarul care are acesti divizori este " + intWithMaxDivisorCount);

    }




    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }
        return count;
    }


}

