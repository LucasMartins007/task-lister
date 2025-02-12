package com.github.lucasmartins.task_lister.infrastructure.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.security.jwt")
public class SecurityProperties {

    private String secret;

    private long expirationMinutes;

    private long expirationFactor;

    private long expirationMultiplier;

    public long getExpiration() {
        return expirationMinutes * expirationFactor * expirationMultiplier;
    }

}
