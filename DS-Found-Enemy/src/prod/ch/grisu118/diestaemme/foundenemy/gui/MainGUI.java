package ch.grisu118.diestaemme.foundenemy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainGUI extends JFrame {

    private final JPanel southPanel;
    private final JPanel mainPanel;

    private final File path = new File(System.getProperty("user.home") + File.separator + "grisu118" + File.separator
            + "DS" + File.separator + "Found-Enemy");
    private final File file = new File(path, "main.ini");

    public MainGUI() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setBounds(0, 0, 1024, 750);
        setMinimumSize(new Dimension(600, 450));
        setTitle("DS - Found enemy by Grisu118");
        addWindowListener(new OwnExitListener());

        setPosition();

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
         * @param url Is the Name of the url which should open in this format
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
            savePosition();
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

    private void setPosition() {
        BufferedReader br = null;
        if (file.exists()) {
            try {
                br = new BufferedReader(new FileReader(file));
                br.readLine();
                String[] s = new String[4];
                String delims = "[=]";
                for (int i = 0; i < 4; i++) {
                    s[i] = br.readLine();
                    String[] s1 = s[i].split(delims);
                    s[i] = s1[1];
                }
                setBounds(Integer.parseInt(s[0].trim()), Integer.parseInt(s[1].trim()), Integer.parseInt(s[3].trim()),
                        Integer.parseInt(s[2].trim()));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            this.setLocationRelativeTo(null);
            ;
        }

    }

    private void savePosition() {
        BufferedWriter bw = null;
        if (!file.exists())
            path.mkdirs();
        try {
            bw = new BufferedWriter(new FileWriter(file));

            bw.write("Copyright © Grisu118");
            bw.newLine();
            bw.write("posx=" + this.getX());
            bw.newLine();
            bw.write("posy=" + this.getY());
            bw.newLine();
            bw.write("height=" + this.getHeight());
            bw.newLine();
            bw.write("width=" + this.getWidth());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
