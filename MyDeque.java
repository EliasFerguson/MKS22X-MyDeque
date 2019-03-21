public class MyDeque<E>{
  private E[] data;
  private int size, start, end;


  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    size = 10;
    data = d;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    size = initialCapacity;
    data = d;
    start = 0;
    end = 0;
  }
  public int size(){
    return data.length;
  }
  public String toString(){
    String output = "";

    return output;
  }
  public void addFirst(E element){
    int newStart = start - 1;
    if (newStart < 0) {
      newStart = data.length;
      if (data[newStart] == null) {
        data[newStart] = element;
        start = newStart;
      }
      else {
        //resize();
      }
    }
    else {
      if (data[newStart] == null) {
        data[newStart] = element;
        start = newStart;
      }
      else {
        //resize();
      }
    }
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
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
}
