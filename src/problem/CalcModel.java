package problem;

import java.util.Iterator;
import java.util.Stack;

public class CalcModel<T>

{
  // Fields

  Stack<Double> stack;

  // Constructor

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

  // Methods

  public void operation(char oper, Double val1, Double val2)
    throws Exception
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

  public Double[] printStack()
  {
    Iterator<Double> it = this.stack.iterator();
    Double[] vals = new Double[this.stack.size()];
    for (int i = 0; it.hasNext(); i++)
      {
        vals[i] = (Double) it.next();
      } // for(i)

    return vals;
  } // printStack()

  public Double printTop()
  {
    return (Double) this.stack.peek();
  } // printTop()

  public void clear()
    throws Exception
  {
    while (!this.stack.isEmpty())
      {
        this.stack.pop();
      } // while
  } // clear()

} // class CalcModel
