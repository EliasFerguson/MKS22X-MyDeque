import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;


  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    start = 0;
    end = 0;
  }
  public int size(){
    if (end > start) {
      size = (end - start) + 1;
    }
    else if (end < start) {
      size = (start - end) + 1;
    }
    else {
      size = 0;
    }
    return size;
  }
  public String toString(){
    if (size == 0) return "{}";
    String output = "{";
    int s = start;
    int e = end;
    while (s != e + 1) {
      output += data[s] + " ";
      s++;
      if (s == data.length) s = 0;
    }
    return output + "}";
  }
  public void addFirst(E element){
    int newStart;
    if (element == null) throw new NullPointerException();
    if (size != 0) {
      newStart = start - 1;
    }
    else {
      newStart = start;
    }
    if (newStart < 0) {
      newStart = data.length;
      if (data[newStart] == null) {
        data[newStart] = element;
        start = newStart;
      }
      else {
        resize();
        data[newStart] = element;
        start = newStart;
      }
    }
    else {
      if (data[newStart] == null) {
        data[newStart] = element;
        start = newStart;
      }
      else {
        resize();
        data[newStart] = element;
        start = newStart;
      }
    }
    size++;
  }
  public void addLast(E element){
    int newEnd;
    if (end == start) {
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
    int newStart = start + 1;
    if (newStart >= data.length) {
      start = 0;
    }
    else {
      start = newStart;
    }
    size--;
    return returner;
  }
  public E removeLast(){
    if (size == 0) throw new NoSuchElementException();
    E returner = data[end];
    data[end] = null;
    int newEnd = end - 1;
    if (newEnd < 0) {
      end = data.length - 1;
    }
    else {
      end = newEnd;
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
      if (s == data.length) s = 0;
    }
    start = 0;
    end = i;
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
