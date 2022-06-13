package com.co.ias.activity.commons;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
