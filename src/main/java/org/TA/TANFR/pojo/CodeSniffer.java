/**
 * 
 */
package org.TA.TANFR.pojo;

/**
 * @author Prabhudatta.C
 *
 */
public class CodeSniffer {

	private String error_text;
	private String error_summary;
	private String code_snippet;
	private String suggested_tech;
	private String category;
	private String testCategoty;

	public String getError_text() {
		return error_text;
	}

	public void setError_text(String error_text) {
		this.error_text = error_text;
	}

	public String getError_summary() {
		return error_summary;
	}

	public void setError_summary(String error_summary) {
		this.error_summary = error_summary;
	}

	public String getCode_snippet() {
		return code_snippet;
	}

	public void setCode_snippet(String code_snippet) {
		this.code_snippet = code_snippet;
	}

	public String getSuggested_tech() {
		return suggested_tech;
	}

	public void setSuggested_tech(String suggested_tech) {
		this.suggested_tech = suggested_tech;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTestCategoty() {
		return testCategoty;
	}

	public void setTestCategoty(String testCategoty) {
		this.testCategoty = testCategoty;
	}

}
