package problem;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Random;

import org.junit.Test;

public class ArrayBasedQueueTest
{

  /**
   * test if the program can enqueue properly.
   */
  @Test
  public void test1()
    throws Exception
  {
    ArrayBasedQueue<Integer> a = new ArrayBasedQueue<Integer>(50);
    assertEquals(a.isEmpty(), true);
    Random r = new Random();
    int n = r.nextInt(50);

    for (int x = 0; x < 50; x++)
      {
        a.enqueue(x);
      } // for(x)
    for (int y = 0; y < n; y++)
      {
        a.dequeue();
        a.enqueue(y);
      } // for(y)

    Iterator<Integer> it = a.iterator();

    for (int i = n; i < 50; i++)
      {
        assertEquals(it.next().compareTo(i) == 0, true);
      } // it.hasNext()
    for (int z = 0; z < n; z++)
      {
        assertEquals(it.next().compareTo(z) == 0, true);
      }
  } // test1()
  
  /**
   * test if the program can enqueue properly.
   */
  @Test
  public void testEnqueue()
    throws Exception
  {
    ArrayBasedQueue<Integer> b = new ArrayBasedQueue<Integer>(50);
    for (int x = 0; x < 50; x++)
      {
        b.enqueue(x);
      } // for(x)
    try
      {
        b.enqueue(1);
      } // try
    catch (Exception e)
      {
        // success
      }
  } // testEnqueue

  /**
   * test if the program can dequeue properly.
   */
  @Test
  public void testDequeue()
    throws Exception
  {
    ArrayBasedQueue<Integer> c = new ArrayBasedQueue<Integer>(50);
    for (int x = 0; x < 50; x++)
      {
        c.enqueue(x);
        c.dequeue();
      } // for(x)
    try
      {
        c.dequeue();
      } // try
    catch (Exception e)
      {
        // success
      } // try catch
  } // testDequeue()

} // class ArrayBasedQueueTest
