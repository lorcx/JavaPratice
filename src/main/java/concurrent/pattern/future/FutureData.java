package concurrent.pattern.future;

/**
 * 代理执行
 *
 * @Author lx
 * @Date 2019/2/23 20:36
 */
public class FutureData implements Data {

    private RealData realData;
    private boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }

        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    /**
     * 阻塞等待结果处理完成
     *
     * @return
     */
    @Override
    public synchronized String getResult() {
        try {
            while (!isReady) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return realData.getResult();
    }
}
