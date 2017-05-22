package com.template.ge;

import com.template.ge.gfx.Screen;
import com.template.ge.levels.LevelSaves;

public class Tick extends Game {
	private static final long serialVersionUID = 1L;
	
	public Tick() {
	}
	
	public void tick() {
		tickCount++;
	}
	
	public void inputTick() {
		if(inputHandler.up.isPressed() && Screen.yOffset > 0) {
			Screen.yOffset--;
		}
		if(inputHandler.down.isPressed() && Screen.yOffset < HEIGHT * LevelSaves.height - screenHeight) {
			Screen.yOffset++;
		}
		if(inputHandler.left.isPressed() && Screen.xOffset + (9 * (screenWidth / WIDTH)) > 0 ) {
			Screen.xOffset--;
		}
		if(inputHandler.right.isPressed() && Screen.xOffset < WIDTH * LevelSaves.width - screenWidth) {
			Screen.xOffset++;
		}
	}
}
