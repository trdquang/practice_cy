package p1_theory.service;

import java.util.List;

public interface BaseService <T, U>{
    List<T> getAll();
    int save(U u);
}
