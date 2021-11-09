package com.kidunion.children.application;

import com.kidunion.children.domain.Children;
import com.kidunion.children.domain.ChildrenRepository;
import com.kidunion.utilities.DeleteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteChildren implements DeleteEntity<Children> {
    private final ChildrenRepository childrenRepository;

    @Autowired
    public DeleteChildren(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    @Override
    public void delete(Long id) {
        childrenRepository.deleteById(id);
    }
}
