package com.teachkal.btf.spring.mono.shared;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Util {

    public Util(){}
    public static <T> List<T> iterableToList(Iterable<T> iterableObj) {
        return StreamSupport
                .stream(iterableObj.spliterator(), false)
                .collect(Collectors.toList());
    }

}
