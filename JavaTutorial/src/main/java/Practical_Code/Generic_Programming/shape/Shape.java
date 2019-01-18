package Practical_Code.Generic_Programming.shape;

abstract class Shape
{
    private int x;
    private int y;

    // constructor
    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // accessors for x & y
    int getX() { return x; }
    int getY() { return y; }
    void setX(int newx) { x = newx; }
    void setY(int newy) { y = newy; }

    // virtual draw method
    abstract void draw();
}
