package Controller;

import Model.Cheft;
import Model.Dish;
import Model.Table;
import Service.CheftService;
import Service.DishService;
import Service.MenuService;
import Service.TableService;
import Util.Input;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    //--------init
    private static CheftService cheftService = new CheftService();
    private static DishService dishService = new DishService();
    private static TableService tableService = new TableService();
    private static MenuService menuService = new MenuService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        while (true){
            menuService.menu();
            int chooseMenu = Input.inputOneNum("Your choose >>");

            while (chooseMenu == 4){
                System.out.println("Kết thúc");
                System.exit(0);
            }

//            --------------------------------Table-------------------------------
            while (chooseMenu == 1){
                menuService.menuTable();
                int chooseTable = Input.inputOneNum("Choose table menu >> ");
                switch (chooseTable){
                    case 0:
                        chooseMenu = 0;
                        break;
                    case 1:
                        Table table = (Table) tableService.creat();
                        tableService.add(table);
                        break;
                    case 2:
                        int idEdit = Input.inputOneNum("id to edit >> ");
                        tableService.edit(idEdit);
                        break;
                    case 3:
                        int idDelete = Input.inputOneNum("id to delete >> ");
                        tableService.delete(idDelete);
                        break;
                    case 4:
                        tableService.diplayAll();
                        break;
                    case 5:
                        System.out.print("Name to find >> ");
                        String name = sc.nextLine();
                        tableService.displayByName(name);
                        break;
                    case 6:
                        System.out.println("List of table have chef");
                        tableService.displayTableHaveChef();
                        break;
                    case 7:
                        System.out.println("List of table don't have chef");
                        tableService.displayTableNoHaveChef();
                        break;
                    case 8:
                        tableService.addCheft();
                        break;
                    case 9:
                        tableService.deleteCheft();
                        break;
                    default:
                        System.out.println("Choose invalid");
                }
            }

//      ----------------------------------Dish-----------------------------------------------
            while (chooseMenu == 2){
                menuService.menuDish();
                int chooseDish = Input.inputOneNum("Choose dish menu >> ");
                switch (chooseDish){
                    case 0:
                        chooseMenu = 0;
                        break;
                    case 1:
                        Dish dish = (Dish) dishService.creat();
                        dishService.add(dish);
                        break;
                    case 2:
                        int idEdit = Input.inputOneNum("id to edit >> ");
                        dishService.edit(idEdit);
                        break;
                    case 3:
                        int idDelete = Input.inputOneNum("id to delete >> ");
                        dishService.delete(idDelete);
                        break;
                    case 4:
                        dishService.diplayAll();
                        break;
                    case 5:
                        System.out.print("Name to find >> ");
                        String name = sc.nextLine();
                        dishService.displayByName(name);
                        break;
                    case 6:
                        dishService.filterByCate();
                        break;
                    case 7:
                        System.out.println("Dish best seller");
                        dishService.displayDishBestSeller();
                        break;
                    case 8:
                        dishService.sel();
                        break;
                    case 9:
                        dishService.readFile();
                        break;
                    case 10:
                        dishService.writeFile();
                        break;
                    default:
                        System.out.println("Choose invalid");
                }
            }

//            ---------------------------------------------------
            while (chooseMenu == 3){
                menuService.menuCheft();
                int chooseCheft = Input.inputOneNum("Choose table menu >> ");
                switch (chooseCheft){
                    case 0:
                        chooseMenu = 0;
                        break;
                    case 1:
                        Cheft cheft = (Cheft) cheftService.creat();
                        cheftService.add(cheft);
                        break;
                    case 2:
                        int idEdit = Input.inputOneNum("id to edit >> ");
                        cheftService.edit(idEdit);
                        break;
                    case 3:
                        int idDelete = Input.inputOneNum("id to delete >> ");
                        cheftService.delete(idDelete);
                        break;
                    case 4:
                        cheftService.diplayAll();
                        break;
                    case 5:
                        System.out.print("Name to find >> ");
                        String name = sc.nextLine();
                        cheftService.displayByName(name);
                        break;
                    case 6:
                        System.out.println("All chef free");
                        cheftService.displayCheafFree();
                        break;
                    case 7:
                        System.out.println("All chef busy");
                        cheftService.displayCheafBusy();
                        break;
                    default:
                        System.out.println("Choose invalid");
                }
            }
//            -----------------------------------------------------------------------
        }

    }
}
