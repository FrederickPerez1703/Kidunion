package com.kidunion.members.application;

import com.kidunion.members.domain.MemberRepository;
import com.kidunion.members.domain.Members;
import com.kidunion.utilities.FindAllEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllMember implements FindAllEntity<Members> {

    private final MemberRepository memberRepository;

    @Autowired
    public FindAllMember(MemberRepository membersMemberRepository) {
        this.memberRepository = membersMemberRepository;
    }

    @Override
    public List<Members> findAll() {
        return memberRepository.findAll();
    }
}
