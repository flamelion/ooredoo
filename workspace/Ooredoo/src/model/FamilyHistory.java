package model;

import javafx.scene.control.TableColumn;

public class FamilyHistory {
	

	private String fathername="";
	private String mothername="";
	private String father_job="";
	private String mother_job="";
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getFather_job() {
		return father_job;
	}
	public void setFather_job(String father_job) {
		this.father_job = father_job;
	}
	public String getMother_job() {
		return mother_job;
	}
	public void setMother_job(String mother_job) {
		this.mother_job = mother_job;
	}
	
}
