import java.util.List;
import java.util.HashMap;

public class Bank {
    
    LoadCSV loadCSV = new LoadCSV();

    HashMap<AssetType,TraderAssetDesk> desks = new HashMap<AssetType, TraderAssetDesk>();
    int roomCounter = 0;


    protected void trade(){
        for (TraderAssetDesk traderAssetDesk : desks.values()){
            traderAssetDesk.traderGroup.checkBalances(traderAssetDesk);;
        }
    }

    public void allTrades(){
        for (int counter = 0; counter < 1; counter++){
            trade();
        }
    }

    public void setUpTraderAssetDesk(){
        for (AssetType assetType : AssetType.values()){
            addTraderAssetDeck(new TraderAssetDesk(assetType));
        }
    }

    public void addTraderAssetDeck(TraderAssetDesk traderAssetDesk){
        desks.put(traderAssetDesk.getAssetType(), traderAssetDesk);
    }



    public TraderAssetDesk getTraderAssetDesk(AssetType assetType){
        return desks.get(assetType);
    }


    protected void setUpPeople(){
        List<String[]> csvPeople = loadCSV.getCSVRows("src/main/resource/people.csv");
        for (String[] row : csvPeople){
            // Assume CSV format: Role, First Name, Last Name, Asset Type, Balance, Trades
            String role = row[0];
            AssetType assetType = AssetType.valueOf(row[3]); // Ensure AssetType enum matches CSV
            Person person = PersonFactory.createPerson(row); // Implement PersonFactory for object creation
            
            TraderAssetDesk desk = getTraderAssetDesk(assetType);
            if (desk != null) {
                desk.addTrader(person); 
            }
        }
    }

    public void setUp(){
        setUpTraderAssetDesk();
        setUpPeople();
    }
    
    public static void main(String[] args){
        Bank bank = new Bank();
        bank.setUp();
        bank.allTrades();
        bank.setUpPeople();
        TraderAssetDesk equityDesk = bank.getTraderAssetDesk(AssetType.COMMODITIES);
        
        System.out.println(equityDesk.getSize());
        //equityDesk.printAllTraderDetails(); // This now includes team leads and their groups
       
    
    }
}
