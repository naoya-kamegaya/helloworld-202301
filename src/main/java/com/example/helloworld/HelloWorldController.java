package com.example.helloworld;

import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloWorldController {

  @GetMapping("/hello")
  public String hello() {
    return "hello world";
  }

  @GetMapping("/fortune")
  public String fortune() {
    LocalDateTime now = LocalDateTime.now();
    // 時+分*秒を10で割った余りをラッキーナンバーとする。いつ/fortuneにアクセスしたかで運命が決まる。
    int luckyNum = (now.getHour() + now.getMinute() * now.getSecond()) % 10;

    // ラッキーナンバーを元に運勢を決める。
    // あえてタイミングによってだいぶ結果が偏るようにした。運勢はリロード程度で大きく変えることはできないかもしれない…
    String fortune = "吉";
    switch(luckyNum){
      case 0:
        fortune = "大吉";
        break;
      case 2:
      case 4:
        fortune = "中吉";
        break;
      case 5:
      case 7:
        fortune = "小吉";
        break;
      case 9:
        fortune = "凶";
    }

    return "<p>明日の運勢は<span style=\"font-weight:bold\">" + fortune + "</span>かも！</p>" +
            "<p>ラッキーナンバーは<span style=\"font-weight:bold\">" + String.valueOf(luckyNum) + "</span>かな？</p>";
  }
}
