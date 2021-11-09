package com.kidunion.members.Infrastructure;

import com.kidunion.members.application.MemberService;
import com.kidunion.members.domain.exception.MemberException;
import com.kidunion.members.domain.Members;
import com.kidunion.utilities.CrudGeneric;
import com.kidunion.utilities.FindByValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/kidunion")
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class MemberController {

    private final CrudGeneric<Members> crudGeneric;
    private final FindByValue<Members> findByValue;
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    public MemberController(CrudGeneric<Members> crudGeneric,
                            FindByValue<Members> findByValue) {
        this.crudGeneric = crudGeneric;
        this.findByValue = findByValue;
    }

    /**
     * @return list of members
     */
    @GetMapping("/Member")
    public List<Members> findAll() {
        return crudGeneric.findAll();
    }

    /**
     * This method saves the members
     *
     * @param members
     */
    @PostMapping("/Member")
    public ResponseEntity<String> save(@RequestBody Members members) {
        ResponseEntity<String> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
        try {
            crudGeneric.save(members);
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

    @DeleteMapping("/Member/{Id}")
    public ResponseEntity<String> deleteById(@PathVariable("Id") long id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("id git init");
    }
}
