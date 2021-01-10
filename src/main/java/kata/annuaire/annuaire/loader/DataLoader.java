package kata.annuaire.annuaire.loader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import kata.annuaire.annuaire.model.Contact;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoader {

    public List<Contact> loadContacts(String fileName) {
        List<Contact> contacts = new ArrayList<Contact>();
        Resource resource = new ClassPathResource(fileName);
        try (CSVReader csvReader = new CSVReader(new FileReader(resource.getFile()));) {
            String[] values = null;
            //ignore header
            csvReader.readNext();
            while ((values = csvReader.readNext()) != null) {
                contacts.add(new Contact(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
