package problem;

import java.io.PrintWriter;

public class ArrayBasedQueueExpt
{

  static PrintWriter pen = new PrintWriter(System.out, true);

  public static void main(String[] args)
    throws Exception
  {
    ArrayBasedQueue<Integer> q = new ArrayBasedQueue<Integer>(5);

    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    pen.println(q.isFull());
    

    pen.println(q.dequeue());
    pen.println(q.isFull());
    q.enqueue(6);
    pen.println(q.isFull());
   
  } // main (String[])

} // ArrayBasedQueueExpt
