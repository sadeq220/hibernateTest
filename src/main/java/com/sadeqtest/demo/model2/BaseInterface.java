package com.sadeqtest.demo.model2;

import java.util.Collection;

public interface BaseInterface<T extends Collection> {
    T getAll(Integer count);
}
