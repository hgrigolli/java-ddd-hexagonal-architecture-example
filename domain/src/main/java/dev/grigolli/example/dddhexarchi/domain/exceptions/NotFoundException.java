package dev.grigolli.example.dddhexarchi.domain.exceptions;


import dev.grigolli.example.dddhexarchi.domain.Identifier;
import dev.grigolli.example.dddhexarchi.domain.validation.DomainError;

import java.util.List;


public class NotFoundException extends DomainException {

    protected NotFoundException(final String aMessage, final List<DomainError> anErrors) {
        super(aMessage, anErrors);
    }

    public static NotFoundException with(
            final Class<?> aClass,
            final Identifier id
    ) {
        final var anError = "%s with ID %s not found".formatted(
                aClass.getSimpleName().replace("ID", ""),
                id.getValue()
        );

        return new NotFoundException(anError, List.of(new DomainError(anError)));
    }

    public static NotFoundException with(final DomainError error) {
        return new NotFoundException(error.message(), List.of(error));
    }

}
