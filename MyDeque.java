public class MyDeque<E>{
  private E[] data;
  private int size, start, end;


  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
  }
  public int size(){
    return data.length;
  }
  public String toString(){
    return "";
  }
  public void addFirst(E element){

  }
  public void addLast(E element){

  }
  public E removeFirst(){
    return null;
  }
  public E removeLast(){
    return null;
  }
  public E getFirst(){
    return null;
  }
  public E getLast(){
    return null;
  }
}
