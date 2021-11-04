package com.kidunion.utilities;

import com.kidunion.members.application.MemberService;
import com.kidunion.Mock.MembersMockFactory;
import com.kidunion.members.domain.exception.MemberException;
import com.kidunion.members.domain.Members;
import com.kidunion.members.domain.MemberRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MemberServiceTest {

    @Mock
    MemberService memberService;
    @Mock
    MemberRepository memberRepository;
    @Mock
    Members members;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        memberService = new MemberService(memberRepository);
    }

    @Test
    public void testFindAll() {
        Assert.assertEquals(MembersMockFactory.newListMembersServices(this.memberService)
        ,this.memberService.findAll());
    }

    @Test
    public void testSaveNull() {
        try{
            Members members = null;
            this.memberService.save(members);
        }catch (MemberException e) {
            Assert.assertEquals("Ha ocurrido un Error",
                    e.getMessage());
        }
    }


    @Test
    public void testFindByValue() {
        Assert.assertEquals( MembersMockFactory.newMembersServices(memberService , "Juan") ,
                this.memberService.findByValue("Juan"));
    }

    @Test
    public void save() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }
}