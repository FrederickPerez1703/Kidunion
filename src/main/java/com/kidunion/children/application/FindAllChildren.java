package com.kidunion.children.application;

import com.kidunion.children.domain.Children;
import com.kidunion.children.domain.ChildrenRepository;

import com.kidunion.utilities.FindAllEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllChildren implements FindAllEntity<Children> {
    private final ChildrenRepository childrenRepository;

    @Autowired
    public FindAllChildren(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    @Override
    public List<Children> findAll() {
        return childrenRepository.findAll();
    }
}
