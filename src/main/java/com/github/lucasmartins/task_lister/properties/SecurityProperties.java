package com.github.lucasmartins.task_lister.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "spring.security.jwt")
public class SecurityProperties {

    private String secret;

    private int expiration;
}
