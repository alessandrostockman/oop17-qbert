package qbert.model;

import java.awt.image.BufferedImage;
import java.util.Map;

public class LevelSettings {
    private int colorNumber;
    private boolean colorReversable;
    private BufferedImage backgroundImage;
    private Map<Integer, BufferedImage> colorMap;

    public LevelSettings(int number, boolean reverse, BufferedImage background, Map<Integer, BufferedImage> colorMap) {
        this.colorNumber = number;
        this.colorReversable = reverse;
        this.backgroundImage = background;
        this.colorMap = colorMap;
    }
    
    public int getColorNumber() {
        return this.colorNumber;
    }

    public boolean getColorReversable() {
        return this.colorReversable;
    }

    public BufferedImage getBackgroundImage() {
        return this.backgroundImage;
    }
     
    public Map<Integer, BufferedImage> getColorMap() {
        return this.colorMap;
    }
}
