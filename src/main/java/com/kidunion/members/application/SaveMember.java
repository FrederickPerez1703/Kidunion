package com.kidunion.members.application;

import com.kidunion.members.domain.MemberRepository;
import com.kidunion.members.domain.Members;
import com.kidunion.members.domain.exception.MemberException;
import com.kidunion.utilities.SaveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SaveMember implements SaveEntity<Members> {
    private final MemberRepository membersMemberRepository;

    @Autowired
    public SaveMember(MemberRepository membersMemberRepository) {
        this.membersMemberRepository = membersMemberRepository;
    }

    @Override
    public void save(Members entity) {
        if (Objects.nonNull(entity)) {
            membersMemberRepository.save(entity);
        }else{
            throw new MemberException("Error in the object");
        }
    }
}
