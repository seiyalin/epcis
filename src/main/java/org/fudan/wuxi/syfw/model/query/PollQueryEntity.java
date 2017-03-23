package org.fudan.wuxi.syfw.model.query;

import org.oliot.model.epcis.QueryParams;


public class PollQueryEntity {
	private String queryName;
	private QueryParams params;
	
	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public QueryParams getParams() {
		return params;
	}

	public void setParams(QueryParams params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "PollQueryEntity [queryName=" + queryName + ", params=" + params
				+ "]";
	}
}

