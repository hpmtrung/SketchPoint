package main;

public class Paint extends javax.swing.JFrame {

    /**
     * Creates new form PaintUI
     */
    public Paint() {
        initComponents();
       // this.getContentPane().setBackground(new java.awt.Color(248, 248, 248));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ControlArea = new javax.swing.JPanel();
        Panel_Tools1 = new javax.swing.JPanel();
        Button_ColorChooser = new javax.swing.JButton();
        Button_FillColor = new javax.swing.JButton();
        Button_ClearAll = new javax.swing.JButton();
        Button_Eraser = new javax.swing.JButton();
        Label_Tools = new javax.swing.JLabel();
        Panel_Tools2 = new javax.swing.JPanel();
        Button_Pencil = new javax.swing.JButton();
        Button_StraightLine = new javax.swing.JButton();
        Button_Select = new javax.swing.JButton();
        Button_View = new javax.swing.JButton();
        Button_Animation = new javax.swing.JButton();
        Separator2 = new javax.swing.JSeparator();
        Panel_ShapesLines = new javax.swing.JPanel();
        Panel_Shapes = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ComboBox_Lines = new javax.swing.JComboBox<>();
        Label_ShapesLines = new javax.swing.JLabel();
        Button_2D = new javax.swing.JRadioButton();
        Button_3D = new javax.swing.JRadioButton();
        Label_DrawingMode = new javax.swing.JLabel();
        labelButton_leftA = new javax.swing.JLabel();
        labelButton_rightA = new javax.swing.JLabel();
        Separator1 = new javax.swing.JSeparator();
        Button_OpenFile = new javax.swing.JButton();
        Button_Save = new javax.swing.JButton();
        Button_Undo = new javax.swing.JButton();
        Button_Redo = new javax.swing.JButton();
        DrawingArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(12, 240, 240));

        ControlArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Panel_Tools1.setLayout(new java.awt.GridLayout(1, 0, 16, 0));

        Button_ColorChooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/colorChooser.png"))); // NOI18N
        Panel_Tools1.add(Button_ColorChooser);

        Button_FillColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fillColor.png"))); // NOI18N
        Panel_Tools1.add(Button_FillColor);

        Button_ClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clearAll.png"))); // NOI18N
        Panel_Tools1.add(Button_ClearAll);

        Button_Eraser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eraser.png"))); // NOI18N
        Panel_Tools1.add(Button_Eraser);

        Label_Tools.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Tools.setForeground(new java.awt.Color(90, 90, 90));
        Label_Tools.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Tools.setText("Tools");

        Panel_Tools2.setLayout(new java.awt.GridLayout(1, 0, 16, 0));

        Button_Pencil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pencil.png"))); // NOI18N
        Panel_Tools2.add(Button_Pencil);

        Button_StraightLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/straightLine.png"))); // NOI18N
        Panel_Tools2.add(Button_StraightLine);

        Button_Select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/select.png"))); // NOI18N
        Panel_Tools2.add(Button_Select);

        Button_View.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/view.png"))); // NOI18N
        Panel_Tools2.add(Button_View);

        Button_Animation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/animations.png"))); // NOI18N
        Panel_Tools2.add(Button_Animation);

