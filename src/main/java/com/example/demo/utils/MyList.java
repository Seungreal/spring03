package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component @Lazy @Setter
public class MyList<T> {
    private List<T> l;
    public MyList(){l= new ArrayList<>();}
    public void add(T t){l.add(t);}
    public void add(int i,T t){l.add(i, t);}
    public boolean contains(T t){return l.contains(t);}
    public int indexOf(T t){return l.indexOf(t);}
    public boolean isEmpty(){return l.isEmpty();}
    public T get(int i){return l.get(i);}
    public List<T> get(){return l;}
    public void remove(int i){l.remove(i);}
    public void set(int i,T t){l.set(i, t);}
    public List<T> subList(int from,int to){return l.subList(from, to);}
    public int size(){return l.size();}
    public String toString(){return l.toString();}
    public void clear(){l.clear();}
}
