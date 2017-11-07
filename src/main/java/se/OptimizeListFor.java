package se;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class OptimizeListFor {
    public static void main(String[] args) {
        List list = new ArrayList();
        if (list instanceof RandomAccess) {
            for (int i = 0; i < list.size(); i++) {

            }
        } else {
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                iter.next();
            }
        }

    }
}
