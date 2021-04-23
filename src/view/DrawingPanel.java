package view;

import control.SettingConstants;
import control.util.Ultility;
import model.shape2d.Point2D;
import model.shape2d.Rectangle;
import model.shape2d.Segment2D;
import model.shape2d.Triangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.shape2d.Arrow2D;
import model.shape2d.Diamond;
import model.shape2d.Ellipse;
import model.shape2d.Shape2D;
import model.shape2d.Star;

/**
 * Class used for implementing drawing area.
 */
public class DrawingPanel extends JPanel {

    /**
     * The actual width of board.
     */
    public final int widthBoard = SettingConstants.WIDTH_DRAW_AREA;

    /**
     * The actual height of board.
     */
    public final int heightBoard = SettingConstants.HEIGHT_DRAW_AREA;

    // Color and coord property of all points when any drawing action is applied
    /**
     * Color of each pixel after applying drawing action.
     */
    public Color[][] colorOfBoard;

    /**
     * Coordination text of each pixel after applying drawing action.
     */
    private String[][] coordOfBoard;

    // The color property of all points when a new drawing action is happened.
    private Color[][] changedColorOfBoard;
    private String[][] changedCoordOfBoard;

    // This array is used to mark the point is changed in an action.
    private boolean[][] markedChangeOfBoard;

    /**
     * Undo stack of coordinate
     */
    private static Stack<String[][]> undoCoordOfBoardStack;
    private static Stack<Color[][]> undoColorOfBoardStack;
    private static Stack<String[][]> redoCoordOfBoardStack;
    private static Stack<Color[][]> redoColorOfBoardStack;

    /**
     * Showing grid lines flag.
     */
    private boolean showGridFlag;

    /**
     * Showing coordinate flag.
     */
    private boolean showCoordinateFlag;

    /**
     * Starting point of drawn object.
     */
    private Point2D startDrawingPoint;

    /**
     * Ending point of drawn object.
     */
    private Point2D endDrawingPoint;

    /**
     * User selected coordinate system.
     */
    private SettingConstants.CoordinateMode coordinateMode;

    /**
     * Selected option by user.
     */
    private SettingConstants.DrawingToolMode selectedToolMode;

    /**
     * User selected color.
     */
    private Color selectedColor;

    /**
     * User customized line style.
     */
    private SettingConstants.LineStyle selectedLineStyle;

    /**
     * User customized line size.
     */
    private Integer selectedLineSize;

    public DrawingPanel() {
        this.colorOfBoard = new Color[heightBoard][widthBoard];
        this.coordOfBoard = new String[heightBoard][widthBoard];

        this.changedColorOfBoard = new Color[heightBoard][widthBoard];
        this.changedCoordOfBoard = new String[heightBoard][widthBoard];

        this.markedChangeOfBoard = new boolean[heightBoard][widthBoard];

        undoCoordOfBoardStack = new Stack<>();
        undoColorOfBoardStack = new Stack<>();
        redoCoordOfBoardStack = new Stack<>();
        redoColorOfBoardStack = new Stack<>();

        showGridFlag = SettingConstants.DEFAULT_VISUAL_SHOW_GRID;
        showCoordinateFlag = SettingConstants.DEFAULT_VISUAL_SHOW_COORDINATE;

        coordinateMode = SettingConstants.CoordinateMode.MODE_2D;

        startDrawingPoint = new Point2D(SettingConstants.DEFAULT_UNUSED_POINT);
        endDrawingPoint = new Point2D(SettingConstants.DEFAULT_UNUSED_POINT);

        selectedToolMode = SettingConstants.DrawingToolMode.DRAWING_LINE_SEGMENT;
        selectedColor = SettingConstants.DEFAULT_FILL_COLOR;
        selectedLineStyle = SettingConstants.LineStyle.DEFAULT;
        selectedLineSize = SettingConstants.DEFAULT_LINE_SIZE;

        resetChangedPropertyArray();
        resetSavedPropertyArray();

        this.addMouseMotionListener(new CustomMouseMotionHandling());
        this.addMouseListener(new CustomMouseClickHandling());
    }

    public Color[][] getColorOfBoard() {
        return this.colorOfBoard;
    }

    public String[][] getCoordOfBoard() {
        return this.coordOfBoard;
    }

