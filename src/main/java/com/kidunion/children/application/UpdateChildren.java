package com.kidunion.children.application;

import com.kidunion.children.domain.Children;
import com.kidunion.children.domain.ChildrenRepository;
import com.kidunion.utilities.UpdateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateChildren implements UpdateEntity<Children> {
    private final ChildrenRepository childrenRepository;

    @Autowired
    public UpdateChildren(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    @Override
    public Children update(Children entity) {
        Children childrenEntity = childrenRepository.getById(entity.getId());
        Children children = new Children();
        children.setLastName(childrenEntity.getLastName());
        children.setName(childrenEntity.getName());
        children.setDateofBirth(childrenEntity.getDateofBirth());
        children.setDegree(childrenEntity.getDegree());
        children.setJeans(childrenEntity.getJeans());
        children.setTshirts(childrenEntity.getTshirts());
        children.setShoes(childrenEntity.getShoes());
        children.setSchool(childrenEntity.getSchool());
        return children;
    }
}
