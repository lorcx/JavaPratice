package java8.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lx on 2016/12/4.
 */
public class ExecuteAround {

    final static String PATH = System.getProperty("user.dir") + "\\src\\java8\\chap3\\";

    public static void main(String[] args) throws IOException {
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("-------------");
        String oneLine = processFile((BufferedReader b ) -> b.readLine());
        System.out.println(oneLine);

        String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
        System.out.println(twoLines);



    }

    private static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH + "\\data.txt"))) {
            return p.process(br);
        }
    }

    private static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH + "\\data.txt"))) {
            return br.readLine();
        }
    }
}
