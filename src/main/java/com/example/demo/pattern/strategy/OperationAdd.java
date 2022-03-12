package com.example.demo.pattern.strategy;

/**
 * 策略模式：实现接口的实体策略类——加法运算
 *
 * @author Yuqiang Wu
 * @since 2022/3/12 012 11:51
 */
public class OperationAdd implements Strategy {
  @Override
  public int doOperation(int num1, int num2) {
    return num1 + num2;
  }
}
