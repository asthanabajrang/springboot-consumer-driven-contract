package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should get email address of customer with id=1"

    request {
        url "/customer/1/email"
        method GET()
        headers {
            contentType(applicationJson())
        }
    }

    response {
        status 200
        body(email: "test@email.com")
        headers {
            contentType(applicationJson())
        }

    }
}