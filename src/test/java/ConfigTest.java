import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for Config")
class ConfigTest {

    Config config;


    @Test
    @DisplayName("Testing get() method for production")
    void get() {
        config = new Config();

        assertAll(
                () -> assertEquals("sq04_db", config.get("dbname")),
                () -> assertEquals("127.0.0.1", config.get("host")),
                () -> assertEquals("fintek", config.get("application.name")),
                () -> assertEquals("8080", config.get("application.port")),
                () -> assertEquals("/api/v1", config.get("application.context-url")),
                () -> assertEquals("production", config.get("mode")),
                () -> assertEquals("green", config.get("theme")),
                () -> assertEquals("fast", config.get("pipeline"))
        );
    }

    @Test
    @DisplayName("Testing get() method for development")
    void getDev() {
        config = new Config("/config-dev.txt");

        assertAll(
                () -> assertEquals("sq04_db-development", config.get("dbname")),
                () -> assertEquals("127.0.0.1", config.get("host")),
                () -> assertEquals("fintek-development", config.get("application.name")),
                () -> assertEquals("8082", config.get("application.port")),
                () -> assertEquals("/api/v1", config.get("application.context-url")),
                () -> assertEquals("development", config.get("mode")),
                () -> assertEquals("yellow", config.get("theme")),
                () -> assertEquals("fast-development", config.get("pipeline"))
        );
    }

    @Test
    @DisplayName("Testing get() method for staging")
    void getStaging() {
        config = new Config("/config-staging.txt");

        assertAll(
                () -> assertEquals("sq04_db", config.get("dbname")),
                () -> assertEquals("127.0.0.1", config.get("host")),
                () -> assertEquals("fintek-staging", config.get("application.name")),
                () -> assertEquals("8081", config.get("application.port")),
                () -> assertEquals("/api/v1", config.get("application.context-url")),
                () -> assertEquals("staging", config.get("mode")),
                () -> assertEquals("blue", config.get("theme")),
                () -> assertEquals("fast-staging", config.get("pipeline"))
        );
    }

}
