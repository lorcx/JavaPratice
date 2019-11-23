package jksj.part06;

/**
 * 单链表插入、查询、删除
 *
 * @Author: lx
 * @Date: Created in 2019/11/19 0019
 */
public class SinglyLinkedList {
    private Node head = null;

    public Node findByValue(int value) {
        if (head == null) {
            return null;
        }

        Node p = head;
        while (p.value != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        if (head == null) {
            return null;
        }

        Node p = head;
        int pos = 0;
        while (pos != index && p != null) {
            p = p.next;
            pos++;
        }
        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        if (null == head) {
            head = newNode;
        } else {
            insertToHead(newNode);
        }
    }

    public void insertToHead(Node newNode) {
        newNode.next = head;
        head = newNode;
    }

    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        if (null == head) {
            this.head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }

            p.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        if (null == head) {
            System.out.println("缺失数据");
            return;
        }

        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        if (null == head) {
            System.out.println("缺失数据");
            return;
        }

        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        Node q = head;
        while (q.next != null && q.next != p) {
            q = q.next;
        }

        if (q.next == null) {
            return;
        }

        newNode.next = q.next;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {

    }

    public void deleteByValue(int value) {

    }

    public void printAll() {
        StringBuilder builder = new StringBuilder();
        Node p = head;
        while (p != null) {
            builder.append(p.value).append(" ");
            p = p.next;
        }
        System.out.println(builder);
    }

    public boolean TFResult(Node left, Node right) {
        return false;
    }

    //判断是否回文
    public boolean palindrome() {
        return false;
    }

    /**
     * 带节点的反转列表
     *
     * @param p
     * @return
     */
    public Node inverseLinkList_head(Node p) {
        return null;
    }

    /**
     * 无节点的链表翻转
     *
     * @param p
     * @return
     */
    public Node inverseLinkList(Node p) {
        return null;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertToHead(1);
        list.insertToHead(2);
        list.insertToHead(3);
        list.printAll();

        list.insertTail(4);
        list.printAll();
        list.insertTail(5);
        list.printAll();

        Node nodex = list.findByIndex(0);
        assert nodex.value == 3;

        nodex = list.findByIndex(1);
        assert nodex.value == 2;

        nodex = list.findByIndex(4);
        assert nodex.value == 5;

        nodex = list.findByIndex(5);
        assert nodex == null;

        nodex = list.findByValue(5);
        System.out.println(nodex.value);


    }

}
