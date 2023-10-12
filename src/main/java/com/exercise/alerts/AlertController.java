package com.exercise.alerts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.io.*;
import java.util.ArrayList;

@RestController
public class AlertController {
    private ArrayList<Alert>dataList;
    @PostMapping("/alerts")
    public ResponseEntity<String> Alerts(@RequestBody Alert alert) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Alert> allAlerts = GetAllFromFile();
        for (Alert item : allAlerts) {
            if (item.getAlertId().equals(alert.getAlertId())){
              return new ResponseEntity<>(objectMapper.writeValueAsString(new AddAlertResult("","alert id repeated")),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        // write alert to data.txt
        try (FileWriter writer = new FileWriter("data.txt", true)) {
            writer.write(objectMapper.writeValueAsString(alert) + System.lineSeparator()); //Write one line followed by the next line
        } catch (IOException e) {
            return new ResponseEntity<>(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new AddAlertResult("",e.toString())),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(new AddAlertResult(alert.getAlertId(),"")),HttpStatus.OK);
    }
    @GetMapping("/alerts")
    public ResponseEntity<String> ListAlerts(@RequestParam("service_id") String ServiceId,
                                             @RequestParam("start_ts") String StartTS,
                                             @RequestParam("end_ts") String EndTS
    ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ListAlertsResult listAlertsResult = new ListAlertsResult();
        if (ServiceId.isEmpty()){
            listAlertsResult.setSuccess(false);
            listAlertsResult.setError("service_id is empty");
            return new ResponseEntity<>(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listAlertsResult),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ArrayList<Alert> alerts = GetAllFromFile();
        for (Alert alert : alerts) {
            if (alert.getServiceId().equals(ServiceId)){
                if (listAlertsResult.ServiceId.isEmpty()){
                    listAlertsResult.setServiceId(alert.getServiceId());
                    listAlertsResult.setServiceName(alert.getServiceName());
                }
                int alertTs=Integer.parseInt(alert.getAlertTS());
                if (!StartTS.isEmpty()){
                    int start=Integer.parseInt(StartTS);
                    if (!(alertTs>=start)){
                        continue;
                    }
                }
                if (!EndTS.isEmpty()){
                    int end=Integer.parseInt(EndTS);
                    if (!(alertTs<=end)){
                        continue;
                    }
                }
                listAlertsResult.getAlerts().add(new SimpleAlert(alert.getAlertId(),
                        alert.getModel(),
                        alert.getAlertType(),
                        alert.getAlertTS(),
                        alert.getSeverity(),
                        alert.getTeamSlack()));
            }
        }
        listAlertsResult.setSuccess(true);
        return new ResponseEntity<>(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listAlertsResult),HttpStatus.OK);
    }
    private ArrayList<Alert>GetAllFromFile() throws IOException {
        ArrayList<Alert> dataList = new ArrayList<>();
        // read alerts from data.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            ObjectMapper objectMapper = new ObjectMapper();
            while ((line = reader.readLine()) != null) {
                Alert myData = objectMapper.readValue(line, Alert.class);
                dataList.add(myData);
            }
        }
        return dataList;
    }
}


