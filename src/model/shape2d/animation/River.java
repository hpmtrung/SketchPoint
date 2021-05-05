/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shape2d.animation;

import control.SettingConstants;
import control.util.Ultility;
import java.awt.Color;
import java.util.ArrayList;
import model.shape2d.Point2D;
import model.shape2d.Shape2D;
import model.shape2d.Vector2D;

/**
 *
 * @author Minh Tu
 */
public class River extends Shape2D{
    public River(boolean[][] markedChangeOfBoard, Color[][] changedColorOfBoard, String[][] changedCoordOfBoard, Color filledColor) {
        super(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, filledColor);
    }
     
    int[] roughNumberArray110 = {1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1, 1, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1, 2, 2, 1, 1, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2};
    int[] roughNumberArray110_2 = {2, 1, 1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 1, 2, 1, 2, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 1, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 2, 2, 1, 1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2};
    int height1 = 22;
    int height2 = height1 + 27 + 8;
    Color surface = new Color (114, 204, 226);
    Color bottom = new Color(37,188,213);
    public void drawRiver(Point2D startP){
        
        int realWidthLimit = SettingConstants.WIDTH_DRAW_AREA/SettingConstants.RECT_SIZE -1;
        this.filledColor = new Color (101, 202, 225);
        //phân viền mặt nước
        this.drawSegment(startP, new Point2D(startP,realWidthLimit,0));
        this.drawSegment(new Point2D (startP,0,1), new Point2D(startP,realWidthLimit,1));
        
        
        this.filledColor = surface;
        this.drawSegment(startP, new Point2D (startP,0,height1));
        this.drawSegment(new Point2D(startP,realWidthLimit,0) , new Point2D (startP,realWidthLimit,height1));
        
        
        // vẽ gợn sóng trên mặt nước
        ArrayList<Point2D> pointList = new ArrayList<>();
        pointList.add(new Point2D (startP, 0,height1));
        pointList.add(new Point2D (pointList.get(0),40,-6));
        pointList.add(new Point2D (pointList.get(1),70,8));
        pointList.add(new Point2D (pointList.get(2),30,-5));
        pointList.add(new Point2D(startP,realWidthLimit,height1));
        
        this.filledColor = new Color (137, 225, 255);
        this.drawZigZagS(pointList,roughNumberArray110, roughNumberArray110_2);
        
        int length = 27;
        int posX = 23;
        this.setLineStyle(SettingConstants.LineStyle.DASH);
        
        this.drawOutlineEllipse(length /2 +1, 3, new Point2D (startP, posX,7), true, true, false, false);
        this.drawOutlineEllipse(length /2 +1, 5, new Point2D (startP, posX + length,7), false, false, true, true);
        
        posX =80;
        length = 20;
        this.drawOutlineEllipse(length /2 +1, 2, new Point2D (startP, posX,12), true, true, false, false);
        this.drawOutlineEllipse(length /2 +1, 4, new Point2D (startP, posX + length,12), false, false, true, true);
        
        posX =140;
        length = 22;
        this.drawOutlineEllipse(length /2 +1, 2, new Point2D (startP, posX,9), true, true, false, false);
        this.drawOutlineEllipse(length /2 +1, 4, new Point2D (startP, posX + length,9), false, false, true, true);
       
        //phân viền dưới nước
         this.setLineStyle(DEFAULT_LINE_STYLE);
        this.filledColor = bottom;
        this.drawSegment(new Point2D (startP,0,height1), new Point2D (startP,0,height2));
        this.drawSegment(new Point2D(startP,realWidthLimit,height1) , new Point2D (startP,realWidthLimit,height2));
        
        this.drawSegment(new Point2D(startP,0,height2) , new Point2D (startP,realWidthLimit,height2));
        
    }
    
    public void paintRiver(Point2D startP){
        this.filledColor = surface;
        Ultility.paint(changedColorOfBoard, markedChangeOfBoard, new Point2D (startP,4,4), filledColor);
        
        this.filledColor = bottom;
        Ultility.paint(changedColorOfBoard, markedChangeOfBoard, new Point2D (startP,4,height1+4), filledColor);
    }
    
    
     @Override
    public void applyMove(Vector2D vector) {

    }

    @Override
    public void saveCoordinates() {

    }

    @Override
    public void drawOutline() {

    }

    @Override
    public void setProperty(Point2D startPoint, Point2D endPoint) {

    }
}
