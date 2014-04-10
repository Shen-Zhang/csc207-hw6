package problem;

public class CalcController
{
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * A model to do computation and store values
   */
  CalcModel<Double> model;
  /**
   * A boolean flag to determine if the calculator is on
   */
  boolean mode = false;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  public CalcController() throws Exception
  {
    this.model = new CalcModel<Double>();
    this.mode = true;
  } // CalcController()

  // +---------+----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * compute a given operation
   * 
   * @param str
   *          a valid string
   * @throws Exception
   */
  public void compute(String str)
    throws Exception
  {
    String[] tokens = str.split(" ");

    for (int i = 0; i < tokens.length; i++)
      {

        if (isNumeric(tokens[i]))
          this.model.push(Double.parseDouble(tokens[i]));
        else
          {
            char temp = tokens[i].charAt(0);
            if (temp == '+' || temp == '-' || temp == '*' || temp == '/')
              {
                double val1;
                double val2;
                if (!this.model.isEmpty())
                  {
                    val2 = this.model.pop();
                    if (!this.model.isEmpty())
                      {
                        val1 = this.model.pop();
                        this.model.operation(temp, val1, val2);
                        // uses model to do the algebra
                      } // if !this.model.isEmpty()
                    else
                      {
                        this.model.push(val2);
                        // if val1 doesn't exist, put val2 back
                        CalcView.printMsg("stack is empty!");
                      }
                  } // !this.model.isEmpty()
                else
                  CalcView.printMsg("stack is empty!");
              } // if temp == '+' || temp == '-' || temp == '*' || temp == '/'
            else
              {
                switch (temp)
                  {
                    case 'p':
                      try
                        {
                          CalcView.print(this.model.printTop());
                        } // try
                      catch (NullPointerException npe)
                        {
                          CalcView.printMsg("stack is empty");
                        } // catch
                      break;
                    case 'c':
                      this.model.clear();
                      break;
                    case 's':
                      try
                        {
                          CalcView.print(this.model.printStack());
                        } // try
                      catch (NullPointerException npe)
                        {
                          CalcView.printMsg("stack is empty");
                        } // catch
                      break;
                    case 'q':
                      CalcView.printMsg("Bye-bye!");
                      this.model.clear();
                      this.mode = false;
                      CalcView.pen.flush();
                      CalcView.eyes.close();
                      CalcView.is.close();
                      break;
                    default:
                      CalcView.printMsg("invalid input");
                  } // switch (temp)
              } // else
          } // if
      } // for (i)
  }// compute(String)

  // +--------+----------------------------------------------------------
  // | Helper |
  // +--------+

  /**
   * A helper to determine if a string is purely numeric.This method is copied
   * and changed from:
   * http://www.coderanch.com/t/405258/java/java/String-IsNumeric
   * 
   * @param str
   *          A valid string
   * @return true, if the string is purely numeric. Vice versa.
   */

  boolean isNumeric(String str)
  {
    try
      {
        Double.parseDouble(str);
      } // try
    catch (NumberFormatException nfe)
      {
        return false;
      } // catch
    return true;
  } // isNumeric(String str)

} // class CalcController
