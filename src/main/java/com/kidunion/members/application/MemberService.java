package com.kidunion.members.application;

import com.kidunion.members.domain.exception.MemberException;
import com.kidunion.members.domain.Members;
import com.kidunion.members.domain.MemberRepository;
import com.kidunion.utilities.CrudGeneric;
import com.kidunion.utilities.FindByValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService implements CrudGeneric<Members>, FindByValue<Members> {

    private final MemberRepository membersMemberRepository;
    private static final String STORAGE_TIME = "3 años";
    private static final String MESSAGE_ERROR = "Ha ocurrido un Error";

    @Autowired
    public MemberService(MemberRepository membersMemberRepository) {
        this.membersMemberRepository = membersMemberRepository;
    }

    @Override
    public List<Members> findAll() {
        return membersMemberRepository.findAll();
    }

    @Override
    public List<Members> findByValue(String value) {
        return findAll().stream().filter(e -> e.getFirstName().equalsIgnoreCase(value) ||
                e.getLastName().equalsIgnoreCase(value)).collect(Collectors.toList());
    }

    @Override
    public void save(Members entity) throws MemberException{
        if(entity != null){
            entity.setStorageTime(STORAGE_TIME);
            membersMemberRepository.save(entity);
        }else{
            throw new MemberException(MESSAGE_ERROR);
        }

    }

    @Override
    public void delete(Long id) {
        membersMemberRepository.deleteById(id);
    }

    @Override
    public Members update(Members entity) {
        Members members = membersMemberRepository.getById(entity.getId());
        members.setFirstName(entity.getFirstName());
        members.setLastName(entity.getLastName());
        members.setDateOfBirth(entity.getDateOfBirth());
        members.setEmail(entity.getEmail());
        members.setPhoneNumber(entity.getPhoneNumber());
        members.setAdress(entity.getAdress());
        members.setPhoto(entity.getPhoto());
        members.setAddedThe(entity.getAddedThe());
        members.setStorageTime(entity.getStorageTime());
        members.setDocumentsProvided(entity.getDocumentsProvided());
        members.setTypeOfRegistration(entity.getTypeOfRegistration());
        save(members);
        return members;
    }
}
