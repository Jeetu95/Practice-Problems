// https://practice.geeksforgeeks.org/problems/check-if-tree-is-isomorphic/1/?track=sp-trees&batchId=152
/*
    Author - Subhajit Das
    University of Engineering and Management, Kolkata
    16/07/2019
*/

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = n;
            Node root1 = null;
            Node root2 = null;
            while (n-- > 0) {
                int a1 = sc.nextInt();
                int a2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if (root1 == null) {
                    root1 = new Node(a1);
                    switch (lr) {
                    case 'L':
                        root1.left = new Node(a2);
                        break;
                    case 'R':
                        root1.right = new Node(a2);
                        break;
                    }
                } else {
                    insert(root1, a1, a2, lr);
                }
            }
            while (m-- > 0) {
                int a1 = sc.nextInt();
                int a2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if (root2 == null) {
                    root2 = new Node(a1);
                    switch (lr) {
                    case 'L':
                        root2.left = new Node(a2);
                        break;
                    case 'R':
                        root2.right = new Node(a2);
                        break;
                    }
                } else {
                    insert(root2, a1, a2, lr);
                }
            }
            // inorder(root1);
            // System.out.println();
            // inorder(root2);
            GfG g = new GfG();
            if (g.isIsomorphic(root1, root2)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static void insert(Node root, int a1, int a2, char lr) {
        if (root == null) {
            return;
        }
        if (root.data == a1) {
            switch (lr) {
            case 'L':
                root.left = new Node(a2);
                break;
            case 'R':
                root.right = new Node(a2);
                break;
            }
        } else {
            insert(root.left, a1, a2, lr);
            insert(root.right, a1, a2, lr);
        }
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

/*
 * This is a function problem.You only need to complete the function given below
 */
/*
 * Complete the function below Node is as follows: class Node{ int data; Node
 * left,right; Node(int d){ data=d; left=right=null; } }
 */
class GfG {
    public boolean isIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.data != root2.data)
            return false;

        return (this.isIsomorphic(root1.left, root2.left) && this.isIsomorphic(root1.right, root2.right))
                || (this.isIsomorphic(root1.left, root2.right) && this.isIsomorphic(root1.right, root2.left));
    }
}