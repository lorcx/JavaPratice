package concurrent.pattern.masterWorker;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 处理任务
 * @Author lx
 * @Date 2019/2/23 23:29
 */
public class Worker implements Runnable {
    private ConcurrentLinkedQueue<Task> taskQueue;
    private ConcurrentHashMap<String, Object> resultMap;

    @Override
    public void run() {
        while (true) {
            Task task = taskQueue.poll();
            if (task == null) {
                break;
            }

            Object resObj = handle();
            System.out.println(Thread.currentThread().getId() + " 处理完毕 返回结果" + resObj);
            resultMap.put(Integer.toString(task.getId()), resObj);
        }
    }

    /**
     * 业务逻辑处理
     * @return
     */
    private Object handle() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        return rand.nextInt(1000);
    }

    public void setTaskQueue(ConcurrentLinkedQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
