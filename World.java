import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class World extends JPanel {
    private List<Isotope> isotopes;
    private Move move;

    public World(List<Isotope> isotopes) {
        this.isotopes = isotopes;

        setPreferredSize(new Dimension(1000, 990));
        setBackground(Color.BLACK);
    }

    public void setMove(Move move) {
        this.move = move;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (move == null) return;

        Map<Isotope, List<Point>> positions = move.getPositions();

        for (Map.Entry<Isotope, List<Point>> entry : positions.entrySet()) {
            Isotope isotope = entry.getKey();
            List<Point> points = entry.getValue();

            g.setColor(new Color(
                    (isotope.getAtomicNumber() * 20) % 256,
                    (isotope.getNeutrons() * 15) % 256,
                    (isotope.getProtons() * 10) % 256
            ));

            for (Point p : points) {
                g.fillOval(p.x, p.y, 5, 5);
            }
        }
    }
    
    public static void main(String[] args) {
        List<Isotope> isotopes = IsotopeData.getAllIsotopes();

        JFrame frame = new JFrame("Isotope World");
        World world = new World(isotopes);

        frame.add(world);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Move move = new Move(isotopes, world.getWidth(), world.getHeight());
        world.setMove(move);

        new Timer(1, e -> {
            move.updatePositions();
            world.repaint();
        }).start();
    }
}