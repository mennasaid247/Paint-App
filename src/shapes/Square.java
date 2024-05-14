/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;
import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;
public class Square extends AbstractShape{
   
    private int length;
public Square(Point point,int length)
{
  super(point);
  this.length=length;
}

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), length, length);
        canvas.setColor(this.getFillColor());
        canvas.fillRect((int)this.getPosition().getX(),(int)this.getPosition().getY(), length, length);
       }

    @Override
    public boolean contains(Point point) {
      Point topRight=new Point((this.getPosition().x) + length,this.getPosition().y);
      Point bottomRight=new Point((this.getPosition().x )+ length,(this.getPosition().y) + length);
      Point bottomLeft=new Point(this.getPosition().x, (this.getPosition().y) + length);
      if((point.x>=this.getPosition().x)&& (point.x<=topRight.x) && (point.y<=bottomLeft.y) && (point.y>=this.getPosition().y))
      {
          return true;
      }
      else 
        return false;
   
    }

    @Override
    public void moveTo(Point point) {
     int diffOfX=point.x-this.getDraggingPoint().x;
     int diffOfY=point.y-this.getDraggingPoint().y;
     this.setPosition(new Point((this.getPosition().x)+diffOfX,(this.getPosition().y)+diffOfY));
    }

    @Override
    public AbstractShape copy(AbstractShape shape) {
       Square temp=new Square(shape.getPosition(),(( Square)shape).length );
      
         temp.setColor(shape.getColor());
        temp.setFillColor(shape.getFillColor());
         return ((AbstractShape)temp);
//        return ((AbstractShape)temp);
//throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean inBorders(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void resize(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
@Override
      public JSONObject tojson()
      {  JSONObject obj=(JSONObject) super.tojson();
      obj.put("Type","Square");
      obj.put("Length",String.valueOf(length) );
              return obj;
       
      

      }
   
}
