package org.fudan.wuxi.syfw.model.hibentity;

/**
 * WarehouseId entity. @author MyEclipse Persistence Tools
 */

public class WarehouseId implements java.io.Serializable {

	// Fields

	private String marId;
	private String id;

	// Constructors

	/** default constructor */
	public WarehouseId() {
	}

	/** full constructor */
	public WarehouseId(String marId, String id) {
		this.marId = marId;
		this.id = id;
	}

	// Property accessors

	public String getMarId() {
		return this.marId;
	}

	public void setMarId(String marId) {
		this.marId = marId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WarehouseId))
			return false;
		WarehouseId castOther = (WarehouseId) other;

		return ((this.getMarId() == castOther.getMarId()) || (this.getMarId() != null
				&& castOther.getMarId() != null && this.getMarId().equals(
				castOther.getMarId())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMarId() == null ? 0 : this.getMarId().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		return result;
	}

}