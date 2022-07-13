package com.example.easySchool.controller;

import com.example.easySchool.models.Contact;
import com.example.easySchool.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContactController {

    private final ContactService contactService;

    Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @RequestMapping(value = {"/contact"})
    public String displayContact(Model model) {
        model.addAttribute("contact",new Contact());
        return "contact.html";
    }

//    @RequestMapping(value = "/saveMsg",method = POST)   ///replaced it with the service based usage
//    public ModelAndView saveMsg(@RequestParam String name,@RequestParam String mobileNum , @RequestParam String email,
//    @RequestParam String subject, @RequestParam String message){
//      logger.info(name);
//      logger.info(mobileNum);
//      logger.info(email);
//      logger.info(subject);
//      logger.info(message);
//
//      return new ModelAndView("redirect:/contact");
//    }


    @RequestMapping(value = "/saveMsg",method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors error){
        if(error.hasErrors()){
            logger.error("Error occured because of invalid input" + error.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
}
