package com.example.demo.pattern.template;

import lombok.extern.log4j.Log4j2;

/**
 * 模板模式：抽象类
 *
 * @author Yuqiang Wu
 * @since 2022/3/12 012 12:54
 */
@Log4j2
public abstract class Game {
  /**
   * 模板
   *
   * @author Yuqiang Wu
   * @since 2022/3/12 012 12:54
   */
  public final void play(){

    // 初始化游戏
    initialize();

    // 开始游戏
    startPlay();

    // 结束游戏
    endPlay();
  }

  void initialize() {
    log.info("比赛初始化！开始比赛。");
  }

  abstract void startPlay();

  void endPlay() {
    log.info("比赛结束！");
  }
}
