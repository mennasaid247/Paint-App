
package shapes;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;

public class Line extends AbstractShape {
    
    private Point endPoint;
    private int borderNumber;
 
    public Line(Point point,Point endPoint)
    {
        super(point);
        this.endPoint=endPoint;
    }
  
    @Override
    public void draw(Graphics canvas) {
        if(pressed){
        canvas.setColor(getBordersColor());
        canvas.drawRect(this.getPosition().x -4, this.getPosition().y -4, 8, 8);
         canvas.drawRect(endPoint.x -4,endPoint.y -4, 8, 8);}
        canvas.setColor(this.getColor());
        canvas.drawLine((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int) endPoint.getX(), (int) endPoint.getY());
    }

    @Override
    public boolean contains(Point point) {
        double slope=(endPoint.getY()-getPosition().getY())/(endPoint.getX()-getPosition().getX());
       double c=endPoint.getY()-(slope*endPoint.getX());
         if(point.getY()==(slope*point.getX()+c))
          {return true;
            }
            else
           return false;
    }  

    @Override
    public void moveTo(Point point) {
     int dx=(int) (point.getX()-this.getDraggingPoint().getX());
     int dy= (int) (point.getY()-this.getDraggingPoint().getY());
      setPosition(new Point((int)getPosition().getX()+dx,
     (int)getPosition().getY()+dy ));
      this.endPoint=new Point((int)endPoint.getX()+dx,(int)endPoint.getY()+dy);
    }  

    @Override
    public AbstractShape copy(AbstractShape shape) {
        Line temp=new Line(shape.getPosition(),((Line)shape).endPoint);
        temp.setColor(shape.getColor());
        return ((AbstractShape)temp);
  }

    @Override
    public boolean inBorders(Point point) {
      Square s = new Square(new Point(this.getPosition().x -4,this.getPosition().y -4) ,8);
         if(s.contains(point))
         {
            borderNumber = 1;
            System.out.println("1");
             return true;
         }
         s.setPosition(new Point(endPoint.x -4,endPoint.y -4));
         if(s.contains(point))
         {   borderNumber=2;
           System.out.println("2");
             return true;}
     
         else return false;
    }

    @Override
    public void resize(Point point) {
        int dx;
        int dy;
        if(borderNumber==1)
        {
           dx=point.x-this.getPosition().x;
           dy=point.y-this.getPosition().y;
           setPosition(new Point(getPosition().x+dx,getPosition().y+dy));
        }else {
          dx=point.x-this.endPoint.x;
          dy=point.y-this.endPoint.y;
           endPoint=new Point(this.endPoint.x+dx,this.endPoint.y+dy);
        }
        
     }
    @Override
      public JSONObject tojson()
      {  JSONObject obj=(JSONObject) super.tojson();
      obj.put("Type","Line");
      obj.put("Endpoint X", String.valueOf(endPoint.x));
       obj.put("Endpoint Y", String.valueOf(endPoint.y) );
       return obj;
       
     

      }

   
    }

   

