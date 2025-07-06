package mini.carlos.skyblock.engine.commons;

import java.awt.event.KeyEvent;

public class KeyboardHelper {

    public static boolean isUp(int keyCode){
        return keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP;
    }

    public static boolean isDown(int keyCode){
        return keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN;
    }

    public static boolean isLeft(int keyCode){
        return keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT;
    }

    public static boolean isRight(int keyCode){
        return keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT;
    }
}
