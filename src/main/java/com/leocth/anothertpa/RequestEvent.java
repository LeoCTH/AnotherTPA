package com.leocth.anothertpa;

import java.util.Timer;
import java.util.TimerTask;
/*
 * Do not criticize my code, I'm a newcomer /Slap-on-my-face/
 *  
 * File: AnotherTPA/com.leocth.anothertpa.RequestEvent
 * Desc.: The TP Request. Hooray!
 * ------------------------------------------------------
 * Don't steal PLZ!!!
 */
/**
 * TP Request. The class name is not important
 * @author LeoC200
 *
 */
public class RequestEvent {
	public Player sender, target;
	
	public RequestEvent(Player p1, Player p2) {
		sender = p1;
		target = p2;
		
	}
	public void accept() {
		sender.sendMessage(I18n.g("accepted", target.getName()));
		target.sendMessage(I18n.g("accept-after-info"));
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				sender.getNestedPlayer().teleport(target.getNestedPlayer());
				target.event = null;
				target.cooldown = AnotherTPA.cooldown;//TODO Not fully implemented
				this.cancel();
			}
		}, 3000);
	}
	public void deny() {
		sender.sendMessage(I18n.g("denied", target.getName()));
		target.sendMessage(I18n.g("deny-after-info"));
		target.event = null;
	}
}
