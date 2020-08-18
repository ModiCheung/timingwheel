package yychen.demo.timingwheel;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Main {

    public static void main(String[] args) {
        System.out.println("当前时间：" + LocalDateTime.now());
        System.out.println("当前时间：" + LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8)));
        //jwt 开始轮询
        SystemTimer systemTimer = new SystemTimer();

        TimerTask timerTask1 = new TimerTask(new Thread(() -> {
            System.out.println("10s后给A先生发信息,当前时间：" + LocalDateTime.now());
        }), 10000);

        TimerTask timerTask2 = new TimerTask(new Thread(() -> {
            System.out.println("15s后给B先生发信息,当前时间：" + LocalDateTime.now());
        }), 15000);
        TimerTask timerTask3 = new TimerTask(new Thread(() -> {
            System.out.println("5s后给C先生发信息,当前时间：" + LocalDateTime.now());
        }), 5000);
        systemTimer.addTask(timerTask2);
        systemTimer.addTask(timerTask1);
        systemTimer.addTask(timerTask3);

    }
}