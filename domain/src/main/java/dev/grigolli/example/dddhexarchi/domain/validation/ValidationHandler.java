package dev.grigolli.example.dddhexarchi.domain.validation;

import java.util.List;
public interface ValidationHandler {

    ValidationHandler append(DomainError anDomainError);

    ValidationHandler append(String anErrorMessage);

    ValidationHandler append(ValidationHandler anHandler);

    <T> T validate(Validation<T> aValidation);

    default boolean hasErrors() {
        return getErrors() != null && !(getErrors().isEmpty());
    }

    default DomainError firstError() {
        if(hasErrors()) {
            return getErrors().get(0);
        }
        return null;
    }

    List<DomainError> getErrors();

    interface Validation<T> {
        T validate();
    }




}
