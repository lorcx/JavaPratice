package concurrent.threadlocal;

public class TestNum {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        /**
         * 设置初始值
         * 延迟调用
         * @return
         */
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    /**
     * 设置下一个序列
      * @return
     */
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    private static class TestClient extends Thread {
        private TestNum tn;

        public TestClient(TestNum tn) {
            this.tn = tn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "-"+ tn.getNextNum());
            }
        }
    }

    public static void main(String[] args) {
        TestNum tn = new TestNum();
        TestClient tc1 = new TestClient(tn);
        TestClient tc2 = new TestClient(tn);
        TestClient tc3 = new TestClient(tn);
        tc1.start();
        tc2.start();
        tc3.start();
    }
}
