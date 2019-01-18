package Practical_Code.Generic_Programming.shape;

class Rectangle extends Shape
{
    private int width;
    private int height;

    // constructor
    Rectangle(int x, int y, int width, int height) {
        super(x, y);
        setWidth(width);
        setHeight(height);
    }


    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    void setWidth(int newwidth) {
        width = newwidth;
    }

    void setHeight(int newheight) {
        height = newheight;
    }

    // draw the rectangle
    void draw() {
        System.out.println("Drawing a Rectangle at:" +
                "(" + getX() + ", " + getY() + "), width " + getWidth() + ", height " + getHeight());
    }
}
