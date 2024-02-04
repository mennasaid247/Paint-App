/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import org.json.simple.JSONObject;

/**
 *
 * @author ann
 */
    public class Triangle extends AbstractShape {
    
    private Point point2;
    private Point point3;
    private int borderNumber;
 
    public Triangle(Point point1,Point point2, Point point3)
    {
    super(point1);
    this.point2=point2;
    this.point3=point3;
    }
    @Override
   public void draw(Graphics canvas) {
       if(pressed){
     canvas.setColor(getBordersColor());
     canvas.drawRect(this.getPosition().x -4 , this.getPosition().y -4, 8, 8);
     canvas.drawRect(this.point2.x -4, this.point2.y -4, 8, 8);
     canvas.drawRect(this.point3.x -4 , this.point3.y -4, 8, 8);}
     int []x={(int)this.getPosition().getX(),(int)point2.getX(),(int)point3.getX()};
     int []y={(int)this.getPosition().getY(),(int)point2.getY(),(int)point3.getY()};
     canvas.setColor(this.getColor());
     canvas.drawPolygon(x,y,3);
     canvas.setColor(this.getFillColor());
     canvas.fillPolygon(x,y,3);
    }

    @Override
    public boolean contains(Point point) {
      int []x={this.getPosition().x,point2.x,point3.x};
      int []y={this.getPosition().y,point2.y,point3.y};
      Polygon tri=new Polygon(x,y,3);
      return tri.contains(point);
    }

    @Override
    public void moveTo(Point point) {
        int diffOfX=point.x-this.getDraggingPoint().x;
        int diffOfY=point.y-this.getDraggingPoint().y;
        this.setPosition(new Point((this.getPosition().x)+diffOfX,(this.getPosition().y)+diffOfY));
        point2=new Point(point2.x+diffOfX,point2.y+diffOfY);
        point3=new Point(point3.x+diffOfX,point3.y+diffOfY);
    }

    @Override
    public AbstractShape copy(AbstractShape shape) {
        Triangle temp=new Triangle(shape.getPosition(),(( Triangle)shape).point2,(( Triangle)shape).point3 );
      
         temp.setColor(shape.getColor());
        temp.setFillColor(shape.getFillColor());
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
         s.setPosition(new Point(this.point2.x -4,this.point2.y -4));
         if(s.contains(point))
         { borderNumber=2;
           System.out.println("2");
           return true;}
         s.setPosition(new Point(this.point3.x -4,this.point3.y -4));
         if(s.contains(point))
         {
           borderNumber=3;
           System.out.println("3");
           return true;
         }
     
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
        } if(borderNumber ==2){
          dx=point.x-this.point2.x;
          dy=point.y-this.point2.y;
          point2=new Point(this.point2.x+dx,this.point2.y+dy);
        }
        if(borderNumber==3)
        {dx=point.x-this.point3.x;
          dy=point.y-this.point3.y;
          point3=new Point(this.point3.x+dx,this.point3.y+dy);
        
        }
    
    }
    @Override
      public JSONObject tojson()
      {  JSONObject obj=(JSONObject) super.tojson();
      obj.put("Type","Triangle");
     obj.put("X2",String.valueOf(point2.x));
  obj.put("Y2",String.valueOf(point2.y));
   obj.put("X3",String.valueOf(point3.x));
  obj.put("Y3",String.valueOf(point3.y));
 
   
              return obj;
       
      

      }

}

   