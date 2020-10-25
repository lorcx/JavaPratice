package guava;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class PreconditionsTest {
    public static void main(String[] args) {
        int i = 0;
        //checkArgument(i > 0, "error msg");

        Object obj = null;
        checkNotNull(obj, "obj is null");


    }
}
