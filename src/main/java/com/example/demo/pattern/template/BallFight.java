package com.example.demo.pattern.template;

import lombok.extern.log4j.Log4j2;

/**
 * 模板模式：扩展了 Game 的实体类，它们重写了抽象类的方法——球球大作战
 *
 * @author Yuqiang Wu
 * @since 2022/3/12 012 12:56
 */
@Log4j2
public class BallFight extends Game {
  @Override
  void initialize() {
    log.info("球球大作战比赛初始化！开始比赛。");
  }

  @Override
  void startPlay() {
    log.info("球球大作战比赛开始。尽情享受游戏吧！");
  }
}
