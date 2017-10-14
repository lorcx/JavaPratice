package review;

import java.io.File;

/**
 * 打印目录下的所有文件
 * Created by lx on 2017/10/13.
 */
public class DirectorAllFile2 {
    public static void showDirector(String director) {
        getAllFileName(new File(director), 0);
    }

    public static void getAllFileName(File file, int level) {
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            if (null != fileList && fileList.length > 0) {
                for (File f : fileList) {
                    getAllFileName(f, level + 1);
                }
            }
        } else {
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(file.getName());
        }
    }

    public static void main(String[] args) {
        showDirector("e:\\");
    }
}
