package kata.annuaire.annuaire.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "contact")
public class Contact {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String departement;

    private Contact() {
    }

    public Contact(String[] values){
        this.id = Long.valueOf(values[0]);
        this.firstName = values[1];
        this.lastName = values[2];
        this.email = values[3];
        this.company = values[4];
        this.departement = values[5];
    }

    private Contact(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.company = builder.company;
        this.departement = builder.departement;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getDepartement() {
        return departement;
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String company;
        private String departement;

        public Builder(Long id) {
            this.id = id;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder withDepartment(String departement) {
            this.departement = departement;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }

    }
}
