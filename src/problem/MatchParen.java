package problem;

import java.io.PrintWriter;

public class MatchParen
{

  static PrintWriter pen = new PrintWriter(System.out, true);

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
        pen.format(format, x.ch + "<-UNMATCHED");
        pen.println();
      } // while
    
    pen.println();
    pen.flush();
  } // Match(String)

  // inner class
  static class group
  {
    int index;
    char ch;

    public group(char ch, int index)
    {
      this.ch = ch;
      this.index = index;
    } // group (char ch, int index)

  }// class group

  // helper
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
            int length = index - checkMatch.index - 1;
            format = "%" + (checkMatch.index + 1) + "s";
            pen.format(format, open);
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
            pen.format(format, close + "<-UNMATCHED");
            pen.println();
          } // if
      }
    else
      {
        format = "%" + (1 + index + "<-UNMATCHED".length()) + "s";
        pen.format(format, close + "<-UNMATCHED");
        pen.println();
      }
  } // drawLine
} // class MatchParen

