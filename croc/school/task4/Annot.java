package ru.croc.school.task4;
public class Annot {
    public String description;
    public Figure figure;

    public Annot(String description, Figure[] figures){
        for (Figure figure:figures){
            this.description = figure.getDescription();
            this.figure = figure;
        }
    }

    public void toString(Figure figure){
        if (figure instanceof Circle circle) {
            System.out.format("Circle (%d, %d), %d: %s", circle.getX1(), circle.getY1(),
                    circle.getRadius(), circle.getDescription());
        }
        else if (figure instanceof Rectangle rect){
            System.out.format("Rectangle (%d, %d), (%d, %d): %s", rect.getX1(), rect.getY1(), rect.getX2(),
                    rect.getY2(), rect.getDescription());
        }
    }
}

class Figure {
    protected String description;

    public String getDescription() {
        return this.description;
    }
}

class Circle extends Figure{
    private int x1;
    private int y1;
    private int radius;

    public Circle(int x1, int y1, int radius, String description){
        this.x1 = x1;
        this.y1 = y1;
        this.radius = radius;
        super.description = description;
    }
    public int getX1(){
        return this.x1;
    }
    public int getY1(){
        return this.y1;
    }
    public int getRadius(){
        return this.radius;
    }
}

class Rectangle extends Figure{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2, String description) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        super.description = description;
    }

    public int getX1(){
        return this.x1;
    }
    public int getY1(){
        return this.y1;
    }
    public int getX2(){
        return this.x2;
    }
    public int getY2(){
        return this.y2;
    }
}
