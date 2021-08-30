package contacts.model;

import java.time.LocalDateTime;

public class Person extends Record{
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;

    private Person(String firstName, String lastName, String birthDate,
                   String gender, String phoneNumber) {
        super(phoneNumber);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Override
    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.setTimeUpdated(LocalDateTime.now());
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.setTimeUpdated(LocalDateTime.now());
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        this.setTimeUpdated(LocalDateTime.now());
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        this.setTimeUpdated(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nSurname: %s\nBirth date: %s\nGender: %s\n" + super.toString(),
                firstName == null ? "[no data]" : firstName,
                lastName == null ? "[no data]" : lastName,
                birthDate == null ? "[no data]" : birthDate,
                gender == null ? "[no data]" : gender.toUpperCase());
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String birthDate;
        private String gender;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName,
                    birthDate, gender, phoneNumber);
        }
    }
}
