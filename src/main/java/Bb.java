import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Bb {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("H:\\support\\1.log"));
        for (String line : lines) {

            String[] lineArr = line.split("=");
            if (lineArr.length != 2) {
                continue;
            }

            String key = lineArr[0];
            String json = lineArr[1];
            String mchntId = key.replace("quick_pay_api_merchant_", "");
            JSONObject jsonObject = JSON.parseObject(json);
            String orgPath = jsonObject.getString("orgPath");
            if (StringUtils.isBlank(orgPath)) {
                continue;
            }

            String lv3OrgId = orgPath.substring(6, 12);

            System.out.println("mchntId:" + mchntId + "   orgId=" + lv3OrgId);
        }
    }
}
