# Vehicle Tax Check - Test Automation

This repository contains automated tests for a vehicle check system.


### Prerequisites

Please make sure to install the following to use the test framework.

```
Java - 1.8
Maven - 3.5
IntelliJ or Eclipse with Cucumber Plugin
```

First time while running test from feature file might receive error "chromedriver” cannot be opened because the developer cannot be verified."

if error is received, using terminal navigate to driver location and run "xattr -d com.apple.quarantine chromedriver"


## Built With

* Maven - Build Management
* Selenium - Web Automation Tool
* Cucumber - BDD Tests
* Serenity - Text execution and reporting
* Hamcrest - Assertions



## Running the tests

#### To run all the tests in the project

```
mvn clean test

```
