package com.app.myapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The third type of application configuration is using JAVA SOURCE
 * - This is to completely get rid of XML configuration.
 * - This configuration class takes place of XML applicationContext file.
 * - All beans are defined here and dependencies are injected.
 * @author user
 *
 */
@Configuration
@ComponentScan("com.app.myapp")
public class SportConfig {

}