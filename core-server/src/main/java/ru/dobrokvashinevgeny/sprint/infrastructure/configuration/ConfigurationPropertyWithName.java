package ru.dobrokvashinevgeny.sprint.infrastructure.configuration;

import javax.inject.Qualifier;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Класс ConfigurationPropertyWithName
 */
@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE, METHOD, PARAMETER})
public @interface ConfigurationPropertyWithName {
	String propertyName();
}