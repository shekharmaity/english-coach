package com.englishcoach.shared.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@ApplicationPath("/")
@OpenAPIDefinition(
    info =
        @Info(
            title = "English Reading Coach API",
            version = "0.1.0",
            contact = @Contact(name = "English Reading Coach")),
    servers = @Server(url = "/"))
public class EnglishCoachApplication extends Application {}
