package com.template.ge.handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.template.ge.Game;
import com.template.util.Log;

public class InputHandler implements KeyListener, MouseListener {
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key draw = new Key();
	public Key escape = new Key();
	
	public int x;
	public int y;
	public static float mouseRatioX;
	public static float mouseRatioY;
	
	public InputHandler(Game game) {
		game.addKeyListener(this);
		game.addMouseListener(this);
		Log.out("Listening");
	}
	
	public class Key {
		private int numTimesPressed = 0;
		private boolean pressed = false;
		
		public int getNumTimesPressed() {
			return numTimesPressed;
		}
		
		public boolean isPressed() {
			return pressed;
		}
		public void toggle(boolean isPressed) {
			pressed = isPressed;
			if(isPressed) {
				numTimesPressed++;
			}
		}
	}
	
	public void keyPressed(KeyEvent event) {
		toggleKey(event.getKeyCode(), true);
	}
	
	public void keyReleased(KeyEvent event) {
		toggleKey(event.getKeyCode(), false);
	}
	
	public void keyTyped(KeyEvent event) {
		//null
	}
	
	public void mouseClicked(MouseEvent event) {
		x = event.getX();
		y = event.getY();
		mouseRatioX = (float) x / (float) Game.screenWidth;
		mouseRatioY = (float) y / (float) Game.screenHeight;
		
		toggleKey(event.getButton(), true);
	}
	
	public void mouseEntered(MouseEvent event) {
	}

	public void mouseExited(MouseEvent event) {
	}

	public void mousePressed(MouseEvent event) {
	}

	public void mouseReleased(MouseEvent event) {
	}
	
	public void toggleKey(int keyCode, boolean isPressed) {
		if(keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			up.toggle(isPressed);
		}
		if(keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			down.toggle(isPressed);
		}
		if(keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
			left.toggle(isPressed);
		}
		if(keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
			right.toggle(isPressed);
		}
		if(keyCode == MouseEvent.BUTTON1) {
			draw.toggle(isPressed);
		}
	}
}
