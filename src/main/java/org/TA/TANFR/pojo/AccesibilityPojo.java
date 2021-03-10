/**
 * 
 */
package org.TA.TANFR.pojo;

import java.util.List;

/**
 * @author Prabhudatta.C
 *
 */
public class AccesibilityPojo {

	private String url;
	private int error_count;
	private int warning_count;
	private List<CodeSniffer> allCodeSnifferDetails;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getError_count() {
		return error_count;
	}

	public void setError_count(int error_count) {
		this.error_count = error_count;
	}

	public int getWarning_count() {
		return warning_count;
	}

	public void setWarning_count(int warning_count) {
		this.warning_count = warning_count;
	}

	public List<CodeSniffer> getAllCodeSnifferDetails() {
		return allCodeSnifferDetails;
	}

	public void setAllCodeSnifferDetails(List<CodeSniffer> allCodeSnifferDetails) {
		this.allCodeSnifferDetails = allCodeSnifferDetails;
	}
}
