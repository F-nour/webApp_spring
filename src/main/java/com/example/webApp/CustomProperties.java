package com.example.webApp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="com.exemple.demo")
public class CustomProperties {

	private String apiUrl;
}
