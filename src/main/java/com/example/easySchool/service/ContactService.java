package com.example.easySchool.service;

import com.example.easySchool.constants.EazySchoolConstants;
import com.example.easySchool.models.Contact;
import com.example.easySchool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequestScope
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;



    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result>0){
            isSaved = true;
        }
        return isSaved;
    }


    public List<Contact> findMsgsWithOpenStatus() {
      List<Contact> contactMsg = contactRepository.findMsgsWithStatus(EazySchoolConstants.OPEN);
      return contactMsg;
    }
}
