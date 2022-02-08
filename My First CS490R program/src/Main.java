import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Hashtable;

public class Main extends JFrame {

    private final Vis contents;
    public static Hashtable<Integer, Point> pointsF = new Hashtable<>();
    public static Hashtable<Integer, Point> pointsM = new Hashtable<>();

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,400);
        contents = new Vis();
        setContentPane(contents);
        setTitle("Scatterplot");
        var abigail = createMenu();
        setJMenuBar(abigail);
        setVisible(true);
    }

    private JMenuBar createMenu() {

        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("Query");
        JMenu plot = new JMenu("Plot");

        JMenuItem attemptedVsPassed = new JMenuItem("Credits attempted vs. Credits passed"); //queries done :)
        attemptedVsPassed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Just clicked option 1");
                Vis.queryNumber = 1;
                try {

                    Connection conn = DriverManager.getConnection("jdbc:derby:/home/abigail/database/pollster");
                    Statement stmt = conn.createStatement();

                    //get number of credits passed
                    ResultSet countF = stmt.executeQuery("SELECT credits_attempted, credits_passed FROM cis2012 WHERE gender = 'F'");
                    int i = 0;
                    while (countF.next()) {

                        // add row to hashtable
                        pointsF.put(i, new Point(countF.getFloat(1),countF.getFloat(2)));
                        i++;
                    }

                    ResultSet countM = stmt.executeQuery("SELECT credits_attempted, credits_passed FROM cis2012 WHERE gender = 'M'");
                    int j = 0;
                    while (countM.next()) {

                        // add row to hashtable
                        pointsM.put(j, new Point(countM.getFloat(1),countM.getFloat(2)));
                        j++;
                    }

                    contents.repaint();
                    conn.close();
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        });

        JMenuItem attemptedVsGpa = new JMenuItem("Credits attempted vs. GPA"); //queries done :)
        attemptedVsGpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Just clicked option 2");
                Vis.queryNumber = 2;
                try {

                    Connection conn = DriverManager.getConnection("jdbc:derby:/home/abigail/database/pollster");
                    Statement stmt = conn.createStatement();

                    //get number of credits passed
                    ResultSet countF = stmt.executeQuery("SELECT credits_attempted, gpa FROM cis2012 WHERE gender = 'F'");
                    int i = 0;
                    while (countF.next()) {

                        // add row to hashtable
                        pointsF.put(i, new Point(countF.getFloat(1),countF.getFloat(2)));
                        i++;
                    }

                    ResultSet countM = stmt.executeQuery("SELECT credits_attempted, gpa FROM cis2012 WHERE gender = 'M'");
                    int j = 0;
                    while (countM.next()) {

                        // add row to hashtable
                        pointsM.put(j, new Point(countM.getFloat(1),countM.getFloat(2)));
                        j++;
                    }

                    contents.repaint();
                    conn.close();
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        });

        JMenuItem passedVsGpa = new JMenuItem("Credits passed vs. GPA"); //queries done :)
        passedVsGpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Just clicked option 3");
                Vis.queryNumber = 3;
                try {

                    Connection conn = DriverManager.getConnection("jdbc:derby:/home/abigail/database/pollster");
                    Statement stmt = conn.createStatement();

                    //get number of credits passed
                    ResultSet countF = stmt.executeQuery("SELECT credits_passed, gpa FROM cis2012 WHERE gender = 'F'");
                    int i = 0;
                    while (countF.next()) {

                        // add row to hashtable
                        pointsF.put(i, new Point(countF.getFloat(1),countF.getFloat(2)));
                        i++;
                    }

                    ResultSet countM = stmt.executeQuery("SELECT credits_passed, gpa FROM cis2012 WHERE gender = 'M'");
                    int j = 0;
                    while (countM.next()) {

                        // add row to hashtable
                        pointsM.put(j, new Point(countM.getFloat(1),countM.getFloat(2)));
                        j++;
                    }

                    contents.repaint();
                    conn.close();
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        });

        JMenuItem ageVsGpa = new JMenuItem("Age vs. GPA");
        ageVsGpa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Just clicked option 4");
                Vis.queryNumber = 4;
                try {

                    Connection conn = DriverManager.getConnection("jdbc:derby:/home/abigail/database/pollster");
                    Statement stmt = conn.createStatement();

                    //get number of credits passed
                    ResultSet countF = stmt.executeQuery("SELECT age, gpa FROM cis2012 WHERE gender = 'F'");
                    int i = 0;
                    while (countF.next()) {

                        // add row to hashtable
                        pointsF.put(i, new Point(countF.getFloat(1),countF.getFloat(2)));
                        i++;
                    }

                    ResultSet countM = stmt.executeQuery("SELECT age, gpa FROM cis2012 WHERE gender = 'M'");
                    int j = 0;
                    while (countM.next()) {

                        // add row to hashtable
                        pointsM.put(j, new Point(countM.getFloat(1),countM.getFloat(2)));
                        j++;
                    }

                    contents.repaint();
                    conn.close();
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        });

        JMenuItem passedVsAge = new JMenuItem("Credits passed vs. Age"); //queries done :)
        passedVsAge.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Just clicked option 5");
                Vis.queryNumber = 5;
                try {

                    Connection conn = DriverManager.getConnection("jdbc:derby:/home/abigail/database/pollster");
                    Statement stmt = conn.createStatement();

                    //get number of credits passed
                    ResultSet countF = stmt.executeQuery("SELECT credits_passed, age FROM cis2012 WHERE gender = 'F'");
                    int i = 0;
                    while (countF.next()) {

                        // add row to hashtable
                        pointsF.put(i, new Point(countF.getFloat(1),countF.getFloat(2)));
                        i++;
                    }

                    ResultSet countM = stmt.executeQuery("SELECT credits_passed, age FROM cis2012 WHERE gender = 'M'");
                    int j = 0;
                    while (countM.next()) {

                        // add row to hashtable
                        pointsM.put(j, new Point(countM.getFloat(1),countM.getFloat(2)));
                        j++;
                    }

                    contents.repaint();
                    conn.close();
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        });

        JMenuItem reset = new JMenuItem("Reset");
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Connection conn = DriverManager.getConnection("jdbc:derby:/home/abigail/database/pollster");
                    Statement stmt = conn.createStatement();
                    //TODO reset bounds here

                    contents.repaint();
                    conn.close();
                } catch (SQLException throwables) {

                    throwables.printStackTrace();
                }
            }
        });

        JMenuItem gender = new JMenuItem("Gender");
        gender.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Vis.showGender = !Vis.showGender;

                contents.repaint();
            }
        });

        //adding questions to the menu bar
        file.add(attemptedVsPassed);
        file.add(attemptedVsGpa);
        file.add(passedVsGpa);
        file.add(ageVsGpa);
        file.add(passedVsAge);
        mb.add(file);

        plot.add(reset);
        plot.add(gender);
        mb.add(plot);

        return mb;
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(Main::new);
    }
}