        Separator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Panel_Shapes.setLayout(new java.awt.GridLayout(1, 0, 16, 0));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rectangle.png"))); // NOI18N
        Panel_Shapes.add(jButton2);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/triangle.png"))); // NOI18N
        Panel_Shapes.add(jButton1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circle.png"))); // NOI18N
        Panel_Shapes.add(jButton3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/diamond.png"))); // NOI18N
        Panel_Shapes.add(jButton5);

        ComboBox_Lines.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboBox_Lines.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ──────────────────", " ---------------------------------", "- ∙ - ∙ - ∙ - ∙ - ∙ - ∙ - ∙ - ∙ - ∙ - ∙ -", "── ∙ ∙ ── ∙ ∙ ── ∙ ∙ ── ∙ ∙ ──" }));

        Label_ShapesLines.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_ShapesLines.setForeground(new java.awt.Color(90, 90, 90));
        Label_ShapesLines.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_ShapesLines.setText("Shapes & Lines");

        Button_2D.setText("2D");

        Button_3D.setText("3D");

        Label_DrawingMode.setBackground(new java.awt.Color(248, 248, 248));
        Label_DrawingMode.setText("Drawing Mode:");

        labelButton_leftA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/leftArrow.png"))); // NOI18N

        labelButton_rightA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rightArrow.png"))); // NOI18N

        javax.swing.GroupLayout Panel_ShapesLinesLayout = new javax.swing.GroupLayout(Panel_ShapesLines);
        Panel_ShapesLines.setLayout(Panel_ShapesLinesLayout);
        Panel_ShapesLinesLayout.setHorizontalGroup(
            Panel_ShapesLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ShapesLinesLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(labelButton_leftA, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_ShapesLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ShapesLinesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Label_DrawingMode)
                        .addGap(32, 32, 32)
                        .addComponent(Button_2D)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_3D)
                        .addGap(45, 45, 45))
                    .addGroup(Panel_ShapesLinesLayout.createSequentialGroup()
                        .addGroup(Panel_ShapesLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_ShapesLines, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_ShapesLinesLayout.createSequentialGroup()
                                .addGroup(Panel_ShapesLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Panel_Shapes, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBox_Lines, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelButton_rightA)))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        Panel_ShapesLinesLayout.setVerticalGroup(
            Panel_ShapesLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ShapesLinesLayout.createSequentialGroup()
                .addGroup(Panel_ShapesLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ShapesLinesLayout.createSequentialGroup()
                        .addGroup(Panel_ShapesLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Panel_Shapes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelButton_rightA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBox_Lines, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_ShapesLinesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelButton_leftA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_ShapesLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_DrawingMode)
                    .addComponent(Button_2D)
                    .addComponent(Button_3D))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Label_ShapesLines))
        );

        Separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        Button_OpenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/openFile.png"))); // NOI18N

        Button_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saveFile.png"))); // NOI18N

        Button_Undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/undo.png"))); // NOI18N

        Button_Redo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/redo.png"))); // NOI18N

        javax.swing.GroupLayout ControlAreaLayout = new javax.swing.GroupLayout(ControlArea);
        ControlArea.setLayout(ControlAreaLayout);
        ControlAreaLayout.setHorizontalGroup(
            ControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ControlAreaLayout.createSequentialGroup()
                        .addComponent(Button_OpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ControlAreaLayout.createSequentialGroup()
                        .addComponent(Button_Undo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Button_Redo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(Panel_ShapesLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Tools1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel_Tools2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Tools, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        ControlAreaLayout.setVerticalGroup(
            ControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_ShapesLines, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ControlAreaLayout.createSequentialGroup()
                        .addComponent(Separator1)
                        .addContainerGap())
                    .addGroup(ControlAreaLayout.createSequentialGroup()
                        .addComponent(Panel_Tools1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(Panel_Tools2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(Label_Tools))
                    .addGroup(ControlAreaLayout.createSequentialGroup()
                        .addGroup(ControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Button_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button_OpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ControlAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Button_Undo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button_Redo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Separator2)))
        );

        DrawingArea.setBackground(new java.awt.Color(248, 248, 248));
        DrawingArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout DrawingAreaLayout = new javax.swing.GroupLayout(DrawingArea);
        DrawingArea.setLayout(DrawingAreaLayout);
        DrawingAreaLayout.setHorizontalGroup(
            DrawingAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DrawingAreaLayout.setVerticalGroup(
            DrawingAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DrawingArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ControlArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ControlArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DrawingArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Paint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Button_2D;
    private javax.swing.JRadioButton Button_3D;
    private javax.swing.JButton Button_Animation;
    private javax.swing.JButton Button_ClearAll;
    private javax.swing.JButton Button_ColorChooser;
    private javax.swing.JButton Button_Eraser;
    private javax.swing.JButton Button_FillColor;
    private javax.swing.JButton Button_OpenFile;
    private javax.swing.JButton Button_Pencil;
    private javax.swing.JButton Button_Redo;
    private javax.swing.JButton Button_Save;
    private javax.swing.JButton Button_Select;
    private javax.swing.JButton Button_StraightLine;
    private javax.swing.JButton Button_Undo;
    private javax.swing.JButton Button_View;
    private javax.swing.JComboBox<String> ComboBox_Lines;
    private javax.swing.JPanel ControlArea;
    private javax.swing.JPanel DrawingArea;
    private javax.swing.JLabel Label_DrawingMode;
    private javax.swing.JLabel Label_ShapesLines;
    private javax.swing.JLabel Label_Tools;
    private javax.swing.JPanel Panel_Shapes;
    private javax.swing.JPanel Panel_ShapesLines;
    private javax.swing.JPanel Panel_Tools1;
    private javax.swing.JPanel Panel_Tools2;
    private javax.swing.JSeparator Separator1;
    private javax.swing.JSeparator Separator2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel labelButton_leftA;
    private javax.swing.JLabel labelButton_rightA;
    // End of variables declaration//GEN-END:variables
}
