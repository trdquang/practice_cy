package Service.Menu;

public class MenuService {
    public static void menu(){
        System.out.println("---------------CHƯƠNG TRÌNH QUẢN LÝ NHAN SỰ---------------");
        System.out.println("1. Quản lý phòng ban");
        System.out.println("2. Quản lý nhân sự");
        System.out.println("3. Thoát");
    }

    public static void menuDepartment(){
        System.out.println("--------Phòng ban--------");
        System.out.println("1. Hiển thị tất cả");
        System.out.println("2. Tìm kiếm theo tên");
        System.out.println("3. Thêm 1 phòng ban");
        System.out.println("4. Sửa phòng ban theo id");
        System.out.println("5. Xóa phòng ban theo id");
        System.out.println("6. Hiển thị phòng ban trống");
        System.out.println("7. Hiển thị phòng ban đã có nhân viên");
        System.out.println("8. Thêm nhân viên cho phòng ban");
        System.out.println("9. Xóa nhân viên cho phòng ban");
        System.out.println("10. Thống kê nhân viên cho các phòng ban");
        System.out.println("11. Thống kê phòng ban bận rộn nhất");
        System.out.println("12. Về chương trình chính");
        System.out.println("13. Thoát");
    }

    public static void menuEmployee(){
        System.out.println("--------Nhân viên--------");
        System.out.println("1. Hiển thị tất cả");
        System.out.println("2. Tìm kiếm theo tên");
        System.out.println("3. Thêm 1 nhân viên");
        System.out.println("4. Sửa nhân viên theo id");
        System.out.println("5. Xóa nhân viên theo id");
        System.out.println("6. Hiển thị nhân viên rảnh");
        System.out.println("7. Hiển thị nhân viên đã có phòng ban");
        System.out.println("8. Thống kê phòng ban của các nhân viên");
        System.out.println("9. Thống kê nhân viên bận rộn nhất");
        System.out.println("10. Về chương trình chính");
        System.out.println("11. Thoát");
    }


}
