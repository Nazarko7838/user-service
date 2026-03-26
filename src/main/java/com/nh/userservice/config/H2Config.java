package com.nh.userservice.config;

import org.springframework.context.annotation.Configuration;

/**
 * Database configuration
 */
@Configuration
public class H2Config {

    // // Примусово запускаємо сервер бази даних на окремому порту (8082)
    // @Bean(initMethod = "start", destroyMethod = "stop")
    // public org.h2.tools.Server h2WebConsoleServer() throws java.sql.SQLException {
    //     return org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
    // }
}