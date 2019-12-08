package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundTrack {
	Sound sound = Gdx.audio.newSound(Gdx.files.internal("PCB - Border of Life.mp3"));
	
	public SoundTrack () {
		long id = sound.play(0.2f);
		sound.setLooping(id, true);
	}
}
