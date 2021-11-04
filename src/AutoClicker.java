import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

public class AutoClicker implements NativeKeyListener {

    private int mouseDelay = 500;
    private String macroHotkey = "F5";
    public boolean isMacroON = false;
    private Robot bot;
    public AutoClicker()
    {
        try {
            GlobalScreen.registerNativeHook();
            System.out.println("Success! nativehook registered");}
        catch (NativeHookException ex) {
            System.out.println(ex);
        }
        GlobalScreen.addNativeKeyListener(new KeyLogger());
    }
    public static void main(String[] args) {

    }
    public int getMouseDelay() {
        return mouseDelay;
    }

    public void setMouseDelay(int mouseDelay) {
        this.mouseDelay = mouseDelay;
    }

    public String getMacroHotkey() {
        return macroHotkey;
    }

    public void setMacroHotkey(String macroHotkey) {
        this.macroHotkey = macroHotkey;
    }

    public boolean isMacroON() {
        return isMacroON;
    }

    public void setMacroON(boolean macroON) {
        isMacroON = macroON;
    }
    public void startAutoClick(JButton btn)
    {
        try
        {
            bot = new Robot();
            int button = InputEvent.BUTTON1_DOWN_MASK;
            while (isMacroON) {
                if (!isMacroON())
                {
                    break;
                }
                bot.mousePress(button);
                bot.delay(getMouseDelay());
                bot.mouseRelease(button);
                bot.delay(getMouseDelay());
                System.out.println("Click! ms: "+getMouseDelay());
            }
        }
        catch (AWTException ex) {ex.printStackTrace();}
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        System.out.println("Key pressed");
        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ESCAPE)
        {
            setMacroON(false);
            System.out.println("Macro OFF");
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {

    }


    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

}
