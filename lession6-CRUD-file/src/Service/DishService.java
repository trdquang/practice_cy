package Service;

import Model.Cheft;
import Model.Dish;
import Model.Table;
import Util.Input;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DishService implements BaseService{
    static Dish[] dishes = new Dish[1000];
    private Scanner sc = new Scanner(System.in);

    public DishService() {
        dishes[0] = new Dish(1, "Beef Wellington", "Beef, Puff Pastry, Mushrooms", "Main Course", 30);
        dishes[1] = new Dish(2, "Spaghetti Carbonara", "Spaghetti, Eggs, Parmesan Cheese", "Main Course", 20);
        dishes[2] = new Dish(3, "Chicken Tikka Masala", "Chicken, Curry Sauce, Rice", "Main Course", 15);
        dishes[3] = new Dish(4, "Pancakes", "Flour, Eggs, Milk", "Dessert", 25);
        dishes[4] = new Dish(5, "Caesar Salad", "Lettuce, Croutons, Caesar Dressing", "Appetizer", 30);


        Dish.setLength(5);
    }

    @Override
    public void diplayAll() {
        for(int i = 0; i < Dish.getLength(); i++){
            System.out.println(dishes[i].toString());
        }
    }

    @Override
    public void displayByName(String name) {
        for(int i = 0; i < Dish.getLength(); i++){
            if(dishes[i].getName().equalsIgnoreCase(name))
                System.out.println(dishes[i].toString());
        }
    }

    @Override
    public int findById(int id) {
        for(int i = 0; i < Dish.getLength(); i++){
            if(dishes[i].getId() == id)
                return i;
        }
        return -1;
    }

    @Override
    public Object creat() {
        Integer id = Input.inputOneNum("id >> ");
        System.out.print("name >>");
        String name = sc.nextLine();
        System.out.print("ingredrents >>");
        String ingredrents = sc.nextLine();
        System.out.print("category >>");
        String category = sc.nextLine();
//        System.out.print("count >>");
        Integer count = Input.inputOneNum("count >> ");

        Dish dish = new Dish(id, name, ingredrents, category, count);
        return dish;
    }

    @Override
    public void add(Object object) {
        if(object instanceof Dish){
            Dish dish = (Dish) object;

            try{
                dishes[Dish.getLength()] = dish;
                Dish.setLength(Dish.getLength()+1);
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
            Dish d = (Dish) creat();
            dishes[pos] = d;
            System.out.println("Sửa thành công");
        }else{
            System.out.println("Không tìm thấy dish");
        }
    }

    @Override
    public void delete(int id) {
        int pos = findById(id);
        if(pos != -1){
//            Dish d = (Dish) creat();
            for(int i = pos; i < Dish.getLength(); i++){
                dishes[i] = dishes[i+1];
            }
            Dish.setLength(Dish.getLength()-1);
            System.out.println("Xóa thành công");
        }else{
            System.out.println("Không tìm thấy dish");
        }
    }

    public void displayDishBestSeller(){
        int max = -1;
        for(int i  = 0; i < Dish.getLength(); i++){
            if(dishes[i].getCount() >= max)
                max = dishes[i].getCount();
        }

        for(int i = 0; i < Dish.getLength(); i++){
            if(dishes[i].getCount() == max)
                System.out.println(dishes[i].toString());
        }
    }

    public int findInArr(String str, String[]arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null && arr[i].equalsIgnoreCase(str))
                return i;
        }
        return -1;
    }

    public String []getAllCate(){
        String[] res = new String[1000];
        int cnt = 0;

        for(int i = 0; i < Dish.getLength(); i++){
            if(findInArr(dishes[i].getCategory(), res) == -1){
                res[cnt++] = dishes[i].getCategory();
            }
        }
        return res;
    }

    public void filterByCate(){
        String[] res = getAllCate();
        System.out.println("List of cate: ");
        for(int i = 0; i < res.length; i++){
            if(res[i] != null){
                System.out.print(res[i] + ";");
            }
        }
        System.out.println();
        System.out.print("Choose cate want to filter >> ");
        String cate = sc.nextLine();
        System.out.println("Result >>>");
        for(int i = 0; i < Dish.getLength(); i++){
            if(dishes[i].getCategory().equalsIgnoreCase(cate)){
                System.out.println(dishes[i].toString());
            }
        }
    }

    public void sel(){
        int num = Input.inputOneNum("Id dish sell >> ");
        int pos = findById(num);
        if(pos == -1){
            System.out.println("Don t have dish");
        }else{
            int quantity = Input.inputOneNum("Quantity sell >> ");
            dishes[pos].sell(quantity);
            System.out.println("Sell success");
        }
    }

    public String []getAtrr(String str){
        String[]res = new String[5];
        StringTokenizer token = new StringTokenizer(str, ";");
        int cnt = 0;
        while (token.hasMoreElements() && cnt < 5){
            res[cnt++] = token.nextToken().trim();
        }
        return res;
    }

    public void writeFile() throws IOException{
        try  (FileOutputStream fout = new FileOutputStream("src/Util/output.txt");
             OutputStreamWriter out = new OutputStreamWriter(fout) ){
            for(int i = 0; i < Dish.getLength(); i++){
                out.write(dishes[i].toString() + "\n");
            }
            System.out.println("Write file sucess");
        }catch (IOException e){
            System.out.println(e);
        }

    }

    public void readFile() throws IOException, EOFException{
        try  (FileInputStream fin = new FileInputStream("src/Util/input.txt");
              InputStreamReader in = new InputStreamReader(fin);
              BufferedReader br = new BufferedReader(in)){
            String line;
            while ((line = br.readLine()) != null) {
                String[] tmp = getAtrr(line);
                try {
                    int id = Integer.parseInt(tmp[0]);
                    String name = tmp[1];
                    String ing = tmp[2];
                    String cate = tmp[3];
                    int cnt = Integer.parseInt(tmp[4]);
                    Dish dTmp = new Dish(id, name, ing, cate, cnt);
                    add(dTmp);

                }catch (Exception e){
                    System.out.println(e);
                }
                System.out.println();
            }

        }catch (EOFException f){
            System.out.println(f);
        }catch (IOException e){
            System.out.println(e);
        }catch (Exception z){

        }
    }
}
