package problem;

import java.io.PrintWriter;

public class MatchParen
{

  /**
   * A pen to print result and messages
   */
  static PrintWriter pen = new PrintWriter(System.out, true);

  /**
   * Check if the parentheses/brackets in the string are matched and print the
   * result
   * 
   * @param str
   *          A valid string
   * @throws Exception
   */
  public static void Match(String str)
    throws Exception
  {

    ArrayBasedStack<group> stack = new ArrayBasedStack<group>(str.length());
    pen.println(str);
    for (int i = 0; i < str.length(); i++)
      {
        char x = str.charAt(i);
        if (x == '(' || x == '[' || x == '`' || x == '<' || x == '{')
          {
            group a = new group(x, i);
            stack.push(a);
          } // if
        else
          {
            switch (x)
              {
                case ')':
                  drawLine(stack, '(', ')', i);
                  break;
                case '}':
                  drawLine(stack, '{', '}', i);
                  break;
                case '>':
                  drawLine(stack, '<', '>', i);
                  break;
                case ']':
                  drawLine(stack, '[', ']', i);
                  break;
                case '\'':
                  drawLine(stack, '`', '\'', i);
                  break;
              } // switch
          } // else
      } // for (i)
    while (!stack.isEmpty())
      {
        group x = stack.pop();
        String format = "%" + (1 + x.index + "<-UNMATCHED".length()) + "s";
        pen.format(format, x.ch + "<-UNMATCHED"); // format the string
        pen.println();
      } // while

    pen.println();
    pen.flush();
  } // Match (String)

  // +-------------+---------------------------------------------------------
  // | Inner Class |
  // +-------------+
  static class group
  {
    // +--------+---------------------------------------------------------
    // | Fields |
    // +--------+
    int index;
    char ch;

    // +-------------+---------------------------------------------------------
    // | Constructor |
    // +-------------+
    public group(char ch, int index)
    {
      this.ch = ch;
      this.index = index;
    } // group (char ch, int index)

  }// class group

  // +--------+---------------------------------------------------------
  // | Helper |
  // +--------+
  /**
   * A helper for drawing lines
   * 
   * @param stack
   *          A valid stack
   * @param open
   *          open parenthesis/bracket
   * @param close
   *          closed parenthesis/bracket
   * @param index
   *          an integer
   * @throws Exception
   */
  public static void drawLine(ArrayBasedStack<group> stack, char open,
                              char close, int index)
    throws Exception
  {
    String format;
    group checkMatch;

    if (!stack.isEmpty())
      {
        checkMatch = stack.peek();

        if (checkMatch.ch == open)
          {
            int length = index - checkMatch.index - 1; // the length of the line
            format = "%" + (checkMatch.index + 1) + "s";
            pen.format(format, open); // format the string
            for (int i = 0; i < length; i++)
              {
                pen.print('-');
              } // for (i)
            pen.println(close);
            stack.pop();
          } // checkMatch.ch = open
        else
          {
            format = "%" + (1 + index + "<-UNMATCHED".length()) + "s";
            pen.format(format, close + "<-UNMATCHED"); // format the string
            pen.println();
          } // if
      } // if
    else
      {
        format = "%" + (1 + index + "<-UNMATCHED".length()) + "s";
        pen.format(format, close + "<-UNMATCHED"); // format the string
        pen.println();
      } // else
  } // drawLine
} // class MatchParen

