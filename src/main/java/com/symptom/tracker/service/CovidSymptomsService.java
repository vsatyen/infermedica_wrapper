package com.symptom.tracker.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CovidSymptomsService {

    Logger log = LogManager.getLogger(CovidSymptomsService.class);

    @Value("${infermedica.covid19.symptoms.path}")
    String path;

    @Value("${infermedica.key}")
    String key;

    @Value("${infermedica.app.id}")
    String appId;

    @Autowired
    RestTemplate infermedicaRestTemplate;

    public List getCovid19Symptoms() {
        List covid19SymptomsResponse;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("App-Id", appId);
        headers.set("App-Key", key);
        try {
            HttpEntity entity = new HttpEntity(headers);
            covid19SymptomsResponse = infermedicaRestTemplate.exchange( path, HttpMethod.GET, entity, List.class).getBody();
        } catch (Exception e) {
            log.error("Error getting covid19 symptoms - " + e.getLocalizedMessage());
            covid19SymptomsResponse = Arrays.asList(e.getLocalizedMessage());
        }
        return covid19SymptomsResponse;
    }
}