    public boolean isEmpty() {
        boolean result = true;
        for (int i = 0; i < heightBoard; i++) {
            for (int j = 0; j < widthBoard; j++) {
                if (!colorOfBoard[i][j].equals(SettingConstants.DEFAULT_PIXEL_COLOR)) {
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }
        return result;
    }

    public void setStartDrawingPoint(int coordX, int coordY) {
        this.startDrawingPoint.setCoord(coordX, coordY);
    }

    public void setEndDrawingPoint(int coordX, int coordY) {
        this.endDrawingPoint.setCoord(coordX, coordY);
    }

    /**
     * Check for undo action.
     *
     * @return
     */
    public boolean ableUndo() {
        return !undoColorOfBoardStack.empty();
    }

    /**
     * Check for redo action.
     *
     * @return
     */
    public boolean ableRedo() {
        return !redoColorOfBoardStack.empty();
    }

    /**
     * Set selected drawing tool button.
     *
     * @param selectedToolMode
     */
    public void setSelectedButtonMode(SettingConstants.DrawingToolMode selectedToolMode) {
        this.selectedToolMode = selectedToolMode;
    }

    /**
     * Get current drawing tool button.
     *
     * @return
     */
    public SettingConstants.DrawingToolMode getSelectedToolMode() {
        return this.selectedToolMode;
    }

    /**
     * Set selected line size.
     *
     * @param lineSize
     */
    public void setSelectedLineSize(int lineSize) {
        selectedLineSize = lineSize;
    }

    /**
     * Set selected line style.
     *
     * @param lineStyle
     */
    public void setSelectedLineStyle(SettingConstants.LineStyle lineStyle) {
        selectedLineStyle = lineStyle;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
    }

    /**
     * Change coordinate system for the board. <br>
     * Release all buffered memory and clear the board.
     *
     * @param mode
     */
    public void setCoordinateMode(SettingConstants.CoordinateMode mode) {
        // Clear old coordinate system before changing coordinate mode flag
        this.coordinateMode = mode;

        resetChangedPropertyArray();
        resetSavedPropertyArray();
        disposeStack();

        showGridFlag = SettingConstants.DEFAULT_VISUAL_SHOW_GRID;
        showCoordinateFlag = SettingConstants.DEFAULT_VISUAL_SHOW_COORDINATE;

        this.repaint();
    }

    /**
     * Release all resource in undo, redo stack.
     */
    private void disposeStack() {
        redoColorOfBoardStack.clear();
        redoCoordOfBoardStack.clear();
        undoColorOfBoardStack.clear();
        undoCoordOfBoardStack.clear();
    }

    /**
     * Clear all drawn object in board by setting its default color and
     * coordinate value. <br>
     * This method doesn't release memory in stack. You can use disposeStack
     * method for this purpose.
     */
    public void resetSavedPropertyArray() {
        for (int i = 0; i < this.heightBoard; i++) {
            for (int j = 0; j < this.widthBoard; j++) {
                colorOfBoard[i][j] = SettingConstants.DEFAULT_PIXEL_COLOR;
                coordOfBoard[i][j] = null;
            }
        }
    }

    /**
     * Clear all buffered drawn object in board. <br>
     */
    public void resetChangedPropertyArray() {
        for (int i = 0; i < this.heightBoard; i++) {
            for (int j = 0; j < this.widthBoard; j++) {
                markedChangeOfBoard[i][j] = false;
                changedColorOfBoard[i][j] = SettingConstants.DEFAULT_PIXEL_COLOR;
                changedCoordOfBoard[i][j] = null;
            }
        }
    }

    public void setShowGridLinesFlag(boolean flag) {
        showGridFlag = flag;
        this.repaint();
    }

    public void setShowCoordinateFlag(boolean flag) {
        showCoordinateFlag = flag;
        this.repaint();
    }

    /**
     * Copy color value of each pixel from <code>color_board_from</code> to
     * <code>color_board_to</code>. <br>
     * Require they have the same size.
     *
     * @param color_board_from
     * @param color_board_to
     */
    public void copyColorValue(Color[][] color_board_from, Color[][] color_board_to, boolean fromColorOBToChangedCOB) {
        int height = color_board_from.length;
        int width = color_board_from[0].length;
        if (!fromColorOBToChangedCOB) {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    color_board_to[row][col] = new Color(color_board_from[row][col].getRGB());
                }
            }
        } else {
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    markedChangeOfBoard[row][col] = true;
                    color_board_to[row][col] = new Color(color_board_from[row][col].getRGB());
                }
            }
        }

    }

    /**
     * Copy coordinate value of each pixel from <code>coord_board_from</code> to
     * <code>coord_board_to</code>. <br>
     * Require they have the same size.
     *
     * @param coord_board_from
     * @param coord_board_to
     */
    public void copyCoordValue(String[][] coord_board_from, String[][] coord_board_to) {
        int height = coord_board_from.length;
        int width = coord_board_from[0].length;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (coord_board_from[row][col] != null) {
                    coord_board_to[row][col] = coord_board_from[row][col];
                }
            }
        }
    }

    /**
     * Save the current color of drawing board to undo stack.
     */
    private void saveCurrentColorBoardToUndoStack() {
        Color[][] tempBoard = new Color[heightBoard][widthBoard];
        copyColorValue(colorOfBoard, tempBoard, false);
        undoColorOfBoardStack.push(tempBoard);
    }

    /**
     * Save the current coordinates of drawing board to undo stack.
     */
    private void saveCurrentCoordBoardToUndoStack() {
        String[][] tempBoard = new String[heightBoard][widthBoard];
        copyCoordValue(coordOfBoard, tempBoard);
        undoCoordOfBoardStack.push(tempBoard);
    }

    /**
     * Save the current color of drawing board to redo stack.
     */
    private void saveCurrentColorBoardToRedoStack() {
        Color[][] tempBoard = new Color[heightBoard][widthBoard];
        copyColorValue(colorOfBoard, tempBoard, false);
        redoColorOfBoardStack.push(tempBoard);
    }

    /**
     * Save the current coordinates of drawing board to redo stack.
     */
    private void saveCurrentCoordBoardToRedoStack() {
        String[][] tempBoard = new String[heightBoard][widthBoard];
        copyCoordValue(coordOfBoard, tempBoard);
        redoCoordOfBoardStack.push(tempBoard);
    }

    /**
     * Get the previous status of board. <br>
     * This reverts back to the saved state at the top of undo stack. If user
     * just changes any color but not coordinate of objects, we only get the
     * color from undo stack of color, not stack of coordinates. The same works
     * for changing coordinate but not color. Simultaneously, the redo stack
     * will push the current state to its.
     */
    public void undo() {
        if (!undoColorOfBoardStack.empty()) {
            saveCurrentColorBoardToRedoStack();
            copyColorValue(undoColorOfBoardStack.pop(), colorOfBoard, false);
        }
        if (!undoCoordOfBoardStack.empty()) {
            saveCurrentCoordBoardToRedoStack();
            copyCoordValue(undoCoordOfBoardStack.pop(), coordOfBoard);
        }
    }

    /**
     * Get the previous status of board after undo action. <br>
     * This reverts back to the saved state at the top of redo stack. If user
     * just changes any color but not coordinate of objects, we only get the
     * color from redo stack of color, not stack of coordinates. The same works
     * for changing coordinate but not color. Simultaneously, the undo stack
     * will push the current state to its.
     */
    public void redo() {
        if (!redoColorOfBoardStack.empty()) {
            saveCurrentColorBoardToUndoStack();
            copyColorValue(redoColorOfBoardStack.pop(), colorOfBoard, false);
        }
        if (!redoCoordOfBoardStack.empty()) {
            saveCurrentCoordBoardToUndoStack();
            copyCoordValue(redoCoordOfBoardStack.pop(), coordOfBoard);
        }
    }

    /**
     * Save the last user's drawing action to saved board.
     */
    public void apply() {
        // Clear redo stacks.
//        redoColorOfBoardStack.clear();
//        redoCoordOfBoardStack.clear();

        // Save current state to undo stack.
//        saveCurrentColorBoardToUndoStack();
//        saveCurrentCoordBoardToUndoStack();
        // Merge of changed color to saved state of board
        // NOTE: Why not mergeColorValue coordinate??
        mergeColorValue();

        // Save the changed coordinate into board.
        copyCoordValue(changedCoordOfBoard, coordOfBoard);

        // Reset marked change array.
        // resetChangedPropertyArray();
    }

    private boolean isNotSelected() {
        return (startDrawingPoint.equal(SettingConstants.DEFAULT_UNUSED_POINT)
                && endDrawingPoint.equal(SettingConstants.DEFAULT_UNUSED_POINT));
    }

    public void setSelected(Point2D startPoint, Point2D endPoint) {
        startDrawingPoint.setCoord(startPoint);
        endDrawingPoint.setCoord(endPoint);
    }

    public boolean getShowGridFlag() {
        return showGridFlag;
    }

    public boolean getShowCoordinateFlag() {
        return showCoordinateFlag;
    }

    /**
     * Return the current coordinate system.
     *
     * @return SettingConstants.CoordinateMode
     */
    public SettingConstants.CoordinateMode getCoordinateMode() {
        return this.coordinateMode;
    }

    /**
     * Fill background board with specific color.
     *
     * @param graphic
     * @param backgroundColor
     */
    private void drawBackgroundBoard(Graphics graphic, Color backgroundColor) {
        graphic.setColor(backgroundColor);
        graphic.fillRect(0, 0, this.widthBoard, this.heightBoard);
    }

    /**
     * Show axis and point coordination.
     *
     * @param graphic
     */
    private void showBoardCoordination(Graphics graphic) {
        /*
            Show axis coordination.
         */
        graphic.setColor(SettingConstants.DEFAULT_COORDINATE_AXIS_COLOR);

        if (coordinateMode == SettingConstants.CoordinateMode.MODE_2D) {
            // Ox axis 
            graphic.drawLine(1, SettingConstants.COORD_Y_O, this.widthBoard, SettingConstants.COORD_Y_O);
            // Oy axis
            graphic.drawLine(SettingConstants.COORD_X_O, 1, SettingConstants.COORD_X_O, this.heightBoard);

        } else {
            // Ox
            graphic.drawLine(SettingConstants.COORD_X_O, SettingConstants.COORD_Y_O, this.widthBoard, SettingConstants.COORD_Y_O);
            // Oy
            graphic.drawLine(SettingConstants.COORD_X_O, 1, SettingConstants.COORD_X_O, SettingConstants.COORD_Y_O);
            // Oz
            graphic.drawLine(SettingConstants.COORD_X_O, SettingConstants.COORD_Y_O, 1, SettingConstants.COORD_X_O + SettingConstants.COORD_Y_O);
        }

        /*
            Show point coordination.
         */
        graphic.setColor(SettingConstants.DEFAULT_COORDINATE_POINT_COLOR);

        for (int i = 0; i < heightBoard; i++) {
            for (int j = 0; j < widthBoard; j++) {
                String coordinateProperty = coordOfBoard[i][j];

                if (coordinateProperty != null) {

                    int posX = (i + 1) * SettingConstants.RECT_SIZE;
                    int posY = j * SettingConstants.RECT_SIZE - 2;

                    // Normalize
                    if (posX <= 0) {
                        posX = 1;
                    } else if (posX >= widthBoard) {
                        posX = widthBoard - coordinateProperty.length() * SettingConstants.SIZE;
                    }

                    if (posY <= 0) {
                        posY = 1;
                    } else if (posY >= heightBoard) {
                        posY = heightBoard - SettingConstants.SIZE;
                    }

                    graphic.drawString(coordinateProperty, posX, posY);
                }
            }
        }
    }

    /**
     * Paint the board but not showing coordination.
     *
     * @param graphic
     */
    private void paintBoardColor(Graphics graphic) {
        if (showGridFlag) {
            drawBackgroundBoard(graphic, SettingConstants.DEFAULT_GRID_BACKGROUND_COLOR);
        } else {
            drawBackgroundBoard(graphic, SettingConstants.DEFAULT_EMPTY_BACKGROUND_COLOR);
        }

        for (int i = 0; i < this.heightBoard / SettingConstants.RECT_SIZE; i++) {
            for (int j = 0; j < this.widthBoard / SettingConstants.RECT_SIZE; j++) {
                if (markedChangeOfBoard[i][j] == true) {
                    graphic.setColor(changedColorOfBoard[i][j]);
                } else {
                    graphic.setColor(colorOfBoard[i][j]);
                }

                graphic.fillRect(j * SettingConstants.RECT_SIZE + 1,
                        i * SettingConstants.RECT_SIZE + 1,
                        SettingConstants.SIZE,
                        SettingConstants.SIZE
                );
            }
        }
    }

    @Override
    public void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);

        paintBoardColor(graphic);

        if (showCoordinateFlag) {
            showBoardCoordination(graphic);
        }
    }

    /**
     * Merge color of this board with another in pixel having position marked in
     * permittedPoint array.
     *
     * @param permittedPoint
     * @param otherBoard
     */
    private void mergeColorValue() {
        for (int i = 0; i < this.heightBoard; i++) {
            for (int j = 0; j < this.widthBoard; j++) {
                if (markedChangeOfBoard[i][j] == true) {
                    colorOfBoard[i][j] = new Color(changedColorOfBoard[i][j].getRGB());
                }
            }
        }
    }

    public boolean checkStartingPointAvailable() {
        return (startDrawingPoint.getCoordX() != -1 && startDrawingPoint.getCoordY() != -1);
    }

    private class CustomMouseClickHandling implements MouseListener {

        /*
        Do later
         */
        @Override
        public void mouseClicked(MouseEvent event) {

            if (!SwingUtilities.isLeftMouseButton(event)) {
                return;
            }

            SettingConstants.DrawingToolMode selectedTool = getSelectedToolMode();
        }

        @Override
        public void mousePressed(MouseEvent event) {
            if (!SwingUtilities.isLeftMouseButton(event)) {
                return;
            }

            setStartDrawingPoint(event.getX() / SettingConstants.RECT_SIZE, event.getY() / SettingConstants.RECT_SIZE);

//            SettingConstants.DrawingToolMode selectedTool = getSelectedToolMode();
            resetChangedPropertyArray();

            switch (selectedToolMode) {
                case DRAWING_LINE_FREE: {
                    //   setEndDrawingPoint(event.getX() / Settings.RECT_SIZE, event.getY() / Settings.RECT_SIZE);
                    //    setStartDrawingPoint(endDrawingPoint.getCoordX(), endDrawingPoint.getCoordY());

                    markedChangeOfBoard[startDrawingPoint.getCoordY()][startDrawingPoint.getCoordX()] = true;
                    changedColorOfBoard[startDrawingPoint.getCoordY()][startDrawingPoint.getCoordX()] = selectedColor;

                    startDrawingPoint.saveCoord(coordOfBoard);

                    repaint();
                    break;
                }
                case TOOL_COLOR_FILLER: {
                    copyColorValue(colorOfBoard, changedColorOfBoard, true);

                    Point2D currentMousePos = new Point2D();

                    currentMousePos.setCoord(event.getX() / SettingConstants.RECT_SIZE, event.getY() / SettingConstants.RECT_SIZE);

                    Ultility.paint(changedColorOfBoard, markedChangeOfBoard, currentMousePos, selectedColor);
                    repaint();
                    break;
                }

            }
        }

        @Override
        public void mouseReleased(MouseEvent event) {

            if (!SwingUtilities.isLeftMouseButton(event)) {
                return;
            }

            apply();
            repaint();
//            switch (selectedToolMode) {
//                case DRAWING_LINE_SEGMENT: {
//                    apply();
//                    repaint();
//
//                    break;
//                }
//                case DRAWING_LINE_STRAIGHT: {
//                    break;
//                }
//                case DRAWING_POLYGON_ELLIPSE: {
//                    apply();
//                    repaint();
//
//                    break;
//                }
//                case DRAWING_POLYGON_TRIANGLE: {
//                    apply();
//                    repaint();
//
//                    break;
//                }
//                case DRAWING_POLYGON_RECTANGLE: {
//                    apply();
//                    repaint();
//
//                    break;
//                }
//                case TOOL_COLOR_FILLER: {
//                    apply();
//                    repaint();
//                    break;
//                }
//            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class CustomMouseMotionHandling implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent event) {

            if (!SwingUtilities.isLeftMouseButton(event)) {
                return;
            }

            setEndDrawingPoint(event.getX() / SettingConstants.RECT_SIZE, event.getY() / SettingConstants.RECT_SIZE);

            switch (selectedToolMode) {
                case DRAWING_LINE_SEGMENT: {
                    resetChangedPropertyArray();
                    if (checkStartingPointAvailable()) {
                        Segment2D segment = new Segment2D(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, selectedColor);
                        if (event.isShiftDown()) {
                            segment.setProperty(startDrawingPoint, endDrawingPoint, Segment2D.Modal.LINE_45_90_DEGREE);
                        } else {
                            segment.setProperty(startDrawingPoint, endDrawingPoint, Segment2D.Modal.STRAIGHT_LINE);
                        }
                        segment.setLineStyle(selectedLineStyle);
                        segment.draw();
                        segment.saveCoordinates();
                    }
                    repaint();
                    break;
                }
                case DRAWING_LINE_STRAIGHT: {
                    // Do no thing
                    break;
                }
                case DRAWING_LINE_FREE: {
                    if (checkStartingPointAvailable()) {
                        Segment2D pixel = new Segment2D(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, selectedColor);
                        pixel.setProperty(startDrawingPoint, endDrawingPoint, Segment2D.Modal.STRAIGHT_LINE);
                        pixel.draw();
                    }
                    setStartDrawingPoint(event.getX() / SettingConstants.RECT_SIZE, event.getY() / SettingConstants.RECT_SIZE);
                    repaint();
                    break;
                }
                case DRAWING_POLYGON_FREE: {
                    // Work later
                }
                case DRAWING_POLYGON_TRIANGLE: {
                    resetChangedPropertyArray();
                    if (checkStartingPointAvailable()) {
                        Triangle triangle = new Triangle(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, selectedColor);
                        if (event.isShiftDown()) {
                            triangle.setProperty(startDrawingPoint, endDrawingPoint, Triangle.Modal.EQUILATERAL_TRIANGLE);
                        } else {
                            triangle.setProperty(startDrawingPoint, endDrawingPoint, Triangle.Modal.COMMON_TRIANGLE);
                        }
                        triangle.setLineStyle(selectedLineStyle);
                        triangle.draw();
                        triangle.saveCoordinate();
                    }
                    repaint();
                    break;
                }
                case DRAWING_POLYGON_RECTANGLE: {
                    resetChangedPropertyArray();
                    if (checkStartingPointAvailable()) {
                        Rectangle rectangle = new Rectangle(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, selectedColor);
                        if (event.isShiftDown()) {
                            rectangle.setProperty(startDrawingPoint, endDrawingPoint, Rectangle.Modal.SQUARE);
                        } else {
                            rectangle.setProperty(startDrawingPoint, endDrawingPoint, Rectangle.Modal.RECTANGLE);
                        }
                        rectangle.setLineStyle(selectedLineStyle);
                        rectangle.draw();
                        rectangle.saveCoordinate();
                    }
                    repaint();
                    break;
                }
                case DRAWING_POLYGON_ELLIPSE: {
                    resetChangedPropertyArray();
                    if (checkStartingPointAvailable()) {
                        Ellipse ellipse = new Ellipse(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, selectedColor);

                        if (event.isShiftDown()) {
                            ellipse.setProperty(startDrawingPoint, endDrawingPoint, Ellipse.Modal.CIRLCE);
                        } else {
                            ellipse.setProperty(startDrawingPoint, endDrawingPoint, Ellipse.Modal.ELLIPSE);
                        }

                        ellipse.setLineStyle(selectedLineStyle);
                        ellipse.draw();
                        ellipse.saveCoordinates();
                    }
                    repaint();
                    break;
                }
                case DRAWING_SHAPE_STAR: {
                    resetChangedPropertyArray();
                    if (checkStartingPointAvailable()) {
                        Star star = new Star(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, selectedColor);
                        star.setProperty(startDrawingPoint, endDrawingPoint);
                        star.setLineStyle(selectedLineStyle);
                        star.draw();
                        star.saveCoordinates();
                    }
                    repaint();
                    break;
                }
                case DRAWING_SHAPE_DIAMOND: {
                    resetChangedPropertyArray();
                    if (checkStartingPointAvailable()) {
                        Diamond diamond = new Diamond(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, selectedColor);
                        diamond.setProperty(startDrawingPoint, endDrawingPoint);
                        diamond.setLineStyle(selectedLineStyle);
                        diamond.draw();
                        diamond.saveCoordinates();
                    }
                    repaint();
                    break;
                }
                case DRAWING_SHAPE_ARROW: {
                    resetChangedPropertyArray();
                    if (checkStartingPointAvailable()) {
                        Arrow2D arrow = new Arrow2D(markedChangeOfBoard, changedColorOfBoard, changedCoordOfBoard, selectedColor);
                        arrow.setProperty(startDrawingPoint, endDrawingPoint);
                        arrow.setLineStyle(selectedLineStyle);
                        arrow.draw();
                        arrow.saveCoordinates();
                    }
                    repaint();
                    break;
                }
            }
        }

        /*
        Use for showing eraser.
         */
        @Override
        public void mouseMoved(MouseEvent e) {
            return;
        }

    }

}
