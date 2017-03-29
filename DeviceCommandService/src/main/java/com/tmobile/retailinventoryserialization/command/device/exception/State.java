package com.tmobile.retailinventoryserialization.command.device.exception;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Documented
@Retention(RUNTIME)
@Target({FIELD, ANNOTATION_TYPE})
@Pattern(regexp = "^[A-Za-z -]+$", message = "{error.validation.not_alphabetic}")
@NotNull
public @interface State {

}
