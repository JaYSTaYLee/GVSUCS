public class GeyserTest
{
    public static void main(String args[]){
        GeyserDatabase db = new GeyserDatabase();
        
        db.readGeyserData("TestList.txt");
        
        //System.out.println(db.eruptionArrayList);
        
        //System.out.println(db.getNumEruptions(1,15,2010));
        
        //System.out.println(db.getEruptions("Scott"));
        
        System.out.println(db.findDayWithMostEruptions(2010));
        //System.out.println(db.geyserArrayList.get(0).getName());
    }

}
