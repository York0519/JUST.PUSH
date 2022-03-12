package com.example.demo.pattern.template;

import lombok.extern.log4j.Log4j2;

/**
 * 模板模式：扩展了 Game 的实体类，它们重写了抽象类的方法——足球
 *
 * @author Yuqiang Wu
 * @since 2022/3/12 012 12:56
 */
@Log4j2
public class Football extends Game {
  @Override
  void startPlay() {
    log.info("足球比赛开始。尽情享受游戏吧！");
  }
}
