package ru.practicum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@PropertySource(value = "file:C:\\myapp\\myapp.properties", ignoreResourceNotFound = true) // пример для Windows
@PropertySource(value = "file:/etc/myapp/myapp.properties", ignoreResourceNotFound = true) // пример для Unix-like
public class AppConfig {
}