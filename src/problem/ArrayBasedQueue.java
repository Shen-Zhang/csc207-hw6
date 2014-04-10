package problem;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queues implemented with arrays.
 * 
 * @author Samuel A. Rebelsky
 * @author Shen Zhang
 */
public class ArrayBasedQueue<T>
    implements
      Queue<T>
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The values stored in the queue.
   */
  T[] values;

  /**
   * The index of the front of the queue.
   */
  int front;

  /**
   * The index of the last element of the queue.
   */
  int back;

  /**
   * The number of elements in the queue.
   */
  int size;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new queue that holds up to capacity elements.
   */
  @SuppressWarnings({ "unchecked" })
  // Handle array casting
  public ArrayBasedQueue(int capacity) throws Exception
  {
    if (capacity <= 0)
      {
        throw new Exception("Queues must have a positive capacity.");
      } // if (capacity <= 0)
    // Yay Java! It's not possible to say new T[capacity], so
    // we use this hack.
    this.values = (T[]) new Object[capacity];
    this.front = 0;
    this.back = -1;
    this.size = 0;
  } // ArayBasedQueue(int capacity)

  // +---------------+---------------------------------------------------
  // | Queue Methods |
  // +---------------+

  @Override
  public boolean isEmpty()
  {
    return this.size <= 0;
  } // isEmpty()

  @Override
  public boolean isFull()
  {
    return this.size >= this.values.length;
  } // isFull()

  @Override
  public void put(T val)
    throws Exception
  {
    if (this.isFull())
      {
        throw new Exception("no more room!");
      } // this.isFull()
    this.back = (this.back + 1) % this.values.length;
    this.values[this.back] = val;
    ++this.size;
  } // put(T)

  @Override
  public T get()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    // Grab and clear the element at the front of the queue
    T result = this.values[this.front];
    this.values[this.front] = null;
    this.front = (this.front + 1) % this.values.length;

    // We're removing an element, so decrement the size
    --this.size;
    // And we're done
    return result;
  } // get(T)

  @Override
  public T peek()
    throws Exception
  {
    if (this.isEmpty())
      {
        throw new Exception("empty");
      } // if empty
    return this.values[this.front];
  } // peek()

  @Override
  public T dequeue()
    throws Exception
  {
    return this.get();
  } // dequeue

  @Override
  public void enqueue(T val)
    throws Exception
  {
    this.put(val);
  } // enqueue

  @Override
  public Iterator<T> iterator()
  {
    return new ArrayBasedQueueIterator<T>(this);
  } // iterator()


} // class ArrayBasedQueue<T>

class ArrayBasedQueueIterator<T>
    implements
      Iterator<T>
{
  // +--------+----------------------------------------------------------
  int front;
  int prev;
  int size;
  T[] vals;
  int count;
  boolean okToRemove;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new iterator.
   */
  public ArrayBasedQueueIterator(ArrayBasedQueue<T> q)
  {
    this.front = q.front;
    this.prev = 0;
    this.size = q.size;
    this.vals = q.values;
    this.count = 0;
    okToRemove = false;
  } // ArrayBasedQueueIterator

  // +---------+---------------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public T next()
    throws NoSuchElementException
  {
    if (!this.hasNext())
      {
        throw new NoSuchElementException("no elements remain");
      } // if no elements
    okToRemove = true;
    int temp = this.front;
    this.prev = this.front;
    this.front = (this.front + 1) % this.size;
    this.count++;
    return this.vals[temp];
    
  } // next()

  @Override
  public boolean hasNext()
  {
    okToRemove = false;
    return this.count < this.size;
  } // hasNext()

  @Override
  public void remove()
    throws IllegalStateException
  {
    if (okToRemove)
      this.vals[this.prev] = null;
    else
      throw new IllegalStateException();
  } // remove()
} // ArrayBasedQueueIterator<T>