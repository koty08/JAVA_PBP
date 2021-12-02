package edu.pnu.edit;

import edu.pnu.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape s){
        shapes.add(s);
    }

    public void clear(){
        shapes.clear();
    }

    public void list(){
        System.out.println(shapes);
    }
}
