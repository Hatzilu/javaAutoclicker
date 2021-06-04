import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private float mouseDelay = 1.0f;
    private String macroHotkey = "F5";
    JFrame macroFrame; //foundation for the GUI
    JPanel macroPanel; //panel for GUI
    JButton macroButton; //button for mouse delay
    JLabel clickLabel; //labels for mouse delay
    JTextField clickDelayField; //input for mouse delay

    JTextField hotkeyField; //input for saving hotkey
    JButton hotkeyButton; //button for saving the hotkey used to toggle macro
    JLabel hotkeyLabel; //label for hotkey

    JButton startMacroButton; //button to start the macro manually
    public boolean isMacroON = false;
    public GUI(){
        try { Robot bot = new Robot();}
        catch (AWTException ex) {ex.printStackTrace();}

        macroFrame = new JFrame( );
        macroPanel = new JPanel();
        clickDelayField = new JTextField();
        clickDelayField.setBounds(50,50,200,30);
        macroButton = new JButton("Save Delay");
        clickLabel = new JLabel(" Current Mouse Delay: "+mouseDelay);

        hotkeyField = new JTextField();
        hotkeyField.setBounds(50,50,200,30);
        hotkeyButton = new JButton("Save Hotkey");
        hotkeyLabel = new JLabel("Current Macro Hotkey: "+macroHotkey);

        startMacroButton = new JButton("Start!");

        //add an ActionListener to this class
        macroButton.addActionListener(this);
        hotkeyButton.addActionListener(this);
        startMacroButton.addActionListener(this);
        //set the window border
        macroPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 40, 1));
        macroPanel.setLayout(new GridLayout(2, 4));
        //add the panel into the thiungy
        macroFrame.add(macroPanel,BorderLayout.CENTER);

        //we need to add the components to the panel object in order to see them in our app
        macroPanel.add(clickDelayField);
        macroPanel.add(macroButton);
        macroPanel.add(clickLabel);
macroPanel.add(startMacroButton);
        macroPanel.add(hotkeyField);
        macroPanel.add(hotkeyButton);
        macroPanel.add(hotkeyLabel);
        macroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        macroFrame.setTitle("Itamar's super cool and rad auto-clicker java app");
        macroFrame.pack();
        //set the window to be visible
        macroFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "Save Hotkey":
                macroHotkey = hotkeyField.getText();
                hotkeyLabel.setText("Current Macro Hotkey: "+macroHotkey);
                System.out.println("Current Macro Hotkey: "+macroHotkey);
                break;
            case "Save Delay":
                try {
                    mouseDelay = Float.parseFloat(clickDelayField.getText());
                    clickLabel.setText(" Current Mouse Delay: "+mouseDelay);
                    System.out.println("Saving mouse input! new value: "+mouseDelay);
                } catch (Exception ex) { System.out.println("Could not parse"+clickDelayField.getText()+" to float value!! \n Error: "+ex); }
                break;

            case "Start!":
                macroFrame.setState(Frame.ICONIFIED);
                break;
        }
    }
}
