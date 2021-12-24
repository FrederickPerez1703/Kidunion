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
    private static final String ARCHIVO = "Archivo";
    private static final String REGISTRATION = "Digital";
    private static final String PHOTO = "ENABLE";
    private static final String STORAGE_TIME = "3 años";
    private static final String MESSAGE_ERROR = "Error in the object";

    @Autowired
    public SaveMember(MemberRepository membersMemberRepository) {
        this.membersMemberRepository = membersMemberRepository;
    }

    @Override
    public void save(Members entity) {
        if (Objects.nonNull(entity)) {
            entity.setPhoto(PHOTO);
            entity.setTypeOfRegistration(REGISTRATION);
            entity.setDocumentsProvided(ARCHIVO);
            membersMemberRepository.save(entity);
        }else{
            throw new MemberException(MESSAGE_ERROR);
        }
    }
}
