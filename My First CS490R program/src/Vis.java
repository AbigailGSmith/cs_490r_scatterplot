import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import static java.awt.Color.*;

public class Vis extends JPanel implements ActionListener, MouseInputListener {

    public static int queryNumber;
    public float yMaxM; public float yMinM; public float xMaxM; public float xMinM;
    public float yMaxF; public float yMinF; public float xMaxF; public float xMinF;
    public float yMax; public float yMin; public float xMax; public float xMin;
    public static boolean showGender;
    public static boolean collision;
    public static float collisionX; public static float collisionY;
    public float verticalLength; public float horizontalLength;
    private Rectangle box;
    private Point mouseDown;


    public Vis() {
        showGender = false;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(50,40,50,getHeight() - 75); //draw vertical axis
        g.drawLine(50,getHeight() - 75, getWidth() - 50,getHeight() - 75); //draw horizontal axis

        verticalLength = (getHeight() - 75) - 40;
        horizontalLength = (getWidth() - 50) - 50;

        if (queryNumber == 1) { //attempted vs passed

            //attempted on y, passed on x
            yMaxM = Main.pointsM.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinM = Main.pointsM.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMaxF = Main.pointsF.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinF = Main.pointsF.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMax = Math.max(yMaxM, yMaxF);
            yMin = Math.min(yMinM, yMinF);
            xMax = Math.max(xMaxM, xMaxF);
            xMin = Math.min(xMinM, xMinF);

            if (showGender) {

                g.setColor(BLUE);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                g.setColor(PINK);
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            } else {

                g.setColor(BLACK);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            }

            //printing x axis labels
            g.setColor(BLACK);
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50);
            }
            g.drawString("0.0",50 ,getHeight() - 50);

