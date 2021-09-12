package contacts.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
/*
 * Abstract record class extended by Person and organization. Contains only one common changeable field: phoneNumber.
 * Time created and updated are managed within program, are only for display, and are not changeable by user.
 */
public abstract class Record implements Serializable {
    private static final long serialVersionUID = 2L;
    private String phoneNumber;
    private final LocalDateTime timeCreated;
    private LocalDateTime timeUpdated;

    protected Record(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        timeCreated = LocalDateTime.now();
        timeUpdated = timeCreated;
    }

    public abstract String getName();

    public abstract String[] getFieldNames();

    public abstract void changeField(String field, String value);

    public abstract String getFieldValues();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.timeUpdated = LocalDateTime.now();
    }

    public void setTimeUpdated(LocalDateTime timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    @Override
    public String toString() {
        return String.format("Number: %s\nTime created: %s\nTime last edit: %s\n",
                phoneNumber == null ? "[no number]" : phoneNumber, timeCreated.truncatedTo(ChronoUnit.MINUTES), timeUpdated.truncatedTo(ChronoUnit.MINUTES));
    }
}
