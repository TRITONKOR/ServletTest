package org.example.servlettest.persistence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.example.servlettest.persistence.entity", "org.example.servlettest.persistence.repository", "org.example.servlettest.persistence.service.impl"})
public class AppConfig {

}
