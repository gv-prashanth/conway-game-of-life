package com.vadrin.conwaygameoflife.models;

public class Cell {

	private boolean alive;

	public boolean isAlive() {
		return alive;
	}

	public void markAlive () {
		this.alive = true;
	}
	
	public void markDead () {
		this.alive = false;
	}

	public Cell() {
		super();
		this.alive = false;
	}
	
}
