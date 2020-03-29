package com.sk.simple.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.text.MessageFormat;


@RestController()
@RequestMapping("/v1")
public class AppResource {

    private final Logger LOGGER = LoggerFactory.getLogger(AppResource.class);

    private static final String s = ":::::ServiceName {0}, Request is from host: {1}, Request is being served from host:{2}:::::";

    @Value("${sample.app.service}")
    private String hostname;

    @Value("${sample.app.port}")
    private String port;

    @Value("${is.service.end}")
    private boolean isEndService;


    @GetMapping("/hostname")
    public String hostName(@RequestHeader HttpHeaders headers) {
        try {
            return MessageFormat.format(s, "SIMPLE-APP", headers.getHost(), String.valueOf(InetAddress.getLocalHost()));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return "Failed to get hostname";
        }
    }

    @GetMapping("/process")
    public String process(@RequestHeader HttpHeaders headers) {
        String response= "";
        if(!isEndService) {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://" + hostname + ":" + port+"/v1/process", String.class);
            response = responseEntity.getBody();
            response = response + "\n";
        }
        return response + hostName(headers);
    }
}
