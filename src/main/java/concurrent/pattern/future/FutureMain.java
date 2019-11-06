package concurrent.pattern.future;

/**
 * 模拟future模式
 * @Author lx
 * @Date 2019/2/23 20:35
 */
public class FutureMain {
    public static void main(String[] args) throws InterruptedException {
        FutureClient client = new FutureClient();
        FutureData futureData = client.commitTask("任务1");
        System.out.println("main-执行其他业务逻辑");
        for (int i = 0; i < 20; i++) {
            System.out.print(i + " ");
            Thread.sleep(500);
        }
        String result = futureData.getResult();
        System.out.println("main-获得返回结果：" + result);
    }
}
