package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class DVDPlayerTest {

	@Test
	public void DrawerClosedPlayingWhenPlayBtnPushed() {
		DVDPlayer p = DVDPlayer.getInstance();
		p.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), p.getCurrentState());
	}

	@Test
	public void DrawerOpenWhenCloseOpenBtnPushedWhilePlaying() {
		DVDPlayer p = DVDPlayer.getInstance();
		p.playButtonPushed();
		p.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), p.getCurrentState());
	}

	@Test
	public void DrawerClosedNotPlayingWhenStopBtnPushedWhilePlaying() {
		DVDPlayer p = DVDPlayer.getInstance();
		p.playButtonPushed();
		p.stopButtonPushed();
		assertEquals(DrawerClosedNotPlaying.getInstance(), p.getCurrentState());
	}
    
}
