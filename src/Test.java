import java.io.IOException;

public class Test
{
  public static void main(String[] args) throws IOException
  {
    Log log=Log.getLog();
    Log log1=Log.getLog();
    log.addLog("push the button");
    log1.addLog("don't push the button");
  }
}
