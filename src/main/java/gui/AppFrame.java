package gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Compressor_Decompressor.Compressor;
import Compressor_Decompressor.Decompressor;

public class AppFrame extends JFrame implements ActionListener {
    /*
    ABove line defines the AppFrame class, which extends the JFrame class and implements the ActionListener interface.
     */

    JLabel label;

    JButton compressButton;
    JButton decompressButton;

    AppFrame() {



        /*
        This is the constructor of the AppFrame class,
        which sets the default close operation of the window to JFrame.EXIT_ON_CLOSE
        and sets the layout of the window to null.
         */

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        label=new JLabel();
        label.setText("Welcome to your App");

        JPanel panel = new JPanel();
        panel.add(label);
        panel.setBackground(Color.CYAN);
        panel.setBounds(20, 20, 460, 20); // set the position and size of the panel
        this.add(panel); // add the panel to the window

        JLabel bottomLabel = new JLabel("© 2023 Amit kumar. All rights reserved.");
        bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomLabel.setBounds(0, 195, 500, 15);

        // Add the bottom label to the window
        this.add(bottomLabel);


        /*
        These three lines create a new JButton object named compressButton, set its text to "Select file to Compress",
         add an ActionListener to it (in this case, the AppFrame class itself),
         and set its position and size on the window using the setBounds() method.
         */
        compressButton = new JButton("Select file to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 120, 200, 30);


        /*
        These three lines create a new JButton object named decompressButton, set its text to "Select file to Decompress",
         add an ActionListener to it (in this case, the AppFrame class itself),
         and set its position and size on the window using the setBounds() method.
         */


        decompressButton = new JButton("Select file to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(260, 120, 200, 30);

        /*
        These two lines add the compressButton and decompressButton objects to the window using the add() method.
         */

        this.add(compressButton);
        this.add(decompressButton);

        /*
        These two lines set the size of the window to 500 pixels wide and 250 pixels high,
        and set the background color of the window to black using the getContentPane() method and the setBackground() method.
         */

        this.setSize(500, 250);
        this.getContentPane().setBackground(Color.CYAN);

        Toolkit tc = getToolkit();
        Dimension size = tc.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        /*
        This line sets the visibility of the window to true, making it visible to the user.
         */
        this.setVisible(true);

    }

    
    /*
    This is the implementation of the actionPerformed() method from the ActionListener interface.
    This method is called whenever an action event (such as a button click) occurs.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            /*
            This checks whether the action event was generated by the compressButton.
            If so, it proceeds to the next block of code.
             */
            /*
            A new JFileChooser object is created,
            and its showSaveDialog() method is called to display a "Save" dialog box for the user
            to select a file to compress.
            The method returns an integer value that represents the user's response, such as whether they clicked "Save" or "Cancel".
             */
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                /*
                This block of code is executed if the user clicked the "Save" button in the file dialog box.
                 */
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                /*
                This retrieves the selected file's path using getSelectedFile() method and creates a new File object from it.
                The File object represents the file that will be compressed.
                 */
                System.out.println(file);// This prints the file path to the console.
                try {
                	Compressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {

                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                	Decompressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }
}
