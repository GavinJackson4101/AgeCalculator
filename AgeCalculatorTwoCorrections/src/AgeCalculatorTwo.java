import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import  java.time.temporal.ChronoUnit;
import javax.swing.*;

public class AgeCalculatorTwo {
    private JFrame mainFrame;
    private JTextField headerLabel;
    private JTextField statusLabel;
    private JPanel controlPanel;

    public AgeCalculatorTwo(){prepareGUI();}
    public static void main(String[] args){
        AgeCalculatorTwo swingControlDemo = new AgeCalculatorTwo();
        swingControlDemo.showEventDemo();

    }
    private void prepareGUI() {//implementation of GUI
        mainFrame = new JFrame("Calculate User Age");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JTextField("", JTextField.CENTER);
        statusLabel = new JTextField("", JTextField.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {//addition of windowlistener
                System.exit(0);
            }
        });
        controlPanel = new JPanel();//new JPanel with headers and labels
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo(){
        //headerLabel

        JButton okButton = new JButton("Calculate Age");//implementation of all buttons
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        okButton.setActionCommand("Calculate Age");//labels for buttons and commands
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cencel");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());

        controlPanel.add(okButton);
        //controlPanel.add submitbutton
        //controlPanel.add cancelbutton

        mainFrame.setVisible(true);
    }
    private class ButtonClickListener implements ActionListener{//implementation of click listener
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Calculate Age")) {
                //statusLabel
                statusLabel.setText("You are " + String.valueOf(CalculateUserAge(headerLabel.getText())));
            } else if (command.equals("Submit")) {
                //statusLabel.settest("cancel button clicked";
            } else {
                //statusLabel.setText("Cancel Button clicked";
            }
        }
    }
    public long CalculateUserAge(String userBirthDate)  {//implementation of format and date for user
        long returnValue = 0;
        LocalDate userProvidedDate = LocalDate.parse(userBirthDate);
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter todayDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(todayDate);
        String formattedUserDate = userProvidedDate.format(todayDate);
        //system.out.prinln Date
        //system.out.println formatted user date

        returnValue = ChronoUnit.YEARS.between(userProvidedDate, dateObj);

        //system.out.println(The ok button has been clicked)
        return returnValue;
    }


}


