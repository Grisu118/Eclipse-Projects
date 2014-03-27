package ch.grisu118.diestämme.foundenemy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

	private final JPanel southPanel;
	private final JPanel mainPanel;

	public MainGUI() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 1024, 750);
		setMinimumSize(new Dimension(600, 450));
		setTitle("DS - Found enemy by Grisu118");
		addWindowListener(new OwnExitListener());

		getContentPane().setLayout(new BorderLayout());

		mainPanel = new JPanel();

		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout(0, 0));
		mainPanel.add(southPanel, BorderLayout.SOUTH);

		JLabel copyright = new JLabel("Copyright © Grisu118");
		copyright.setFont(new Font("Arial", Font.BOLD, 14));
		southPanel.add(copyright, BorderLayout.EAST);
		
		JLabel website = new JLabel("http://grisu118.ch");
		website.setFont(new Font("Arial", Font.BOLD, 14));
		southPanel.add(website, BorderLayout.WEST);
		
		website.addMouseListener(new OwnMouseEvent(website));
		copyright.addMouseListener(new OwnMouseEvent(copyright));

	}

	public JPanel getSouthPanel() {
		return this.southPanel;
	}
	
	public JPanel getMainPanel() {
		return this.mainPanel;
	}
	
	private class OwnMouseEvent implements MouseListener {
		
		JLabel label;
		Color color;
		
		public OwnMouseEvent(JLabel label) {
			this.label = label;
			this.color = label.getForeground();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			openURL("http://grisu118.ch");
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			label.setForeground(Color.BLUE);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			label.setForeground(color);
			
		}
		
		/**
		 * Opens a URL in the Webbrowser
		 * 
		 * @param url
		 *            Is the Name of the url which should open in this format
		 *            "http://www.website.ch"
		 */

		public void openURL(String url) {
			try {
				Desktop.getDesktop().browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	private class OwnExitListener implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {
			
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			
			
		}
		
	}

}
