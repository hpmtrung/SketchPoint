package main;

import java.awt.Color;
import java.awt.Graphics;
import javafx.util.Pair;
import javax.swing.JButton;
import javax.swing.JPopupMenu;

public class Ultility {

    public Ultility() {
    }

    public static void fillCells(Graphics g, int coordX, int coordY, Color color) {
        g.fillRect(coordX, coordY, coordX + 5, coordY + 5);
    }

    public static void showPopMenuOfButton(JButton button, JPopupMenu popMenu) {
        assert (button != null && popMenu != null);
        popMenu.show(button,
                (int) button.getAlignmentX() + button.getWidth(), 
                (int) button.getAlignmentY()
        );
    }
}