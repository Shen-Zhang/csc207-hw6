package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * A user interface for the calculator
 * 
 * @author Shen Zhang
 * 
 */
public class CalcView
{
  /**
   * A pen to print value, values and message.
   */
  static PrintWriter pen = new PrintWriter(System.out, true);

  /**
   * An is to read the input stream.
   */
  static InputStreamReader is = new InputStreamReader(System.in);

  /**
   * eyes to read lines
   */
  static BufferedReader eyes = new BufferedReader(is);

  public static void main(String[] args)
    throws Exception
  {
    CalcController calculator = new CalcController();

    pen.println("Welcome to the PRNCaculator!");
    pen.println("Options:");
    pen.println("p - print the top value on the stack");
    pen.println("s - print the whole stack");
    pen.println("c - clear the stack");
    pen.println("q - quit the calculator");

    String operations = eyes.readLine();
    while (calculator.mode)
      {
        calculator.compute(operations);
        if (calculator.mode)
          operations = eyes.readLine();
      } // while

  } // main

  /**
   * print a value
   * 
   * @param val
   *          a real value
   */
  public static void print(Double val)
  {
    pen.println(val);
  } // print

  /**
   * print an array of double
   * 
   * @param vals
   *          an array of double
   */
  public static void print(Double[] vals)
  {
    pen.print("[");
    for (int i = 0; i < vals.length - 1; i++)
      {
        pen.print(vals[i] + ", ");
      } // for(i)

    pen.println(vals[vals.length - 1] + "]");
  } // print

  /**
   * print a piece of message
   * 
   * @param str
   *          a valid string
   */
  public static void printMsg(String str)
  {
    pen.println(str);
  } // printMsg
} // class CalcView
