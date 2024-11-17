public interface BinarySearchTreeInterface<T>{
  public void clear();

  public boolean isEmpty();

  public boolean contains(T value);

  public T findMin();

  public T findMax();

  public void add(T data);

  public void delete(T data);

  public void printTree();
}
