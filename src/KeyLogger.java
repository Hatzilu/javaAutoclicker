import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyLogger implements NativeKeyListener {
    public AutoClicker clicker;
    boolean isClicking = false;
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        clicker = new AutoClicker();
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE)
        {
            clicker.setMacroON(false);
        }
        System.out.println(NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    public static void main (String[] args)
    {

    }
}
