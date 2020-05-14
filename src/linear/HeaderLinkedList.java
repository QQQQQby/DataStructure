package linear;

public class HeaderLinkedList { //带表头结点的单链表

    ListNode header; //表头结点
    int n; //表中当前元素个数

    public HeaderLinkedList() { //初始化
        header = new ListNode(0);
        n = 0;
    }

    public int get(int i) { //查找指定下标的数据元素并返回值
        if (i < 0 || i >= n)
            throw new RuntimeException("下标越界");
        ListNode p = header;
        for (int j = -1; j < i; j++)
            p = p.next;
        return p.val;
    }

    public void insert(int i, int x) { //将x插入到顺序表中下标为i的元素后面，若i为-1，则插入到表的最前面
        if (i < -1 || i >= n)
            throw new RuntimeException("下标越界");
        ListNode p = new ListNode(x), q = header;
        for (int j = -1; j < i; j++)
            q = q.next;
        p.next = q.next;
        q.next = p; //这两句不能写反
        n++;
    }

    public void delete(int i) { //删除表中下标为i的元素
        if (i < 0 || i >= n)
            throw new RuntimeException("下标越界");
        ListNode p = header, q;
        for (int j = 0; j < i; j++)
            p = p.next;
        q = p.next;
        p.next = q.next;
        n--;
    }

    public void update(int i, int x) { //将表中下标为i的元素的值改为x
        if (i < 0 || i >= n)
            throw new RuntimeException("下标越界");
        ListNode p = header;
        for (int j = -1; j < i; j++)
            p = p.next;
        p.val = x;
    }


    public void print() { //打印该单链表
        if (n == 0) {
            System.out.println("带表头结点的单链表为空");
            return;
        }
        ListNode p = header;
        for (int i = 0; i < n - 1; i++) {
            p = p.next;
            System.out.print(p.val + " ");
        }
        System.out.println(p.next.val);
    }


    public static HeaderLinkedList mergeLinkedList(HeaderLinkedList list1, HeaderLinkedList list2) { //合并两个递增链表，返回新链表
        ListNode p = list1.header.next, q = list2.header.next;
        HeaderLinkedList res = new HeaderLinkedList();
        ListNode r = res.header;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = new ListNode(p.val);
                p = p.next;
            } else {
                r.next = new ListNode(q.val);
                q = q.next;
            }
            r = r.next;
        }
//        if (p != null)
//            r.next = p;
//        if (q != null)
//            r.next = q;
//上面做法会造成链表有交集
        while (p != null) {
            r.next = new ListNode(p.val);
            r = r.next;
            p = p.next;
        }
        while (q != null) {
            r.next = new ListNode(q.val);
            r = r.next;
            q = q.next;
        }

        return res;
    }
}

