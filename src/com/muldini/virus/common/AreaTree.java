package com.muldini.virus.common;

import java.io.Serializable;

public class AreaTree  implements Serializable {

	private static final long serialVersionUID = -46465144643689744L;
	private int id;
	private String name;
	private String count_confirm;
	private String count_confirmcuts;
	private String count_wzz_add;
	private String confirm;
	private String dead;
	private String heal;
	private String wzz;
	private String suspect;
	private String nowconfirm;
	private String showheal;
	private String showrate;
	private String lastupdatetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCount_confirm() {
		return count_confirm;
	}
	public void setCount_confirm(String count_confirm) {
		this.count_confirm = count_confirm;
	}
	public String getCount_confirmcuts() {
		return count_confirmcuts;
	}
	public void setCount_confirmcuts(String count_confirmcuts) {
		this.count_confirmcuts = count_confirmcuts;
	}
	public String getCount_wzz_add() {
		return count_wzz_add;
	}
	public void setCount_wzz_add(String count_wzz_add) {
		this.count_wzz_add = count_wzz_add;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getDead() {
		return dead;
	}
	public void setDead(String dead) {
		this.dead = dead;
	}
	public String getHeal() {
		return heal;
	}
	public void setHeal(String heal) {
		this.heal = heal;
	}
	public String getWzz() {
		return wzz;
	}
	public void setWzz(String wzz) {
		this.wzz = wzz;
	}
	public String getSuspect() {
		return suspect;
	}
	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}
	public String getNowconfirm() {
		return nowconfirm;
	}
	public void setNowconfirm(String nowconfirm) {
		this.nowconfirm = nowconfirm;
	}
	public String getShowheal() {
		return showheal;
	}
	public void setShowheal(String showheal) {
		this.showheal = showheal;
	}
	public String getShowrate() {
		return showrate;
	}
	public void setShowrate(String showrate) {
		this.showrate = showrate;
	}
	public String getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(String lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AreaTree [id=" + id + ", name=" + name + ", count_confirm=" + count_confirm + ", count_confirmcuts="
				+ count_confirmcuts + ", count_wzz_add=" + count_wzz_add + ", confirm=" + confirm + ", dead=" + dead
				+ ", heal=" + heal + ", wzz=" + wzz + ", suspect=" + suspect + ", nowconfirm=" + nowconfirm
				+ ", showheal=" + showheal + ", showrate=" + showrate + ", lastupdatetime=" + lastupdatetime + "]";
	}
	
	
	
}
