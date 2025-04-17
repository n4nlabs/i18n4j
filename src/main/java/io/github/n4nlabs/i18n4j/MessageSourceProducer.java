package io.github.n4nlabs.i18n4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MessageSourceProducer {

    @ConfigProperty(name = "messages.basename", defaultValue = "messages")
    String basename;

    @Produces
    public MessageSource messageSource() {
        return new DefaultMessageSource(basename);
    }
}
