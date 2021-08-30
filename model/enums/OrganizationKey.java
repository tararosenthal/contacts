package contacts.model.enums;

public enum OrganizationKey implements RecordKey{
    ORGANIZATION_NAME,
    ADDRESS,
    PHONE_NUMBER;

    @Override
    public String toString() {
        return super.toString().toLowerCase().replaceAll("_", " ");
    }
}
