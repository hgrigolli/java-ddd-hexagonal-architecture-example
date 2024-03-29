package dev.grigolli.example.dddhexarchi.domain.exceptions;

import dev.grigolli.example.dddhexarchi.domain.validation.DomainError;

import java.util.List;

public class DomainException extends NoStacktraceException {

    private final List<DomainError> errors;

    protected DomainException(final String aMessage, final List<DomainError> anErrors) {
       super(aMessage);
       this.errors = anErrors;
    }

    public static DomainException with(final DomainError anError) {
        return new DomainException(anError.message(), List.of(anError));
    }

    public static DomainException with(final List<DomainError> anErrors) {
        return new DomainException("", anErrors);
    }

    public List<DomainError> getErrors() {
        return this.errors;
    }


}
