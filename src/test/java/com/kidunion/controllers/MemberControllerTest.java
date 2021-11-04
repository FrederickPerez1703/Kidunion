package com.kidunion.controllers;

import com.kidunion.members.Infrastructure.MemberController;
import com.kidunion.Mock.MembersMockFactory;
import com.kidunion.members.domain.Members;
import com.kidunion.members.domain.MemberRepository;
import com.kidunion.members.application.MemberService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MemberControllerTest {

    @InjectMocks
    MemberController memberController;
    @Mock
    MemberService memberService;
    @Mock
    MemberRepository memberRepository;
    @Mock
    Members members;
    List<Members> membersList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        memberService = new MemberService(memberRepository);
        //memberController = new MemberController(memberService);
        MembersMockFactory.newListMembers(memberController);
        MembersMockFactory.newMembers(memberController , "juan");
    }

    @Test
    public void testFindAll() {
        membersList = new ArrayList<>();
        Assert.assertEquals(membersList, memberController.findAll());
    }

    @Test
    public void testSave() {
        Assert.assertEquals(ResponseEntity.status(HttpStatus.CREATED).body("Successfully created")
                ,memberController.save(members));
    }


    @Test
    public void testFindByFirstName() {
        membersList = new ArrayList<>();
        Assert.assertEquals(membersList , memberController.findByFirstName("juam"));
    }

    @Test
    public void testFindByFirstNameEmpty(){
        membersList = new ArrayList<>();
        Assert.assertEquals(membersList , memberController.findByFirstName(""));
    }
}