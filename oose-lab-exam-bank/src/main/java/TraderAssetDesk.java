import java.util.ArrayList;
import java.util.List;

public class TraderAssetDesk {

    protected int wib = -30000;
    protected int wia = 30000;

    private TraderGroup currentTeamLeadGroup = null; // Holds the current team lead's group
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
            // Create a new group for this team lead
            currentTeamLeadGroup = new TraderGroup(trader.getName() + " Group");
            currentTeamLeadGroup.add(trader);
            allTraderGroups.add(currentTeamLeadGroup);
        } else if (currentTeamLeadGroup != null) {
            // Add this trader to the current team lead's group
            currentTeamLeadGroup.add(trader);
        } else {
            // If no team lead has been encountered yet, add to the main group
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
        System.out.println("Asset Deck: " + this.getAssetType().name()); // Print once for the asset type
        for (TraderGroup group : allTraderGroups) {
            if (group == traderGroup) { 
                continue; 
            }
            group.printTraderDetails();
        }
    }
    

    
}
