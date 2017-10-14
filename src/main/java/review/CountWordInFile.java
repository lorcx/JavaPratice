package review;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 统计一个字符串在一个文件中出现的位置
 * Created by lx on 2017/10/13.
 */
public class CountWordInFile {
    /**
     * 该类是静态类所以不允许new创建
     */
    private CountWordInFile() {
    }

    /**
     * 统计数量
     * @param source
     * @param word
     * @return
     */
    public static int satanistWord(String source, String word) {
        int count = 0;
        try (FileReader fr = new FileReader(source)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
//                Pattern p = Pattern.compile("/"++"/g");
                while ((line = br.readLine()) != null) {
                    int index;
                    while (line.length() >= word.length() && (index = line.indexOf(word)) != -1) {
                        count++;
                        line = line.substring(index + word.length());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(satanistWord("f:\\pwd.md", "银行"));
    }
}
