package com.exercise.alerts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Alert {
    @JsonProperty("alert_id")
    private String AlertId;
    @JsonProperty("service_id")
    private String ServiceId;
    @JsonProperty("service_name")
    private String ServiceName;
    @JsonProperty("model")
    private String Model;
    @JsonProperty("alert_type")
    private String AlertType;
    @JsonProperty("alert_ts")
    private String AlertTS;
    @JsonProperty("severity")
    private String Severity;
    @JsonProperty("team_slack")
    private String TeamSlack;

    public String getAlertId() {
        return AlertId;
    }

    public void setAlertId(String alertId) {
        AlertId = alertId;
    }

    public String getServiceId() {
        return ServiceId;
    }

    public void setServiceId(String serviceId) {
        ServiceId = serviceId;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getAlertType() {
        return AlertType;
    }

    public void setAlertType(String alertType) {
        AlertType = alertType;
    }

    public String getAlertTS() {
        return AlertTS;
    }

    public void setAlertTS(String alertTS) {
        AlertTS = alertTS;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public String getTeamSlack() {
        return TeamSlack;
    }

    public void setTeamSlack(String teamSlack) {
        TeamSlack = teamSlack;
    }
}
