package com.template.ge.levels;

import com.template.util.Log;

public class Tile {
	
	public static final Tile[] tiles = new Tile[1024];
	public static final Tile TILE = new Tile(0, 0, 0, 0);
	
    protected byte id;
    protected byte x;
    protected byte y;
    protected int color;
    
    public Tile(int id, int x, int y, int color) {
        this.id = (byte) id;
        this.x = (byte) x;
        this.y = (byte) y;
        this.color = color;
        
        if (tiles[id] != null){
        	Log.warning(id + " is already a tile name. Please try again.");
        }
        tiles[id] = this;
        
        Log.out("New tile created with id " + id + " at position " + x + ", " + y);
    }
    
    public static int getID(Tile tile) {
    	return tile.id;
    }
    
    public static int getTilePosX(Tile tile) {
    	return tile.x;
    }
    
    public static int getTilePosY(Tile tile) {
    	return tile.y;
    }
    
    public static int getMapColor(Tile tile) {
    	return tile.color;
    }
    
    public static int getIDByColor(int color) {
    	for(int i = 0; i < Tile.tiles.length; i++) {
    		if(color == Tile.tiles[i].color) {
    			return Tile.tiles[i].id;
    		}
    	}
    	return -1;
    }
    
    public static Tile getTileByColor(int color) {
    	for(int i = 0; i < Tile.tiles.length; i++) {
    		if(color == Tile.tiles[i].color) {
    			return Tile.tiles[i];
    		}
    	}
    	return null;
    }
}
