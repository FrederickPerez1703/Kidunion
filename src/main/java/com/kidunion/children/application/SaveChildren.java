package com.kidunion.children.application;

import com.kidunion.children.domain.Children;
import com.kidunion.children.domain.ChildrenRepository;
import com.kidunion.children.domain.exception.ChildreException;
import com.kidunion.utilities.SaveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SaveChildren implements SaveEntity<Children> {
    private final ChildrenRepository childrenRepository;
    private static final String MESSAGE_ERROR = "Error in the object";

    @Autowired
    public SaveChildren(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    @Override
    public void save(Children entity) throws ChildreException{
        if (Objects.nonNull(entity)){
            childrenRepository.save(entity);
        }else{
            throw new ChildreException(MESSAGE_ERROR);
        }
    }
}
