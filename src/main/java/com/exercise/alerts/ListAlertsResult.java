package com.exercise.alerts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ListAlertsResult {
    @JsonProperty("success")
    private boolean Success;
    @JsonProperty("service_id")
    public String ServiceId;
    @JsonProperty("service_name")
    private String ServiceName;
    @JsonProperty("alerts")
    private ArrayList<SimpleAlert>Alerts;
    @JsonProperty("error")
    private String Error;

    public ListAlertsResult(){
        this.ServiceId="";
        this.ServiceName="";
        this.Alerts=new ArrayList<>();
        this.Error="";
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public void setServiceId(String serviceId) {
        ServiceId = serviceId;
    }


    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public ArrayList<SimpleAlert> getAlerts() {
        return Alerts;
    }

    public void setAlerts(ArrayList<SimpleAlert> alerts) {
        Alerts = alerts;
    }

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }
}

class SimpleAlert{
    @JsonProperty("alert_id")
    private String AlertId;
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

    public SimpleAlert(String alertId, String model, String alertType, String alertTS, String severity, String teamSlack) {
        AlertId = alertId;
        Model = model;
        AlertType = alertType;
        AlertTS = alertTS;
        Severity = severity;
        TeamSlack = teamSlack;
    }

    public void setAlertId(String alertId) {
        AlertId = alertId;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setAlertType(String alertType) {
        AlertType = alertType;
    }

    public void setAlertTS(String alertTS) {
        AlertTS = alertTS;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public void setTeamSlack(String teamSlack) {
        TeamSlack = teamSlack;
    }
}
