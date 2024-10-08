package Service;

public class MenuService {
    public MenuService() {
    }

    public void menu(){
        System.out.println("--------NHÀ HÀNG--------");
        System.out.println("1. Table");
        System.out.println("2. Dish");
        System.out.println("3. Cheft");
        System.out.println("4. Thoát");
    }

    public void menuTable(){
        System.out.println("--------Table--------");
        System.out.println("1. Thêm");
        System.out.println("2. Sửa");
        System.out.println("3. Xóa");
        System.out.println("4. Hiển thị");
        System.out.println("5. Tìm theo tên");
        System.out.println("6. Hiển thị bàn có chef");
        System.out.println("7. Hiển thị bàn chưa có chef");
        System.out.println("8. Thêm bếp trưởng");
        System.out.println("9. Xóa bếp trưởng");

        System.out.println("0. Back");
    }

    public void menuDish(){
        System.out.println("--------Table--------");
        System.out.println("1. Thêm");
        System.out.println("2. Sửa");
        System.out.println("3. Xóa");
        System.out.println("4. Hiển thị");
        System.out.println("5. Tìm theo tên");
        System.out.println("6. Món ăn theo danh mục");
        System.out.println("7. Món ăn best seller");
        System.out.println("8. Bán");
        System.out.println("9. Đọc file");
        System.out.println("10. Ghi file");

        System.out.println("0. Back");
    }

    public void menuCheft(){
        System.out.println("--------Table--------");
        System.out.println("1. Thêm");
        System.out.println("2. Sửa");
        System.out.println("3. Xóa");
        System.out.println("4. Hiển thị");
        System.out.println("5. Tìm theo tên");
        System.out.println("6. Tìm chef rảnh");
        System.out.println("5. Tìm chef bận");

        System.out.println("0. Back");
    }
}
