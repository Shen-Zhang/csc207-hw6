package problem;

import java.util.Iterator;
import java.util.Stack;

/**
 * A model to do the algebra and store values.
 * 
 * @author Shen Zhang
 * 
 */
public class CalcModel<T>

{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stack to store results and operations
   */
  Stack<Double> stack;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  public CalcModel() throws Exception
  {
    this.stack = new Stack<Double>();

  } // CalcModel(String operations)

  public void push(double x)
    throws Exception
  {
    this.stack.push(x);
  } // push

  public boolean isEmpty()
    throws Exception
  {
    return this.stack.isEmpty();
  } // isEmpty()

  public double pop()
    throws Exception
  {
    return (Double) this.stack.pop();
  }

  // +---------+---------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * 
   * Compute val1 and val2 by given operation
   * 
   * @param oper
   *          oper can only be '+', '-', '*' or '/'
   * @param val1
   *          a real number
   * @param val2
   *          a real number
   */
  public void operation(char oper, Double val1, Double val2)
  {
    switch (oper)
      {
        case '+':
          this.stack.push(val1 + val2);
          break;
        case '-':
          this.stack.push(val1 - val2);
          break;
        case '*':
          this.stack.push(val1 * val2);
          break;
        case '/':
          this.stack.push(val1 / val2);
          break;
      } // switch
  } // compute(String, Double, Double)

  /**
   * Print the current stack
   * 
   * @return an array of double
   * @throws NullPointerException
   */
  public Double[] printStack()
    throws NullPointerException
  {
    if (this.stack.isEmpty())
      throw new NullPointerException();
    else
      {
        Iterator<Double> it = this.stack.iterator();
        Double[] vals = new Double[this.stack.size()];
        for (int i = 0; it.hasNext(); i++)
          {
            vals[i] = (Double) it.next();
          } // for(i)
        return vals;
      }
  } // printStack()

  /**
   * Print the top value on the stack
   * 
   * @return a double
   * @throws NullPointerException
   */
  public Double printTop()
    throws NullPointerException
  {
    if (!this.stack.isEmpty())
      return (Double) this.stack.peek();
    else
      throw new NullPointerException();
  } // printTop()

  /**
   * remove all the items on the current stack
   * 
   * @throws Exception
   */
  public void clear()
    throws Exception
  {
    while (!this.stack.isEmpty())
      {
        this.stack.pop();
      } // while
  } // clear()

} // class CalcModel
