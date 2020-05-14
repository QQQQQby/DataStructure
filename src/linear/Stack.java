package linear;

public class Stack { //使用数组实现的栈

    int[] nums; //存储元素
    int top, maxSize; //栈顶元素下标，栈为空时值为-1；栈最大可存储元素

    public Stack(int maxSize) { //初始化
        nums = new int[maxSize];
        top = -1;
        this.maxSize = maxSize;
    }

    public int getSize() { //获取栈当前存储元素个数
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int x) { //将元素x压入栈
        if (isFull())
            throw new RuntimeException("栈已满");
        nums[++top] = x;
    }

    public void pop() { //栈顶元素出栈
        if (isEmpty())
            throw new RuntimeException("栈为空");
        top--;
    }

    public int getTop() { //返回栈顶元素的值
        if (isEmpty())
            throw new RuntimeException("栈为空");
        return nums[top];
    }

    public void print() { //打印该栈
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        for (int i = 0; i < top; i++)
            System.out.print(nums[i] + " ");
        System.out.println(nums[top]);
    }
}
