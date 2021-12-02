import java.util.HashMap;
import java.util.Iterator;

public class Cafe {
    private String name;
    private HashMap<String, Beverage> menus = new HashMap<>();

    @Override
    public String toString() {
        String msg = "Cafe Name: " + name + " Beverage Count: " + menus.size() + "\n";
        Iterator<Beverage> values = menus.values().iterator();
        while(values.hasNext()){
            msg += "\t" + values.next() + "\n";
        }
        return msg;
    }

    public Cafe(String name){
        this.name = name;
    }

    public void addBeverage(Beverage newBeverage) {
        menus.put(newBeverage.getBeverageName(), newBeverage);
    }

    public void removeAllBeverage() {
        menus.clear();
    }

    public Beverage findBeverage(String name, String type) {
        Beverage findobj = new Beverage(name, type);
        if(menus.containsKey(name)){
            if(findobj.equals(menus.get(name))){
                return menus.get(name);
            }
            return null;
        }
        return null;
    }
}
