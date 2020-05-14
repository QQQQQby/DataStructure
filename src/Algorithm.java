import java.util.Scanner;
import java.util.Stack;

public class Algorithm {

    public static float calculateRPN(String expression) { //计算逆波兰表达式(只支持整型的加减乘除和指数计算)
        Scanner scanner = new Scanner(expression);
        Stack<Float> stack = new Stack<>();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if ((s.charAt(0) <= '9' && s.charAt(0) >= '0') || (s.charAt(0) == '-' && s.length() > 1)) { //如果第一个字符是数字，或者第一个字符是负号但字符长度超过1，说明是操作数
                stack.push(Float.valueOf(s));
            } else {
                float b = stack.peek(); //首先出栈的是第二个操作数
                stack.pop();
                float a = stack.peek();
                stack.pop();
                switch (s) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b); //整型除法为向下取余
                        break;
                    case "^":
                        stack.push((float) Math.pow(a, b));
                        break;
                    default:
                        throw new RuntimeException("符号错误");
                }
            }
        }
        if (stack.size() != 1) //此时堆栈应该只有一个元素
            throw new RuntimeException("表达式不正确");
        return stack.peek();
    }

    public static int[] getFail(String p) { //得到KMP算法中模式串对应的Fail数组
        if (p.isEmpty())
            return new int[0];
        int[] fail = new int[p.length()];
        fail[0] = -1;
        int j = 0, k = -1;
        while (j + 1 < fail.length) {
            if (k == -1 || p.charAt(j) == p.charAt(k))
                fail[++j] = (++k);
            else
                k = fail[k];
        }
        return fail;
    }

    public static int KMP(String s, String p) { //判断p是否为s的子串，若是则返回p在s中的起始位置，否则返回-1
        if (s.isEmpty() || p.isEmpty())
            return -1;
        int i = 0, j = 0;
        int[] fail = getFail(p);
        while (i < s.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (j >= p.length())
                    return i - j;
            } else {
                if (fail[j] == -1) //fail[0]为-1，此时主串s的下标i应加1
                    i++;
                else
                    j = fail[j]; //p[j]失配时，下一趟匹配j应回溯的位置是fail[j]
            }
        }
        return -1;
    }

    public static void swap(int[] nums, int i, int j) { //交换数组nums中下标为i和j的元素的值
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void selectSort(int[] nums) { //简单选择排序
        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i], minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
    }

    public static void insertSort(int[] nums) { //直接插入排序
        int j;
        for (int i = 1; i < nums.length; i++) {
            int insertNum = nums[i]; //待插入元素
            for (j = i - 1; j >= 0; j--) {
                if (insertNum < nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = insertNum;
        }
    }

    public static void bubbleSort(int[] nums) { //冒泡排序
        for (int i = nums.length - 1; i >= 1; i--) {
            boolean isSwap = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap)
                return;
        }
    }

    public static void quickSort(int[] nums) { //快速排序
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int low, int high) { //将数组nums中下标从low到high的元素进行一趟快速排序
        if (low >= high)
            return;
        int pivot = nums[low]; //分割元素
        int i = low + 1, j = high;
        do { //只能为do...while，不能改成while
            while (nums[j] > pivot) //若i一开始为low则应改成do...while
                j--;
            while (nums[i] < pivot) //若j一开始为high + 1则应改成do...while
                i++;
            if (i < j)
                swap(nums, i, j);
        } while (i < j);
        swap(nums, low, j); //下标为low + 1 ~ j的元素的值<=下标为pivot，即下标为low的元素，所以还要交换一次
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);
    }

    public static void mergeSort(int[] nums) { //两路合并排序
        int[] temp = new int[nums.length];
        int n1 = 1;
        while (n1 < nums.length) {
            int low = 0, k = 0;
            while (low + n1 < nums.length) {
                int n2 = Math.min(nums.length - low - n1, n1);
                int i = low, j = low + n1;
                while (i < low + n1 && j < low + n1 + n2) {
                    if (nums[i] < nums[j]) {
                        temp[k++] = nums[i++];
                    } else {
                        temp[k++] = nums[j++];
                    }
                }
                while (i < low + n1) {
                    temp[k++] = nums[i++];
                }
                while (j < low + n1 + n2) {
                    temp[k++] = nums[j++];
                }
                low += n1 + n2;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
            n1 *= 2;
        }
    }

    public static void createHeap(int[] nums) { //创建最大化堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustDown(nums, i, nums.length - 1);
        }
    }

    public static void adjustDown(int[] nums, int low, int high) { //向下调整堆，假设low + 1 ~ high已经是最大化堆
        int temp = nums[low];
        for (int i = low * 2 + 1; i <= high; i = i * 2 + 1) {
            if (i < high && nums[i] < nums[i + 1])
                i++;
            if (temp > nums[i])
                break;
            nums[low] = nums[i];
            low = i;
        }
        nums[low] = temp;
    }

    public static void heapSort(int[] nums) { //堆排序
        createHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustDown(nums, 0, i - 1);
        }
    }


    public static void printArray(int[] nums) { //打印数组
        printArray(nums, 0, nums.length);
    }

    public static void printArray(int[] nums, int i, int j) { //打印数组nums中下标为i到j-1的元素的值
        for (; i < j; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void halfSelectSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int a = 0, b = i, e = nums[i];
            while (a != b) {
                int t = (a + b) / 2;
                if (nums[t] > e)
                    b = t;
                else
                    a = t + 1;
            }
            for (int j = i - 1; j >= a; j--) {
                nums[j + 1] = nums[j];
            }
            nums[a] = e;
        }

    }
}

