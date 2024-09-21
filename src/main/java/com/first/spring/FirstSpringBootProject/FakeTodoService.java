package com.first.spring.FirstSpringBootProject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("FakeService")
public class FakeTodoService implements  TodoService{
    public String doSomething(){
        return "Something";
    }
}
