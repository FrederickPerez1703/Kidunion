package com.kidunion.members.Infrastructure;

import com.kidunion.members.domain.exception.MemberException;
import com.kidunion.members.domain.Members;
import com.kidunion.utilities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/kidunion")
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class MemberController {

    private final FindByValue<Members> findByValue;
    private final SaveEntity<Members> saveEntity;
    private final DeleteEntity<Members> deleteMember;
    private final UpdateEntity<Members> updateEntity;
    private final FindAllEntity<Members> findAllEntity;
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    public MemberController(FindByValue<Members> findByValue,
                            SaveEntity<Members> saveEntity,
                            DeleteEntity<Members> deleteMember,
                            FindAllEntity<Members> findAllEntity,
                            UpdateEntity<Members> updateEntity) {
        this.findByValue = findByValue;
        this.saveEntity = saveEntity;
        this.deleteMember = deleteMember;
        this.findAllEntity = findAllEntity;
        this.updateEntity = updateEntity;
    }

    /**
     * @return list of members
     */
    @GetMapping("/Member")
    public List<Members> findAll() {
        return findAllEntity.findAll();
    }

    /**
     * This method saves the membersx
     *
     * @param members
     */
    @PostMapping("/Member")
    public ResponseEntity<String> save(@RequestBody Members members) {
        ResponseEntity<String> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        try {
            saveEntity.save(members);
            return responseEntity;
        } catch (MemberException e) {
            LOGGER.error(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failure");
    }

    /**
     * This method filters a list of members according to his firstName
     *
     * @param firstName
     * @return list of members
     */
    @GetMapping("/Member/{firstName}")
    public List<Members> findByFirstName(@PathVariable("firstName") String firstName) {
        return findByValue.findByValue(firstName);
    }

    @PutMapping("/Member")
    public ResponseEntity<Members> update(@RequestBody Members members) {
        updateEntity.update(members);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(members);
    }

    @DeleteMapping("/Member/{Id}")
    public ResponseEntity<String> deleteById(@PathVariable("Id") long id) {
        ResponseEntity<String> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).body("delete exist");
        Optional<Members> optionalMembers = findAll().stream().filter(members -> members.getId().equals(id)).findAny();
       if (optionalMembers.isPresent()){
           deleteMember.delete(id);
           return responseEntity;
       }
        return ResponseEntity.status(HttpStatus.OK).body("the id not exist");
    }
}
