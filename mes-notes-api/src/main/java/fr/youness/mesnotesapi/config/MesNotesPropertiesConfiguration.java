package fr.youness.mesnotesapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mesnotes-config")
@RefreshScope
public class MesNotesPropertiesConfiguration {

    private int limitReturnedNotes;

    public int getLimitReturnedNotes() {
        return limitReturnedNotes;
    }

    public void setLimitReturnedNotes(int limitReturnedNotes) {
        this.limitReturnedNotes = limitReturnedNotes;
    }
}
