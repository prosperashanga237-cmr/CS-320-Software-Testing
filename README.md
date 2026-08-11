# CS 320: Software Testing, Automation, and Quality Assurance

## Portfolio Overview

This repository contains artifacts from my work in CS 320: Software Testing, Automation, and Quality Assurance. The projects demonstrate my experience developing software from customer requirements, creating JUnit tests, validating software functionality, and applying testing strategies to improve software quality.

The portfolio includes the Contact Service files from Project One and my Summary and Reflections Report from Project Two.

## How can I ensure that my code, program, or software is functional and secure?

I can ensure that software is functional and secure by developing it directly from clearly defined requirements and continuously testing whether those requirements are satisfied. In Project One, I translated customer requirements into JUnit tests for the Contact, Task, and Appointment services. I tested normal behavior as well as boundary values and invalid inputs. For example, the Contact class required a unique ID of no more than 10 characters, names of no more than 10 characters, a 10-digit phone number, and an address of no more than 30 characters. My tests verified valid values while also checking null values, values beyond the permitted lengths, and incorrectly formatted data.

I also learned that code coverage by itself does not guarantee quality. Tests need meaningful assertions that confirm the program actually produces the expected results. Using techniques such as `assertEquals()` and `assertThrows()` allowed me to verify both successful operations and the rejection of invalid data. Security also requires defensive programming, input validation, appropriate error handling, and testing unexpected or malicious inputs. A combination of automated testing, code review, static analysis, integration testing, and security testing provides stronger confidence than relying on one technique alone.

## How do I interpret user needs and incorporate them into a program?

I interpret user needs by converting them into specific, measurable software requirements before implementing the solution. Requirements help define what the program must do, what data is considered valid, and how the program should respond to different situations. In Project One, the customer's requirements determined the structure and behavior of the Contact, Task, and Appointment classes and their corresponding services.

For example, the customer specified exactly which Contact fields could be updated and established length and format restrictions for each field. Instead of making assumptions about what the customer intended, I implemented those requirements directly and created tests that traced back to them. I also tested boundary conditions because user needs include more than the expected path through a program. The software must behave correctly when users provide invalid, missing, duplicate, or unexpected information. This requirements-driven approach helps ensure that the final software solves the customer's actual problem rather than simply functioning according to the developer's assumptions.

## How do I approach designing software?

I approach software design by first understanding the requirements and then breaking the problem into smaller components with clearly defined responsibilities. For this project, separating the data objects from their service classes made the application easier to understand, test, and maintain. The Contact class was responsible for representing and validating contact information, while ContactService managed operations such as adding, deleting, and updating contacts.

I also consider testability while designing software. Small and focused classes and methods are easier to test independently, and automated unit tests provide immediate feedback when changes introduce defects. I try to consider both valid and invalid scenarios during development rather than waiting until the end of the project to think about testing. Going forward, I will continue using requirements-driven development, modular design, input validation, automated testing, and regular code review. This approach helps me create software that is functional, maintainable, secure, and easier to improve as requirements change.

## Portfolio Artifacts

**Project One – Contact Service**
- `Contact.java`
- `ContactService.java`
- `ContactTest.java`
- `ContactServiceTest.java`

**Project Two**
- Summary and Reflections Report

These artifacts demonstrate my ability to create unit tests to uncover errors, analyze software-testing approaches based on requirements, and apply appropriate testing strategies to meet customer requirements.
