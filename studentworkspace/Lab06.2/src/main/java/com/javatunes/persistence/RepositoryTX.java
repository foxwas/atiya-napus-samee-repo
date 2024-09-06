package com.javatunes.persistence;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Much detail omitted …
@Target({ElementType.TYPE})
public @interface RepositoryTX {

}
