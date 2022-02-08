import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.text.DecimalFormat;
import java.awt.geom.Line2D;

public class Vis extends JPanel implements ActionListener {

    public static int queryNumber;
    public int bins;
    public float yMaxM; public float yMinM; public float xMaxM; public float xMinM;
    public float yMaxF; public float yMinF; public float xMaxF; public float xMinF;
    public float yMax; public float yMin; public float xMax; public float xMin;

    public Vis() {

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
        } else if (queryNumber == 2) { //attempted vs gpa


            System.out.println("a");
        } else if (queryNumber == 3) { //passed vs gpa

            System.out.println("a");
        } else if (queryNumber == 4) { //age vs gpa

            System.out.println("a");
        } else if (queryNumber == 5) { //passed vs age

            System.out.println("a");
        }
    }
}

