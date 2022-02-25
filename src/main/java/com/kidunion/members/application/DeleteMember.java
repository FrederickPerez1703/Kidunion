package com.kidunion.members.application;

import com.kidunion.members.domain.MemberRepository;
import com.kidunion.members.domain.Members;
import com.kidunion.utilities.DeleteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteMember implements DeleteEntity<Members> {

    private final MemberRepository memberRepository;

    @Autowired
    public DeleteMember(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
