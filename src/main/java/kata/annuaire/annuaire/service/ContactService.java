package kata.annuaire.annuaire.service;

import kata.annuaire.annuaire.loader.DataLoader;
import kata.annuaire.annuaire.model.Contact;
import kata.annuaire.annuaire.repository.ContactRepository;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    ContactRepository contactRepository;
    DataLoader dataLoader;
    private static final String FILE_NAME = "mock_data.csv";

    public ContactService(ContactRepository contactRepository, DataLoader dataLoader) {
        this.contactRepository = contactRepository;
        this.dataLoader = dataLoader;
    }

    //recherche multicritères
    public List<Contact> find(ContactInputs contactInputs) {
        return contactRepository.findByFirstNameLikeOrLastNameLikeOrEmailLike(contactInputs.getFirstName(),
                contactInputs.getLastName(), contactInputs.getEmail());
    }


}
