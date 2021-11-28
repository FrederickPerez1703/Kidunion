package com.kidunion.children.infrastructure;

import com.kidunion.children.domain.Children;
import com.kidunion.members.domain.Members;
import com.kidunion.utilities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("kidunion")
public class ChildrenController {
    private final FindByValue<Children> findByValue;
    private final SaveEntity<Children> saveEntity;
    private final DeleteEntity<Children> deleteMember;
    private final UpdateEntity<Children> updateEntity;
    private final FindAllEntity<Children> findAllEntity;

    public ChildrenController(FindByValue<Children> findByValue, SaveEntity<Children> saveEntity,
                              DeleteEntity<Children> deleteMember, UpdateEntity<Children> updateEntity,
                              FindAllEntity<Children> findAllEntity) {
        this.findByValue = findByValue;
        this.saveEntity = saveEntity;
        this.deleteMember = deleteMember;
        this.updateEntity = updateEntity;
        this.findAllEntity = findAllEntity;
    }

    /**
     * @return list of Children
     */
    @GetMapping("/Children")
    public List<Children> findAll() {
        return findAllEntity.findAll();
    }

    /**
     * This method saves the children
     *
     * @param children
     */
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Children children) {
        this.saveEntity.save(children);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }

    /**
     * This method filters a list of members according to his firstName
     *
     * @param firstName
     * @return list of Children
     */
    @GetMapping("/findByFirstName/{firstName}")
    public List<Children> findByFirstName(@PathVariable("firstName") String firstName) {
        if (firstName.isEmpty()) {
            return new ArrayList<>();
        }
        return findByValue.findByValue(firstName);
    }
}
