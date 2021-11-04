package com.kidunion.children.infrastructure;

import com.kidunion.children.domain.Children;
import com.kidunion.utilities.CrudGeneric;
import com.kidunion.utilities.FindByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("kidunion")
public class ChildrenController {

    private final CrudGeneric<Children> crudGeneric;
    private final FindByValue<Children> findByValue;

    @Autowired
    public ChildrenController(CrudGeneric<Children> crudGeneric , FindByValue<Children> findByValue ) {
        this.crudGeneric = crudGeneric;
        this.findByValue = findByValue;
    }

    /**
     * @return list of Children
     */
    @GetMapping("/Children")
    public List<Children> findAll() {
        return crudGeneric.findAll();
    }

    /**
     * This method saves the children
     * @param children
     */
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Children children) {
        this.crudGeneric.save(children);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }

    /**
     * This method filters a list of members according to his firstName
     * @param firstName
     * @return list of Children
     */
    @GetMapping("/findByFirstName/{firstName}")
    public List<Children> findByFirstName(@PathVariable("firstName") String firstName){
        if (firstName.isEmpty()){
            return new ArrayList<>();
        }
        return findByValue.findByValue(firstName);
    }
}
