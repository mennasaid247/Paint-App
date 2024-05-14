
package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
 import java.awt.geom.Rectangle2D;
import org.json.simple.JSONObject;


 
public class Rectangle extends AbstractShape  {
    
    private int width;
    private int height;
    private int borderNumber;
public Rectangle(Point point,int width,int height)
   {
   super(point);
   this.width=width;
   this.height=height;
     }
  
    @Override
   public void draw(Graphics canvas) {
       if(pressed){
        canvas.setColor(getBordersColor());
        canvas.drawRect(this.getPosition().x -4 , this.getPosition().y -4, 8, 8);
        canvas.drawRect(this.getPosition().x -4 +width, this.getPosition().y -4, 8, 8);
        canvas.drawRect(this.getPosition().x -4 , this.getPosition().y +height -4, 8, 8);
        canvas.drawRect(this.getPosition().x -4 +width, this.getPosition().y +height -4, 8, 8);}
        canvas.setColor(this.getColor());
        canvas.drawRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), width, height);
        canvas.setColor(this.getFillColor());
        canvas.fillRect((int)this.getPosition().getX(), (int)this.getPosition().getY(), width, height);
    }

    @Override
    public boolean contains(Point point) {
      Point topRight=new Point((this.getPosition().x) + width,this.getPosition().y);
      Point bottomRight=new Point((this.getPosition().x )+ width,(this.getPosition().y) + height);
      Point bottomLeft=new Point(this.getPosition().x, (this.getPosition().y) + height);
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
         Rectangle temp=new Rectangle(shape.getPosition(),((  Rectangle)shape).width,((  Rectangle)shape).height);
         temp.setColor(shape.getColor());
        temp.setFillColor(shape.getFillColor());
         return ((AbstractShape)temp);
//      
//throw new UnsupportedOperationException("Not supported yet.");
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
         s.setPosition(new Point(this.getPosition().x -4 +width,this.getPosition().y -4));
         if(s.contains(point))
         {   borderNumber=2;
           System.out.println("2");
             return true;}
         s.setPosition(new Point(this.getPosition().x-4,this.getPosition().y +height));
         if(s.contains(point))
         {   borderNumber=3;
           System.out.println("3");
             return true;}
         s.setPosition(new Point(this.getPosition().x-4 +width, this.getPosition().y -4 +height));
         if(s.contains(point))
         {   borderNumber=4;
           System.out.println("4");
             return true ;}
         else return false;
     }

    @Override
    public void resize(Point point) {
        int dx,dy; boolean flipped=false;boolean exit=false;
        dx=(point.x-this.getDraggingPoint().x);
        dy=(point.y-this.getDraggingPoint().y);
        Point newPosition=new Point();
//         if(borderNumber==1)
//         {
//          newPosition.x=getPosition().x+dx;
//          newPosition.y=getPosition().y+dy;
//          setPosition(newPosition);
//          this.width=this.width-dx;
//          this.height=this.height-dy;
//         }
//         if(borderNumber==2)
//         {
//           newPosition.x=getPosition().x;
//           newPosition.y=getPosition().y+dy;
//           setPosition(newPosition);
//           this.width=this.width+dx;
//           this.height=this.height-dy;
  //         
    //     }
      //   if(borderNumber==3)
//         {
  //         newPosition.x=getPosition().x+dx;
    //       newPosition.y=getPosition().y;
      //     setPosition(newPosition);
//           this.width=this.width-dx;
  //        this.height=this.height+dy;
    //     }
      //   if(borderNumber==4){
        //   newPosition.x=getPosition().x;
          // newPosition.y=getPosition().y;
//           setPosition(newPosition);
  //           
    //       this.width=this.width+dx;
      //     this.height=this.height+dy;
        // }
               if(borderNumber==1)
         {
          newPosition.x=getPosition().x+dx;
          newPosition.y=getPosition().y+dy;
          setPosition(newPosition);
          this.width=this.width-dx;
          this.height=this.height-dy;
           if(dx>width )
         {
          borderNumber=2;
         }
         if(dy>height)
         {
          borderNumber=3;
         }
         }
         if(borderNumber==2)
         {
           newPosition.x=getPosition().x;
           newPosition.y=getPosition().y+dy;
           setPosition(newPosition);
           this.width=this.width+dx;
           this.height=this.height-dy;
         if(dx>width )
         {
          borderNumber=1;
         }
         if(dy>height)
           {
               borderNumber=4;
           }
           
         }
         if(borderNumber==3)
         {
           newPosition.x=getPosition().x+dx;
           newPosition.y=getPosition().y;
           setPosition(newPosition);
           this.width=this.width-dx;
          this.height=this.height+dy;
         if(dy>height)
          {
          borderNumber=1;
          }
         if(dx>width)
          {
              borderNumber=4;
          }
         }
         if(borderNumber==4){
           newPosition.x=getPosition().x;
           newPosition.y=getPosition().y;
           setPosition(newPosition);
           this.width=this.width+dx;
           this.height=this.height+dy;
           if(dx>width)
           {
               borderNumber=3;
           }
           if(dy>height)
           {
               borderNumber=2;
           }
         }
    }
     @Override
      public JSONObject tojson()
      {  JSONObject obj=(JSONObject) super.tojson();
      obj.put("Type","Recatngle");
      obj.put("Width",String.valueOf(width) );
       obj.put("Height",String.valueOf(height) );
       return obj;
       
      

      }
}