            //printing y axis labels
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*yMax), 15,(int) (verticalLength - (verticalLength * (i/4.0f))+50));
            }
            g.drawString("0.0",50 ,getHeight() - 50);
        } else if (queryNumber == 2) { //attempted vs gpa

            //attempted on y, passed on x
            yMaxM = Main.pointsM.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinM = Main.pointsM.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMaxF = Main.pointsF.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinF = Main.pointsF.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMax = Math.max(yMaxM, yMaxF);
            yMin = Math.min(yMinM, yMinF);
            xMax = Math.max(xMaxM, xMaxF);
            xMin = Math.min(xMinM, xMinF);

            if (showGender) {

                g.setColor(BLUE);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                g.setColor(PINK);
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            } else {

                g.setColor(BLACK);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            }

            //printing x axis labels
            g.setColor(BLACK);
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50);
            }
            g.drawString("0.0",50 ,getHeight() - 50);

            //printing y axis labels
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*yMax), 15,(int) (verticalLength - (verticalLength * (i/4.0f))+50));
            }
            g.drawString("0.0",50 ,getHeight() - 50);
        } else if (queryNumber == 3) { //passed vs gpa

            //attempted on y, passed on x
            yMaxM = Main.pointsM.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinM = Main.pointsM.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMaxF = Main.pointsF.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinF = Main.pointsF.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMax = Math.max(yMaxM, yMaxF);
            yMin = Math.min(yMinM, yMinF);
            xMax = Math.max(xMaxM, xMaxF);
            xMin = Math.min(xMinM, xMinF);

            if (showGender) {

                g.setColor(BLUE);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                g.setColor(PINK);
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            } else {

                g.setColor(BLACK);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            }

            //printing x axis labels
            g.setColor(BLACK);
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50);
            }
            g.drawString("0.0",50 ,getHeight() - 50);

            //printing y axis labels
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*yMax), 15,(int) (verticalLength - (verticalLength * (i/4.0f))+50));
            }
            g.drawString("0.0",50 ,getHeight() - 50);
        } else if (queryNumber == 4) { //age vs gpa

            //attempted on y, passed on x
            yMaxM = Main.pointsM.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinM = Main.pointsM.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMaxF = Main.pointsF.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinF = Main.pointsF.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMax = Math.max(yMaxM, yMaxF);
            yMin = Math.min(yMinM, yMinF);
            xMax = Math.max(xMaxM, xMaxF);
            xMin = Math.min(xMinM, xMinF);

            if (showGender) {

                g.setColor(BLUE);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                g.setColor(PINK);
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            } else {

                g.setColor(BLACK);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            }

            //printing x axis labels
            g.setColor(BLACK);
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50);
            }
            g.drawString("0.0",50 ,getHeight() - 50);

            //printing y axis labels
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*yMax), 15,(int) (verticalLength - (verticalLength * (i/4.0f))+50));
            }
            g.drawString("0.0",50 ,getHeight() - 50);
        } else if (queryNumber == 5) { //passed vs age

            //attempted on y, passed on x
            yMaxM = Main.pointsM.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinM = Main.pointsM.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinM = Main.pointsM.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMaxF = Main.pointsF.values().stream().map(w -> w.y).max(Float::compareTo).orElse(0.0f);
            yMinF = Main.pointsF.values().stream().map(w -> w.y).min(Float::compareTo).orElse(0.0f);
            xMaxF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);
            xMinF = Main.pointsF.values().stream().map(w -> w.x).max(Float::compareTo).orElse(0.0f);

            yMax = Math.max(yMaxM, yMaxF);
            yMin = Math.min(yMinM, yMinF);
            xMax = Math.max(xMaxM, xMaxF);
            xMin = Math.min(xMinM, xMinF);

            if (showGender) {

                g.setColor(BLUE);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                g.setColor(PINK);
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            } else {

                g.setColor(BLACK);
                for (Point p: Main.pointsM.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
                for (Point p: Main.pointsF.values()) {

                    g.fillOval((int) (((p.x/xMax)*horizontalLength)+50), (int) (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)), getHeight()/50,getHeight()/50);
                }
            }

            //printing x axis labels
            g.setColor(BLACK);
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50);
            }
            g.drawString("0.0",50 ,getHeight() - 50);

            //printing y axis labels
            for (int i = 0; i < 5; i++) {

                g.drawString(String.valueOf((i/4.0f)*yMax), 15,(int) (verticalLength - (verticalLength * (i/4.0f))+50));
            }
            g.drawString("0.0",50 ,getHeight() - 50);
        }

        if (box != null) {

            //drawing the selection box
            Color color = new Color(103,101,196, 60);
            g.setColor(color);
            g.fillRect(box.x, box.y, box.width, box.height);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        mouseDown = new Point(x,y);
        box = new Rectangle();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

        box = null;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        box.setFrameFromDiagonal(mouseDown.x, mouseDown.y, e.getX(), e.getY());
        repaint();
    }

    public void checkCollision(int x, int y) {

        collision = false;
        for (Point p: Main.pointsM.values()) {

            float x_start = (((p.x/xMax)*horizontalLength) + 50);
            float x_end = (((p.x/xMax)*horizontalLength) + 50) + (getHeight()/50);
            float y_start = (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength));
            float y_end = (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)) + (getHeight()/50);

            if (x >= x_start  && x <= x_end ) {

                if (y >= y_start && y <= y_end) {

                    collision = true;
                    collisionX = p.x;
                    collisionY = p.y;
                }
            }
        }

        for (Point p: Main.pointsF.values()) {

            float x_start = (((p.x/xMax)*horizontalLength) + 50);
            float x_end = (((p.x/xMax)*horizontalLength) + 50) + (getHeight()/50);
            float y_start = (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength));
            float y_end = (getHeight() - 75 - (getHeight()/50) - ((p.y/yMax)*verticalLength)) + (getHeight()/50);

            if (x >= x_start  && x <= x_end ) {

                if (y >= y_start && y <= y_end) {

                    collision = true;
                    collisionX = p.x;
                    collisionY = p.y;
                }
            }
        }
    }

    //adding tool tips to each point
    @Override
    public void mouseMoved(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        checkCollision(x, y);

        if (collision) {

            if (queryNumber == 1) {

                setToolTipText("Credits attempted: " + collisionX + " Credits passed: " + collisionY);
            } else if (queryNumber == 2) {

                setToolTipText("Credits attempted: " + collisionX + " GPA: " + collisionY);
            } else if (queryNumber == 3) {

                setToolTipText("Credits passed: " + collisionX + " GPA: " + collisionY);
            } else if (queryNumber == 4) {

                setToolTipText("Age: " + collisionX + " GPA: " + collisionY);
            } else if (queryNumber == 5) {

                setToolTipText("Credits passed: " + collisionX + " Age: " + collisionY);
            }
        } else {

            setToolTipText(null);
        }
    }
}


