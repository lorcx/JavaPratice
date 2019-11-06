package concurrent.pattern.future;

/**
 * @Author lx
 * @Date 2019/2/23 20:37
 */
public class RealData implements Data {
    private String resStr;

    public RealData(String reqStr) {
        // 执行自己的业务逻辑
        System.out.println("参数：" + reqStr + "realData处理中");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("realdata处理完毕");
        resStr = "realData结果";
    }

    @Override
    public String getResult() {
        return resStr;
    }
}
