package tree;

import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTree { //二叉树

    BinaryTreeNode root; //二叉树的根

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(String preString) { //以先序遍历来创建该二叉树
        Scanner scanner = new Scanner(preString);
        root = preCreateTree(scanner);
        scanner.close();
    }

    public BinaryTree(int[] nums) { //以完全二叉树的形式来创建
        BinaryTreeNode[] nodes = new BinaryTreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new BinaryTreeNode(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (2 * i + 1 < nums.length)
                nodes[i].left = nodes[2 * i + 1];
            if (2 * i + 2 < nums.length)
                nodes[i].right = nodes[2 * i + 2];
        }
        root = nodes[0];
    }

//    public int height(int x) {
//        if (root == null)
//            return 0;
//        return height(root, x, 0);
//    }
//
//    public static int height(BinaryTreeNode root, int x, int h) {
//        h++;
//        if (root.val == x)
//            return h;
//        int a = -1, b = -1;
//        if (root.left != null) {
//            a = height(root.left, x, h);
//        }
//        if (a != -1)
//            return a;
//        if (root.right != null) {
//            b = height(root.right, x, h);
//        }
//        return b;
//    }

    public boolean isAVL() { //判断是否为AVL树
        return isBST() && isBalanced(root, new AtomicInteger(0));
    }

    public static boolean isBalanced(BinaryTreeNode root, AtomicInteger height) { //判断root的平衡因子是否满足条件，若满足则将root的高度传给height
        if (root == null) {
            height.set(0);
            return true;
        }
        AtomicInteger l = new AtomicInteger(0), r = new AtomicInteger(0);
        boolean leftAVL = isBalanced(root.left, l), rightAVL = isBalanced(root.right, r);
        if (!leftAVL || !rightAVL)
            return false;
        if (Math.abs(l.get() - r.get()) > 1)
            return false;
        height.set(Math.max(l.get(), r.get()) + 1);
        return true;
    }

    public boolean isBST() { //判断是否为二叉搜索树
        AtomicInteger t = new AtomicInteger(Integer.MIN_VALUE);
        return isBST(root, t);
    }

    public static boolean isBST(BinaryTreeNode root, AtomicInteger last) { //判断root为根的二叉树是否为二叉搜索树，其中last用来存储中序遍历前驱的值
        if (root == null)
            return true;
        if (!isBST(root.left, last))
            return false;
        if (last.get() >= root.val)
            return false;
        last.set(root.val);
        if (!isBST(root.right, last))
            return false;
        return true;
    }


    public void preOrderTraverse2() { //非递归先序遍历
        if (root == null)
            return;
        System.out.print("前序遍历：");
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode p = stack.pop();
            System.out.print(p.val + " ");
            if (p.right != null)
                stack.push(p.right);
            if (p.left != null)
                stack.push(p.left);
        }
        System.out.println();
    }

    public void inOrderTraverse2() { //非递归中序遍历
        if (root == null)
            return;
        System.out.print("前序遍历：");
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode p = root;
        while (p != null) { //从根开始往左下角的所有结点依次入栈
            stack.push(p);
            p = p.left;
        }
        while (!stack.isEmpty()) {
            p = stack.pop();
            System.out.print(p.val + " ");
            p = p.right;
            while (p != null) { //如果有右结点，那么从该结点往左下角所有结点入栈
                stack.push(p);
                p = p.left;
            }
        }
        System.out.println();
    }


    public void preOrderTraverse() { //前序遍历该二叉树
        System.out.print("前序遍历：");
        preOrderTraverse(root);
        System.out.println();
    }

    public void inOrderTraverse() { //中序遍历该二叉树
        System.out.print("中序遍历：");
        inOrderTraverse(root);
        System.out.println();
    }

    public void postOrderTraverse() { //后序遍历该二叉树
        System.out.print("后序遍历：");
        postOrderTraverse(root);
        System.out.println();
    }

    private static BinaryTreeNode preCreateTree(Scanner scanner) {
        if (!scanner.hasNext())
            return null;
        String next = scanner.next();
        if (next.equals("#"))
            return null;
        BinaryTreeNode t = new BinaryTreeNode(Integer.valueOf(next));
        t.left = preCreateTree(scanner);
        t.right = preCreateTree(scanner);
        return t;
    }

    private static void preOrderTraverse(BinaryTreeNode root) { //从当前节点开始前序遍历该二叉树
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    private static void inOrderTraverse(BinaryTreeNode root) { //从当前节点开始中序遍历该二叉树
        if (root == null)
            return;
        inOrderTraverse(root.left);
        System.out.print(root.val + " ");
        inOrderTraverse(root.right);
    }

    private static void postOrderTraverse(BinaryTreeNode root) { //从当前节点开始后序遍历该二叉树
        if (root == null)
            return;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.val + " ");
    }
}

