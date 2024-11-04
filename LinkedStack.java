public class LinkedStack<T>{
  
}
class Node<T>{
  Node next;
  T data;
  public Node(T data){
    this.data = data;
    this.next = null;
  }
  public Node(T data, Node<T> next){
    this.data = data;
    this.next = next;
  }
}
