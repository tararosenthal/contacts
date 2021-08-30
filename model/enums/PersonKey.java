package contacts.model.enums;

public enum PersonKey implements RecordKey{
    FIRST_NAME,
    LAST_NAME,
    BIRTH_DATE,
    GENDER,
    PHONE_NUMBER;

    @Override
    public String toString() {
        return super.toString().toLowerCase().replaceAll("_", " ");
    }
}
