package guava;

import com.google.common.base.Splitter;
import design_model.bridge.Source;

import java.util.List;
import java.util.Map;

public class SplitterListTest {
    public static void main(String[] args) {
        String test = "344333,34,34,ahhd ,";
        List<String> lists = Splitter.on(",").splitToList(test);
        System.out.println(lists+ " size=" + lists.size());

        lists = Splitter.on(",").trimResults().splitToList(test);
        System.out.println(lists+ " size=" + lists.size());

        lists = Splitter.on(",").omitEmptyStrings().splitToList(test);
        System.out.println(lists + " size=" + lists.size());

        test = "343443434哈哈";

        lists = Splitter.fixedLength(3).splitToList(test);
        System.out.println(lists);

        test = "aa.dd,,ff,,.";
        lists = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(test);
        System.out.println(lists);
    }
}
