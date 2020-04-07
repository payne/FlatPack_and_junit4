package demo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Hello {
    public static void main(String[] args) {
        try {
            System.out.println("Hello");
            Hello hello = new Hello();
            hello.run();
        } catch (Exception bland) {
            bland.printStackTrace();
        }
    }

    private void run() {
        JUnitCore junit = new JUnitCore();
        Class<?> testClasses=HelloTests.class;
        Result result = junit.run(testClasses);
    }
}
