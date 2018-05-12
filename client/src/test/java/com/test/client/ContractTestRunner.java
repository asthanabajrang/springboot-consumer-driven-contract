package com.test.client;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractTestRunner {

    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.test.customer",
                    "customer", "0.0.1-SNAPSHOT", "stubs")
            .withPort(8000)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    public void verifyGetEmailAddress() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity personResponseEntity = restTemplate.getForEntity("http://localhost:8000/customer/1/email", Object.class);

        assertThat(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(personResponseEntity.getBody().toString()).isEqualTo("test@email.com");
    }
}
