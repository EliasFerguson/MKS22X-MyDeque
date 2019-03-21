public class MyDeque<E>{
  private E[] data;
  private int size, start, end;


  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    start = 0;
    end = 0;
  }
  public int size(){
    return 0;
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
    int newEnd = end + 1;
    if (newEnd >= data.length) {
      if (data[newEnd] == null) {
        data[newEnd] = element;
        end = newEnd;
      }
      else {
        //resize();
      }
    }
    else {
      if (data[newEnd] == null) {
        data[newEnd] = element;
        end = newEnd;
      }
      else {
        //resize();
      }
    }
  }
  public E removeFirst(){
    E returner = data[start];
    data[start] = null;
    int newStart = start + 1;
    if (newStart >= data.length) {
      start = 0;
    }
    else {
      start = newStart;
    }
    return returner;
  }
  public E removeLast(){
    E returner = data[end];
    data[end] = null;
    int newEnd = end - 1;
    if (newEnd < 0) {
      end = data.length - 1;
    }
    else {
      end = newEnd;
    }
    return returner;
  }
  public void resize() {
    
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
}
