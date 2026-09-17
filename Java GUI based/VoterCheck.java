import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.font.*;
import java.io.File;

public class VoterCheck {
    int width = 800;
    int height = 600;

    Color color1 = new Color(19,122,99);
    Color color2 = new Color (10,58,42);

    JFrame frame = new JFrame("Voter Eligiblity Check - By: Subhadip");
    JPanel textpanel = new JPanel();
    JLabel textlabel = new JLabel();

    JPanel textpanel1 = new JPanel();
    JLabel textlabel1 = new JLabel();

    JTextField input = new JTextField("Enter in numbers only");
    JPanel inputpanel = new JPanel();
    JButton button = new JButton("Submit");

    JPanel centerpanel = new JPanel();





    // Constructor
        VoterCheck(){
        // Frame settings
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // First panel settings
        textlabel.setLayout(new BorderLayout());
        textlabel.setBackground(color2);
        textlabel.setForeground(Color.WHITE);
        textlabel.setFont(new Font("Algerian", Font.BOLD, 50));
        textlabel.setHorizontalAlignment(JLabel.CENTER);
        textlabel.setText("Voter Eligiblity Check");
        textlabel.setOpaque(true);
        textpanel.setLayout(new BorderLayout());
        textpanel.add(textlabel);
        frame.add(textpanel, BorderLayout.NORTH);

        // Grid settings
        centerpanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = 2;

        // Age heading label
        JLabel agelabel = new JLabel("Enter your age:");
        agelabel.setFont(new Font("Arial", Font.BOLD, 50));
        agelabel.setForeground(Color.white);
        agelabel.setOpaque(true);
        agelabel.setBackground(Color.black);
        agelabel.setHorizontalAlignment(JLabel.CENTER);
        agelabel.setLayout(new BorderLayout());
        textpanel1.add(agelabel);
        
        

        // Input field settings
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JTextField ageTextField = new JTextField(10);
        ageTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        inputPanel.add(ageTextField);

        // Submit button settings
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 30));
        inputPanel.add(submitButton);

        gbc.gridy = 1;
        centerpanel.add(inputPanel, gbc);

        //Image settings
        ImageIcon eligibleIcon = new ImageIcon("eligible.png");
        ImageIcon notEligibleIcon = new ImageIcon("noteligible.png");

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridy = 2;
        centerpanel.add(imageLabel, gbc);

        frame.setVisible(true);
        frame.add(textpanel1);
        frame.add(centerpanel, BorderLayout.CENTER);


    }
    
}
