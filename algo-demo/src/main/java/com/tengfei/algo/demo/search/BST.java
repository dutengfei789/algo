package com.tengfei.algo.demo.search;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Binary search tree
 * 二分搜索树
 */
public class BST<E extends Comparable<E>> {

    private Node root;

    private int size;

    private class Node{
        private E e;

        private Node left;

        private Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    public int getSize(){
        return this.size;
    }

    public void add1(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }else {
            add1(root, e);
        }


    }

    private void add1(Node node, E e) {
        //边界条件
        if (node.e.compareTo(e)==0) {
            return;
        } else if (node.e.compareTo(e) > 0 && node.left==null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (node.e.compareTo(e) < 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        //循环最小单元
        if (node.e.compareTo(e) > 0) {
            add1(node.left, e);
        }else {
            add1(node.right, e);
        }

    }

    /**
     * 向二分搜索中添加新元素
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            node = new Node(e);
            size++;
            return node;
        }

        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e);
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {

        return false;
    }


    private boolean contains(Node node,E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e)==0) {
            return true;
        } else if (node.e.compareTo(e)>0) {
            return contains(node.left, e);
        }
        return contains(node.right, e);
    }
    public void  preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void midOrder(Node node) {
        if (node == null) {
            return;
        }

        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);
    }

    //前序遍历的非递归实现
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //中序遍历又叫广义优先遍历
    public void levelOrderNR(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.e);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //后续遍历
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "NULL\n");
            return;
        }
        sb.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public E removeMin(){
        E ret = minimum();
        root=removeMin(root);
        return ret;
    }

    //删除以node为根节点的二分搜索树的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node right=node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left=removeMin(node.left);
       return node;
    }

    public E removeMax(){
        E ret = maximum();
        root=removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public E minimum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            //
            node.right = remove(node.right, e);
            return node;
        }else { //node.e==e

            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }

            //待删除节点右子树为空
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }

            //待删节点左右子树均不为空的情况
            //找到比待删除节点大的最小值，即待删除节点右子树的最小节点
            Node successor = minimum(node.right);
            //用这个节点顶替待删除节点的位置
            successor.right = removeMin(node.right);//这里不需要再重新维护一下size。已删除过了，且successor节点没有丢弃
            successor.left = node.left;

            node.left = node.right = null;
            return successor;

        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        Integer[] nums = {5, 3, 6, 8, 4, 2};
//        for (Integer num : nums) {
//            bst.add(num);
//        }
//        bst.preOrder();
        Random random = new Random();
        IntStream.range(0,200).forEach(cur->{
            bst.add(random.nextInt(10000));
        });
//        bst.levelOrderNR();

        ArrayList<Integer> list = new ArrayList<>();
        while (!bst.isEmpty()) {
            Integer del = bst.removeMax();
            list.add(del);
        }
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i - 1) < list.get(i)) {
                throw new IllegalArgumentException("删除异常");
            }
        }
        System.out.println(list);
    }

    public boolean isEmpty() {
        return size==0;
    }
}
