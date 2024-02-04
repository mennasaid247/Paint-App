package shapes;


import java.awt.Graphics;
import java.util.ArrayList;

public class Canvas extends javax.swing.JPanel  implements DrawingEngine {

    private ArrayList<Shape> x = new ArrayList<>();

    /**
     * Creates new form DrawingArea
     */
    public Canvas() {
        initComponents();

    }

    
    @Override
    protected void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);
        for (int i = 0; i < x.size(); i++) {
            x.get(i).draw(canvas);
            // Rectangle bounds = canvas.
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void addShape(Shape shape) {
        x.add(shape);
    }
    @Override
    public void removeShape(Shape shape) {
        x.remove(shape);
    }
    @Override
    public Shape[] getShapes() {
      return x.toArray(new Shape[x.size()]);
    }
    @Override
    public void refresh(Graphics canvas) {
     this.repaint();
    }
    public void clearpanel()
    {int i;
    Shape[]temp=getShapes();
        for(i=0;i<temp.length;i++)
        {removeShape(temp[i]);
        refresh(null);
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
