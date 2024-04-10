import java.util.ArrayList;

public class RobotEnum {
    Position pos;
    Direction direction;

    ArrayList<Position> history=new ArrayList<>();

    public RobotEnum(Position pos, Direction direction) {
        this.pos = pos;
        this.direction = direction;
    }

    public void turnLeft() {
        if(direction == Direction.UP)
            direction = Direction.LEFT;
        else if (direction== Direction.LEFT) {
            direction=Direction.DOWN;
        } else if (direction== Direction.DOWN) {
            direction= Direction.RIGHT;
        } else if (direction==Direction.RIGHT) {
            direction= Direction.UP;
        }
    }

    public void turnRight() {
        if(direction == Direction.UP)
            direction = Direction.RIGHT;
        else if (direction== Direction.LEFT) {
            direction=Direction.UP;
        } else if (direction== Direction.DOWN) {
            direction= Direction.LEFT;
        } else if (direction==Direction.RIGHT) {
            direction= Direction.DOWN;
        }
    }

    public void stepForward() {
        history.add(pos);       //позиция ушла в историю
        //переход на новую позицию:
        if (direction == Direction.RIGHT)   pos = new Position(pos.x+1, pos.y);
        if (direction == Direction.UP)      pos = new Position(pos.x, pos.y+1);
        if (direction == Direction.LEFT)    pos = new Position(pos.x-1, pos.y);
        if (direction == Direction.DOWN)    pos = new Position(pos.x, pos.y-1);

    }

    public void doCommand(char symbol) {
        if (symbol == 'R')
            turnRight();
        if (symbol == 'L')
            turnLeft();
        if (symbol == 'S')
            stepForward();
    }

    public boolean checkIfIWasHere() {
        return history.contains(pos);
    }

    public int runProgramUntilCross(String proga) {
        for (char symbol : proga.toCharArray()) {
            doCommand(symbol);
            if (symbol=='S' && checkIfIWasHere() )
                return this.history.size();
        }
        return -1;
    }

    @Override
    public String toString() {
        return "RobotEnum{" +
                "pos=" + pos +
                ", direction=" + direction +
                '}';
    }
}
