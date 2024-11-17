public class BinarySearchTree<T> implements BinarySearchTreeInterface<T>{
  Node<T> root;
  public BinarySearchTree(){
    root.setRootData(null);
  }

  public void clear(){
    root = Node<T>();
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
  }

  public T findMax(){
  }

  public void add(T data){
  }

  public void delete(T data){
  }

  public void printTree(){
  }

  private boolean search(Node<T> root, T value){
    if (root.getData() == null){
      return false;
    }
    if (value.compareTo(root.getData()) > 0){
      return search(root.getRight())
    }
    if (value.compareTo(root.getData()) < 0){
      return search(root.getLeft())
    }
    if (value.compareTo(root.getData()) == 0){
      return true;
    }
  }
}
