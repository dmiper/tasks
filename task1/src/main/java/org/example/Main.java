package org.example;

public class Main {
public static void main(String[] args) {

    int randomDirection = (int) (Math.random() * 3 + 1);
    int startX = (int) (Math.random() * 100 - 10);
    int startY = (int) (Math.random() * 100 - 10);
    int finishX = (int) (Math.random() * 100 - 10);
    int finishY = (int) (Math.random() * 100 - 10);

    Robot robot = switch (randomDirection) {
        case 1 -> new Robot(startX, startY, Direction.DOWN);
        case 2 -> new Robot(startX, startY, Direction.RIGHT);
        case 3 -> new Robot(startX, startY, Direction.UP);
        case 4 -> new Robot(startX, startY, Direction.LEFT);
        default -> throw new IllegalStateException("Unexpected value: " + randomDirection);
    };
    moveRobot(robot, finishX, finishY);
}

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

public static class Robot {
    private int x;
    private int y;
    private Direction dir;

    public Robot(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDirection() {
        return dir;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        if (dir == Direction.UP) {
            dir = Direction.LEFT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.DOWN;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.UP;
        }
    }

    public void turnRight() {
        if (dir == Direction.UP) {
            dir = Direction.RIGHT;
        } else if (dir == Direction.DOWN) {
            dir = Direction.LEFT;
        } else if (dir == Direction.LEFT) {
            dir = Direction.UP;
        } else if (dir == Direction.RIGHT) {
            dir = Direction.DOWN;
        }
    }

    public void stepForward() {
        if (dir == Direction.UP) {
            y++;
        }
        if (dir == Direction.DOWN) {
            y--;
        }
        if (dir == Direction.LEFT) {
            x--;
        }
        if (dir == Direction.RIGHT) {
            x++;
        }
    }
}

public static void moveRobot(Robot robot, int toX, int toY) {
    System.out.println("Изначальная точка x = " + robot.getX() + ", y = " + robot.getY());

    switch (robot.getDirection()) {
        case UP -> {
            if (toX > robot.getX()) {
                robot.turnRight();
                for (int i = robot.getX(); i < toX; i++) {
                    robot.stepForward();
                }
                lookRight(robot, toY);
            } else if (toX < robot.getX()) {
                robot.turnLeft();
                for (int i = robot.getX(); i > toX; i--) {
                    robot.stepForward();
                }
                lookLeft(robot, toY);
            }
        }
        case DOWN -> {
            if (toX > robot.getX()) {
                robot.turnLeft();
                for (int i = robot.getX(); i < toX; i++) {
                    robot.stepForward();
                }
                lookRight(robot, toY);
            } else if (toX < robot.getX()) {
                robot.turnRight();
                for (int i = robot.getX(); i > toX; i--) {
                    robot.stepForward();
                }
                lookLeft(robot, toY);
            }
        }
        case LEFT -> {
            if (toX > robot.getX()) {
                robot.turnRight();
                robot.turnRight();
                for (int i = robot.getX(); i < toX; i++) {
                    robot.stepForward();
                }
                lookRight(robot, toY);
            } else if (toX < robot.getX()) {
                for (int i = robot.getX(); i > toX; i--) {
                    robot.stepForward();
                }
                lookLeft(robot, toY);
            }
        }
        case RIGHT -> {
            if (toX > robot.getX()) {
                for (int i = robot.getX(); i < toX; i++) {
                    robot.stepForward();
                }
                lookRight(robot, toY);
            } else if (toX < robot.getX()) {
                robot.turnLeft();
                robot.turnLeft();
                for (int i = robot.getX(); i > toX; i--) {
                    robot.stepForward();
                }
                lookLeft(robot, toY);
            }
        }
        default -> throw new IllegalStateException("Unexpected value: " + robot.getDirection());
    }

    System.out.println("Ожидалось, что робот окажется в точке с координатой x = " + toX + ", y = " + toY + " и он смотрел в сторону " + robot.getDirection());
    System.out.println("Однако робот оказался в точке x = " + robot.getX() + ", y = " + robot.getY());

}

private static void lookLeft(Robot robot, int toY) {
    if (toY > robot.getY()) {
        robot.turnRight();
        for (int i = robot.getY(); i < toY; i++) {
            robot.stepForward();
        }
    } else if (toY < robot.getY()) {
        robot.turnLeft();
        for (int i = robot.getY(); i > toY; i--) {
            robot.stepForward();
        }
    }
}

private static void lookRight(Robot robot, int toY) {
    if (toY > robot.getY()) {
        robot.turnLeft();
        for (int i = robot.getY(); i < toY; i++) {
            robot.stepForward();
        }
    } else if (toY < robot.getY()) {
        robot.turnRight();
        for (int i = robot.getY(); i > toY; i--) {
            robot.stepForward();
        }
    }
}
}