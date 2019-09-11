package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 深拷贝.
 *
 * @className: DeepCopyUtils
 * @author: Yuqiang Wu
 * @date: 2019/8/20 020 9:50
 * @version: V1.0
 */
public class DeepCopyUtils {

  /**
   * 通过序列化方法实现深拷贝.
   *
   * @param data
   * @return: void
   * @author: Yuqiang Wu
   * @date: 2019/8/20 020 9:57
   */
  public static <T> T deepCopyBySerialization(T data) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(data);
    oos.flush();
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
    return (T) ois.readObject();
  }

  public static <T> T cloneJson(T data, Class<T> clazz) {
    String json = JSON.toJSONString(data);
    return JSON.parseObject(json, clazz);
  }

  public static <T> List<T> cloneJson(List<T> data, Class<T> clazz) {
    String json = JSON.toJSONString(data);
    return JSON.parseArray(json, clazz);
  }

}
