package com.example.demo.pattern.strategy;

/**
 * 策略模式：使用了某种策略的类
 *
 * @author Yuqiang Wu
 * @since 2022/3/12 012 11:51
 */
public class Context {
  private final Strategy strategy;

  public Context(Strategy strategy){
    this.strategy = strategy;
  }

  /**
   * 执行策略
   *
   * @param num1 int
   * @param num2 int
   * @return int
   * @author Yuqiang Wu
   * @since 2022/3/12 012 12:52
   */
  public int executeStrategy(int num1, int num2){
    return strategy.doOperation(num1, num2);
  }
}
