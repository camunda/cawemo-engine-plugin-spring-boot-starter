# Spring Boot starter for the Cawemo engine plugin

## About
This project provides a Spring Boot starter for the [Cawemo engine plugin](https://docs.camunda.org/cawemo/latest/technical-guide/integrations/engine/).
The starter makes it more convenient to use the plugin in Spring Boot-based applications like
[Camunda Platform Run](https://docs.camunda.org/manual/latest/user-guide/camunda-bpm-run/), by providing an easy
configuration mechanism via application properties.

## Disclaimer
This library is not production-ready and not actively maintained. It rather serves as an example of how you could use
the Cawemo engine plugin with Spring Boot.

## How it works
If the class `CawemoEnginePlugin` is found on the classpath, the starter will
automatically instantiate it as a Spring bean.

### Configuration
The plugin can be configured with the following application properties (please refer to the [Camunda Docs](https://docs.camunda.org/cawemo/latest/technical-guide/integrations/engine/#parameters-explained)
for a detailed description of the different properties).

#### Required properties
- `camunda.cawemo.cawemo-url`
- `camunda.cawemo.user-id`
- `camunda.cawemo.api-key`
- `camunda.cawemo.project-name`
- `camunda.cawemo.auth-mode` (`BASIC` or `QUERY_PARAM`)
#### Optional properties
(can be used with `authMode=QUERY_PARAM` only)
- `camunda.cawemo.custom-basic-auth.user`
- `camunda.cawemo.custom-basic-auth.password`

## How to use it with Camunda Platform Run
1. Download the Cawemo engine plugin JAR file as described in the [Camunda Docs](https://docs.camunda.org/cawemo/latest/technical-guide/integrations/engine/#as-jar) 
2. Clone this repository
3. Build a JAR file with `mvn clean package`
    - You'll find the file `cawemo-engine-plugin-spring-boot-starter-1.0.0.jar` in the `target` folder
4. Copy both JAR files to the `configuration/userlib` folder of your Camunda Platform Run distribution
5. Configure the Cawemo plugin in the `configuration/default.yml` or `configuration/production.yml` file (depending on your use case) with the [properties listed above](#configuration)
6. Start Camunda Platform Run
7. Check if the integration is working by deploying a process to the Camunda Platform; if everything is set up correctly,
the process will be synced to an "Engine deployment" project in Cawemo
