import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node{
    int val;
    Node left;
    Node right;
    Node(){}
    Node(int value){
        val = value;
    }
}

public class Main {
    public static void main(String[] args) {
        Node root  = new Node(4);
        Node n1 = new Node(2);
        Node n2 = new Node(7);
        Node n3 = new Node(1);
        Node n4 = new Node(3);
        Node n5 = new Node(9);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right =n4;
        n2.right = n5;

        Solution s = new Solution();
        //s.traverseInorder(root);
        //s.traversePreorder(root);
        //s.traversePostorder(root);
        //List<Integer> res = s.iteratePredorder(root);
        //System.out.println(res.toString());
        //List<Integer> res = s.iteratePostorder(root);
        //System.out.println(res.toString());

        List<Integer> res = s.iterateInorder(root);
        System.out.println(res.toString());
    }
}

class Solution {
    public void traverseInorder(Node root) {
        // base case
        if (root == null) return;
        traverseInorder(root.left);
        System.out.println("I am in " + root.val);
        traverseInorder(root.right);
    }

    public void traversePreorder(Node root) {
        // base case
        if (root == null) return;

        System.out.println("I am in " + root.val);
        traversePreorder(root.left);
        traversePreorder(root.right);
    }

    public void traversePostorder(Node root) {
        // base case
        if (root == null) return;

        traversePostorder(root.left);
        traversePostorder(root.right);
        System.out.println("I am in " + root.val);
    }

    public List<Integer> iteratePredorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.add(root); // traverse
        while (!stack.isEmpty()) {
            Node curr = stack.pollLast();// traverse and handle it at same time
            res.add(curr.val);
            if (curr.right != null) stack.add(curr.right); // right first
            if (curr.left != null) stack.add(curr.left);
        }
        return res;
    }

    public List<Integer> iteratePostorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            res.add(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        // reverse the list
        for (int i = 0; i < res.size() / 2; ++i) {
            int tmp = res.get(i);
            res.set(i, res.get(res.size() - 1 - i));
            res.set(res.size() - 1 - i, tmp);
        }

        return res;
    }


    public List<Integer> iterateInorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        Node curr = root; // use pointer to traverse the node

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left; // left
            } else {
                curr = stack.pop();// handle it
                res.add(curr.val); // mid
                curr = curr.right; // right
            }
        }
        return res;
    }
}