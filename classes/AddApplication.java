import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;

public class AddApplication {

  public AddApplication(String newName, String newPath) {
    
    addToPanel(newName);
    addActionListener(newName);
    addButtonName(newName);
    addImageIcon(newName);
    addImage(newName);
    addMapLine(newName, newPath);
  }

  public void addMapLine(String newName, String newPath) {
    try {
      //Change Path
      Path path = Paths.get("CommandMap.java");
      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      int position = 11;
      String mapLine = "    commands.put(\"" + newName + "\", new File(\"" + newPath + "\"));";
      lines.add(position, mapLine);
      Files.write(path, lines, StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void addImage(String newName){
    try {
      Path path = Paths.get("DesktopGUI.java");
      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      int position = 75;
      String imageLine = "      Image " + newName.substring(0,3) +"Image = getScaledImage(ImageIO.read(new File(\"../images/" + newName + "_image.png\")), 20, 20);";
      lines.add(position, imageLine);
      Files.write(path, lines, StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void addImageIcon(String newName) {
    try {
      Path path = Paths.get("DesktopGUI.java");
      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      int position = 75;
      String imageIconLine = "      ImageIcon " + newName + "Image = new ImageIcon(" + newName.substring(0,3) + "Image);";
      lines.add(position, imageIconLine);
      Files.write(path, lines, StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void addButtonName(String newName) {
    try {
      Path path = Paths.get("DesktopGUI.java");
      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      int position = 75;
      String buttonNameLine = "      JButton " + newName + "= new JButton(\"" + newName.substring(0,1).toUpperCase() + newName.substring(1) + "\", " + newName + "Image);";
      lines.add(position, buttonNameLine);
      Files.write(path, lines, StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void addActionListener(String newName) {
    try {
      Path path = Paths.get("DesktopGUI.java");
      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      int position = 75;
      String actionListenerLine = "      " + newName + ".addActionListener(new ActionListener() {\n        @Override public void actionPerformed(ActionEvent e) {\n          cmap.launchCommand(cmap.getCommand(\"" + newName + "\"));\n        }\n      });";
      lines.add(position, actionListenerLine);
      Files.write(path, lines, StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public void addToPanel(String newName) {
    try {
      Path path = Paths.get("DesktopGUI.java");
      List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      int position = 75;
      String panelLine = "      panel.add("+ newName + ");";
      lines.add(position, panelLine);
      Files.write(path, lines, StandardCharsets.UTF_8);
    } catch (Exception e) {
      System.out.println(e);
    }
  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Give me an application name: ");
    String appName = scan.next();
    System.out.println("Give me a path with two backslashes: ");
    String newPath = scan.next();
    AddApplication addApp = new AddApplication(appName, newPath);

  }

}
