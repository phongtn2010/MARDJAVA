package com.nsw.monre.p01.model.base;




public abstract class TbdThongTinCoSoSX1BaseModel {

	private boolean canUpdate;

	public boolean isCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(boolean canUpdate) {
		this.canUpdate = canUpdate;
	}
	
	private boolean canDelete;

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
	

}