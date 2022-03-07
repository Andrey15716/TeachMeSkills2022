package Lesson10_1;

import Lesson10_1.hands.SamsungHand;
import Lesson10_1.hands.SonyHand;
import Lesson10_1.hands.ToshibaHand;
import Lesson10_1.heads.SamsungHead;
import Lesson10_1.heads.SonyHead;
import Lesson10_1.heads.ToshibaHead;
import Lesson10_1.legs.SamsungLeg;
import Lesson10_1.legs.SonyLeg;
import Lesson10_1.legs.ToshibaLeg;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */

        Robot robot = new Robot(new SamsungHead(100), new SonyHand(121), new ToshibaLeg(112));
        Robot robot1 = new Robot(new SonyHead(232), new ToshibaHand(455), new SamsungLeg(545));
        Robot robot2 = new Robot(new ToshibaHead(134), new SamsungHand(113), new SonyLeg(165));

        System.out.println("robot1 -");
        robot.action();
        System.out.println("robot2 -");
        robot1.action();
        System.out.println("robot3 -");
        robot2.action();



        System.out.println("Самый дорогой робот - " + Robot.getMostExpensive(robot, Robot.getMostExpensive(robot1, robot2)));
    }
}
