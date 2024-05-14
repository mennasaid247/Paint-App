/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.awt.Graphics;
import java.awt.Point;
import org.json.simple.JSONObject;


public class Circle extends AbstractShape {
    
    private int verticalDiameter;
    private int horizontalDiameter;
    private int borderNumber;
   public Circle(Point point,int verticalDiameter,int horizontalDiameter)
   {
     super(point);
     this.verticalDiameter=verticalDiameter;
     this.horizontalDiameter=horizontalDiameter;
   }
    
    @Override
    public void draw(Graphics canvas) {
        if(pressed){
        canvas.setColor(getBordersColor());
        canvas.drawRect(this.getPosition().x -4 , this.getPosition().y -4, 8, 8);
        canvas.drawRect(this.getPosition().x -4 +horizontalDiameter, this.getPosition().y -4, 8, 8);
        canvas.drawRect(this.getPosition().x -4 , this.getPosition().y +verticalDiameter -4, 8, 8);
        canvas.drawRect(this.getPosition().x -4 +horizontalDiameter, this.getPosition().y +verticalDiameter -4, 8, 8);}
        canvas.setColor(this.getColor());
        canvas.drawOval((int)this.getPosition().getX(), (int)this.getPosition().getY(), horizontalDiameter, verticalDiameter);
        canvas.setColor(this.getFillColor());
        canvas.fillOval((int)this.getPosition().getX(),(int)this.getPosition().getY(), horizontalDiameter,  verticalDiameter);
          }

    @Override
    public boolean contains(Point point) {
//      double p = (Math.pow((((int)point.getX()) - ((int)this.getPosition().getX()+this.horizontalRadius)), 2)
//                    / Math.pow(this.horizontalRadius, 2))
//                   + (Math.pow((((int)point.getY()) - ((int)this.getPosition().getY()+this.verticalRadius)), 2)
//                      / Math.pow(this.verticalRadius, 2));
      
        double p = (Math.pow((((int)point.getX()) - ((int)this.getPosition().getX()+(this.horizontalDiameter/2))), 2) / Math.pow((this.horizontalDiameter/2), 2)) + (Math.pow((((int)point.getY()) - ((int)this.getPosition().getY()+(this.verticalDiameter/2))), 2)  / Math.pow((this.verticalDiameter/2), 2));
if(p<=1)
    return true;
else
      return false;
    }

    @Override
    public void moveTo(Point point) {
        int dx=(int) (point.getX()-this.getDraggingPoint().getX());
        int dy= (int) (point.getY()-this.getDraggingPoint().getY());
      setPosition(new Point((int)getPosition().getX()+dx,
     (int)getPosition().getY()+dy ));
        
    }

    @Override
    public AbstractShape copy(AbstractShape shape) {
        Circle temp=new Circle(shape.getPosition(),((Circle)shape).verticalDiameter,((Circle)shape).horizontalDiameter);
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
         s.setPosition(new Point(this.getPosition().x -4 +horizontalDiameter,this.getPosition().y -4));
         if(s.contains(point))
         {   borderNumber=2;
           System.out.println("2");
             return true;}
         s.setPosition(new Point(this.getPosition().x-4,this.getPosition().y +verticalDiameter));
         if(s.contains(point))
         {   borderNumber=3;
           System.out.println("3");
             return true;}
         s.setPosition(new Point(this.getPosition().x-4 +horizontalDiameter, this.getPosition().y -4 +verticalDiameter));
         if(s.contains(point))
         {   borderNumber=4;
           System.out.println("4");
             return true ;}
         else return false;
    }

    @Override
    public void resize(Point point) {
      int dx,dy; 
        dx=(point.x-this.getDraggingPoint().x);
        dy=(point.y-this.getDraggingPoint().y);
        Point newPosition=new Point();
         if(borderNumber==1)
         {
          newPosition.x=getPosition().x+dx;
          newPosition.y=getPosition().y+dy;
          setPosition(newPosition);
          this.horizontalDiameter=this.horizontalDiameter-(dx);
          this.verticalDiameter=this.verticalDiameter-(dy);
          if(dx>horizontalDiameter )
         {
          borderNumber=2;
         }
         if(dy>verticalDiameter)
         {
          borderNumber=3;
         }
         }
         if(borderNumber==2)
         {
           newPosition.x=getPosition().x;
           newPosition.y=getPosition().y+dy;
           setPosition(newPosition);
           this.horizontalDiameter=this.horizontalDiameter+(dx);
           this.verticalDiameter=this.verticalDiameter-(dy);
           
          if(dx>horizontalDiameter )
         {
          borderNumber=1;
         }
         if(dy>verticalDiameter)
           {
               borderNumber=4;
           }
           
         }
         if(borderNumber==3)
         {
           newPosition.x=getPosition().x+dx;
           newPosition.y=getPosition().y;
           setPosition(newPosition);
           this.horizontalDiameter=this.horizontalDiameter-(dx);
          this.verticalDiameter=this.verticalDiameter+(dy);
          
           if(dy>verticalDiameter)
          {
          borderNumber=1;
          }
         if(dx>horizontalDiameter)
          {
              borderNumber=4;
          }
         }
         if(borderNumber==4){
           newPosition.x=getPosition().x;
           newPosition.y=getPosition().y;
           setPosition(newPosition);
             
           this.horizontalDiameter=this.horizontalDiameter+(dx);
           this.verticalDiameter=this.verticalDiameter+(dy);
           
           if(dx>horizontalDiameter)
           {
               borderNumber=3;
           }
           if(dy>verticalDiameter)
           {
               borderNumber=2;
           }
         }
    }
    @Override
      public JSONObject tojson()
      {  JSONObject obj=(JSONObject) super.tojson();
      obj.put("Type","Oval");
//       JSONObject verradius=new JSONObject();
//   verradius.put("verticalradius",verticalradius+"");
//    obj.put("verticalradius",verradius);
//    JSONObject horradius=new JSONObject();
//   horradius.put("horizontalradius",horizontalradius+"");
//    obj.put("horizontalradius",horradius);
      obj.put("vertical radius", String.valueOf(verticalDiameter));
       obj.put("Horizontal radius",String.valueOf(horizontalDiameter) );
      
       return obj;
       
      

      }
    
}
