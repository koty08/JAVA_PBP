package edu.pnu.admin;

import edu.pnu.admin.Beverage;
import edu.pnu.collection.GenericList;

import java.util.HashMap;
import java.util.Iterator;

public class Cafe {
    private String name;
    private GenericList<Beverage> students = new GenericList<Beverage>();
    private GenericList<Beverage> menus = new GenericList<Beverage>();

    @Override
    public String toString() {
        String msg = "Cafe Name: " + name + " Beverage Count: " + students.getSize() + "\n";
        Iterator<Beverage> values = students.values().iterator();
        while(values.hasNext()){
            msg += "\t" + values.next() + "\n";
        }
        return msg;
    }

    public Cafe(String name){
        this.name = name;
    }

    public void addBeverage(Beverage newBeverage) {
        students.put(newBeverage);
    }

    public void removeAllBeverage() {
        students.clear();
    }

    public Beverage findBeverage(String name, String type) {
        Beverage findobj = new Beverage(name, type);
        for(int i = 0; i < students.getSize(); i++){
            if(findobj.equals(students.get(i))){
                return students.get(i);
            }
        }
        return null;
    }
}
