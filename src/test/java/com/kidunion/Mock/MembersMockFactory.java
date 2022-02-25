package com.kidunion.Mock;

import com.kidunion.members.Infrastructure.MemberController;
import com.kidunion.members.domain.Members;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class MembersMockFactory {

    public static List<Members> newListMembers(MemberController memberController) {
        List<Members> membersList = new ArrayList<>();
        when(memberController.findAll()).thenReturn(membersList);
        return membersList;
    }

    public static List<Members> newMembers(MemberController memberController , String firstName){
        List<Members> membersList = new ArrayList<>();
        when(memberController.findByFirstName(firstName)).thenReturn(membersList);
        return membersList;
    }

/*    public static List<Members> newListMembersServices(MemberService memberService) {
        List<Members> membersList = new ArrayList<>();
        when(memberService.findAll()).thenReturn(membersList);
        return membersList;
    }

    public static List<Members> newMembersServices(MemberService memberService, String firstName){
        List<Members> membersList = new ArrayList<>();
        when(memberService.findByValue(firstName)).thenReturn(membersList);
        return membersList;
    }*/
}
