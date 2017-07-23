package util;

import javax.lang.model.SourceVersion;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * Created by lx on 2016/11/13.
 */
public class Compiler {
    public static void main(String[] args) {

        final JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        for (final SourceVersion version : jc.getSourceVersions()) {
            //显示当前编译器支持的版本
            System.out.println(version);
        }
    }
}
