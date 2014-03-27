package ch.grisu118.diestämme.foundenemy.business;

import java.awt.BorderLayout;

import ch.grisu118.diestämme.foundenemy.gui.InputGUI;
import ch.grisu118.diestämme.foundenemy.gui.MainGUI;

public class Main_DSFoundEnemy {

	public static void main(String[] args) {
		MainGUI gui = new MainGUI();
		gui.setVisible(true);
		gui.getMainPanel().add(new InputGUI(), BorderLayout.CENTER);
		gui.validate();
		gui.repaint();
	}

}
