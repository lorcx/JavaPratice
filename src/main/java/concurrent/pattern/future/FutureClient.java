package concurrent.pattern.future;

/**
 * @Author lx
 * @Date 2019/2/23 20:37
 */
public class FutureClient {

    /**
     * 提交任务
     * @param reqStr
     * @return
     */
    public FutureData commitTask(final String reqStr) {
        final FutureData fData = new FutureData();

        new Thread(() -> {
            RealData realData = new RealData(reqStr);
            fData.setRealData(realData);
        }).start();

        return fData;
    }
}
