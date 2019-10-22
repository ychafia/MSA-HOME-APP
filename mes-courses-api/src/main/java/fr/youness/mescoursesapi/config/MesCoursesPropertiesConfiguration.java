package fr.youness.mescoursesapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mescourses-config")
@RefreshScope
public class MesCoursesPropertiesConfiguration {
    private int limitReturnedElement;

    public int getLimitReturnedElement() {
        return limitReturnedElement;
    }

    public void setLimitReturnedElement(int limitReturnedElement) {
        this.limitReturnedElement = limitReturnedElement;
    }
}
