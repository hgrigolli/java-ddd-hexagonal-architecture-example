package dev.grigolli.example.dddhexarchi.application;

public abstract class UseCase<IN, OUT> implements NotFoundable {

    public abstract OUT execute(IN anInput);

}
