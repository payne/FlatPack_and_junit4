package demo;


import java.io.*;

import net.sf.flatpack.DataSet;
import net.sf.flatpack.brparse.BuffReaderFixedParser;
import net.sf.flatpack.brparse.BuffReaderParseFactory;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.List;

public class Hello {
    public static void main(String[] args) {
        try {
            System.out.println("Hello");
            int i=0;
            for (String arg: args) {
                System.out.println("\targs["+i+"]="+arg);
                i++;
            }
            Hello hello = new Hello();
            hello.fixedWidthExample();
            hello.run();
        } catch (Exception bland) {
            bland.printStackTrace();
        }
    }

    private void fixedWidthExample() throws Exception {
        String mapping = "PEOPLE-FixedLength.pzmap.xml";
        String data = "PEOPLE-FixedLength.txt";
        String baseDir = "src/main/resources/";
        String[] colNames = null;
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(baseDir+mapping));
        BuffReaderFixedParser pzparse = (BuffReaderFixedParser) BuffReaderParseFactory.getInstance()
                .newFixedLengthParser(lineNumberReader, new FileReader(baseDir + data));

            final DataSet ds = pzparse.parse();
            colNames = ds.getColumns();

            while (ds.next()) {
                for (final String colName : colNames) {
                    System.out.println("COLUMN NAME: " + colName + " VALUE: " + ds.getString(colName));
                }

                System.out.println("===========================================================================");
            }
    }

    private void run() {
        JUnitCore junit = new JUnitCore();
        Class<?> testClasses=HelloTests.class;
        Result result = junit.run(testClasses);
        List<Failure> failures = result.getFailures();
        for (Failure failure: failures) {
            System.out.println(failure.getMessage());
            System.out.println(failure.getTrace());
            System.out.println("\n\n*************\n\n");
        }
        if (result.wasSuccessful()) {
            // In the great UNIX tradition, a 0 exit code means things went great.
            // Windows also follows this tradition
            System.exit(0);
        } else {
            System.exit(1);
        }
    }
}
