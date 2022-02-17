package Lesson10_1;

import Lesson10_1.hands.IHand;
import Lesson10_1.heads.IHead;
import Lesson10_1.legs.ILeg;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot implements IRobot {
    private IHead head;
    private IHand hand;
    private ILeg leg;

    public Robot(IHead head, IHand hand, ILeg leg) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
    }

    public Robot() {
    }

    public static Robot getMostExpensive(Robot robot, Robot robot1) {
        if (robot.getPrice() > robot1.getPrice()) {
            return robot;
        } else {
            return robot1;
        }
    }

    @Override
    public String toString() {

        return "Robot{" + getClass().getName() +
                "head=" + head +
                ", hand=" + hand +
                ", leg=" + leg +
                '}';
    }


    @Override
    public void action() {
        head.speak();
        hand.upHand();
        leg.step();
    }

    /**
     * Get the cost of a robot
     *
     * @return int
     */
    @Override
    public int getPrice() {
        return head.getPrice() + hand.getPrice() + leg.getPrice();
    }
}