package linear;

public class LinkedList { //不带表头结点的单链表

    ListNode first; //表中第一个元素
    int n; //表中当前元素个数

    public LinkedList() { //初始化
        first = null;
        n = 0;
    }

    public int get(int i) { //查找指定下标的数据元素并返回值
        if (i < 0 || i >= n)
            throw new RuntimeException("下标越界");
        ListNode p = first;
        for (int j = 0; j < i; j++)
            p = p.next;
        return p.val;
    }

    public void insert(int i, int x) { //将x插入到顺序表中下标为i的元素后面，若i为-1，则插入到表的最前面
        if (i < -1 || i >= n)
            throw new RuntimeException("下标越界");
        ListNode p = new ListNode(x);
        if (i == -1) { //如果i=-1，那么表头(第一个元素)的位置需要更改，所以需单独考虑。下面删除操作同样的道理
            p.next = first;
            first = p;
        } else {
            ListNode q = first;
            for (int j = 0; j < i; j++)
                q = q.next;
            p.next = q.next;
            q.next = p;
        }
        n++;
    }

    public void delete(int i) { //删除表中下标为i的元素
        if (i < 0 || i >= n)
            throw new RuntimeException("下标越界");
        if (i == 0) {
            first = first.next;
        } else {
            ListNode p = first, q;
            for (int j = 1; j < i; j++)
                p = p.next;
            q = p.next;
            p.next = q.next;
        }
        n--;
    }

    public void update(int i, int x) { //将表中下标为i的元素的值改为x
        if (i < 0 || i >= n)
            throw new RuntimeException("下标越界");
        ListNode p = first;
        for (int j = 0; j < i; j++)
            p = p.next;
        p.val = x;
    }

    public void print() { //打印该单链表
        if (n == 0) {
            System.out.println("单链表为空");
            return;
        }
        ListNode p = first;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println(p.val);
    }
}

