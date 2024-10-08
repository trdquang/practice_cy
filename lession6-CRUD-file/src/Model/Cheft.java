package Model;

public class Cheft {
    private int id;
    private String name;
    private String phoneNumber;
    private boolean status;
    private static int length = 0;

    public Cheft() {
    }

    public Cheft(int id, String name, String phoneNumber, boolean status) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static int getLength() {
        return length;
    }

    public static void setLength(int length) {
        Cheft.length = length;
    }

    @Override
    public String toString() {
//        return super.toString();
        return String.format("%-10d, %-15s, %-15s, %-1b", id, name, phoneNumber, status);
    }
}
