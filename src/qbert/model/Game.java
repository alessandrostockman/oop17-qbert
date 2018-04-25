package qbert.model;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import qbert.model.utilities.Position2D;
import qbert.model.Sprites;

public class Game {

    private Toolkit t; 
    private Dimension d;
    
    private Level gameLevel;
   
    public Game() {
        
        t = Toolkit.getDefaultToolkit();
        d = t.getScreenSize();
         
        try {
          for(File file: new File("res/png/").listFiles()) {
              if(!file.isDirectory()) {
                  file.delete();
              }
          }
          
          convertSvgToPng("res/svg/BackgroundBlue.svg","res/png/BackgroundBlue.png"); 
          convertSvgToPng("res/svg/BackgroundBrown.svg","res/png/BackgroundBrown.png"); 
          convertSvgToPng("res/svg/BackgroundGreen.svg","res/png/BackgroundGreen.png"); 
          convertSvgToPng("res/svg/BackgroundGrey.svg","res/png/BackgroundGrey.png"); 
          convertSvgToPng("res/svg/CoilyBackMove.svg","res/png/CoilyBackMove.png"); 
          convertSvgToPng("res/svg/CoilyBackStand.svg","res/png/CoilyBackStand.png"); 
          convertSvgToPng("res/svg/CoilyFrontMove.svg","res/png/CoilyFrontMove.png"); 
          convertSvgToPng("res/svg/CoilyFrontStand.svg","res/png/CoilyFrontStand.png");
          convertSvgToPng("res/svg/GreenBallMove.svg","res/png/GreenBallMove.png"); 
          convertSvgToPng("res/svg/GreenBallStand.svg","res/png/GreenBallStand.png");
          convertSvgToPng("res/svg/PurpleBallMove.svg","res/png/PurpleBallMove.png"); 
          convertSvgToPng("res/svg/PurpleBallStand.svg","res/png/PurpleBallStand.png");
          convertSvgToPng("res/svg/QbertBackMove.svg","res/png/QbertBackMove.png"); 
          convertSvgToPng("res/svg/QbertBackStand.svg","res/png/QbertBackStand.png"); 
          convertSvgToPng("res/svg/QbertFrontMove.svg","res/png/QbertFrontMove.png"); 
          convertSvgToPng("res/svg/QbertFrontStand.svg","res/png/QbertFrontStand.png");
          convertSvgToPng("res/svg/RedBallMove.svg","res/png/RedBallMove.png"); 
          convertSvgToPng("res/svg/RedBallStand.svg","res/png/RedBallStand.png");
          convertSvgToPng("res/svg/TileBeige.svg","res/png/TileBeige.png");
          convertSvgToPng("res/svg/TileBlue.svg","res/png/TileBlue.png");
          convertSvgToPng("res/svg/TileGreen.svg","res/png/TileGreen.png");
          convertSvgToPng("res/svg/TileGrey.svg","res/png/TileGrey.png");
          convertSvgToPng("res/svg/TilePink.svg","res/png/TilePink.png");
          convertSvgToPng("res/svg/TilePurple.svg","res/png/TilePurple.png");
          convertSvgToPng("res/svg/TileYellow.svg","res/png/TileYellow.png");
          
          //Wait converting image
          Thread.sleep(9000);
          
          Sprites.blueBackground=loadImg("res/png/BackgroundBlue.png");  
          Sprites.brownBackground=loadImg("res/png/BackgroundBrown.png");
          Sprites.greenBackground=loadImg("res/png/BackgroundGreen.png");
          Sprites.greyBackground=loadImg("res/png/BackgroundGrey.png"); ; 
          Sprites.coilyBackMoving=loadImg("res/png/CoilyBackMove.png");; 
          Sprites.coilyBackStanding=loadImg("res/png/CoilyBackStand.png"); 
          Sprites.coilyFrontMoving=loadImg("res/png/CoilyFrontMove.png");  
          Sprites.coilyFrontStanding=loadImg("res/png/CoilyFrontStand.png");
          Sprites.GreenBallMoving=loadImg("res/png/GreenBallMove.png");
          Sprites.GreenBallStanding=loadImg("res/png/GreenBallStand.png");
          Sprites.PurpleBallMoving=loadImg("res/png/PurpleBallMove.png"); 
          Sprites.PurpleBallStanding=loadImg("res/png/PurpleBallStand.png"); 
          Sprites.qbertBackMoving=loadImg("res/png/QbertBackMove.png"); 
          Sprites.qbertBackStanding=loadImg("res/png/QbertBackStand.png");
          Sprites.qbertFrontMoving=loadImg("res/png/QbertFrontMove.png"); 
          Sprites.qbertFrontStanding=loadImg("res/png/QbertFrontStand.png");
          Sprites.RedBallMoving=loadImg("res/png/RedBallMove.png");
          Sprites.RedBallStanding=loadImg("res/png/RedBallStand.png");
          Sprites.beigeTile=loadImg("res/png/TileBeige.png");
          Sprites.blueTile=loadImg("res/png/TileBlue.png");
          Sprites.greenTile=loadImg("res/png/TileGreen.png"); 
          Sprites.greyTile=loadImg("res/png/TileGrey.png");
          Sprites.pinkTile=loadImg("res/png/TilePink.png");
          Sprites.purpleTile=loadImg("res/png/TilePurple.png");
          Sprites.yellowTile=loadImg("res/png/TileYellow.png");  
          
          //Da fare png
          Sprites.life=loadImg("res/png/TileYellow.png"); 
          
        } catch(Exception e) {
            System.out.println("Error load"+e.getMessage());
        }  

      
        Dimensions.screenHeight = d.height;
        Dimensions.screenWidth = d.width;
        Dimensions.windowHeight = Dimensions.screenHeight*3/4;
        Dimensions.windowWidth = Dimensions.screenWidth*3/4;
        Dimensions.deathHeight = Dimensions.windowHeight+200;
        Dimensions.spawningHeight = -100;
        Dimensions.spawningPointLeft = new Position2D((Dimensions.windowWidth/2)-Sprites.blueTile.getWidth(),-500);
        Dimensions.spawningPointRight = new Position2D((Dimensions.windowWidth/2),-500);
        Dimensions.spawningQBert = new Position2D((Dimensions.windowWidth/2)-Sprites.blueTile.getWidth()/2,-500);
        Dimensions.backgroundHeight = Sprites.blueBackground.getHeight();
        Dimensions.backgroundWidth = Sprites.blueBackground.getWidth();
        Dimensions.backgroundX = (Dimensions.windowWidth-Dimensions.backgroundWidth)/2;
        Dimensions.backgroundY = (Dimensions.windowHeight-Dimensions.backgroundHeight)/2;
        Dimensions.cubeHeight = Sprites.blueBackground.getHeight()/7;
        Dimensions.tileHeight = Sprites.blueTile.getHeight();
        Dimensions.tileWidth = Sprites.blueTile.getWidth();
        Dimensions.tileWidth = Sprites.blueTile.getWidth();
        
        gameLevel = new Level();
    }
    
