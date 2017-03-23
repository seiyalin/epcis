package org.fudan.wuxi.syfw.model.hibentity;

/**
 * AquaticContainerId entity. @author MyEclipse Persistence Tools
 */

public class AquaticContainerId implements java.io.Serializable {

	// Fields

	private String id;
	private String conId;

	// Constructors

	/** default constructor */
	public AquaticContainerId() {
	}

	/** full constructor */
	public AquaticContainerId(String id, String conId) {
		this.id = id;
		this.conId = conId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConId() {
		return this.conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AquaticContainerId))
			return false;
		AquaticContainerId castOther = (AquaticContainerId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getConId() == castOther.getConId()) || (this
						.getConId() != null && castOther.getConId() != null && this
						.getConId().equals(castOther.getConId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getConId() == null ? 0 : this.getConId().hashCode());
		return result;
	}

}