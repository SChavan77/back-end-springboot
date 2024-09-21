package com.first.spring.FirstSpringBootProject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("AnotherService")
//@Primary
public class AnotherFakeTodoService implements TodoService{
    @Override
    public String doSomething() {
        return "Another something";
    }
}
