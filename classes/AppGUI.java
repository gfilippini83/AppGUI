import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.*;
import javax.swing.*;

public class AppGUI {

	private static Image getScaledImage(Image srcImg, int w, int h){
    		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    		Graphics2D g2 = resizedImg.createGraphics();

    		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    		g2.drawImage(srcImg, 0, 0, w, h, null);
   			g2.dispose();

    		return resizedImg;
	}


	public static void main(String[] args) {
		try {
			CommandMap cmap = new CommandMap();

			Image aImage = getScaledImage(ImageIO.read(new File("../images/atom_image.png")), 20, 20);
			Image pImage = getScaledImage(ImageIO.read(new File("../images/pokerstars_image.png")), 20, 20);
			Image cImage = getScaledImage(ImageIO.read(new File("../images/chrome_image.png")), 20, 20);
			Image fImage = getScaledImage(ImageIO.read(new File("../images/fortnite_image.png")), 20, 20);
			Image auImage = getScaledImage(ImageIO.read(new File("../images/audacity_image.png")), 20, 20);

			ImageIcon atomImage = new ImageIcon(aImage);
			ImageIcon pokerstarsImage = new ImageIcon(pImage);
			ImageIcon chromeImage = new ImageIcon(cImage);
			ImageIcon fortniteImage = new ImageIcon(fImage);
			ImageIcon audacityImage = new ImageIcon(auImage);

			JFrame frame = new JFrame("Application Launcher");
			JPanel panel = new JPanel();
			frame.setSize(250, 250);
			frame.setLocation(300, 300);
			frame.getContentPane().add(panel)
			;
			JButton atom = new JButton("Atom", atomImage);
			JButton pokerstars = new JButton("Pokerstars", pokerstarsImage);
			JButton chrome = new JButton("Chrome", chromeImage);
			JButton fortnite = new JButton("Fortnite", fortniteImage);
			JButton audacity = new JButton("Audacity", audacityImage);

			atom.setVerticalTextPosition(AbstractButton.CENTER);
    	atom.setHorizontalTextPosition(AbstractButton.LEADING);
			chrome.setVerticalTextPosition(AbstractButton.CENTER);
    	chrome.setHorizontalTextPosition(AbstractButton.LEADING);

			atom.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					cmap.launchCommand(cmap.getCommand("atom"));
				}
			});
			pokerstars.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					cmap.launchCommand(cmap.getCommand("pokerstars"));
				}
			});
			chrome.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					cmap.launchCommand(cmap.getCommand("chrome"));
				}
			});
			fortnite.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					cmap.launchCommand(cmap.getCommand("fortnite"));
				}
			});
      Image spoImage = getScaledImage(ImageIO.read(new File("../images/spotify_image.png")), 20, 20);
      ImageIcon spotifyImage = new ImageIcon(spoImage);
      JButton spotify= new JButton("Spotify", spotifyImage);
      spotify.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
          cmap.launchCommand(cmap.getCommand("spotify"));
        }
      });
      panel.add(spotify);
			audacity.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					cmap.launchCommand(cmap.getCommand("audacity"));
				}
			});

			panel.add(atom);
			panel.add(audacity);
			panel.add(chrome);
			panel.add(fortnite);
			panel.add(pokerstars);

			frame.setLocationRelativeTo(null);
	    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		} catch (Exception e) {
			System.out.println(e);
		}


	}
}
