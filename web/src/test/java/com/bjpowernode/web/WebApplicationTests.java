package com.bjpowernode.web;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*@SpringBootTest*/
class WebApplicationTests {

    @Test
    void q123456() {

        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(34);
        list.add(56);
        Stream<Integer> stream = list.stream();
        List<Integer> retList = stream.filter(i -> i > 20).collect(Collectors.toList());
        System.out.println(retList); // [34, 56]
    }

}
