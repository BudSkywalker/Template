package com.template.ge.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.template.ge.Game;
import com.template.ge.levels.Tile;
import com.template.util.Config;
import com.template.util.Log;

public class Render extends Game {
	private static final long serialVersionUID = 1L;
	
	public static int tileX = (int) ((-1) * frame.getWidth() * 0.3);
	
	public void render(Graphics graphics, BufferStrategy bufferStrategy) {
		fps(graphics);
		graphics.dispose();
		bufferStrategy.show();
	}
	
	private void fps(Graphics graphics) {
		if(Config.get("showfps").equals("true")) {
			graphics.setFont(new Font("Century Gothic", 0, screenHeight / 50));
			graphics.drawString("FPS: " + Game.fps, screenWidth - (screenWidth / 50) - (screenWidth / 50), screenHeight);
		} else if(Config.get("showfps").equals("false")) {
		} else {
			Log.warning("Unknow argument " + Config.get("showfps") + " in config.properties. Must be true or false");
		}
	}
	
	private void renderTile(Graphics graphics, Tile tile, int x, int y) {
		graphics.drawImage(SpriteSheet.getSprite(Tile.getTilePosX(tile), Tile.getTilePosY(tile)), 
				(WIDTH * x - Screen.xOffset), 
				HEIGHT * y - Screen.yOffset, WIDTH, HEIGHT, null);
	}
}
