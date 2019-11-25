package jksj.part06;

/**
 * @Author: lx
 * @Date: Created in 2019/11/25 0025
 */
public class SNode<T> {
    private T data;
    private SNode<T> next;

    public SNode() {
        this.next = null;
        this.data = null;
    }

    public SNode(T data, SNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SNode<T> getNext() {
        return next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }
}
