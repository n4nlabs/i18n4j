package io.github.n4nlabs.i18n4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MessageSourceProducer {

    @ConfigProperty(name = "n4nlabs.i18n4j.folder", defaultValue = "i18n")
    String folder;

    @ConfigProperty(name = "n4nlabs.i18n4j.basename", defaultValue = "messages")
    String basename;

    @Produces
    public MessageSource messageSource() {
        return new DefaultMessageSource(folder, basename);
    }

}