    public Level getLevel() {
        return gameLevel;
    }
    
    public void update( float elapsed) {
        gameLevel.update(elapsed);
    }
    
    private BufferedImage loadImg(String pathOut) throws Exception{
        BufferedImage res = null;
        final URL spriteUrl = this.getClass().getResource("/png/"+pathOut.split("/")[2]);
        try {
            res = ImageIO.read(spriteUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    
    private static void convertSvgToPng(String svg, String png) throws Exception {
        
        String uriSvg = Paths.get(svg).toUri().toURL().toString();
        TranscoderInput imageSvg = new TranscoderInput(uriSvg);
        OutputStream streamPng = new FileOutputStream(png);
        TranscoderOutput outputImagePng = new TranscoderOutput(streamPng);
        PNGTranscoder converter = new PNGTranscoder();
        
        final SAXBuilder builder = new SAXBuilder();
        final Document document = builder.build(svg);

        final Element root = document.getRootElement();
        float width = Float.valueOf(root.getAttributeValue("width"));
        float height = Float.valueOf(root.getAttributeValue("height"));
        converter.addTranscodingHint(PNGTranscoder.KEY_WIDTH, new Float(1*width));
        converter.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, new Float(1*height));
        converter.addTranscodingHint(PNGTranscoder.KEY_AOI, new Rectangle( 0, 0, Math.round(width), Math.round(height)));

        converter.transcode(imageSvg, outputImagePng);
        streamPng.flush();
        streamPng.close();


        
    }

     
}
