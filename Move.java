import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Move {
    private Map<Isotope, List<Point>> positions;
    private int worldWidth;
    private int worldHeight;
    private Random random;

    public Move(List<Isotope> isotopes, int worldWidth, int worldHeight) {
    this.worldWidth = worldWidth;
    this.worldHeight = worldHeight;
    this.random = new Random();
    this.positions = new HashMap<>();

    for (Isotope isotope : isotopes) {
        List<Point> isoPositions = new java.util.ArrayList<>();

        int count = Math.max(1, (int) Math.ceil(isotope.getNaturalAbundance()));

        for (int i = 0; i < count; i++) {
            int x = random.nextInt(worldWidth);
            int y = random.nextInt(worldHeight);
            isoPositions.add(new Point(x, y));
        }

        positions.put(isotope, isoPositions);
    }
}

    public void updatePositions() {
        for (Map.Entry<Isotope, List<Point>> entry : positions.entrySet()) {
            List<Point> isoPositions = entry.getValue();
            for (int i = 0; i < isoPositions.size(); i++) {
                Point p = isoPositions.get(i);
                int dx = random.nextInt(3) - 1; // -1, 0, or 1
                int dy = random.nextInt(3) - 1; // -1, 0, or 1
                int newX = Math.min(Math.max(p.x + dx, 0), worldWidth - 1);
                int newY = Math.min(Math.max(p.y + dy, 0), worldHeight - 1);
                isoPositions.set(i, new Point(newX, newY));
            }
        }
    }

    public Map<Isotope, List<Point>> getPositions() {
        return positions;
    }
}
