import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;


  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = -1;
    end = -1;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = -1;
    end = -1;
  }
  public int size(){
    /* if (end > start) {
      size = (end - start) + 1;
    }
    else if (end < start) {
      size = (start - end) + 1;
    }
    else {
      size = 0;
    } */
    return size;
  }
  public String toString(){
    if (size == 0) return "{}";
    String output = "[";
    if (start <= end){
      for (int idx = start; idx < end + 1; idx++){
        output += data[idx] + ", ";
      }
    }
    else{
      for (int idx = start; idx < data.length; idx++) {
        output += data[idx] + ", ";
      }
      for (int idx = 0; idx < end + 1; idx++) {
        output += data[idx] + ", ";
      }
    }
    return output.substring(0, output.length() - 2) + "]";
  }
  public void addFirst(E element){
    if (element == null) throw new NullPointerException();
    if (size == 0) {
      start = 0;
      end = 0;
    }
    else if (size == data.length) {
      resize();
      start = data.length - 1;
    }
    else {
      start--;
      if (start < 0) start = data.length - 1;
    }
    data[start] = element;
    size++;
  }
  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    if (size == 0) {
      start = 0;
      end = 0;
    }
    else if (size == data.length) {
      resize();
      end++;
    }
    else {
      end++;
      if (end >= data.length) end = 0;
    }
    data[end] = element;
    size++;
  }
  public E removeFirst(){
    if (size == 0) throw new NoSuchElementException();
    E returner = data[start];
    data[start] = null;
    if (start == data.length - 1) {
      start = 0;
    }
    else if (size == 1){
      start = -1;
      end = -1;
    }
    else {
      start++;
    }
    size--;
    return returner;
  }
  public E removeLast(){
    if (size == 0) throw new NoSuchElementException();
    E returner = data[end];
    data[end] = null;
    size--;
    if (end == 0) {
      end = data.length - 1;
    }
    else if (size == 1) {
      end = 0;
      start = 0;
    }
    else {
      end--;
    }
    return returner;
  }
  public void resize() {
    @SuppressWarnings("unchecked")
    E[] newData = (E[]) new Object[(data.length + 1) * 2];
    int i = 0;
    if (start <= end){
      for (int idx = start; idx < end + 1; idx++){
        newData[i] = data[idx];
        i++;
      }
    }
    else{
      for (int idx = start; idx < data.length; idx++) {
        newData[i] = data[idx];
        i++;
      }
      for (int idx = 0; idx < end + 1; idx++) {
        newData[i] = data[idx];
        i++;
      }
    }
    start = 0;
    end = i - 1;
    data = newData;
  }
  public E getFirst(){
    if (size == 0) throw new NoSuchElementException();
    return data[start];
  }
  public E getLast(){
    if (size == 0) throw new NoSuchElementException();
    return data[end];
  }
}
