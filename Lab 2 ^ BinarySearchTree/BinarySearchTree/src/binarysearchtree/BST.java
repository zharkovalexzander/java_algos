package binarysearchtree;

public class BST {

    protected TreeNode root;

    public BST() {
        root = null;
    }

    public boolean TreeEmpty() {
        return (root == null);
    }

    public boolean TreeFull() {
        try {
            TreeNode temp = new TreeNode(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return true;
    }

    public void Clear() {
        root = null;
    }

    private int depth(TreeNode p) {
        if (p != null) {
            return (1 + Math.max(depth(p.left), depth(p.right)));
        }
        return 0;
    }

    private int difference(TreeNode a) {
        return (depth(a.right) - depth(a.left));
    }

    private TreeNode SmallRotateLeft(TreeNode a) {
        TreeNode b = a.right;
        a.right = b.left;
        b.left = a;
        return b;
    }

    private TreeNode SmallRotateRight(TreeNode a) {
        TreeNode b = a.left;
        a.left = b.right;
        b.right = a;
        return b;
    }

    private TreeNode Balance_rec(TreeNode a) {
        if (difference(a) == 2) {
            if (difference(a.right) < 0)
            {
                a.right = SmallRotateRight(a.right);
            }
            return SmallRotateLeft(a);
        }
        if (difference(a) == -2) {
            if (difference(a.left) > 0)
            {
                a.left = SmallRotateLeft(a.left);
            }
            return SmallRotateRight(a);
        }
        return a;
    }
    public void AddNode(int item) {
        root = addNode_rec(item, root);
    }

    private TreeNode addNode_rec(int item, TreeNode p) {
        if (p == null) {
            p = new TreeNode(item);
            p.left = p.right = null;
        } else if (item < p.value) {
            p.left = addNode_rec(item, p.left);
        } else {
            p.right = addNode_rec(item, p.right);
        }
        return Balance_rec(p);
    }

    private boolean recBinSea(TreeNode p, int data) {
        if (p == null) {
            return false;
        }
        if (p.value == data) {
            return true;
        } else if (p.value > data) {
            return recBinSea(p.left, data);
        } else {
            return recBinSea(p.right, data);
        }
    }

    public boolean BinarySearch(int data) {
        return recBinSea(root, data);
    }

    private int rec_len(TreeNode p) {
        if (p != null) {
            return 1 + rec_len(p.left) + rec_len(p.right);
        }
        return 0;
    }

    public int NodeNum() {
        return rec_len(root);
    }

    private int getBiggest(TreeNode p) {
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    private TreeNode find_nod(TreeNode p) {
        int temporary;
        if (p.left == null) {
            return p.right;
        } else if (p.right == null) {
            return p.left;
        } else {
            temporary = getBiggest(p.left);
            p.value = temporary;
            p.left = rec_del(temporary, p.left);
            return p;
        }
    }

    private TreeNode rec_del(int data, TreeNode p) {
        if (data < p.value) {
            p.left = rec_del(data, p.left);
        } else if (data > p.value) {
            p.right = rec_del(data, p.right);
        } else {
            p = find_nod(p);
        }
        return p;
    }

    public void Delete(int data) {
        root = Balance_rec(rec_del(data, root));
    }

    private void recPrePrint(TreeNode p) {
        if (p != null) {
            System.out.println(p.value);
            recPrePrint(p.left);
            recPrePrint(p.right);
        }
    }

    public void PrintPre() {
        recPrePrint(root);
    }

    private void recInPrint(TreeNode p) {
        if (p != null) {
            recInPrint(p.left);
            System.out.println(p.value);
            recInPrint(p.right);
        }
    }

    public void PrintIn() {
        recInPrint(root);
    }

    private void recPostPrint(TreeNode p) {
        if (p != null) {
            recInPrint(p.left);
            recInPrint(p.right);
            System.out.println(p.value);
        }
    }

    public void PrintPost() {
        recPostPrint(root);
    }
}
