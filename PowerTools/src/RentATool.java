
import java.util.ArrayList;
import oop.powertool.PowerTool;
import oop.powertool.drill.Drill;
import oop.powertool.grinder.Grinder;
import oop.powertool.saw.Saw;

public class RentATool {

    private String comanyName;
    private ArrayList<PowerTool> equipment;
    private boolean[] available;
    private double DRILL_RENT_COST;
    private double SAW_RENT_COST;
    private double GRINDER_RENT_COST;

    public RentATool(String comanyName, int maximum) {
        this.comanyName = comanyName;
       this.equipment = new ArrayList<>();
        this.available = new boolean[maximum];
        this.DRILL_RENT_COST = 85.75;
        this.GRINDER_RENT_COST = 96.55;
        this.SAW_RENT_COST = 91.85;
    }

    public RentATool(String comanyName, ArrayList<PowerTool> equipment, int maximum) {
        this.comanyName = comanyName;
        this.equipment = equipment;
        
        this.DRILL_RENT_COST = 85.75;
        this.GRINDER_RENT_COST = 96.55;
        this.SAW_RENT_COST = 91.85;
        this.available = new boolean[maximum];
    }

    public String getComanyName() {
        return comanyName;
    }

    public ArrayList<PowerTool> getEquipment() {
        return equipment;
    }

    public boolean[] getAvailable() {
        return available;
    }

    public void addStock(PowerTool tools) {

        equipment.add(tools);
        this.available[equipment.size()] = true;

    }

    public double rentPowerTool(char toolType, int daysToRent) {
       // boolean found;
        double fee = -1;
        if (toolType == 'D') {

            for (int i = 0; i < available.length; i++) {
                if (equipment.get(i) instanceof Drill && available[i] == true) {

                    available[i] = false;
                    fee = daysToRent * DRILL_RENT_COST;
                    break;
                }

            }

        } else if (toolType == 'S') {

            for (int i = 0; i < available.length; i++) {
                if (equipment.get(i) instanceof Saw && available[i] == true) {

                    
                    available[i] = false;
                    fee = daysToRent * SAW_RENT_COST;
                    break; 
                }

            }

        } else if (toolType == 'G') {

            for (int i = 0; i < available.length; i++) {
                if (equipment.get(i) instanceof Grinder && available[i] == true) {

                   
                    available[i] = false;
                    fee = daysToRent * GRINDER_RENT_COST;
                    break;
                }

            }

        } else {
            fee = -1;
        }

        return fee;
    }

}
