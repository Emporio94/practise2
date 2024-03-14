import java.util.List;
import java.util.ArrayList;

public class TraderGroup{

    protected List<Person> traders = new ArrayList<>();
    protected String name;


    public TraderGroup(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void checkBalances(TraderAssetDesk traderAssetDesk){
        //Task Two
    }

    public void add(Person trader){
        // Adds a trader to this groups list of traders
        this.traders.add(trader);
    }

    public void printTraderDetails(){
        System.out.println("Trader Group: " + name);
        for (Person trader : traders) {
            // Assuming Person class has a method to get the full name and role
            System.out.println("Name: " + trader.firstName + " " + trader.lastName + ", Role: " + trader.getRole().toString());
        }
    }

}
