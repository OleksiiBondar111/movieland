package com.bonolex.movieland.exceptions;

/**
 * Created by OBondar on 10.03.2019.
 */
public class EntityErrorResponse    {
    private int status;
    private String message;
    private long timestamp;

    public EntityErrorResponse() {

    }

    public EntityErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
