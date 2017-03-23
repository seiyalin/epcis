package org.fudan.wuxi.syfw.model.base;

import java.io.Serializable;

public abstract class UuidEntity implements Serializable {

	private static final long serialVersionUID = 1L;
    
	public String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
