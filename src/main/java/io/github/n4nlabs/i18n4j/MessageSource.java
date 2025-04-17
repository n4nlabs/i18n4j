package io.github.n4nlabs.i18n4j;

import java.util.Locale;

public interface MessageSource {
    String getMessage(String code, Object[] args, Locale locale);
}