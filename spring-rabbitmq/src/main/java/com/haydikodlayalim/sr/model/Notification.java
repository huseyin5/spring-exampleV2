package com.haydikodlayalim.sr.model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public Date getCraetedAt() {
        return craetedAt;
    }

    public void setCraetedAt(Date craetedAt) {
        this.craetedAt = craetedAt;
    }

    private String notificationId;
    private String message;
    private Boolean seen;
    private Date craetedAt;

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", message='" + message + '\'' +
                ", seen=" + seen +
                ", craetedAt=" + craetedAt +
                '}';
    }
}
