package kata.annuaire.annuaire.repository;

import kata.annuaire.annuaire.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByFirstNameLikeOrLastNameLikeOrEmailLike(String firstName, String lastName, String email);

}
