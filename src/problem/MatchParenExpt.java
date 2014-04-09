package problem;

public class MatchParenExpt
{

  
  public static void main(String[] args) throws Exception
  {
    String a = "{oh [boy] (I am having) (<so> much) fun matching `symbols'}";
    MatchParen.Match(a);
    String b = "(Hello (world)";
    MatchParen.Match(b);
    String c = "(Hello (world))}  ]";
    MatchParen.Match(c);
    String d = ")()(((()()";
    MatchParen.Match(d);
  } // main
}
