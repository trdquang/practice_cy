package Service;

public interface BaseService {
    void diplayAll();
    void displayByName(String name);
    int findById(int id);
    Object creat();
    void add(Object object);
    void edit(int id);
    void delete(int id);
}
