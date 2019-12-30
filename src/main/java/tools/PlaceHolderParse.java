package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: lx
 * @Date: Created in 2019/12/30 0030
 */
public class PlaceHolderParse {

    /**
     * 解析数据
     *
     * @param content    要解析的数据
     * @param beginToken 前缀
     * @param endToken   后缀
     * @return
     */
    public List<String> parse(String content, Character beginToken, Character endToken) {
        Objects.requireNonNull(beginToken);
        Objects.requireNonNull(endToken);
        List<String> resultList = new ArrayList<>();

        if (content == null) {
            return null;
        }

        char[] chars = content.toCharArray();
        int startOffset = 0;
        boolean isFindStart = false;

        for (int i = 0; i < chars.length; i++) {
            //前缀搜索
            if (Objects.equals(beginToken, chars[i]) && !isFindStart) {

                int nextOffset = i + 1;
                //判断当前字符是不是最后一个
                if (nextOffset < chars.length) {
                    //开始和结束之间为空
                    if (chars[nextOffset] == endToken) {
                        resultList.add("");
                        i++;
                    } else {
                        //找到了前缀位置
                        startOffset = nextOffset;
                        isFindStart = true;
                    }

                    continue;
                }

                return resultList;
            }

            //后缀搜索
            if (Objects.equals(endToken, chars[i])) {
                resultList.add(content.substring(startOffset, i));

                //重置
                startOffset = 0;
                isFindStart = false;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        //String s = "|aaa|";
        String s = "|aaa|,|bb,b|,||,|ddd|";

        //System.out.println(s.substring(7, 10));

        //String[] strings = StringUtils.splitByWholeSeparatorPreserveAllTokens(s, "|,|");
        //System.out.println(Arrays.toString(strings));
        //
        //String[] split = StringUtils.split(s, "|,|");
        //System.out.println(Arrays.toString(split));

        /*PlaceHolderParse holderParse = new PlaceHolderParse();
        System.out.println(holderParse.parse(s, '|', '|'));

        s = "|aaa|,|bbb|,|ddd|,||";
        System.out.println(holderParse.parse(s, '|', '|'));

        s = "||,|aaa|,|bbb|,|ddd|";
        System.out.println(holderParse.parse(s, '|', '|'));

        s = "|aaa|";
        System.out.println(holderParse.parse(s, '|', '|'));

        s = "||";
        System.out.println(holderParse.parse(s, '|', '|'));
        System.out.println(holderParse.parse(s, '|', '|').size());*/

        System.out.println("asdf${2231}1123".indexOf("${"));

    }
}
