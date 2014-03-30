package ch.grisu118.diestaemme.foundenemy.business;

import java.awt.BorderLayout;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ch.grisu118.diestaemme.foundenemy.gui.InputGUI;
import ch.grisu118.diestaemme.foundenemy.gui.MainGUI;
/**
 * This is the Class with the main Method.
 * @author Grisu118
 *
 */
public class Main_DSFoundEnemy {
    /**
     * The main method.
     * @param args what ever you want.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {

            e.printStackTrace();
        }
        MainGUI gui = new MainGUI();
        gui.setVisible(true);
        gui.getMainPanel().add(new InputGUI(), BorderLayout.CENTER);
        gui.validate();
        gui.repaint();
    }

}
