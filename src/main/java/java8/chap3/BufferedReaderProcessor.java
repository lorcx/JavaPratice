package java8.chap3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by lx on 2016/12/4.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    public String process(BufferedReader b) throws IOException;
}
