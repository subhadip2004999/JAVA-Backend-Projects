import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {
    // Set size of the calculator window
    int width = 500;
    int height =750;

    // Set colors for the calculator
    Color teal = new Color(34, 66, 72);
    Color yellow = new Color(253, 187, 119);
    Color orange = new Color(231, 111, 81);
    Color beige = new Color(253, 240, 213);

    JFrame frame = new JFrame("Calculator - By: Subhadip");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JPanel buttonpanel = new JPanel();

    // ArrayList to store the values of the buttons on the calculator
    // Set the values for the buttons on the calculator
    String[] buttonvalues = {
            "AC", "+/-", "%", " ←",
            "7", "8", "9", "÷",
            "4", "5", "6", "×",
            "1", "2", "3", "+",
            ".", "0", "=", "−"
        };

    // Set the values for the right side buttons on the calculator
    String[] rightsymbols = {"÷", "×", "−", "+", "="};

    // Set the values for the top buttons on the calculator
    String[] topsymbols = {"AC", "+/-", "%"};

    String backspace = " ←";


    // A+B, A-B, A*B, A/B, A^B, √A, 1/A
    String A = "0";
    String operator = null;
    String B = null;

    
    Calculator(){
        // Set frame properties
        frame.setSize(width, height);// Set the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Set the default close operation to exit the application when the frame is closed
        frame.setResizable(true);// Set the frame to be non-resizable
        frame.setLocationRelativeTo(null);// Set the frame to be centered on the screen
        frame.setLayout(new BorderLayout());// Set the layout of the frame to BorderLayout


        // Set label properties
        label.setBackground(Color.BLACK);// Set the background color of the label to black
        label.setForeground(Color.WHITE);// Set the foreground color of the label to yellow
        label.setFont(new Font("Arial", Font.PLAIN, 100));// Set the font of the label to Arial, bold, size 80
        label.setHorizontalAlignment(JLabel.RIGHT);// Set the horizontal alignment of the label to right
        label.setText("0");// Set the text of the label
        label.setOpaque(true); // Set the label to be opaque so that the background color is visible


        // Set panel properties
        panel.setLayout(new BorderLayout());// Set the layout of the panel to BorderLayout


        // Set label inside the panel
        panel.add(label);
        // Set panel inside the frame(window)
        frame.add(panel, BorderLayout.NORTH);


        // Set button properties
        buttonpanel.setLayout(new GridLayout(5, 4, 2, 2));// Set the layout of the button panel to GridLayout with 5 rows, 4 columns, and 10 pixels of horizontal and vertical gaps
        buttonpanel.setBackground(Color.BLACK);// Set the background color of the button panel to black
        frame.add(buttonpanel);


        // Create buttons and add them to the button panel
        for (int i=0; i < buttonvalues.length; i++){
            JButton button = new JButton();
            // Set the value of the button to the corresponding value in the buttonvalues array
            String buttonvalue = buttonvalues[i];
            button.setFont(new Font("Funky", Font.BOLD, 58));
            // Set Rightbutton font to Arial, bold, size 50
            if (Arrays.asList(rightsymbols).contains(buttonvalue)){
                button.setFont(new Font("Arial", Font.BOLD, 60));
            }
            
            // Set the border of the button to a line border with a thickness of 1 pixel and a color of black
            button.setText(buttonvalue);
            // Remove the focus from the button so that it does not have a square box around it when clicked
            button.setFocusable(false);
            buttonpanel.add(button);

            // Set the background color of the button to beige if it is a top button
            if (Arrays.asList(topsymbols).contains(buttonvalue)){
                button.setBackground(Color.lightGray);// Set the background color of the button to beige
                button.setForeground(Color.BLACK);// Set the Text color of the button to white
            }

            else if (buttonvalue == "="){
                button.setBackground(Color.LIGHT_GRAY);// Set the background color of the button to teal
                button.setForeground(Color.BLACK);// Set the Text color of the button to white
            }

            // Set the background color of the button to yellow if it is a right side button
            else if (Arrays.asList(rightsymbols).contains(buttonvalue)){
                button.setBackground(yellow);// Set the background color of the button to yellow
                button.setForeground(Color.WHITE);// Set the Text color of the button to white
            }
            // Set the background color of the button to teal if it is a number button
            else if (buttonvalue == backspace){
                button.setBackground(orange);// Set the button color 
                button.setForeground(Color.WHITE);// Set the Text color 
            }

            else {
                button.setBackground(Color.GRAY);// Set the button color 
                button.setForeground(Color.WHITE);// Set the Text color 
            }

            buttonpanel.add(button);

            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                   JButton source = (JButton)e.getSource();
                   String buttonvalue = source.getText();


                   if(Arrays.asList(topsymbols).contains(buttonvalue)){
                       if (buttonvalue == "AC"){
                           clearAll();
                           label.setText("0");
                       }
                       else if (buttonvalue == "+/-"){
                           double numDisplay = Double.parseDouble(label.getText());
                           numDisplay *= -1;
                           label.setText(removeZeroDecimal(numDisplay));

                       }
                       else if (buttonvalue == "%"){
                           double numDisplay = Double.parseDouble(label.getText());
                           numDisplay /= 100;
                           label.setText(removeZeroDecimal(numDisplay));
                       }
                   }

                   else if (buttonvalue == backspace){
                           delete();
                   }

                   else if (Arrays.asList(rightsymbols).contains(buttonvalue)){
                          if (buttonvalue == "="){
                            if (A!= null){
                                B = label.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);

                                if (operator == "+"){
                                    double result = numA + numB;
                                    label.setText(removeZeroDecimal(result));
                                }
                                else if (operator == "−"){
                                    double result = numA - numB;
                                    label.setText(removeZeroDecimal(result));
                                }
                                else if (operator == "×"){
                                    double result = numA * numB;
                                    label.setText(removeZeroDecimal(result));
                                }
                                else if (operator == "÷"){
                                    double result = numA / numB;
                                    label.setText(removeZeroDecimal(result));
                                }
                                clearAll();

                                
                            }

                        }
                        else if ("+−×÷".contains(buttonvalue)){
                            if (operator == null){
                                A = label.getText();
                                label.setText("0");
                                B = "0";                               
                            }
                            operator = buttonvalue;                            
                        }


                   }
                   else {
                       if (buttonvalue == "."){
                        if (!label.getText().contains(".")){
                            label.setText(label.getText() + buttonvalue);
                        }

                    }
                       
                       else if ("1234567890".contains(buttonvalue)){
                            if (label.getText()=="0"){
                                label.setText(buttonvalue);
                            }
                            else {
                                label.setText(label.getText() + buttonvalue);
                            }

                       }
                   }
                }

            });

            frame.setVisible(true);
        }

    }

    // A function called Delete
    void delete(){
        String currentText = label.getText();
            if (currentText.length() > 1){
                label.setText(currentText.substring(0, currentText.length() - 1));
            }
            else {
                label.setText("0");
            }
    }
        // A function called Clear all
       void clearAll(){
            A = "0";
            operator = null;
            B = null;
        }

        String removeZeroDecimal(double numDisplay) {
            if (numDisplay % 1 ==0){
                return Integer.toString((int) numDisplay);
            }
            
            return Double.toString(numDisplay);
        }

    
    public static void main(String[] args) {
        new Calculator();
    }
}
