package binarySearchTree;

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class BinarySearchTree {
  private TreeNode root;

  public BinarySearchTree() {
    root = null;
  }

  public void insert(int data) {
    root = insertNode(root, data);
  }

  public TreeNode insertNode(TreeNode root, int data) {
    if (root == null) {
      return new TreeNode(data);
    }

    if (data < root.data) {
      root.left = insertNode(root.left, data);
    } else if (data > root.data) {
      root.right = insertNode(root.right, data);
    }
    return root;
  }

  public boolean contains(TreeNode root, int data) {
    if (root == null) {
      return false;
    }

    if (root.data == data) {
      return true;
    } else if (root.data < data) {
      return contains(root.right, data);
    } else {
      return contains(root.left, data);
    }
  }

  public void inOrderTraversal() {
    inOrder(this.root);
  }

  private void inOrder(TreeNode root) {
    if (root != null) {
      inOrder(root.left);
      System.out.println(root.data);
      inOrder(root.right);
    }
  }

  public TreeNode getRoot() {
    return root;
  }

  public TreeNode find(int data) {
    return findNode(root, data);
  }

  private TreeNode findNode(TreeNode root, int data) {
    if (root == null) {
      return null;
    }

    if (root.data == data) {
      return root;
    }

    if (data < root.data) {
      return findNode(root.left, data);
    } else {
      return findNode(root.right, data);
    }
  }

  public void delete(int data) {
    root = deleteNode(root, data);
  }

  private TreeNode deleteNode(TreeNode root, int data) {
    if (root == null) {
      return null;
    }
    if (data < root.data) {
      root.left = deleteNode(root.left, data);
    } else if (data > root.data) {
      root.right = deleteNode(root.right, data);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      root.data = minValue(root.right);
      root.right = deleteNode(root.right, root.data);
    }
    return root;
  }

  private int minValue(TreeNode root) {
    int minValue = root.data;

    while (root.left != null) {
      minValue = root.left.data;
      root = root.left;
    }
    return minValue;
  }
}
