package com.kidunion.services.Mock;

import com.kidunion.controllers.MemberController;
import com.kidunion.model.Members;

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
}
