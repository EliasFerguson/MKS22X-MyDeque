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
    String output = "{";
    int s = start;
    int e = end;
    while (s != e) {
      output += data[s] + " ";
      s++;
      if (s == data.length) s = 0;
    }
    return output + "}";
  }
  public void addFirst(E element){
    if (element == null) throw new NullPointerException();
    int newStart;
    if (size == 0) {
      start = 0;
      end = 0;
      newStart = 0;
    }
    else if (size == data.length) {
      resize();
      newStart = data.length - 1;
    }
    else {
      newStart = start - 1;
      if (newStart < 0) newStart = data.length - 1;
    }
    data[newStart] = element;
    start = newStart;
    size++;
  }
  public void addLast(E element){
    if (element == null) throw new NullPointerException();
    int newEnd;
    if (size == 0) {
      start = 0;
      end = 0;
      newEnd = 0;
    }
    else if (size == data.length) {
      resize();
      newEnd = end + 1;
    }
    else {
      newEnd = end + 1;
      if (newEnd >= data.length) newEnd = 0;
    }
    data[newEnd] = element;
    end = newEnd;
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
    size--;
    return returner;
  }
  public void resize() {
    @SuppressWarnings("unchecked")
    E[] newData = (E[]) new Object[(data.length + 1) * 2];
    int s = start;
    int e = end;
    int i = 0;
    while (s != e + 1) {
      newData[i] = data[s];
      s++;
      i++;
      if (s == data.length - 1) s = 0;
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
