import java.util.ArrayList;
import java.util.List;

public class TraderAssetDesk {

    protected int wib = -30000;
    protected int wia = 30000;

    protected TraderGroup traderGroup;
    private List<TraderGroup> allTraderGroups = new ArrayList<>();  
    private AssetType assetType;
    private int groupCounter = 1;
   

    public TraderAssetDesk(AssetType assetType){
        this.assetType = assetType;
        traderGroup = new TraderGroup(assetType.name());
        allTraderGroups.add(traderGroup);
    }

    public void addTrader(Person trader) {
        if (trader.getRole() == Role.TEAM_LEAD) {
            // Create new group for the team lead and add them to it
            TraderGroup newGroup = new TraderGroup(trader.getName() + " Group");
            newGroup.add(trader);
            allTraderGroups.add(newGroup);
            // Optionally, also add team lead to the main group if required
            // traderGroup.add(trader);
        } else {
            // Determine correct group for trader and add them
            // This might involve checking a mapping of team leads to groups
            traderGroup.add(trader);
        }
    }
    

    public String getName(){
        return assetType.name();
    }

    public AssetType getAssetType(){
        return assetType;
    }

    public int getGroupCounter(){
        return groupCounter;
    }

    public int getSize(){
        return allTraderGroups.size();
    }

    
    public void printAllTraderDetails(){
        for (TraderGroup group : allTraderGroups) {
            group.printTraderDetails();
        }
    }

    
}
