package com.kidunion.members.application;

import com.kidunion.members.domain.Members;
import com.kidunion.utilities.FindByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindByValueMember implements FindByValue<Members> {
    private final FindAllMember memberFindAll;

    @Autowired
    public FindByValueMember(FindAllMember memberFindAll) {
        this.memberFindAll = memberFindAll;
    }

    @Override
    public List<Members> findByValue(String value) {
        return memberFindAll.findAll().stream().filter(e -> e.getFirstName().equalsIgnoreCase(value) ||
                e.getLastName().equalsIgnoreCase(value)).collect(Collectors.toList());
    }
}
