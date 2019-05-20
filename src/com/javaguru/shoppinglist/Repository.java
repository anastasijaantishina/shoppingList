package com.javaguru.shoppinglist;

import java.util.List;

public interface Repository<T> {

    void add(T item);

    void delete(Long id);

}
