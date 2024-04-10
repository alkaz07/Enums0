public class Main {
    public static void main(String[] args) {
       // Direction d = new Direction(); так делать не надо

        Direction d2 = Direction.LEFT;
        d2 = Direction.RIGHT;
        System.out.println("направление сейчас "+d2);

        RobotEnum robby = new RobotEnum(new Position(0, 0), Direction.UP);

        robby.runProgramUntilCross("SSSS");
        System.out.println(robby);
        robby.runProgramUntilCross("RSSRSSSSRSLS");
        System.out.println(robby);

    }
}