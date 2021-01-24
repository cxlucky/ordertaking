package com.muldini.virus.common;

import java.io.Serializable;

public class ChinaTotal  implements Serializable {

	private static final long serialVersionUID = -46465144643689744L;
	 private int id;
	 private String confirm;
	 private String heal;
	 private String dead;
	 private String nowConfirm;
	 private String suspect;
	 private String nowSevere;
	 private String importedCase;
	 private String noInfect;
	 private String showLocalConfirm;
	 private String showlocalinfeciton;
	 private String localConfirm;
	 private String noInfectH5;
	 private String localConfirmH5;
	 private String lastupdatetime;
	 
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(String lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getHeal() {
		return heal;
	}
	public void setHeal(String heal) {
		this.heal = heal;
	}
	public String getDead() {
		return dead;
	}
	public void setDead(String dead) {
		this.dead = dead;
	}
	public String getNowConfirm() {
		return nowConfirm;
	}
	public void setNowConfirm(String nowConfirm) {
		this.nowConfirm = nowConfirm;
	}
	public String getSuspect() {
		return suspect;
	}
	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}
	public String getNowSevere() {
		return nowSevere;
	}
	public void setNowSevere(String nowSevere) {
		this.nowSevere = nowSevere;
	}
	public String getImportedCase() {
		return importedCase;
	}
	public void setImportedCase(String importedCase) {
		this.importedCase = importedCase;
	}
	public String getNoInfect() {
		return noInfect;
	}
	public void setNoInfect(String noInfect) {
		this.noInfect = noInfect;
	}
	public String getShowLocalConfirm() {
		return showLocalConfirm;
	}
	public void setShowLocalConfirm(String showLocalConfirm) {
		this.showLocalConfirm = showLocalConfirm;
	}
	public String getShowlocalinfeciton() {
		return showlocalinfeciton;
	}
	public void setShowlocalinfeciton(String showlocalinfeciton) {
		this.showlocalinfeciton = showlocalinfeciton;
	}
	public String getLocalConfirm() {
		return localConfirm;
	}
	public void setLocalConfirm(String localConfirm) {
		this.localConfirm = localConfirm;
	}
	public String getNoInfectH5() {
		return noInfectH5;
	}
	public void setNoInfectH5(String noInfectH5) {
		this.noInfectH5 = noInfectH5;
	}
	public String getLocalConfirmH5() {
		return localConfirmH5;
	}
	public void setLocalConfirmH5(String localConfirmH5) {
		this.localConfirmH5 = localConfirmH5;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	 @Override
	public String toString() {
		return "ChinaTotal [id=" + id + ", confirm=" + confirm + ", heal=" + heal + ", dead=" + dead + ", nowConfirm="
				+ nowConfirm + ", suspect=" + suspect + ", nowSevere=" + nowSevere + ", importedCase=" + importedCase
				+ ", noInfect=" + noInfect + ", showLocalConfirm=" + showLocalConfirm + ", showlocalinfeciton="
				+ showlocalinfeciton + ", localConfirm=" + localConfirm + ", noInfectH5=" + noInfectH5
				+ ", localConfirmH5=" + localConfirmH5 + "]";
	}
}
