package com.test.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController("/customer/{customer-id}/")
public class CustomerController {

    @RequestMapping(name = "/email", method = GET, produces = "application/json")
    public ResponseEntity getEmail() {
        return ResponseEntity
                .status(200)
                .body(new Email("test@email.com"));
    }

    static class Email {
        @JsonProperty("email")
        String email;

        @SuppressWarnings("unused")
        private Email() {
        }

        public Email(String email) {
            this.email = email;
        }
    }
}
