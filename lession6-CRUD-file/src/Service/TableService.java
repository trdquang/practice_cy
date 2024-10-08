package Service;

import Model.Cheft;
import Model.Table;
import Util.Input;

import java.util.Scanner;

public class TableService implements BaseService{

    static Table[] tables = new Table[1000];
    private Scanner sc = new Scanner(System.in);
    private CheftService cheftService = new CheftService();

    public TableService() {
        tables[0] = new Table(1, "Table 1", "Guest A", null);
        tables[1] = new Table(2, "Table 2", "Guest B", null);
        tables[2] = new Table(3, "Table 3", "Guest C", null);
        tables[3] = new Table(4, "Table 4", "Guest D", null);
        tables[4] = new Table(5, "Table 5", "Guest E", null);

        Table.setLength(5);
    }

    @Override
    public void diplayAll() {
        for(int i = 0; i < Table.getLength(); i++){
            System.out.println(tables[i].toString());
        }
    }

    @Override
    public void displayByName(String name) {
        for(int i = 0; i < Table.getLength(); i++){
            if(tables[i].getName().equalsIgnoreCase(name))
                System.out.println(tables[i].toString());
        }
    }

    @Override
    public int findById(int id) {
        for(int i = 0; i < Table.getLength(); i++){
            if(tables[i].getId() == id)
                return i;
        }
        return -1;
    }

    @Override
    public Object creat() {
        Integer id = Input.inputOneNum("id >> ");
        System.out.print("name >>");
        String name = sc.nextLine();
        System.out.print("guestName >>");
        String guestName = sc.nextLine();

        Table table = new Table(id, name, guestName, null);
        return table;
    }

    @Override
    public void add(Object object) {
        if(object instanceof Table){
            Table table = (Table) object;

            try{
                tables[Table.getLength()] = table;
                Table.setLength(Table.getLength()+1);
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
            Table c = (Table) creat();
            tables[pos] = c;
            System.out.println("Sửa thành công");
        }else{
            System.out.println("Không tìm thấy table");
        }
    }

    @Override
    public void delete(int id) {
        int pos = findById(id);
        if(pos != -1){
//            Table c = (Table) creat();
            for(int i = pos; i < Table.getLength(); i++){
                tables[i] = tables[i+1];
            }
            Table.setLength(Table.getLength()-1);
            System.out.println("Xóa thành công");
        }else{
            System.out.println("Không tìm thấy table");
        }
    }

    public void displayTableHaveChef(){
        for(int i = 0; i < Table.getLength(); i++){
            if(tables[i].getCheft() != null)
                System.out.println(tables[i].toString());
        }
    }

    public void displayTableNoHaveChef(){
        for(int i = 0; i < Table.getLength(); i++){
            if(tables[i].getCheft() == null)
                System.out.println(tables[i].toString());
        }
    }

    public void addCheft( ){
        int idTableAdd = Input.inputOneNum("id table want to add chef >> ");
        if(findById(idTableAdd) == -1){
            System.out.println("Dont have table");
        }else{
            if(tables[idTableAdd].getCheft() != null)
                System.out.println("Table is full");
            else {
                int idChef = Input.inputOneNum("id chef >> ");
                Cheft cheft = cheftService.findCheftById(idChef);
                if (cheftService.findById(idChef) == -1) {
                    System.out.println("Cheft onvalid");
                } else{
                    if(cheft.isStatus() == true)
                        System.out.println("Cheft is busy");
                    else {
                        cheft.setStatus(true);
                        tables[findById(idTableAdd)].setCheft(cheft);
                    }
                }
            }
        }
    }

    public void deleteCheft(){
        int idTableAdd = Input.inputOneNum("id table want to delete chef >> ");
        if(findById(idTableAdd) == -1){
            System.out.println("Dont have table");
        }else{
            if(tables[findById(idTableAdd)].getCheft() == null)
                System.out.println("Table is empty");
            else {
                tables[findById(idTableAdd)].getCheft().setStatus(false);
                tables[findById(idTableAdd)].setCheft(null);
            }
        }
    }
}
