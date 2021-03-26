import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Log
{
  private BufferedWriter out;
  private static Log log;
  private static Object lock=new Object();

  private Log() throws IOException
  {
    File logFile = new File("Log.txt");
    this.out = new BufferedWriter(new FileWriter(logFile, true));
  }
  public static Log getLog() throws IOException
  {
    if(log==null)
    {
      synchronized (lock)
      {
        if(log==null)
        {
          log=new Log();
        }
      }
    }
    return log;
  }
  public void addLog(String log)
  {
    LogLine logLine = new LogLine(log);
    addToFile(logLine);
    System.out.println(logLine);
  }

  private synchronized void addToFile(LogLine log)
  {
    if (log == null)
    {
      return;
    }
    BufferedWriter out = null;
    try
    {
      File logFile = new File("Log.txt");
      out = new BufferedWriter(new FileWriter(logFile, true));
      out.write(log + "\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        out.close();
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
