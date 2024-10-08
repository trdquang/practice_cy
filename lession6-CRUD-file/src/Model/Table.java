package Model;

public class Table {
    private int id;
    private String name;
    private String guestName;
    private Cheft cheft;
    private static int length = 0;

    public Table() {
    }

    public Table(int id, String name, String guestName, Cheft cheft) {
        this.id = id;
        this.name = name;
        this.guestName = guestName;
        this.cheft = cheft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Cheft getCheft() {
        return cheft;
    }

    public void setCheft(Cheft cheft) {
        this.cheft = cheft;
    }

    public void addCheft(Cheft cheft){
        this.cheft = cheft;
    }

    public void removeCheft(Cheft cheft){
        this.cheft = null;
    }

    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Table.length = length;
    }

    @Override
    public String toString() {
//        return super.toString();
        String s1 =  String.format("%-10d, %-15s, %-15s", id, name, guestName);
        if (cheft != null) {
            s1 = s1+ ", " +cheft.toString();
        }
        return s1;
    }
}
