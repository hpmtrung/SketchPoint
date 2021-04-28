package model.shape2d;

import java.awt.Color;

public class Diamond extends Shape2D {

    private Point2D startPoint;
    private Point2D endPoint;

    private Point2D leftPoint;
    private Point2D rightPoint;
    private Point2D topPoint;
    private Point2D bottomPoint;

    public enum Modal {
        COMMON_DIAMOND,
        SQUARE_DIAMOND,
    }
    public Diamond(boolean[][] markedChangeOfBoard, Color[][] changedColorOfBoard, String[][] changedCoordOfBoard, Color filledColor) {
        super(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, filledColor);

        startPoint = new Point2D();
        endPoint = new Point2D();
        leftPoint = new Point2D();
        rightPoint = new Point2D();
        topPoint = new Point2D();
        bottomPoint = new Point2D();
    }

    public void setProperty(Point2D startPoint, Point2D endPoint,Modal modal) {
        int width = endPoint.getCoordX() - startPoint.getCoordX();
        int height = endPoint.getCoordY() - startPoint.getCoordY();
        
        this.startPoint = startPoint;
        if(modal == Modal.COMMON_DIAMOND){
            this.endPoint = endPoint;
        } else {
            int widthDirection = this.getWidthDirection(width);
            int heightDirection = this.getHeightDirection(height);
            int preferedLength = this.getPreferredLength(width, height);
            
            
            this.endPoint.setCoord(this.startPoint.getCoordX()+widthDirection*preferedLength,this.startPoint.getCoordY()+heightDirection*preferedLength);
        }
        
        
        this.centerPoint = Point2D.midPoint(this.startPoint, this.endPoint);

        this.leftPoint.setCoord(this.startPoint.coordX, this.centerPoint.coordY);
        this.rightPoint.setCoord(this.endPoint.coordX, this.centerPoint.coordY);
        this.topPoint.setCoord(this.centerPoint.coordX, this.startPoint.coordY);
        this.bottomPoint.setCoord(this.centerPoint.coordX, this.endPoint.coordY);
    }
    @Override
    public void setProperty(Point2D startPoint, Point2D endPoint) {
        setProperty(startPoint, endPoint, Modal.COMMON_DIAMOND);
    }
    @Override
    public void saveCoordinates() {
        this.leftPoint.saveCoord(changedCoordOfBoard);
        this.rightPoint.saveCoord(changedCoordOfBoard);
        this.topPoint.saveCoord(changedCoordOfBoard);
        this.bottomPoint.saveCoord(changedCoordOfBoard);
    }

    @Override
    public void drawOutline() {
        Point2D tempTopPoint = topPoint.createRotationPoint(centerPoint, rotatedAngle);
        Point2D tempBottomPoint = bottomPoint.createRotationPoint(centerPoint, rotatedAngle);
        Point2D tempLeftPoint = leftPoint.createRotationPoint(centerPoint, rotatedAngle);
        Point2D tempRightPoint = rightPoint.createRotationPoint(centerPoint, rotatedAngle);

        drawSegment(tempTopPoint, tempRightPoint);
        drawSegment(tempRightPoint, tempBottomPoint);
        drawSegment(tempBottomPoint, tempLeftPoint);
        drawSegment(tempLeftPoint, tempTopPoint);
    }

    @Override
    public void applyMove(Vector2D vector) {
        topPoint.rotate(rotatedAngle).move(vector);
        bottomPoint.rotate(rotatedAngle).move(vector);
        leftPoint.rotate(rotatedAngle).move(vector);
        rightPoint.rotate(rotatedAngle).move(vector);
        centerPoint.move(vector);
    }
}