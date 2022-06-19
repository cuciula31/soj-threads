package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SingleSolution {

    private static int maxDivisorCount = 0;
    private static int intWithMaxDivisorCount;

     private static void report(int maxCountFromThread, int intWithMaxFromThread) {
        if (maxCountFromThread > maxDivisorCount) {
            maxDivisorCount = maxCountFromThread;
            intWithMaxDivisorCount = intWithMaxFromThread;
        }
    }

    public static int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }
        return count;
    }
    private static void findDivisors() {
        int maxDivisors = 0;
        int whichInt = 0;
        for (int i = 0; i < 100000; i++) {
            int divisors = countDivisors(i);
            if (divisors > maxDivisors) {
                maxDivisors = divisors;
                whichInt = i;
            }
        }
        report(maxDivisors, whichInt);
    }

    public static void run(){
        findDivisors();
        System.out.println("\nCei mai multi divizori " +
                "pentru un numar cuprins intre 1 si 100000 este " + maxDivisorCount + "\nNumarul care are acesti divizori este " + intWithMaxDivisorCount);
    }





}
