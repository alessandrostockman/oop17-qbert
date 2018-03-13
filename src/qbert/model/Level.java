package qbert.model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import qbert.model.utilities.Position2D;
import qbert.view.CharacterGraphicComponent;
import qbert.view.CharacterGraphicComponentImpl;

public class Level {

    private Map<Integer, Map<Integer, Tile>> tiles;
    private List<Character> gameCharacters;
    private int mapHeight = 7;
    private int points = 0;
    private BufferedImage background;

    private int level;
    private int round;

    public Level() {
        this.createLevelTiles();
        this.importBackground();
        this.level = 5;
        this.round = 2;
        this.gameCharacters = new ArrayList<>();
    }

    public Tile getTile(final int x, final int y) {
        return tiles.get(x).get(y);
    }

    public BufferedImage getBackground() {
        return this.background;
    }

    private void createLevelTiles() {
        tiles = new HashMap<>();

        //TODO: Utilizzare un metodo di creazione dei tile migliore
        for (int i = 1; i <= this.mapHeight; i++) {
            Map<Integer, Tile> tmpMap = new HashMap<>();
            for (int j = 1; j <= this.mapHeight; j++) {
                if (j <= i) {
                    tmpMap.put(j, new Tile(j, i));
                }
                tiles.put(i, tmpMap);
            }
        }
    }

    private void importBackground() {
        final URL mapSpriteUrl = this.getClass().getResource("/background.png");
        try {
            this.background = ImageIO.read(mapSpriteUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Move in specific class and refactor
    private BufferedImage tempLoader(String path) {
        BufferedImage res = null;
        final URL spriteUrl = this.getClass().getResource(path);
        try {
            res = ImageIO.read(spriteUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Character> getEntities() {
        return this.gameCharacters;
    }

    public List<Tile> getTiles() {
        return this.tiles
                .entrySet()
                .stream()
                .flatMap((Map.Entry<Integer, Map<Integer, Tile>> me) -> me.getValue()
                        .entrySet()
                        .stream()
                        .map(Map.Entry::getValue))
                .collect(Collectors.toList());
    }

    public void spawn(Character entity) {
        this.gameCharacters.add(entity);
    }

    public int getRound() {
        return ((this.level - 1) * 3) + this.round;
    }

    public int getPoints() {
        return this.points;
    }
}
