/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package shapes;

import java.awt.Point;

/**
 *
 * @author ann
 */
public interface Movable {
    
    public void setDraggingPoint(Point point);
    public Point getDraggingPoint();
    public boolean contains(Point point);
    public void moveTo(Point point);
    public AbstractShape copy(AbstractShape shape)  ; // public AbstractShape getbounds();
    public void resize(Point point);
}
