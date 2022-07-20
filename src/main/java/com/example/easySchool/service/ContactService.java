package com.example.easySchool.service;

import com.example.easySchool.constants.EazySchoolConstants;
import com.example.easySchool.models.Contact;
import com.example.easySchool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequestScope
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;



//    public boolean saveMessageDetails(Contact contact){
//        boolean isSaved = false;
//        Contact savedContact = contactRepository.save(contact);
//        if(null != savedContact && savedContact.getContactId()>0){
//            isSaved = true;
//        }
//        return isSaved;
//    }
//
//
//    public List<Contact> findMsgsWithOpenStatus() {
//      List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(EazySchoolConstants.OPEN);
//      return contactMsgs;
//    }
//
//    public boolean updateMsgStatus(int contactId, String updatedBy){
//        boolean isUpdated = false;
//        int result = contactRepository.updateMsgStatus(contactId,EazySchoolConstants.CLOSE, updatedBy);
//        if(result>0) {
//            isUpdated = true;
//        }
//        return isUpdated;
//    }
}
