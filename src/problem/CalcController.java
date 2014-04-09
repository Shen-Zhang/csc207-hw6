package problem;

public class CalcController
{
  CalcModel<Double> model;
  boolean mode = false;

  // CalcView view;

  public CalcController() throws Exception
  {
    this.model = new CalcModel<Double>();
    this.mode = true;
  } // CalcController()

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
                      }
                    else
                      throw new Exception("stack is empty!");
                  }
                else
                  throw new Exception("stack is empty!");
              }
            if (temp == 'p')
              CalcView.print(this.model.printTop());
            if (temp == 'c')
              this.model.clear();
            if (temp == 's')
              CalcView.print(this.model.printStack());
            if (temp == 'c')
              this.model.clear();
            if (temp == 'q')
              {
                CalcView.printMsg("Bye-bye!");
                this.model.clear();
                this.mode = false;
                CalcView.pen.flush();
                CalcView.eyes.close();
                CalcView.is.close();                  
              }
          } // else
      } // for (i)
  } // compute(String)

  // helper
  // http://www.coderanch.com/t/405258/java/java/String-IsNumeric
  boolean isNumeric(String str)
  {
    try
      {
        double d = Double.parseDouble(str);
      }
    catch (NumberFormatException nfe)
      {
        return false;
      }
    return true;
  } // isNumeric(String str)

} // class CalcController
