package io.github.n4nlabs.i18n4j;

import jakarta.enterprise.context.ApplicationScoped;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ApplicationScoped
public class DefaultMessageSource implements MessageSource {
    private final String folder;
    private final String basename;
    private final ConcurrentMap<Locale, ResourceBundle> bundles = new ConcurrentHashMap<>();

    public DefaultMessageSource() {
        this("i18n", "messages");
    }

    public DefaultMessageSource(String folder, String basename) {
        this.folder = folder;
        this.basename = basename;
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) {
        String fullBase = folder + "/" + basename;
        ResourceBundle bundle = bundles.computeIfAbsent(locale, loc -> ResourceBundle.getBundle(fullBase, loc,
                Thread.currentThread().getContextClassLoader(), new UTF8Control()));
        String pattern = bundle.containsKey(code) ? bundle.getString(code) : code;
        return MessageFormat.format(pattern, args != null ? args : new Object[] {});
    }

}
