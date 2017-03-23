package org.fudan.wuxi.syfw.model.hibentity;

/**
 * AquaticContainer entity. @author MyEclipse Persistence Tools
 */

public class AquaticContainer implements java.io.Serializable {

	// Fields

	private AquaticContainerId id;
	private Aquatic aquatic;

	// Constructors

	/** default constructor */
	public AquaticContainer() {
	}

	/** full constructor */
	public AquaticContainer(AquaticContainerId id, Aquatic aquatic) {
		this.id = id;
		this.aquatic = aquatic;
	}

	// Property accessors

	public AquaticContainerId getId() {
		return this.id;
	}

	public void setId(AquaticContainerId id) {
		this.id = id;
	}

	public Aquatic getAquatic() {
		return this.aquatic;
	}

	public void setAquatic(Aquatic aquatic) {
		this.aquatic = aquatic;
	}

}