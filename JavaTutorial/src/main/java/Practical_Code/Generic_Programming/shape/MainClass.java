package Practical_Code.Generic_Programming.shape;

import java.util.ArrayList;
import java.util.List;

class MainClass
{
    public static void main(String[] args)
    {
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(2,3 , 10, 10));
        rectangles.add(new Rectangle(2,3 , 20, 20));
        rectangles.add(new Rectangle(2,3 , 30, 30));

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(2, 3 , 10));
        circles.add(new Circle(2, 3 , 20));
        circles.add(new Circle(2, 3 , 30));

        Drawer obj = new Drawer();
        obj.drawPicture(rectangles);
        obj.drawPicture(circles);
    }
}
