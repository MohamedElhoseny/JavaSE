package Practical_Code.Generic_Programming.shape;

import java.util.List;

class Drawer
{
    public void drawPicture(List<? extends Shape> shapes)
    {
        for (Shape shape: shapes) {
            shape.draw();
        }
    }
}
