/*
 *    This Code is 100% written by me
 *    No outside resources just pen and paper
 *              And Debugging
 */
import java.io.IOException;
import java.util.EmptyStackException;

public class BinarySearchTree<T extends Comparable<? super T>>{
  private treeNode<T> root;
  public BinarySearchTree(){
    root = new treeNode<>();
  }
  public void clear(){
    root = new treeNode<T>();
  }

  public boolean isEmpty(){
    if (root.getData() == null){
      return true;
    }
    return false;
  } 

  public boolean contains(T value){
    return search(root, value);
  }

  public T findMin(){
    return min(root);
  }

  public T findMax(){
    return max(root);
  }

  public void add(T data){
    if (root.getData() == null){
      root.setRootData(data);
    }
    else{
      insertion(root, data);
    }
  }

  public void delete(T data){
    if (!search(root, data)){
      throw new IllegalAccessError("No such data in binary tree!");
    }
    else{
      treeNode<T> deletionNode = find(root, data);
      if (deletionNode.getLeft() == null && deletionNode.getRight() == null){
        deleteLeaf(root, deletionNode);
      }
      if (deletionNode.getLeft() == null || deletionNode.getRight() == null){
        deleteOneChild(root, deletionNode);
      }
      else{
        deleteRoot(root, deletionNode);
      }
    }
  }

  public void printTree(){
    DFS(root);
  }

  private boolean search(treeNode<T> root, T value){
    if (root.getData() == null){
      return false;
    }
    if (value.compareTo(root.getData()) > 0){
      return search(root.getRight(), value);
    }
    if (value.compareTo(root.getData()) < 0){
      return search(root.getLeft(), value);
    }
    if (value.compareTo(root.getData()) == 0){
      return true;
    }
    return false;
  }

  private void insertion(treeNode<T> node, T value){
    if (node == null){
      node = new treeNode<>(value);
    }
    if (value.compareTo(node.getData()) > 0){
      if (node.getRight() == null){
        node.setRightNode(new treeNode<>(value));
      }
      else{
      insertion(node.getRight(), value);
      }
    }
    if (value.compareTo(node.getData()) < 0){
      if (node.getLeft() == null){
        node.setLeftNode(new treeNode<>(value));
      }
      else{
      insertion(node.getLeft(), value);
      }
    }
  }

  private T min(treeNode<T> node){
    if (node.getData() == null){
      throw new EmptyStackException();
    }
    if (node.getLeft() != null){
      return min(node.getLeft());
    }
    return node.getData();
  }

    private T max(treeNode<T> node){
    if (node.getData() == null){
      throw new EmptyStackException();
    }
    if (node.getRight() != null){
      return min(node.getRight());
    }
    return node.getData();
  }

  private void DFS(treeNode<T> node){
    if (node.getData() == null){ // assuming the root that was passed is null
      System.out.println("null");
    }
    if (node.getLeft() != null){
      DFS(node.getLeft());
    }
    if (node.getRight() != null){
      DFS(node.getRight());
    }
    System.out.println(node.getData());
  }

  private treeNode<T> find(treeNode<T> node, T data){
    if (data.compareTo(node.getData()) == 0){
      return node;
    }
    if (data.compareTo(node.getData()) > 0){
      return find(node.getRight(), data);
    }
    if (data.compareTo(node.getData()) < 0){
      return find(node.getLeft(), data);
    }
    return node;
  }

  private void deleteLeaf(treeNode<T> node, treeNode<T> nodeToDelete){
    if (node.getLeft() != null){
      if (node.getLeft().getData().compareTo(nodeToDelete.getData()) == 0){
        node.setLeftNode(null);
        return;
      }
      if (nodeToDelete.getData().compareTo(node.getData()) < 0){
        deleteLeaf(node.getLeft(), nodeToDelete);
      }
    }
    if (node.getRight() != null){
      if (node.getRight().getData().compareTo(nodeToDelete.getData()) == 0){
        node.setRightNode(null);
        return;
      }
      if (nodeToDelete.getData().compareTo(node.getData()) > 0){
      deleteLeaf(node.getRight(), nodeToDelete);
      }
    }
  }

  private void deleteOneChild(treeNode<T> node, treeNode<T> nodeToDelete){
    if (node.getLeft() != null){
      if (node.getLeft().getData().compareTo(nodeToDelete.getData()) == 0){
        node.setLeftNode(node.getLeft().getLeft());
        return;
      }
      if (nodeToDelete.getData().compareTo(node.getData()) < 0){
        deleteOneChild(node.getLeft(), nodeToDelete);
      }
    }
    if (node.getRight() != null){
      if (node.getRight().getData().compareTo(nodeToDelete.getData()) == 0){
        node.setRightNode(node.getRight().getRight());
        return;
      }
      if (nodeToDelete.getData().compareTo(node.getData()) > 0){
        deleteOneChild(node.getRight(), nodeToDelete);
      }
    }
  }

  private void deleteRoot(treeNode<T> node, treeNode<T> nodeToDelete){
    treeNode<T> replacement = findMaxNode(nodeToDelete.getLeft());
    nodeToDelete.setRootData(replacement.getData());
    if (replacement.getLeft() == null && replacement.getRight() == null){
      deleteLeaf(node.getLeft(), replacement);
    }
    else{
      deleteOneChild(node.getLeft(), replacement);
    }
  }

  private treeNode<T> findMaxNode(treeNode<T> node){
    if (node.getData() == null){
      throw new EmptyStackException();
    }
    if (node.getRight() != null){
      return findMaxNode(node.getRight());
    }
    return node;
  }
}
