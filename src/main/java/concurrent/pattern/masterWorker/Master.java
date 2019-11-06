package concurrent.pattern.masterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author lx
 * @Date 2019/2/23 23:29
 */
public class Master {
    // 保存所有任务
    private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();
    // 保存worker线程引用
    private Map<String, Thread> workerMap = new HashMap<>();
    // 保存所有worker执行结果
    private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();

    public Master(Worker worker, int workerNum) {
        worker.setTaskQueue(this.taskQueue);
        worker.setResultMap(this.resultMap);

        for (int i = 0; i < workerNum; i++) {
            workerMap.put("xc" + i, new Thread(worker));
        }
    }

    /**
     * 提交任务
     *
     * @param task
     */
    public void submit(Task task) {
        taskQueue.offer(task);
    }

    /**
     * 执行任务
     */
    public void execute() {
        for (Map.Entry<String, Thread> entry : workerMap.entrySet()) {
            entry.getValue().start();
        }
    }

    /**
     * 所有线程是否执行完毕
     *
     * @return
     */
    public boolean isComplete() {
        for (Map.Entry<String, Thread> entry : workerMap.entrySet()) {
            if (!entry.getValue().getState().equals(Thread.State.TERMINATED)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 汇总所有执行结果
     *
     * @return
     */
    public Object getResult() {
        int n = 0;
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            n += (int) entry.getValue();
        }
        return n;
    }
}
