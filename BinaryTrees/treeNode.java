public class treeNode<T>{
  private treeNode<T> left;
  private treeNode<T> right;
  private T data;
  public treeNode(){
    this(null);
  }
  public treeNode(T data){
    this(data, null, null);
  }
  public treeNode(T data,treeNode<T> left, treeNode<T> right){
    this.data = data;
    this.left = left;
    this.right = right;
  }
  public T getData(){
    return data;
  }
  public treeNode<T> getLeft(){
    return left;
  }
  public treeNode<T> getRight(){
    return right;
  }
  public void setLeftNode(treeNode<T> node){
    this.left = node;
  }
  public void setRightNode(treeNode<T> node){
    this.right = node;
  }
  public void setRootData(T data){
    this.data = data;
  }
}
