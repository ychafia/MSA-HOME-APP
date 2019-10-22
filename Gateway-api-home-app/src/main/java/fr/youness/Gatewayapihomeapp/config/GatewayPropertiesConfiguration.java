package fr.youness.Gatewayapihomeapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("gateway-config")
@RefreshScope
public class GatewayPropertiesConfiguration {
    private int variableTest;

    public int getVariableTest() {
        return variableTest;
    }

    public void setVariableTest(int variableTest) {
        this.variableTest = variableTest;
    }
}
