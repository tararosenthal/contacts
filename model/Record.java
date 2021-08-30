package contacts.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Record {
    private String phoneNumber;
    private final LocalDateTime timeCreated;
    private LocalDateTime timeUpdated;

    protected Record(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        timeCreated = LocalDateTime.now();
        timeUpdated = timeCreated;
    }

    public abstract String getName();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.timeUpdated = LocalDateTime.now();
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeUpdated() {
        return timeUpdated;
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
