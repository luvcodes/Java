package Homework;

import java.util.*;

public class DAO<T> {
    private Map<String, T> map = new HashMap<>();
    public T get(String id) {
        return map.get(id);
    }
    public void save(String id, T entity) {
        map.put(id, entity);
    }
    public void update(String id, T entity) {
        map.put(id, entity);
    }
    public void delete(String id) {
        map.remove(id);
    }
    public List<T> list() {
        ArrayList<T> list = new ArrayList<>();
        // 遍历map把value，也就是T放到list里面去
        Set<String> set = map.keySet();
        for (String keySet : set) {
            // map.get(keySet)返回的就是User对象 -> ArrayList
            list.add(map.get(keySet));
        }
        return list;
    }
}
