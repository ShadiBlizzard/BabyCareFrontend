package model;

import java.io.Serializable;

public enum AppointmentStatus implements Serializable {
    REQUESTED,
    SEEN,
    ACCEPTED,
    CANCELLED,
    REJECTED
}
