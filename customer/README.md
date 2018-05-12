# Simple Example on Consumer Driven Contract using Spring cloud

## How to run this application/publish producer contract

mvn clean install

The above command will publish the service stub in .m2 repository.
We can also see the generated classes in test-class folder under target folder

## How to write consumer driven contract
The fundamental approach used in CDC is that it uses service stub produced by upstream service by downstream or consumer application that verifies the contract.

We just add BaseClass with spring boot annotation and create contract in groovy (e.g. shouldGetEmailAddress.groovy).



