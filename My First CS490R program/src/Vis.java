import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.text.DecimalFormat;
import java.awt.geom.Line2D;

import static java.awt.Color.*;

public class Vis extends JPanel implements ActionListener {

    public static int queryNumber;
    public float yMaxM; public float yMinM; public float xMaxM; public float xMinM;
    public float yMaxF; public float yMinF; public float xMaxF; public float xMinF;
    public float yMax; public float yMin; public float xMax; public float xMin;
    public static boolean showGender;

    public Vis() {
        showGender = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawLine(50,40,50,getHeight() - 75); //draw vertical axis
        g.drawLine(50,getHeight() - 75, getWidth() - 50,getHeight() - 75); //draw horizontal axis

        float verticalLength = (getHeight() - 75) - 40;
        float horizontalLength = (getWidth() - 50) - 50;

        DecimalFormat df = new DecimalFormat("###.##");

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

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50); //max 162 - why does it say infinity????????????????
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

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50); //max 162 - why does it say infinity????????????????
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

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50); //max 162 - why does it say infinity????????????????
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

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50); //max 162 - why does it say infinity????????????????
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

                g.drawString(String.valueOf((i/4.0f)*xMax), (int) ((horizontalLength * (i/4.0f))+50),getHeight() - 50); //max 162 - why does it say infinity????????????????
            }
            g.drawString("0.0",50 ,getHeight() - 50);
        }
    }
}

