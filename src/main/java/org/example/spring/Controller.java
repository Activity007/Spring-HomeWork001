package org.example.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class Controller {
    // Constructor Injection
    private final AppProperties appProperties;
    public Controller(AppProperties appProperties) {
        this.appProperties = appProperties;
    }
    @GetMapping("/config")
    public Map<String, Object> getConfig() {
        Map<String, Object> map = new HashMap<>();
        map.put("name",appProperties.getName());
        map.put("version",appProperties.getVersion());
        map.put("desc",appProperties.getDesc());
        map.put("jwtSecret",appProperties.getSecurity().getJwtSecret());
        map.put("experation",appProperties.getSecurity().getExpiration());

        map.put("topic",appProperties.getKafka().getTopic());
        return map;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
/*
    @Value("${app.info.name}")
    private String appName;
*/
    @GetMapping("/thread")
    public String thread() {
        var thread = Thread.currentThread();
        return "Thread: " + thread.toString();
    }
}
