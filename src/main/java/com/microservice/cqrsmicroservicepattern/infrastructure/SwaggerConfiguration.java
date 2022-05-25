package com.microservice.cqrsmicroservicepattern.infrastructure;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi api() {
        List<Parameter> parameters = new ArrayList<>(
                List.of(getCustomHeader("APPLICATION_ID", "1")));

        return GroupedOpenApi.builder()
                .group("default")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    parameters.forEach(operation::addParametersItem);
                    return operation;
                })
                .addOpenApiMethodFilter(method -> method.getDeclaringClass().isAnnotationPresent(RestController.class))
                .build();
    }

    private Parameter getCustomHeader(String name, String defaultValue) {
        return new Parameter()
                .in("header")
                .name(name)
                .schema(new StringSchema())
                .required(true)
                .example(defaultValue);
    }


    @Bean
    public OpenAPI apiInfo() {
        String applicationName = "Cqrs API";
        String applicationVersion = "v1";
        return new OpenAPI().info(
                new Info().title(applicationName)
                        .description(applicationName)
                        .contact(contact())
                        .version(applicationVersion)
        );
    }

    private Contact contact() {
        return new Contact().name("Caner").email("caner3278@gmail.com");
    }
}