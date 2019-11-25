package jksj.part06;

import org.hsqldb.TransactionManager2PL;
import se.d6.qiankelong.Address;

import java.security.cert.PKIXRevocationChecker;

/**
 * 头结点是个空结点
 *
 * @Author: lx
 * @Date: Created in 2019/11/25 0025
 */
public class LRUBaseList<T> {
    private SNode<T> head;
    private int count = 0;
    private int capacity;
    private int DEFAULT_CAPACITY = 10;

    public LRUBaseList() {
        head = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.count = 0;
    }

    public LRUBaseList(int capacity) {
        head = new SNode<>();
        this.capacity = capacity;
        this.count = 0;
    }

    public void add(T data) {
        SNode<T> preNode = findPreNode(data);
        if (preNode == null) {
            //已经是头结点 如果容量满了，删除尾结点
            if (count == capacity) {
                deleteLastNode();
            }
            insertToHead(data);
        } else {
            //删除原结点，并从新插入
            deleteOriginNode(preNode);
            insertToHead(data);
        }
    }

    private void deleteOriginNode(SNode<T> preNode) {
        SNode<T> next1 = preNode.getNext();
        preNode.setNext(next1.getNext());
        count--;
    }

    private void insertToHead(T data) {
        SNode<T> sNode = head.getNext();
        head.setNext(new SNode<>(data, sNode));
        count++;
    }

    private void deleteLastNode() {
        SNode<T> tmp = head;
        while (tmp.getNext().getNext() != null) {
            tmp = tmp.getNext();
        }

        tmp.setNext(null);
        count--;
    }

    /**
     * 查找前一结点
     *
     * @param data
     * @return
     */
    private SNode<T> findPreNode(T data) {
        if (head.getNext() == null) {
            return null;
        }

        SNode<T> tmp = head;
        while (tmp.getNext() != null) {
            if (data.equals(tmp.getNext().getData())) {
                return tmp;
            }
            tmp = tmp.getNext();
        }

        return null;
    }

    public void printAll() {
        if (head.getNext() == null) {
            return;
        }

        StringBuilder builder = new StringBuilder();
        SNode<T> tmp = head.getNext();
        while (tmp != null) {
            builder.append(tmp.getData()).append(" ");
            tmp = tmp.getNext();
        }

        System.out.println(builder);
    }

    public static void main(String[] args) {
        LRUBaseList<Integer> cache = new LRUBaseList<>();
        cache.add(1);
        cache.add(2);
        cache.add(3);
        cache.add(4);
        cache.add(5);
        System.out.println("------------------first----------------");
        cache.printAll();

        cache.add(6);
        cache.add(7);
        cache.add(8);
        cache.add(9);
        cache.add(10);
        System.out.println("------------------second----------------");
        cache.printAll();

        cache.add(11);
        cache.add(12);
        cache.add(13);
        System.out.println("------------------third----------------");
        cache.printAll();

        System.out.println("-------------------middle------------------");
        cache.add(9);
        cache.printAll();


        System.out.println("----------------------临界值验证--------------------");
        cache = new LRUBaseList<>();
        cache.add(1);
        cache.add(1);
        cache.printAll();

        cache.add(2);
        cache.add(1);
        cache.printAll();
    }
}
