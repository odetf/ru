package ru.croc.school.task5;

public class Annotation {
    private String description;
    private Figure figure;

    public Annotation(String description, Figure figure){
            this.description = description;
            this.figure = figure;
        }

    @Override
    public String toString(){
        return figure.toString() + " " + description;
    }

    public String getDescription(){
        return description;
    }

    Annotation findByPoint(Annotation annot[], int x, int y, Annotation first){
        outer:
        for (Annotation a:annot){
            if (a.figure instanceof Circle circ){
                if ((circ.getX1()-circ.getRadius() <= x | circ.getX1()-circ.getRadius() >= x)
                        & (circ.getY1()- circ.getRadius() <= y) | (circ.getY1()- circ.getRadius() >= y)) {
                    first = a;
                    break;
                }
            }
            else if (a.figure instanceof Rectangle rec){
                if ((rec.getX1()<= x)&(rec.getX2()>=x)&(rec.getY1()<=y)&(rec.getY2()>=y)){
                    first = a;
                    break;
                }
            }
        }
        return first;
    }

    Annotation findByLabel(Annotation[] annots, String label, Annotation annotation){
        for (Annotation annot:annots){
            if (annot.description.contains(label)){
                annotation = annot;
                break;
            }
        }
        return annotation;
    }
    public interface Movable {
        void move(int dx, int dy); //"place" shows a place of the coordinate to change
    }
    abstract class Figure implements Movable {
    }

class Circle extends Figure{
    private int x1;
    private int y1;
    private int radius;

    public Circle(int x1, int y1, int radius){
        this.x1 = x1;
        this.y1 = y1;
        this.radius = radius;
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

    public void setCoord(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void move(int dx, int dy){
        setCoord(x1+dx, y1+dx);
    }

    @Override
    public String toString(){
        return "Circle ("+ Annotation.Circle.this.getX1()+", "+ Annotation.Circle.this.getY1()+"), "+ Annotation.Circle.this.getRadius();
    }
}

class Rectangle extends Figure{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
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

    void setCoords(int x, int y, int place){
        if (place == 1){
            this.x1 = x; this.y1 = y;
        } else {
            this.x2 = x; this.y2 = y;
        }
    }

    @Override
    public void move(int dx, int dy){
        setCoords(x1+dx, y1+dy, 1);
        setCoords(x2+dx, y2+dy, 2);
    }
    @Override
    public String toString(){
        return "Rectangle ("+ Annotation.Rectangle.this.getX1()+", "+ Annotation.Rectangle.this.getY1()+"), ("
                + Annotation.Rectangle.this.getX2()+", "+ Annotation.Rectangle.this.getY2()+"):";
    }
}}
