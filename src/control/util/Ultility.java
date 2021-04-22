package control.util;

import model.shape2d.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import control.SettingConstants;

public class Ultility {
    
    private static final int D_X[] = {-1, 0, 0, 1};
    private static final int D_Y[] = {0, -1, 1, 0};

    public Ultility() {
    }

    public static void fillCells(Graphics g, int coordX, int coordY, Color color) {
        g.fillRect(coordX, coordY, coordX + 5, coordY + 5);
    }

    public static void showPopMenuOfButton(JButton button, JPopupMenu popMenu) {
        popMenu.show(button,
                (int) button.getAlignmentX() + button.getWidth(),
                (int) button.getAlignmentY()
        );
    }

    /**
     * Check if point is in bound of array.
     *
     * @param array
     * @param x
     * @param y
     * @return
     */
    public static boolean checkValidPoint(Object[][] array, int x, int y) {
        if (array.length == 0) {
            return false;
        }

        int height = array.length;
        int width = array[0].length;

        return (0 <= x && x < width && 0 <= y && y < height);
    }

    /**
     * Check if pixel can be put or not.
     *
     * @param pixelCounter
     * @param lineStyle
     * @return
     */
    public static boolean checkPixelPut(int pixelCounter, SettingConstants.LineStyle lineStyle) {
        switch (lineStyle) {
            case DEFAULT:
                return true;
            case DASH: {
                return (pixelCounter % 5 != 0);
            }
            case DASH_DOT: {
                return (pixelCounter % 6 != 4 && pixelCounter % 6 != 0);
            }
            case DASH_DOT_DOT: {
                return (pixelCounter % 8 != 4 && pixelCounter % 8 != 6 && pixelCounter % 8 != 0);
            }
            case ARROW: {
                return true;
            }
        }
        return false;
    }

    /**
     * Paint the neighbors of current point via BFS algorithm.
     * @param colorOfBoard
     * @param markedArray
     * @param point
     * @param choosedColor 
     */
   public static void paint(Color[][] colorOfBoard, boolean[][] markedArray, Point2D point, Color chosenColor) {
      //  int coordX = point.getCoordX();
      //  int coordY = point.getCoordY();

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        if (!checkValidPoint(colorOfBoard, point.getCoordX(), point.getCoordY())) {
            return;
        }

        Color oldColor = colorOfBoard[point.getCoordY()][point.getCoordX()];
        
        if (!oldColor.equals(chosenColor)) {
           // markedArray[point.getCoordY()][point.getCoordX()] = true;
            colorOfBoard[point.getCoordY()][point.getCoordX()] = chosenColor;
            
            queue.add(new Pair<>(point.getCoordX(), point.getCoordY()));
            
            int newCoordX;
            int newCoordY;
            while (queue.size() > 0) {
                Pair<Integer, Integer> frontQueue = queue.poll();
                
                for (int i = 0; i < 4; i++) {
                    newCoordX = frontQueue.getKey() + D_X[i];
                    newCoordY = frontQueue.getValue() + D_Y[i];
                    
                    if (checkValidPoint(colorOfBoard, newCoordX, newCoordY) &&
                            colorOfBoard[newCoordY][newCoordX].equals(oldColor)) {
                      //  markedArray[newCoordY][newCoordX] = true;
                        colorOfBoard[newCoordY][newCoordX] = chosenColor;
                        queue.add(new Pair<>(newCoordX, newCoordY));
                        
                    }
                }
            }
            
        }
    }
}