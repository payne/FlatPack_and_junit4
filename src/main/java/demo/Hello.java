package demo;


import java.io.*;

import net.sf.flatpack.DataSet;
import net.sf.flatpack.brparse.BuffReaderFixedParser;
import net.sf.flatpack.brparse.BuffReaderParseFactory;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hello {
    public static final String LINE_NUMBER = "LINE_NUMBER";

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
        LineNumberReader lineNumberReaderMapping = new LineNumberReader(new FileReader(baseDir+mapping));
        LineNumberReader lineNumberReaderData = new LineNumberReader( new FileReader(baseDir + data));
        BuffReaderFixedParser pzparse = (BuffReaderFixedParser) BuffReaderParseFactory.getInstance()
                .newFixedLengthParser(lineNumberReaderMapping, lineNumberReaderData);

            final DataSet ds = pzparse.parse();
            colNames = ds.getColumns();

        List<Map<String, String>> lines = Singleton.getSingleton().getLines();

            while (ds.next()) {
                Map<String, String> line = new HashMap<>();
                line.put(LINE_NUMBER, lineNumberReaderData.getLineNumber()+"");
                for (final String colName : colNames) {
                    String colValue = ds.getString(colName);
                    line.put(colName, colValue);
                    System.out.println("COLUMN NAME: " + colName + " VALUE: " + colValue);
                }
                lines.add(line);
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
            System.out.println(failure.getTrace()); // TODO(DAVE): Have an option to not print the trace
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
