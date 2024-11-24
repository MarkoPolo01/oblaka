package ru.matveyakulov.markoservcomeback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class
MarkoServComeBackApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MarkoServComeBackApplication.class, args);
    }

}
