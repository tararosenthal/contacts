package contacts.model.enums;

public interface RecordKey {
    static RecordKey getRecordKey(String string) {
        if (RecordType.PERSON.equals(RecordType.getRecordType())) {
            switch (string.toLowerCase().trim()) {
                case "first name":
                case "name":
                case "given name":
                    return PersonKey.FIRST_NAME;
                case "last name":
                case "surname":
                    return PersonKey.LAST_NAME;
                case "birth":
                case "birth date":
                case "birthday":
                    return PersonKey.BIRTH_DATE;
                case "gender":
                case "sex":
                    return PersonKey.GENDER;
                case "number":
                case "phone number":
                    return PersonKey.PHONE_NUMBER;
                default:
                    return null;
            }
        } else {
            switch (string.toLowerCase().trim()) {
                case "name":
                case "organization name":
                case "business name":
                    return OrganizationKey.ORGANIZATION_NAME;
                case "address":
                case "location":
                    return OrganizationKey.ADDRESS;
                case "number":
                case "phone number":
                    return OrganizationKey.PHONE_NUMBER;
                default:
                    return null;
            }
        }
    }
}
