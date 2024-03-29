package dev.grigolli.example.dddhexarchi.domain.validation.handler;


import dev.grigolli.example.dddhexarchi.domain.exceptions.DomainException;
import dev.grigolli.example.dddhexarchi.domain.validation.DomainError;
import dev.grigolli.example.dddhexarchi.domain.validation.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidationHandler {

    private final List<DomainError> errors;


    private Notification(final List<DomainError> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final DomainError anError) {
        return new Notification(List.of(anError));
    }

    public static Notification create(final Throwable aThrowable) {
        return create(new DomainError(aThrowable.getMessage()));
    }

    @Override
    public Notification append(DomainError anError) {
        this.errors.add(anError);
        return this;
    }

    @Override
    public ValidationHandler append(String anErrorMessage) {
        DomainError error = new DomainError(anErrorMessage);
        this.errors.add(error);
        return this;
    }

    @Override
    public Notification append(ValidationHandler anHandler) {
        this.errors.addAll(anHandler.getErrors());
        return this;
    }

    @Override
    public <T> T validate(final Validation<T> aValidation) {
        try {
            return aValidation.validate();
        } catch (final DomainException ex) {
            this.errors.addAll(ex.getErrors());
        } catch (final Throwable t) {
            this.errors.add(new DomainError(t.getMessage()));
        }
        return null;
    }

    @Override
    public List<DomainError> getErrors() {
        return this.errors;
    }
}
