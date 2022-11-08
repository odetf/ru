package ru.croc.school.task5;
public class Annotation {
    public String description;
    public Figure figure;

    public Annotation(String description, Figure[] figures){
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

    Annotation findByPoint(Annotation annot[], int x, int y, Annotation first){
        outer:
        for (Annotation a:annot){
            if (a.figure instanceof Circle circ){
                if (circ.getX1() == x & circ.getY1()==y) {
                    first = a;
                    break outer;
                }
            }
            else if (a.figure instanceof Rectangle rec){
                if ((rec.getX1()==x & rec.getY1()==y) | (rec.getX2()==x & rec.getY2()==y)){
                    first = a;
                    break outer;
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
        void move(int dx, int dy, int place); //"place" shows a place of the coordinate to change
    }
    abstract class Figure implements Movable {
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

    public void setCoord(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void move(int dx, int dy, int place){
        place = 0;
        setCoord(x1+dx, y1+dx);
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

    void setCoords(int x, int y, int place){
        if (place == 1){
            this.x1 = x; this.y1 = y;
        } else {
            this.x2 = x; this.y2 = y;
        }
    }

    @Override
    public void move(int dx, int dy, int place){
        if (place == 1){
            setCoords(x1+dx, y1+dy, 1);
        } else {
            setCoords(x2+dx, y2+dy, 2);
        }
    }
}}
