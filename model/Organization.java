package contacts.model;

import java.time.LocalDateTime;

public class Organization extends Record{
    private String organizationName;
    private String address;

    private Organization(String organizationName, String address, String phoneNumber) {
        super(phoneNumber);
        this.organizationName = organizationName;
        this.address = address;
    }

    @Override
    public String getName() {
        return organizationName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        this.setTimeUpdated(LocalDateTime.now());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.setTimeUpdated(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return String.format("Organization name: %s\nAddress: %s\n" + super.toString(),
                organizationName == null ? "[no data]" : organizationName,
                address == null ? "[no data]" : address);
    }

    public static class Builder {
        private String organizationName;
        private String address;
        private String phoneNumber;

        public Builder setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Organization build() {
            return new Organization(organizationName, address, phoneNumber);
        }
    }
}
