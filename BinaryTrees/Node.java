public class Node<T>{
  private Node<T> left;
  private Node<T> right;
  private T data;
  public Node(){
    this(null);
  }
  public Node(T data){
    this(data, null, null);
  }
  public Node(T data, Node<T> left, Node<T> right){
    this.data = data;
    this.left = left;
    this.right = right;
  }
  public T getData(){
    return data;
  }
  public Node<T> getLeft(){
    return left;
  }
  public Node<T> getRight(){
    return right;
  }
  public void setLeftNode(Node<T> node){
    this.left = node;
  }
  public void setRightNode(Node<T> node){
    this.right = node;
  }
  public void setRootData(T data){
    this.data = data;
  }
}
