package westernjava;

import java.io.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author ISEN
 */
public class Log {

      /**
       *
       */
      protected static String defaultLogFile = "c:\\msglog.txt";

      /**
       *
       * @param s
       * @throws IOException
       */
      public static void write(String s) throws IOException {
            write(defaultLogFile, s);
      }

      /**
       *
       * @param f
       * @param s
       * @throws IOException
       */
      public static void write(String f, String s) throws IOException {
            TimeZone tz = TimeZone.getTimeZone("EST"); // or PST, MID, etc ...
            Date now = new Date();
            DateFormat df = new SimpleDateFormat("yyyy.mm.dd hh:mm:ss ");
            df.setTimeZone(tz);
            String currentTime = df.format(now);

            try (FileWriter aWriter = new FileWriter(f, true)) {
                  aWriter.write(currentTime + " " + s + "\n");
                  aWriter.flush();
            }
      }

}
