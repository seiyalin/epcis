package org.fudan.wuxi.syfw.model.feed;

public class FeedEmp {
	private String name;
	private String age;
	private String  healthState;
	public FeedEmp(String name, String age, String healthState) {
		super();
		this.name = name;
		this.age = age;
		this.healthState = healthState;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHealthState() {
		return healthState;
	}
	public void setHealthState(String healthState) {
		this.healthState = healthState;
	}
	@Override
	public String toString() {
		return "FeedEmp [name=" + name + ", age=" + age + ", healthState="
				+ healthState + "]";
	}
	
}