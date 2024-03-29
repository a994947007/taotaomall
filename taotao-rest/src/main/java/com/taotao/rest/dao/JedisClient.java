package com.taotao.rest.dao;

public interface JedisClient {
    //Redis SET命令用于在Redis键中设置一些字符串值
    String set(String key, String value);
    //根据key去查询相应的值
    String get(String key);
    //判断key在Redis缓存中是否存在
    Boolean exists(String key);
    //设置key的过期时间
    Long expire(String key, int seconds);
    //Redis TTL 命令以秒为单位返回 key 的剩余过期时间
    Long ttl(String key);
    //Redis Incr 命令将 key 中储存的数字值增一
    Long incr(String key);
    Long hset(String key, String field, String value);
    //Redis Hget 命令用于返回哈希表中指定字段的值。
    String hget(String key, String field);
    //Redis Hdel 命令用于删除哈希表 key 中的一个或多个指定字段，不存在的字段将被忽略。
    Long hdel(String key, String... field);
}