package Practical_Code.Generic_Programming.shape;

class Circle extends Shape {
    private int radius;

    // constructor
    Circle(int x, int y, int radius) {
        super(x, y);
        setRadius(radius);
    }

    int getRadius() { return radius; }
    void setRadius(int newradius) { radius = newradius; }

    // draw the circle
    void draw() {
        System.out.println("Drawing a Circle at:(" + getX() + ", " + getY() +
                "), radius " + getRadius());
    }
}
