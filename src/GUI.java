import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    public final AutoClicker clicker;
    private KeyLogger keyLogger;

     JFrame macroFrame; //foundation for the GUI
    JPanel macroPanel, secondPanel; //panel for GUI
    JButton macroButton; //button for mouse delay
    JLabel clickLabel; //labels for mouse delay
    JTextField clickDelayField; //input for mouse delay

    JTextField hotkeyField; //input for saving hotkey
    JButton hotkeyButton; //button for saving the hotkey used to toggle macro
    JLabel hotkeyLabel; //label for hotkey
    JButton stopMacroButton;
    JButton startMacroButton; //button to start the macro manually
    public GUI(){
        keyLogger = new KeyLogger();
        clicker = new AutoClicker();
        macroFrame = new JFrame( );
        macroPanel = new JPanel();
        secondPanel = new JPanel();
        clickDelayField = new JTextField();
        clickDelayField.setBounds(50,50,200,30);
        macroButton = new JButton("Save Delay");
        clickLabel = new JLabel(" Current Mouse Delay: "+clicker.getMouseDelay());

        hotkeyField = new JTextField();
        hotkeyField.setBounds(50,50,200,30);
        hotkeyButton = new JButton("Save Hotkey");
        hotkeyLabel = new JLabel("Current Macro Hotkey: "+clicker.getMacroHotkey());

        startMacroButton = new JButton("Start!");
        stopMacroButton = new JButton("Stop!");
        //add an ActionListener to this class
        macroButton.addActionListener(this);
        hotkeyButton.addActionListener(this);
        startMacroButton.addActionListener(this);
        stopMacroButton.addActionListener(this);

        //set the window border
        macroPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 40, 1));
        macroPanel.setLayout(new GridLayout(3, 1));
        //add the panel into the thingy
        macroFrame.add(macroPanel,BorderLayout.CENTER);

        //we need to add the components to the panel object in order to see them in our app
        macroPanel.add(clickDelayField);
        macroPanel.add(macroButton);
        macroPanel.add(clickLabel);
        macroPanel.add(hotkeyField);
        macroPanel.add(hotkeyButton);
        macroPanel.add(hotkeyLabel);

        macroPanel.add(startMacroButton);
        macroPanel.add(stopMacroButton);

        //frame settings
        macroFrame.setAlwaysOnTop(true);
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
                clicker.setMacroHotkey(hotkeyField.getText());
                hotkeyLabel.setText("Current Macro Hotkey: "+clicker.getMacroHotkey());
                System.out.println("Current Macro Hotkey: "+clicker.getMacroHotkey());
                break;
            case "Save Delay":
                try {
                    clicker.setMouseDelay(Integer.parseInt(clickDelayField.getText()));
                    clickLabel.setText(" Current Mouse Delay: "+clicker.getMouseDelay());
                    System.out.println("Saving mouse input! new value: "+clicker.getMouseDelay());
                } catch (Exception ex) { System.out.println("Could not parse"+clickDelayField.getText()+" to int value!! \n Error: "+ex); }
                break;

            case "Start!":
//                startMacroButton.setSelected(false);
                System.out.println("Starting Autoclicker!!"+startMacroButton.isSelected());
                clicker.setMacroON(true);
//                macroFrame.setState(Frame.ICONIFIED);
                clicker.startAutoClick(startMacroButton);
                break;
            case "Stop!":
                clicker.setMacroON(false);
                System.out.println("Stopping Autoclicker!");
                break;
        }
    }
}
