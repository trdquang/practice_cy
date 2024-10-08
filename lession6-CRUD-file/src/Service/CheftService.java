package Service;

import Model.Cheft;
import Model.Dish;
import Util.Input;

import java.util.Scanner;

public class CheftService implements BaseService{
    static Cheft[] chefts = new Cheft[1000];
    private Scanner sc = new Scanner(System.in);

    public CheftService() {
        chefts[0] = new Cheft(1, "Gordon Ramsay", "0901234567", true);
        chefts[1] = new Cheft(2, "Jamie Oliver", "0902345678", true);
        chefts[2] = new Cheft(3, "Wolfgang Puck", "0903456789", false);
        chefts[3] = new Cheft(4, "Alain Ducasse", "0904567890", true);
        chefts[4] = new Cheft(5, "Rachael Ray", "0905678901", false);

        Cheft.setLength(5);
    }

    @Override
    public void diplayAll() {
        for(int i = 0; i < Cheft.getLength(); i++){
            System.out.println(chefts[i].toString());
        }
    }

    @Override
    public void displayByName(String name) {
        for(int i = 0; i < Cheft.getLength(); i++){
            if(chefts[i].getName().equalsIgnoreCase(name))
                System.out.println(chefts[i].toString());
        }
    }

    @Override
    public int findById(int id) {
        for(int i = 0; i < Cheft.getLength(); i++){
            if(chefts[i].getId() == id)
                return i;
        }
        return -1;
    }

    public Cheft findCheftById(int id) {
        for(int i = 0; i < Cheft.getLength(); i++){
            if(chefts[i].getId() == id)
                return chefts[i];
        }
        return null;
    }

    @Override
    public Object creat() {
        Integer id = Input.inputOneNum("id >> ");
        System.out.print("name >>");
        String name = sc.nextLine();
        System.out.print("phoneNumber >>");
        String phoneNumber = sc.nextLine();
        System.out.println("status >>(0: free, another:not-free)");
        char sta =  sc.nextLine().charAt(0);
        boolean status = false;
        if(sta != '0')
            status = true;

        Cheft cheft = new Cheft(id, name, phoneNumber, status);
        return cheft;
    }

    @Override
    public void add(Object object) {
        if(object instanceof Cheft){
            Cheft cheft = (Cheft) object;

            try{
                chefts[Cheft.getLength()] = cheft;
                Cheft.setLength(Cheft.getLength()+1);
                System.out.println("Thêm thành công");
            }catch (Exception e){
                System.out.println("Thêm thất bại (" + e + ")");
            }
        }
    }

    @Override
    public void edit(int id) {
        int pos = findById(id);
        if(pos != -1){
            Cheft c = (Cheft) creat();
            chefts[pos] = c;
            System.out.println("Sửa thành công");
        }else{
            System.out.println("Không tìm thấy cheft");
        }
    }

    @Override
    public void delete(int id) {
        int pos = findById(id);
        if(pos != -1){
//            Cheft c = (Cheft) creat();
            for(int i = pos; i < Cheft.getLength(); i++){
                chefts[i] = chefts[i+1];
            }
            Cheft.setLength(Cheft.getLength()-1);
            System.out.println("Xóa thành công");
        }else{
            System.out.println("Không tìm thấy cheft");
        }
    }

    public void displayCheafFree(){
        for(int i = 0; i < Cheft.getLength(); i++){
            if(chefts[i].isStatus() == false)
                System.out.println(chefts[i].toString());
        }
    }

    public void displayCheafBusy(){
        for(int i = 0; i < Cheft.getLength(); i++){
            if(chefts[i].isStatus() == true)
                System.out.println(chefts[i].toString());
        }
    }
}
