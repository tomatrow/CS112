// TestScoreReader.java
// The TestScoreReader class reads test scores as
// tokens from a file and calculates the average
// of each line of scores.

import java.io.*;         // For File and IOException
import java.util.StringTokenizer;

public class TestScoreReader
{
   private FileReader freader;
   private BufferedReader inputFile;
   private String line;
   
   // The constructor opens a file named by the
   // filename parameter      
   public TestScoreReader(String filename) throws IOException
   {
      freader = new FileReader(filename);
      inputFile = new BufferedReader(freader);
   }
   
   // The readNextLine method reads the next line
   // from the file. If a line was read, the method
   // returns true. Otherwise it returns false.
   public boolean readNextLine() throws IOException
   {
      boolean lineRead; // Flag variable indicating successful read
    
      // Get the next line from the file
      line = inputFile.readLine();

      // Determine whether a line was successfully read
      if (line!= null)
        lineRead = true;
      else
        lineRead = false;
        
      // Return status of the read operation 
      return lineRead;
   }

   // The getAverage method calculates the average
   // of the last set of test scores read from the file.
   public double getAverage()
   {
      String testToken; // To hold a test score token
      int total = 0,    // Accumulator
          count = 0;    // To hold the number of test scores
      double average;   // To hold the average test score

      // Tokenize the last line read from the file.
      StringTokenizer tokenizer = new StringTokenizer(line, ",");
    
      // Calculate the total of the test scores.
      while (tokenizer.hasMoreTokens())
      {
         // Get the next token
         testToken = tokenizer.nextToken();
         
         // Convert it to an int and accumulate it
         total += Integer.parseInt(testToken);
         
         // Increment the count of test scores
         count++;
      }
    
      // Calculate the average of the test scores.
      // Use a cast to avoid integer division.
      average = (double) total / count;
    
      // Return the average.
      return average;
   }
   
   // The close method closes the file.   
   public void close() throws IOException
   {
      inputFile.close();
   }
}