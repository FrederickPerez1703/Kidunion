package com.kidunion.services;

import java.util.List;

public interface FindByValue <T>{
    List<T> findByValue(String value);
}
