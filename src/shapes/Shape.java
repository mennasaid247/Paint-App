
package shapes;

import org.json.simple.JSONObject;


public interface Shape {

    public java.awt.Point getPosition();
    public void setPosition(java.awt.Point p);
    public java.awt.Color getColor();
    public void setColor(java.awt.Color color);
    public void draw(java.awt.Graphics canvas);
    public void setFillColor(java.awt.Color color);
    public java.awt.Color getFillColor();
     public JSONObject tojson();
}
