package com.example.demo.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component("px")
public class Proxy {
    public void printer(String t){
        Consumer<String> f = System.out::println;
        f.accept(t);;
    }
    public int integer(String t){
        Function<String,Integer> f= Integer::parseInt;
        return f.apply(t);
    }
    public String string(Object t){
        Function<Object,String> f = String::valueOf;
        return f.apply(t);
    }
    public boolean equals(String t1,String t2){
        BiPredicate<String,String> f = String::equals;
        return f.test(t1,t2);
    }
    public int random(int begin,int end){
        BiFunction<Integer,Integer,Integer> f = (t,u)->(int)(Math.random()*(u-t))+1;
        return f.apply(begin, end);
        // Supplier<Double> f = Math::random;
        // return (int)(f.get()*(end-begin))+1;
    }
    public int[] array(int size){
        //int[] arr = new int[size];
        Function<Integer,int[]> f = int[]::new;
        return f.apply(size);
    }
    public Map<Object,Object> hashMap(){
        //Map<String,String> map = new HashMap<>();
        Supplier<Map<Object,Object>> f = HashMap::new;
        return f.get();
    }
    public String message(int i){
        return (i==1)?"SUCCESS":"FAILURE";
    }
    public String time(){
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    }
    public File mkdir(String t,String u){
        BiFunction<String,String,File> f = File::new;
        return f.apply(t, u);
    }
    public File mkfile(File t,String u){
        BiFunction<File,String,File> f = File::new;
        return f.apply(t, u);
    }
}
