import linear.*;
import tree.*;
import graph.*;

import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        SequenceList list = new linear.SequenceList(4);
//        System.out.println(list.isEmpty());
//        list.print();
//        list.insert(-1, 9);
//        list.insert(0, 2);
//        list.insert(-1, 54);
//        list.insert(-1, 5);
//        list.print();
//        list.delete(0);
//        list.print();
//        list.update(2, 26);
//        list.print();
//        System.out.println(list.isEmpty());
//
//
//        HeaderLinkedList list2 = new linear.HeaderLinkedList();
//        list2.print();
//        list2.insert(-1, 6);
//        list2.insert(0, 9);
//        list2.insert(0, 8);
//        list2.insert(2, 3);
//        list2.print();
//        list2.delete(0);
//        list2.update(0, 7);
//        list2.print();
//        System.out.println(list2.get(0));
//
//        Stack stack = new linear.Stack(5);
//        stack.print();
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(8);
//        stack.push(1);
//        stack.print();
//        stack.pop();
//        stack.print();
//        System.out.println(stack.getTop());
//
//        Queue queue = new linear.Queue(5);
//        queue.enQueue(2);
//        queue.enQueue(3);
//        queue.enQueue(4);
//        queue.enQueue(5);
//        System.out.println(queue.getFront());
//        queue.print();
//        queue.deQueue();
//        queue.print();
//        queue.deQueue();
//        queue.deQueue();
//        queue.deQueue();
//        queue.print();

//        System.out.println(Calculation.calculateRPN("-98 2 ^"));
//        int n = 5;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                System.out.print((i*(2*n-i-1)/2+j)+" ");
//            }
//        }

//        int[] fail = Algorithm.getFail("abcdabcabcdaab");
//        for (int i = 0; i < fail.length; i++) {
//            System.out.print(fail[i] + " ");
//        }
//        System.out.println();
//
//        System.out.println(Algorithm.KMP("abcdabcabcdaab", "daab"));

//        System.out.println(Algorithm.calculateRPN("5.5 2.2 * 2 +"));

//        BinaryTree tree = new BinaryTree("1 2 4 # # # 3 # 5 #");
//        tree.preOrderTraverse();
//        tree.preOrderTraverse2();
//        tree.inOrderTraverse();
//        tree.postOrderTraverse();

//        System.out.println(tree.height(5));

//        int[] nums = {
//                32, 74, 66, 88, 93, 4, 25, 87, 49, 24,
//                97, 71, 13, 82, 68, 86, 21, 60, 54, 61,
//                12, 80, 8, 76, 92, 62, 7, 96, 51, 29,
//                67, 55, 64, 28, 36, 35, 81, 9, 53, 83,
//                11, 79, 6, 95, 100, 90, 52, 47, 99, 98, 23, 40, 59, 65, 27, 18, 85, 70, 30, 33, 20, 15, 31, 41, 45, 84, 5, 56, 91, 46, 42, 43, 34, 22, 50, 78, 1, 89, 3, 72, 38, 17, 69, 14, 77, 26, 58, 63, 39, 19, 10, 37, 75, 94, 48, 73, 57, 44, 16, 2};
//        int[] nums = {5, 0};
//        Algorithm.halfSelectSort(nums);
//        Algorithm.selectSort(nums);
//        Algorithm.bubbleSort(nums);
//        Algorithm.insertSort(nums);
//        Algorithm.mergeSort(nums);
//        Algorithm.heapSort(nums);
//        Algorithm.quickSort(nums);
//        Algorithm.printArray(nums);

//        ListGraph graph = new ListGraph(7);
//        graph.insert(0, 4, 1);
//        graph.insert(0, 2, 1);
//        graph.insert(0, 1, 1);
//        graph.insert(1, 3, 1);
//        graph.insert(4, 6, 1);
//        graph.insert(4, 5, 1);
//        graph.DFS();
//        graph.BFS();
//
//        graph.reverse();

//        HeaderLinkedList list1 = new HeaderLinkedList(), list2 = new HeaderLinkedList();
//        list1.insert(-1, 0);
//        list1.insert(0, 2);
//        list1.insert(1, 5);
//
//        list2.insert(-1, 1);
//        list2.insert(0, 3);
//
//        HeaderLinkedList t = HeaderLinkedList.mergeLinkedList(list1, list2);

//        BinaryTree tree = new BinaryTree(new int[]{3,1,5,0,2,4,6,-1});
//        tree.preOrderTraverse();
//        tree.preOrderTraverse2();
//        tree.inOrderTraverse();
//        tree.inOrderTraverse2();
//        System.out.println(tree.isAVL());

        String a = "apple";
        Trie trie = new Trie();
        trie.insert(a);
        System.out.println(trie.startsWith("apple"));

    }

}
