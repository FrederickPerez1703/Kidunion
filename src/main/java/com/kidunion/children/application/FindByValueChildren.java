package com.kidunion.children.application;

import com.kidunion.children.domain.Children;
import com.kidunion.utilities.FindByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindByValueChildren implements FindByValue<Children> {
    private final FindAllChildren findAllChildren;

    @Autowired
    public FindByValueChildren(FindAllChildren findAllChildren) {
        this.findAllChildren = findAllChildren;
    }

    @Override
    public List<Children> findByValue(String value) {
        return findAllChildren.findAll().stream().filter(e -> e.getName().equalsIgnoreCase(value) ||
                e.getLastName().equalsIgnoreCase(value)).collect(Collectors.toList());
    }
}
