package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CalcView
{
  static PrintWriter pen = new PrintWriter(System.out, true);
  static InputStreamReader is = new InputStreamReader(System.in);
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

  public static void print(Double val)
  {
    pen.println(val);
  } // print

  public static void print(Double[] vals)
  {
    pen.print("[");
    for (int i = 0; i < vals.length - 1; i++)
      {
        pen.print(vals[i] + ", ");
      } // for(i)

    pen.println(vals[vals.length - 1] + "]");
  } // print

  public static void printMsg(String str)
  {
    pen.println(str);
  } // printMsg
} // class CalcView
