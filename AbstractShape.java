/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Color;
import java.awt.Point;
import org.json.simple.JSONObject;
/**
 *
 * @author ann
 */
public abstract class AbstractShape implements Shape,Movable{

    private Color color;
    private Color fillColor;
    private Color bordersColor=Color.BLACK;
    private Point position;
    private Point draggingPoint;
    public boolean pressed;
    public AbstractShape(Point position)
    {
        this.setPosition(position);
    }
    
    @Override
    public Point getPosition() {
        return position;
    }
    @Override
    public void setPosition(Point p) {
      this.position=p;
    }

    @Override
    public Color getColor() {
     return color;
    }

    @Override
    public void setColor(Color color) {
      this.color=color;
    }
    
    @Override
    public void setFillColor(Color color) {
     this.fillColor=color;
    }

    @Override
    public Color getFillColor() {
    return fillColor;
    }
    @Override
     public void setDraggingPoint(Point point)
     {
         draggingPoint=point;
     }
    @Override
    public Point getDraggingPoint()
    {
        return draggingPoint;
    }
     public void setBordersColor(Color color)
     {
         bordersColor=color;
     }
    public Color getBordersColor()
    {
        return bordersColor;
    }
   abstract public boolean inBorders(Point point);
    @Override
      public JSONObject tojson()
     {JSONObject obj=new JSONObject();
    
   obj.put("X",String.valueOf(position.x));
  obj.put("Y",String.valueOf(position.y));
  
   String bordercolor=color.toString();
   obj.put("Border color",extractstring(bordercolor));
   
     String fillcolor=fillColor.toString();
     obj.put("Fill color",extractstring(fillcolor));
     return obj;
    
   
    
   
         
     }
     private String extractstring (String s)
     {
         return s.substring(15,s.length()-1);
     }
}
