package com.kidunion.children.application;

import com.kidunion.children.domain.exception.ChildreException;
import com.kidunion.children.domain.Children;
import com.kidunion.children.domain.ChildrenRepository;
import com.kidunion.utilities.CrudGeneric;
import com.kidunion.utilities.FindByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildrenService implements CrudGeneric<Children>, FindByValue<Children> {

    private final ChildrenRepository childrenRepository;
    private final String MESSAGER_ERROR = "Ha ocurrido un error...";

    @Autowired
    public ChildrenService(ChildrenRepository childrenRepository) {
        this.childrenRepository = childrenRepository;
    }

    @Override
    public List<Children> findAll() {
        return childrenRepository.findAll();
    }

    @Override
    public void save(Children entity) {
        if (entity != null ) {
            childrenRepository.save(entity);
        }else{
            throw new ChildreException(MESSAGER_ERROR);
        }
    }

    @Override
    public void delete(Long id) {
        childrenRepository.deleteById(id);
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

    @Override
    public List<Children> findByValue(String value) {
        return findAll().stream()
                .filter(children -> children.getName().equalsIgnoreCase(value))
                .collect(Collectors.toList());
    }

}
