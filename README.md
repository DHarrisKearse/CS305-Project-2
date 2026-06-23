# CS 305 Project Two: Secure Software Practices

## Overview

This project was completed for **CS 305: Software Security** at Southern New Hampshire University. The goal was to refactor an existing Spring Boot application for Artemis Financial by implementing secure communication mechanisms, applying secure coding practices, and verifying that the application complied with software security testing protocols.

The project focused on data integrity, encryption, vulnerability assessment, secure communications, and static security testing.

---

## Client Summary

### Who Was the Client?

Artemis Financial is a financial consulting company that develops individualized financial plans for its customers. These plans include retirement planning, investments, insurance products, and savings strategies. Because the company handles sensitive customer and financial information, maintaining secure communications and protecting data integrity are critical business requirements.

### What Issue Did the Company Want Addressed?

Artemis Financial wanted to modernize its software security by adding secure communication mechanisms to its public web application. Specifically, the company requested a file verification process using cryptographic checksums to validate data integrity during transmission. The application also required HTTPS encryption and security testing to identify and mitigate potential vulnerabilities.

---

## Security Enhancements Implemented

### SHA-256 Checksum Verification

The application was refactored to implement SHA-256 hashing using Java's MessageDigest class. A checksum endpoint was added to generate a cryptographic hash value for a data string, allowing the integrity of transmitted information to be verified.

Benefits:

* Detects unauthorized modifications to data
* Produces a unique 256-bit digest
* Uses an industry-standard cryptographic algorithm
* Supports secure data validation practices

### HTTPS Secure Communications

Secure communication was implemented by generating a self-signed TLS certificate using Java Keytool and configuring Spring Boot to use HTTPS on port 8443.

The application can be accessed through:

```text
https://localhost:8443/hash
```

This ensures that information transmitted between the client and server is encrypted during transport.

### Vulnerability Assessment

OWASP Dependency-Check was used to perform static analysis of project dependencies and identify known security vulnerabilities. The resulting report was reviewed to determine whether any new vulnerabilities were introduced during the refactoring process.

---

## What I Did Well

One of the strongest aspects of this project was successfully identifying the difference between vulnerabilities introduced by my own code and vulnerabilities inherited from existing framework dependencies. Rather than simply accepting automated scan results at face value, I reviewed each finding and determined whether it applied to the actual deployment configuration of the application.

Secure coding is important because software vulnerabilities can expose sensitive customer information, compromise system integrity, and create financial and reputational risks for organizations. Software security provides value by protecting customer data, reducing business risk, maintaining regulatory compliance, and preserving customer trust.

---

## Most Helpful and Challenging Parts of the Assessment

The most challenging aspect of the project was working through vulnerability assessment results and determining which findings represented actual risks versus false positives. Automated security tools can identify a large number of vulnerabilities, but understanding the context of each finding requires additional analysis.

The most helpful aspect was learning how static analysis tools such as OWASP Dependency-Check can be integrated into the software development lifecycle. These tools provide valuable insight into known vulnerabilities and help developers proactively address security concerns before deployment.

---

## Increasing Layers of Security

Several layers of security were added during this project:

1. SHA-256 checksum verification for data integrity.
2. TLS encryption through HTTPS for secure communications.
3. Static vulnerability analysis using OWASP Dependency-Check.
4. Functional testing to verify secure application behavior.

In future projects, I would continue using vulnerability scanning tools, dependency analysis tools, penetration testing methodologies, secure code reviews, and industry security frameworks such as the OWASP Top Ten to assess vulnerabilities and determine appropriate mitigation strategies.

---

## Ensuring Functionality and Security

After refactoring the application, several testing methods were used to verify functionality and security.

### Functional Testing

* Verified successful project compilation.
* Confirmed application startup without runtime errors.
* Tested the `/hash` endpoint.
* Verified correct SHA-256 checksum generation.

### Security Testing

* Verified HTTPS communication through TLS.
* Confirmed successful certificate deployment.
* Reviewed dependency vulnerabilities using OWASP Dependency-Check.

### Post-Refactoring Validation

After implementing the security enhancements, OWASP Dependency-Check was executed to verify that no additional vulnerabilities had been introduced. Findings were reviewed individually to distinguish actual risks from configuration-specific false positives.

---

## Tools, Resources, and Practices Used

The following tools and practices were valuable throughout the project:

### Development Tools

* Eclipse IDE
* Maven
* Java Keytool
* Spring Boot
* GitHub

### Security Tools

* OWASP Dependency-Check
* TLS/HTTPS Certificates
* SHA-256 Cryptographic Hashing

### Secure Coding Practices

* Principle of least privilege
* Secure communication protocols
* Cryptographic integrity verification
* Vulnerability assessment and remediation
* Static code analysis

These resources will continue to be valuable in future software development and security-focused projects.

---

## Skills Demonstrated

This project demonstrates several technical and professional skills that could be shown to future employers:

* Secure software development
* Java programming
* Spring Boot application development
* Cryptographic hashing implementation
* HTTPS and TLS configuration
* Vulnerability assessment and mitigation
* Static security analysis
* Secure coding best practices
* Software testing and validation
* Technical documentation

The completed project serves as a practical example of implementing security controls within an existing software application while maintaining functionality and validating security through testing.

---

## Technologies Used

* Java 11
* Spring Boot 2.2.4
* Maven
* Eclipse IDE
* OWASP Dependency-Check
* TLS/HTTPS
* SHA-256
* Java Keytool
* GitHub

---

## Author

**Dhandeaka Harris-Kearse**

Bachelor of Science in Computer Science
Southern New Hampshire University
