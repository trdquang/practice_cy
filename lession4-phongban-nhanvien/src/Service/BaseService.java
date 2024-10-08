package Service;

import Exception_Test.IdException;
import Exception_Test.NameException;

public interface BaseService {
    Object inputOne();

    void displayByName( String name);
    int findById( String id);
    int findByName( String name);

    void add( Object object) throws IdException, NameException;
    void editById( String id);

    void deleteById( String id);
    void displayAll();
}
