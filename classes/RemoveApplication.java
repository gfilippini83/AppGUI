import java.util.*;
import java.io.*;

class RemoveApplication {

  public RemoveApplication(String app_name) {
    delete_app_gui(app_name);
    delete_command_map(app_name);
  }

  public void delete_app_gui(String app_name) {

    try {
      File inputFile = new File("C:\\Users\\Garrett\\Desktop\\AppGUI\\classes\\AppGUI.java");
      File tempFile = new File("C:\\Users\\Garrett\\Desktop\\AppGUI\\classes\\TempAppGUI.java");

      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

      String currentLine;
      boolean skip = false;
      int count = 0;
      while((currentLine = reader.readLine()) != null) {
          // trim newline when comparing with lineToRemove
          String trimmedLine = currentLine.trim();
          if(skip) {
            if(count > 6) {
              skip = false;
            }
            count += 1;
          } else {
            if(trimmedLine.contains(app_name)) {
              skip = true;
            } else{
              writer.write(currentLine + System.getProperty("line.separator"));
            }
          }

      }
      writer.close();
      reader.close();
      inputFile.delete();
      File trueName = new File("AppGUI.java");
      boolean successful = tempFile.renameTo(trueName);
      System.out.println(successful);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void delete_command_map(String app_name) {
    try{
      File inputFile = new File("C:\\Users\\Garrett\\Desktop\\AppGUI\\classes\\CommandMap.java");
      File tempFile = new File("C:\\Users\\Garrett\\Desktop\\AppGUI\\classes\\TempCommandMap.java");

      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

      String currentLine;

      while((currentLine = reader.readLine()) != null) {
        // trim newline when comparing with lineToRemove
        String trimmedLine = currentLine.trim();
        if(trimmedLine.contains(app_name)) continue;
        writer.write(currentLine + System.getProperty("line.separator"));
      }
      writer.close();
      reader.close();
      inputFile.delete();
      File trueName = new File("CommandMap.java");
      boolean successful = tempFile.renameTo(trueName);
      System.out.println(successful);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("What application would you like to delete?");
    String app_name = scan.next();
    RemoveApplication ra = new RemoveApplication(app_name);
  }
}
