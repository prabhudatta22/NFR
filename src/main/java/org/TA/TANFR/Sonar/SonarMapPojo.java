/**
 * 
 */
package org.TA.TANFR.Sonar;

/**
 * @author prabhudatta.choudhur
 *
 */
public class SonarMapPojo {

	
	private String severity;
	private String component;
	private String lineNo;
	private String violation_details;
	private String author;
	private String type;
	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	/**
	 * @return the component
	 */
	public String getComponent() {
		return component;
	}
	/**
	 * @param component the component to set
	 */
	public void setComponent(String component) {
		this.component = component;
	}
	/**
	 * @return the lineNo
	 */
	public String getLineNo() {
		return lineNo;
	}
	/**
	 * @param lineNo the lineNo to set
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	/**
	 * @return the violation_details
	 */
	public String getViolation_details() {
		return violation_details;
	}
	/**
	 * @param violation_details the violation_details to set
	 */
	public void setViolation_details(String violation_details) {
		this.violation_details = violation_details;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
