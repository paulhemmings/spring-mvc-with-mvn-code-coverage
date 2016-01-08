spring-mvc-with-mvn-code-coverage
=================================

A simple Spring MVC maven project with full code coverage plugins (cobertura, PMD) as well as example unit tests.

To run:

1. Clone the project
2. mvn clean install -Pdev
3. mvn jetty:run -Pdev

To run code analysis:

1. mvn cobertura:cobertura
2. open target/site/cobertura/index.html
