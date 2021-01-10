package kata.annuaire.annuaire;


import kata.annuaire.annuaire.loader.DataLoader;
import kata.annuaire.annuaire.model.Contact;
import kata.annuaire.annuaire.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AnnuaieApplication implements CommandLineRunner {

    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private ContactRepository contactRepository;

    public static void main(String[] args) {

        SpringApplication.run(AnnuaieApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        List<Contact> loadedContactList= dataLoader.loadContacts("mock_data.csv");
        contactRepository.saveAll(loadedContactList);
    }
}
