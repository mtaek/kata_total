package kata.annuaire.annuaire.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kata.annuaire.annuaire.model.Contact;
import kata.annuaire.annuaire.service.ContactInputs;
import kata.annuaire.annuaire.service.ContactService;
import kata.annuaire.annuaire.transformer.ContactTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping(path = "/find"  ,produces = "application/json")
    List<Contact> findContact(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, @RequestParam(required = false) String email) throws JsonProcessingException {
        final ContactInputs contactInputs = new  ContactInputs(firstName, lastName, email);
        List<Contact> contacts = contactService.find(contactInputs);

        return contacts;
    }
}
