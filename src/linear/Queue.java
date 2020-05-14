package linear;

public class Queue { //使用循环数组实现的队列

    int front, rear; //队头和队尾位置
    int maxSize; //最多可存储的元素个数(队列存满时数组中还有一个位置未使用，所以队列最大可存储个数要-1)
    int[] nums; //用来存储数据元素

    public Queue(int maxSize) { //初始化
        front = 0;
        rear = 0;
        this.maxSize = maxSize;
        nums = new int[maxSize];
    }

    public boolean isEmpty() { //判断队列是否为空
        return front == rear;
    }

    public boolean isFull() { //判断队列是否已满
        return (rear + 1) % maxSize == front; //取余操作是为了防止数组下标越界，下同
    }

    public int getFront() { //返回队头元素的值
        if (isEmpty())
            throw new RuntimeException("队列为空");
        return nums[(front + 1) % maxSize];
    }

    public void enQueue(int x) { //将x入队
        if (isFull())
            throw new RuntimeException("队列已满");
        rear++;
        rear %= maxSize;
        nums[rear] = x;
    }

    public void deQueue() { //将队头元素出队
        if (isEmpty())
            throw new RuntimeException("队列为空");
        front++;
        front %= maxSize;
    }

    public void clear() { //清除队列所有元素
        front = 0;
        rear = 0;
    }

    public void print() { //打印队列
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = (front + 1) % maxSize; i != rear; i++, i %= maxSize)
            System.out.print(nums[i] + " ");
        System.out.println(nums[rear]);
    }

}
