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
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q != null) {
            q.next = q.next.next;
        }

    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;
        while (p != null && p.value != value) {
            q = p;
            p = p.next;
        }

        //没有找到
        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;//删除头节点
        } else {
            q.next = q.next.next;//删除非头节点
        }
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
        Node l = left;
        Node r = right;

        boolean flag = true;
        while (l != null && r != null) {
            if (l.value != r.value) {
                flag = false;
                break;
            }

            l = l.next;
            r = r.next;
        }

        return flag;
    }

    //判断是否回文
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            Node leftLink = null;
            Node rightLink = null;

            Node p = head;
            Node q = head;

            if (p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }

            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }

            if (q.next == null) {//奇数节点
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
            } else {//偶数节点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return TFResult(leftLink, rightLink);
        }
    }

    /**
     * 带节点的反转列表
     *
     * @param p
     * @return
     */
    public Node inverseLinkList_head(Node p) {
        if (p == null) {
            return null;
        }

        Node head = new Node(999, null);
        head.next = p;
        Node cur = p.next;
        p.next = null;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }

        return head;
    }

    /**
     * 无节点的链表翻转
     *
     * @param p
     * @return
     */
    /*public Node inverseLinkList(Node p) {
        if (p == null) {
            return null;
        }

        Node head = p;
        Node cur = p.next;
        p.next = null;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = head;
            head = cur;
            cur = next;
        }

        return head;
    }
*/

    //无头结点的链表翻转
    public Node inverseLinkList(Node p){

        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.value);
        Node next= null;
        while(r !=p){
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;

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

        System.out.println("-------------------------");
        list.printAll();
        System.out.println("删除3");
        list.deleteByValue(3);
        list.printAll();
        System.out.println("删除5");
        list.deleteByValue(5);
        list.printAll();
        System.out.println("删除1");
        list.deleteByValue(1);
        list.printAll();
        System.out.println("---------------验证deleteByValue成功----------------");

        System.out.println("_________________________回文判断_______________________");
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertToHead(3);
        list2.insertToHead(2);
        list2.insertToHead(2);
        list2.insertToHead(3);
        list2.printAll();
        System.out.println(list2.palindrome());
    }

}
