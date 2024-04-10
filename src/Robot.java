import java.util.ArrayList;

public class Robot {

    Position pos;
    int directionGrad;

    ArrayList<Position> history=new ArrayList<>();

    public Robot(int x, int y, int directionGrad) {
        this.pos = new Position(x, y);
        this.directionGrad = directionGrad;
    }

    public void turnLeft() {
        directionGrad = (directionGrad + 90) % 360;
    }

    public void turnRight() {
        directionGrad = (directionGrad - 90 + 360) % 360;
    }

    public void stepForward() {
        history.add(pos);       //позиция ушла в историю
                                //переход на новую позицию:
        if (directionGrad == 0)   pos = new Position(pos.x+1, pos.y);
        if (directionGrad == 90)  pos = new Position(pos.x, pos.y+1);
        if (directionGrad == 180) pos = new Position(pos.x-1, pos.y);
        if (directionGrad == 270) pos = new Position(pos.x, pos.y-1);

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
}
