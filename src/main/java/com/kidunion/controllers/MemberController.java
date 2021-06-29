package com.kidunion.controllers;

import com.kidunion.model.Members;
import com.kidunion.services.CrudGeneric;
import com.kidunion.services.FindByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kidunion")
public class MemberController {

    private CrudGeneric<Members> crudGeneric;
    private FindByValue<Members> findByValue;

    @Autowired
    public MemberController(CrudGeneric<Members> crudGeneric , FindByValue<Members> findByValue) {
        this.findByValue = findByValue;
        this.crudGeneric = crudGeneric;
    }

    @GetMapping("/Member")
    public List<Members> findAll() {
        return crudGeneric.findAll();
    }

    /**
     * This method saves the members
     * @param members
     */
    @PostMapping("/Member")
    public void save(@RequestBody Members members) {
        crudGeneric.save(members);
    }

    /**
     * This method filters a list of members according to his firstName
     * @param firstName
     * @return list of members
     */
    @GetMapping("/Member/{firstName}")
    public List<Members> findByFirstName(@PathVariable("firstName") String firstName){
        return findByValue.findByValue(firstName);
    }

}
