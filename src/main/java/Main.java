import algorithms.MultiSolution;
import algorithms.SingleSolution;

public class Main {


    private final SingleSolution singleSolution = new SingleSolution();

    private static void runMultiThreadSolution(){
        long start = System.currentTimeMillis();
        MultiSolution.run();
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms pentru solutia MT");
    }

    private static void runSingleThreadSolution(){
        long start = System.currentTimeMillis();
        SingleSolution.run();
        long end = System.currentTimeMillis();
        System.out.println(end-start + " ms pentru solutia ST");
    }

    public static void main(String[] args) {
        runMultiThreadSolution();
        runSingleThreadSolution();
    }

}
