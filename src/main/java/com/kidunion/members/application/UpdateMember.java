package com.kidunion.members.application;

import com.kidunion.members.domain.MemberRepository;
import com.kidunion.members.domain.Members;
import com.kidunion.utilities.UpdateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UpdateMember implements UpdateEntity<Members> {
    private final MemberRepository memberRepository;
    private static final String ARCHIVO = "Archivo";
    private static final String REGISTRATION = "Digital";
    private static final String PHOTO = "ENABLE";

    @Autowired
    public UpdateMember(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Members update(Members entity) {
        Members members = memberRepository.getById(entity.getId());
        if (Objects.nonNull(members)){
            members.setFirstName(entity.getFirstName());
            members.setLastName(entity.getLastName());
            members.setDateOfBirth(entity.getDateOfBirth());
            members.setEmail(entity.getEmail());
            members.setPhoneNumber(entity.getPhoneNumber());
            members.setAdress(entity.getAdress());
            members.setPhoto(PHOTO);
            members.setAddedThe(entity.getAddedThe());
            members.setStorageTime(entity.getStorageTime());
            members.setDocumentsProvided(ARCHIVO);
            members.setTypeOfRegistration(REGISTRATION);
            memberRepository.save(members);
            return members;
        }else{
            return null;
        }

    }
}
