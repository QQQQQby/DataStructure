package linear;

public class SequenceList { //顺序表

    int maxLength; //最大存储长度
    int n; //目前数据元素的个数
    int[] nums; //存放数据元素

    public SequenceList(int maxLength) { //建立指定长度的顺序表
        if (maxLength < 0)
            throw new RuntimeException("长度不可为负");
        this.maxLength = maxLength;
        n = 0;
        nums = new int[maxLength];
    }

    public int getLength() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int get(int i) { //查找指定下标的数据元素并返回值
        if (i < 0 || i >= n)
            throw new RuntimeException("下标越界");
        return nums[i];
    }

    public void insert(int i, int x) { //将x插入到顺序表中下标为i的元素后面，若i为-1，则插入到表的最前面
        if (i < -1 || i >= n)
            throw new RuntimeException("下标越界");
        if (n == maxLength)
            throw new RuntimeException("顺序表已满");
        for (int j = n - 1; j > i; j--) //插入元素时只能将后面的元素倒序后移一位，否则会出错
            nums[j + 1] = nums[j];
        nums[i + 1] = x;
        n++;
    }

    public void delete(int i) { //删除指定下标元素
        if (i < 0 || i > n)
            throw new RuntimeException("下标越界");
        for (int j = i + 1; j < n; j++) //删除元素时只能将后面的元素顺序前移一位，否则会出错
            nums[j - 1] = nums[j];
        n--;
    }

    public void update(int i, int x) { //将指定下标元素更改为x
        if (i < 0 || i > n)
            throw new RuntimeException("下标越界");
        nums[i] = x;
    }

    public void print() { //输出线性表
        if (n == 0) {
            System.out.println("顺序表为空");
            return;
        }
        for (int i = 0; i < n - 1; i++)
            System.out.print(nums[i] + " ");
        System.out.println(nums[n - 1]);
    }
}
