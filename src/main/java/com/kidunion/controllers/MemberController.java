package com.kidunion.controllers;

import com.kidunion.model.Members;
import com.kidunion.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/kidunion")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     *
     * @return list of members
     */
    @GetMapping("/Member")
    public List<Members> findAll() {
        return memberService.findAll();
    }

    /**
     * This method saves the members
     * @param members
     */
    @PostMapping("/Member")
    public ResponseEntity<String> save(@RequestBody Members members) {
        memberService.save(members);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created");
    }

    /**
     * This method filters a list of members according to his firstName
     * @param firstName
     * @return list of members
     */
    @GetMapping("/Member/{firstName}")
    public List<Members> findByFirstName(@PathVariable("firstName") String firstName){
        if (firstName.isEmpty()){
            return new ArrayList<>();
        }
        return memberService.findByValue(firstName);
    }

}
