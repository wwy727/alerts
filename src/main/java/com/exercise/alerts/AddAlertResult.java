package com.exercise.alerts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddAlertResult{
    @JsonProperty("alert_id")
    private String AlertId;
    @JsonProperty("error")
    private String Error;

    public AddAlertResult(String alertId, String error) {
        AlertId = alertId;
        Error = error;
    }

    public void setAlertId(String alertId) {
        AlertId = alertId;
    }

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }
}
