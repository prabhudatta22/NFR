package org.TA.TANFR.testutils;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.TA.TANFR.accessibility.Result;
import org.TA.TANFR.pojo.AccesibilityPojo;
import org.TA.TANFR.pojo.CodeSniffer;
import org.TA.TANFR.setup.TestSetUp;
import org.apache.commons.lang3.StringUtils;

import oeg.TA.TANFR.Sonar.SonarIssues;
import oeg.TA.TANFR.Sonar.SonarMapPojo;

/**
 * @author Prabhudatta.C
 *
 */
public class HTMLUpdateReport {

	public void createHTMLReport(List<SonarMapPojo> snmp, Set<String> sortedLinks, Map<String, Object> audit_report,
			AccesibilityPojo acspojo) {

		String folderPath = System.getProperty("user.dir") + "/Reports";
		File dir = new File(folderPath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		File file = new File(dir, new SonarIssues().getDateFormat() + "_"
				+ TestSetUp.configProperty.getProperty("projectName") + "_NFR_Report.html");

		StringBuffer sbuf = new StringBuffer();
		sbuf = sbuf.append(getHeader());
		sbuf = sbuf.append(getReportPageNavigation());
		sbuf = sbuf.append(getReportSummary(acspojo, snmp, audit_report));
		sbuf = sbuf.append(getSonarViolationSummaryChart(snmp));
		sbuf = sbuf.append(getSonarViolationDetails(snmp));
		sbuf = sbuf.append(getUnitTestReportDetails());
		sbuf = sbuf.append(getRegressionTestReportDetails());
		sbuf = sbuf.append(getAccessibilityReportDetails(sortedLinks, audit_report));
		sbuf = sbuf.append(getVulnerabilitySummaryChart());
		sbuf = sbuf.append(getVulnerabilityReportDetails(acspojo));
		sbuf = sbuf.append(getFooter(acspojo, snmp));

		try {
			FileWriter archivo = new FileWriter(file);
			archivo.write(sbuf.toString());
			archivo.flush();
			archivo.close();
			sbuf = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	private StringBuffer getRegressionTestReportDetails() {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<div id=\"tab6\" class=\"tab-pane fade\">\r\n" + "          <div class=\"nav2-content\">\r\n"
				+ "            <p class=\"content-align\">\r\n" + "              Summary\r\n" + "            </p>\r\n"
				+ "          </div>\r\n" + "          <div class=\"container\">\r\n"
				+ "            <div class=\"row-width\">\r\n" + "              <div class=\"chart-content \">\r\n"
				+ "                <p class=\"content\">Result</p>\r\n"
				+ "                <span class=\"primary-dot\"></span>\r\n"
				+ "                <p class=\"pri-label\">Pass</p>\r\n"
				+ "                <span class=\"secondary-dot\"></span>\r\n"
				+ "                <p class=\"sec-label\">Fail</p>\r\n" + "			\r\n" + "              </div>\r\n"
				+ "              <div class=\"chart\">\r\n"
				+ "                <canvas id=\"dchart\" class=\"dchart-component\"></canvas>\r\n"
				+ "              </div>\r\n" + "            </div>\r\n"
				+ "          </div> <div class=\"container\">\r\n" + "            \r\n"
				+ "            <table class=\"table-width\">\r\n" + "              <thead class=\"heads\">\r\n"
				+ "                <tr>\r\n" + "                  <th class=\"head-align\">Test Case</th>\r\n"
				+ "                  <th class=\"head-space\">Result</th>\r\n"
				+ "                  <th class=\"head-space\">Exception</th>\r\n"
				+ "                  <th class=\"head-space\">Remark</th>\r\n"
				+ "                  <th class=\"align\">Line No.</th>\r\n" + "                </tr>\r\n"
				+ "              </thead>\r\n" + "              <tbody class=\"info\"><tr>\r\n"
				+ "                  <td>  <h3 style=\\\"color:Blue;\\\">Coming Soon</h3></td>\r\n"
				+ "                </tr>\r\n" + "</tbody>\r\n" + "            </table></div>\r\n" + "        </div>");
		return sbuf;
	}

	/**
	 * @return
	 */
	private StringBuffer getUnitTestReportDetails() {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<div id=\"tab5\" class=\"tab-pane fade\">\r\n" + "          <div class=\"nav2-content\">\r\n"
				+ "            <p class=\"content-align\">\r\n" + "              Summary\r\n" + "            </p>\r\n"
				+ "          </div>\r\n" + "          <div class=\"container\">\r\n"
				+ "            <div class=\"row-width\">\r\n" + "              <div class=\"chart-content \">\r\n"
				+ "                <p class=\"content\">Result</p>\r\n"
				+ "                <span class=\"primary-dot\"></span>\r\n"
				+ "                <p class=\"pri-label\">Pass</p>\r\n"
				+ "                <span class=\"secondary-dot\"></span>\r\n"
				+ "                <p class=\"sec-label\">Fail</p>\r\n" + "			\r\n" + "              </div>\r\n"
				+ "              <div class=\"chart\">\r\n"
				+ "                <canvas id=\"dchart\" class=\"dchart-component\"></canvas>\r\n"
				+ "              </div>\r\n" + "            </div>\r\n"
				+ "          </div> <div class=\"container\">\r\n" + "            \r\n"
				+ "            <table class=\"table-width\">\r\n" + "              <thead class=\"heads\">\r\n"
				+ "                <tr>\r\n" + "                  <th class=\"head-align\">Test Case</th>\r\n"
				+ "                  <th class=\"head-space\">Result</th>\r\n"
				+ "                  <th class=\"head-space\">Exception</th>\r\n"
				+ "                  <th class=\"head-space\">Remark</th>\r\n"
				+ "                  <th class=\"align\">Line No.</th>\r\n" + "                </tr>\r\n"
				+ "              </thead>\r\n" + "              <tbody class=\"info\"><tr>\r\n"
				+ "                  <td>  <h3 style=\\\"color:Blue;\\\">Coming Soon</h3></td>\r\n"
				+ "                </tr>\r\n" + "</tbody>\r\n" + "            </table></div>\r\n" + "        </div>");
		return sbuf;
	}

	/**
	 * @return
	 */
	private StringBuffer getFooter(AccesibilityPojo acspojo, List<SonarMapPojo> snmp) {

		Map<String, Integer> vulnCount = getVulnerabilityCount(acspojo);

		int errorCount = (vulnCount.get("Error") == null ? 0 : vulnCount.get("Error"));
		int warningCount = (vulnCount.get("Warning") == null ? 0 : vulnCount.get("Warning"));

		Map<String, Integer> sonarCount = getSonarViolationsCount(snmp);
		int crtical = (sonarCount.get("CRITICAL") == null ? 0 : sonarCount.get("CRITICAL"));
		int blocker = (sonarCount.get("BLOCKER") == null ? 0 : sonarCount.get("BLOCKER"));
		int major = (sonarCount.get("MAJOR") == null ? 0 : sonarCount.get("MAJOR"));

		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<script src=\"http://code.jquery.com/jquery-1.11.0.min.js\"></script>\n"
				+ " <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n"
				+ "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/chart.js@2.8.0\"></script>\n"
				+ "    <script src=\"js/index.js\"></script>\n" + "<script>\n"
				+ "  var ctx = document.getElementById('myChart').getContext('2d');\n"
				+ "var myPieChart = new Chart(ctx, {\n" + "    type: 'doughnut',\n" + "\n" + "\n" + "data : {\n"
				+ "    labels: ['Blocker', 'Critical', 'Major'],\n" + "    datasets: [{\n" + "        data: [" + blocker
				+ "," + crtical + "," + major + "],\n" + "        backgroundColor: [            \n"
				+ "            \"#A5F58D\",\n" + "            \"#FF8757\",            \n" + "          ],  \n"
				+ "    }],\n" + "},\n" + "options:{\n" + "responsive:true,\n" + "maintainAspectRatio:false,\n"
				+ "cutoutPercentage: 70,\n" + "tooltips: {\n" + "    enabled: true\n" + " },\n" + " legend: {\n"
				+ "    display: false\n" + "}\n" + "},\n" + "\n" + "});\n" + "\n" + "\n" + "\n" + "\n"
				+ "var ctx = document.getElementById('dchart').getContext('2d');\n"
				+ "var myPieChart = new Chart(ctx, {\n" + "    type: 'doughnut',\n" + "data : {\n"
				+ "    labels: ['Error', 'Warning'],\n" + "    datasets: [{\n" + "        data: [" + errorCount + ","
				+ warningCount + "],\n" + "        backgroundColor: [\n" + "         \n" + "            \"#FFC29C\",\n"
				+ "            \"#F9DC6A\",\n" + "                            \n" + "          ],\n" + "    }],   \n"
				+ "},\n" + "options:{\n" + "responsive:true,\n" + "maintainAspectRatio:false,\n"
				+ "cutoutPercentage: 70,\n" + "tooltips: {\n" + "    enabled: true\n" + " },\n" + " legend: {\n"
				+ "    display: false\n" + "}\n" + "},\n" + "\n" + "});\n"
				+ "var ele=document.getElementById(\"critical\").innerHTML;\n"
				+ "var ele1=document.getElementById(\"errors\").innerHTML;\n"
				+ "var ele2=document.getElementById(\"blocker\").innerHTML;\n" + "if(ele>=3 || ele1>=5 || ele2>=1) {\n"
				+ "  document.getElementById(\"status\").style.color=\"red\";\n }\n" + "\n" + "	</script>\n"
				+ " </body>\n" + "</html>");
		return sbuf;
	}

	/**
	 * @return
	 */
	private StringBuffer getVulnerabilityReportDetails(AccesibilityPojo acspojo) {

		String codeSnippet = null;
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<div class=\"container\">\r\n" + "           \r\n" + "            <table class=\"box-width\">\r\n"
				+ "              <thead class=\"heads\">\r\n" + "                <tr>\r\n"
				+ "                  <th class=\"data-align\">URL</th>\r\n"
				+ "                  <th class=\"head-space\">Category</th>\r\n"
				+ "                  <th class=\"head-space\">Accessibility Category</th>\r\n"
				+ "                  <th class=\"head-space\">Error Summary</th>\r\n"
				+ "                  <th class=\"head-space\">Code Snippet</th>\r\n"
				+ "                  <th class=\"head-space\">Suggested Techniques</th>\r\n"
				+ "                </tr>\r\n" + "              </thead>\r\n" + "              <tbody class=\"info\">");

		if (acspojo != null) {
			for (CodeSniffer cd : acspojo.getAllCodeSnifferDetails()) {

				codeSnippet = (StringUtils.isEmpty(cd.getCode_snippet())) ? " " : cd.getCode_snippet();
				System.out.println("code snippet >> " + cd.getCode_snippet());
				sbuf.append("<tr>\r\n" + "                  <td>\r\n" + acspojo.getUrl() + "                  </td>\r\n"
						+ "                  <td>\r\n" + cd.getCategory() + "                  </td>\r\n"
						+ "                  <td>\r\n" + cd.getTestCategoty() + "                  </td>\r\n"
						+ "                  <td>\r\n" + cd.getError_summary() + "                  </td>\r\n"
						+ "                  <td class=\"code-width\">\r\n"
						+ codeSnippet.replaceAll(">", "").replaceAll("<", "") + "                  </td>\r\n"
						+ "                  <td>\r\n" + codeSnippet.replaceAll(">", "").replaceAll("<", "")
						+ "                  </td>\r\n" + "                </tr>");
			}
		}
		sbuf.append("</tbody>\r\n" + "            </table>\r\n" + "           \r\n" + "          </div>\r\n"
				+ "        </div> </div>");
		return sbuf;
	}

	/**
	 * @return
	 */
	private StringBuffer getVulnerabilitySummaryChart() {

		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<div id=\"tab4\" class=\"tab-pane fade nav2-content\">\r\n"
				+ "          <p class=\"content-align\">\r\n" + "            Summary\r\n"
				+ "<p class=\"content-align\">      <br><h5 style=margin-left:55px>Tool Used: HTMLCodeSniffer</h5></br>          </p>\r\n"
				+ "          <div class=\"container\">\r\n" + "            <div class=\"bgcol\">\r\n"
				+ "              <div class=\"terms\">\r\n"
				+ "                <p class=\"terms-title\">Categories</p>\r\n"
				+ "                <span class=\"firstpt\"></span>\r\n"
				+ "                <p class=\"firstterm\">Error</p>\r\n"
				+ "                <span class=\"secondpt\"></span>\r\n"
				+ "                <p class=\"secondterm\">Warning</p>\r\n" + "                              </div>\r\n"
				+ "              <div class=\"content-width\">\r\n"
				+ "                <canvas id=\"dchart\" class=\"dchart-component\"></canvas>\r\n"
				+ "              </div>\r\n" + "              <div class=\"chart-values\">\r\n"
				+ "			  <span class=\"point1\"></span>\r\n"
				+ "                <p class=\"point1-value\">ALT Text missing</p>\r\n"
				+ "                <span class=\"point2\"></span>\r\n"
				+ "                <p class=\"point2-value\">Poor Contrast</p>\r\n"
				+ "				<span class=\"point3\"></span>\r\n"
				+ "                <p class=\"point3-value\">No Name</p>\r\n"
				+ "                <span class=\"point4\"></span>\r\n"
				+ "                <p class=\"point4-value\">No Caption</p>\r\n"
				+ "                <span class=\"point5\"></span>\r\n"
				+ "                <p class=\"point5-value\">H 44</p>\r\n" + "                           \r\n"
				+ "               </div>\r\n" + "            </div>\r\n" + "          </div>");
		return sbuf;
	}

	/**
	 * @param sortedLinks
	 * @param audit_report
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private StringBuffer getAccessibilityReportDetails(Set<String> sortedLinks, Map<String, Object> audit_report) {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<div id=\"tab3\" class=\"container tab-pane fade\">\n" + "  <br><h5 style=" + "margin-left:-55px"
				+ ">" + "Tool Used: JQueryInjection</h5></br>" + "          <div class=\"container\">\n"
				+ "            <table class=\"box-width\">\n" + "              <thead class=\"heads\">\n"
				+ "                <tr>\n" + "                  <th class=\"head-space\">URL</th>\n"
				+ "                  <th class=\"head-space\">Error Element</th>\n"
				+ "                  <th class=\"head-space\">Rule Against Error</th>\n"
				+ "                  <th class=\"head-space\">Warning Element</th>\n"
				+ "                  <th class=\"head-space\">Rule Against Warning</th>\n" + "                </tr>\n"
				+ "              </thead>\n" + "              <tbody class=\"info\">\n" + "</div>");

		if (sortedLinks.size() != 0) {

			for (String link : sortedLinks) {
				for (String key : audit_report.keySet()) {

					List<Result> result = (List<Result>) audit_report.get("Error");
					try {
						if (result.size() == 0) {
							break;
						} else {

							sbuf.append(" <tr>\r\n" + "                  <td class=\"url-width\">" + link + "</td>\r\n"
									+ "                  <td>\r\n" + result.get(0).getElements().toString()
									+ "                  </td>\r\n" + "                  <td>\r\n"
									+ result.get(0).getRule().toString());
						}
					} catch (Exception e) {
					}

					result = (List<Result>) audit_report.get("Warning");
					try {
						if (result.size() == 0) {
							break;
						} else {

							sbuf.append("                  </td>\r\n" + "                  <td>\r\n"
									+ result.get(0).getElements().toString() + "                  </td>\r\n"
									+ "                  <td>\r\n" + result.get(0).getRule().toString()
									+ "                  </td>\r\n" + "                </tr>");
						}
					} catch (Exception e) {
					}
				}
			}
		}

		sbuf.append("</tbody>\r\n" + "            </table></div>\r\n" + "        </div>");

		return sbuf;
	}

	/**
	 * @param snmp
	 * @return
	 */
	private StringBuffer getSonarViolationDetails(List<SonarMapPojo> snmp) {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append(" <div class=\"container\">\r\n" + "            \r\n"
				+ "            <table class=\"table-width\">\r\n" + "              <thead class=\"heads\">\r\n"
				+ "                <tr>\r\n" + "                  <th class=\"head-align\">Severity</th>\r\n"
				+ "                  <th class=\"head-space\">Violation</th>\r\n"
				+ "                  <th class=\"head-space\">Violation Details</th>\r\n"
				+ "                  <th class=\"head-space\">Component</th>\r\n"
				+ "                  <th class=\"align\">Line No.</th>\r\n" + "                </tr>\r\n"
				+ "              </thead>\r\n" + "              <tbody class=\"info\">");

		try {
			if (!snmp.isEmpty()) {
				for (SonarMapPojo sn : snmp) {

					sbuf.append("<tr>\r\n" + "                  <td>" + sn.getSeverity() + "</td>\r\n"
							+ "                  <td>" + sn.getType() + "</td>\r\n" + "                  <td>\r\n"
							+ sn.getViolation_details().trim().replaceAll("<", "_").replaceAll(">", "_")
							+ "                  </td>\r\n" + "                  <td>" + sn.getComponent().trim()
							+ "</td>\r\n" + "                  <td>" + sn.getLineNo() + "</td>\r\n"
							+ "                </tr>\r\n");

				}
			} else {
				sbuf.append("<tr>\r\n" + "                  <td>"
						+ "\"  <h1 style=\\\"color:Blue;\\\">There are no Sonar Violations</h3>" + "</td>\r\n"
						+ "                </tr>\r\n");
			}
		} catch (Exception e) {

			sbuf.append("<tr>\r\n" + "                  <td>"
					+ "\"  <h1 style=\\\"color:Blue;\\\">There are no Sonar Violations</h3>" + "</td>\r\n"
					+ "                </tr>\r\n");

		}
		sbuf.append("</tbody>\r\n" + "            </table></div>\r\n" + "        </div>");
		return sbuf;
	}

	/**
	 * @return
	 */
	private StringBuffer getSonarViolationSummaryChart(List<SonarMapPojo> snmp) {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<div id=\"tab2\" class=\"tab-pane fade\">\r\n" + "          <div class=\"nav2-content\">\r\n"
				+ "            <p class=\"content-align\">\r\n" + "              Summary\r\n" + "            </p>\r\n"
				+ "          </div>\r\n" + "          <div class=\"container\">\r\n"
				+ "            <div class=\"row-width\">\r\n" + "              <div class=\"chart-content \">\r\n"
				+ "                <p class=\"content\">Severity</p>\r\n"
				+ "                <span class=\"primary-dot\"></span>\r\n"
				+ "                <p class=\"pri-label\">Critical</p>\r\n"
				+ "                <span class=\"secondary-dot\"></span>\r\n"
				+ "                <p class=\"sec-label\">Major</p>\r\n" + "			\r\n"
				+ "              </div>\r\n" + "              <div class=\"chart\">\r\n"
				+ "                <canvas id=\"myChart\" class=\"chart-component\"></canvas>\r\n"
				+ "              </div>\r\n" + "            </div>\r\n" + "          </div>");
		return sbuf;
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private StringBuffer getReportSummary(AccesibilityPojo acspojo, List<SonarMapPojo> snmp,
			Map<String, Object> audit_report) {

		Map<String, Integer> vulnCount = getVulnerabilityCount(acspojo);

		List<Result> result = (List<Result>) audit_report.get("Error");
		List<Result> warning = (List<Result>) audit_report.get("Warning");

		int errorCount = (result == null ? 0 : result.size());
		int warningCount = (warning == null ? 0 : warning.size());

		Map<String, Integer> sonarCount = getSonarViolationsCount(snmp);
		int crtical = (sonarCount.get("Critical") == null ? 0 : sonarCount.get("Critical"));
		int blocker = (sonarCount.get("Blocker") == null ? 0 : sonarCount.get("Blocker"));
		int major = (sonarCount.get("Major") == null ? 0 : sonarCount.get("Major"));

		Map<String, Integer> accessCount = getAccessibilityCount(acspojo);

		int aaaCount = (accessCount.get("WCAG2AAA") == null ? 0 : accessCount.get("WCAG2AAA"));
		int aaCount = (accessCount.get("WCAG2AA") == null ? 0 : accessCount.get("WCAG2AA"));
		int aCount = (accessCount.get("WCAG2A") == null ? 0 : accessCount.get("WCAG2A"));

		String buildStatus = getBuildStatus(sonarCount, vulnCount);

		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<div class=\"tab-content\">\r\n" + "       \r\n"
				+ "        <div id=\"home\" class=\"tab-pane active nav1-content\">\r\n"
				+ "          <p class=\"p-align\">\r\n" + "            Build Quality Report Summary\r\n"
				+ "            results.\r\n" + buildStatus + " <br>Project Name: "
				+ TestSetUp.configProperty.getProperty("projectName") + "</br>         </p>\r\n"
				+ "          <div class=\"table-data\">\r\n" + "            <table class=\"report\" id=\"menu_1\">\r\n"
				+ "              <tr>\r\n" + "                <th colspan=\"2\">Broken Links</th>\r\n"
				+ "              </tr>\r\n" + "              <tr>\r\n"
				+ "                <td>No Of Broken Links</td>\r\n" + "                <td>0</td>\r\n"
				+ "              </tr>\r\n" + "            </table>\r\n" + "\r\n"
				+ "           <table class=\"report1\" id=\"menu_2\">\n" + "              <tr>\n"
				+ "                <th colspan=\"2\">\n"
				+ "				<button class=\"main_button\" onclick=\"myFunction1()\" >Sonar Violations Details</button></th>\n"
				+ "			 </tr>             </tr>\r\n" + "              <tr>\r\n"
				+ "                <td>Critical</td>\r\n" + "                <td>" + crtical + "</td>\r\n"
				+ "              </tr>\r\n" + "			   <tr>\r\n" + "                <td>Blocker</td>\r\n"
				+ "                <td>" + blocker + "</td>\r\n" + "              </tr>\r\n" + "			   <tr>\r\n"
				+ "                <td>Major</td>\r\n" + "                <td>" + major + "</td>\r\n"
				+ "              </tr>\r\n" + "            </table>\r\n" + "\r\n"
				+ "            <table class=\"report2\" id=\"menu_3\">\n" + "              <tr>\n"
				+ "                <th colspan=\"2\"><button class=\"main_button\"  onclick=\"myFunction2()\" >Accessibility Report</button></th>\n"
				+ "              </tr>\n" + "              <tr>\r\n" + "                <td>AAA</td>\r\n"
				+ "                <td>" + aaaCount + "</td>\r\n" + "              </tr>\r\n" + "              <tr>\r\n"
				+ "                <td>AA</td>\r\n" + "                <td>" + aaCount + "</td>\r\n"
				+ "              </tr>\r\n" + "              <tr>\r\n" + "                <td>A</td>\r\n"
				+ "                <td>" + aCount + "</td>\r\n" + "              </tr>\r\n" + "            </table>\r\n"
				+ "\r\n" + "           <table class=\"report3\" id=\"menu_4\">\n" + "              <tr>\n"
				+ "                <th colspan=\"2\">\n"
				+ "				<button class=\"main_button\"  onclick=\"myFunction3()\" >Vulnerability Report</button></th>\n"
				+ "              </tr>\n" + "              <tr>\r\n" + "                <td>Errors</td>\r\n"
				+ "                <td>" + errorCount + "</td>\r\n" + "              </tr>\r\n"
				+ "              <tr>\r\n" + "                <td>Warnings</td>\r\n" + "                <td>"
				+ warningCount + "</td>\r\n" + "              </tr>\r\n" + "            </table>\r\n" +

				"          </div>\r\n" + "  <table class=\"report4\">\r\n" + "              <tr>\r\n"
				+ "                <th colspan=\"2\">Unit Test Report</th>\r\n" + "              </tr>\r\n"
				+ "              <tr>\r\n" + "   <td>Not Available</td>\r\n" + "              </tr>\r\n"
				+ "              <tr>\r\n" + "            </table>\r\n" + "            <table class=\"report5\">\r\n"
				+ "              <tr>\r\n" + "                <th colspan=\"2\">Regression Test Report</th>\r\n"
				+ "              </tr>\r\n" + "              <tr>\r\n" + "                 <td>Not Available</td>\r\n"
				+ "              </tr>\r\n" + "            </table>       </div>");
		return sbuf;
	}

	/**
	 * @param snmp
	 * @return
	 */
	private Map<String, Integer> getSonarViolationsCount(List<SonarMapPojo> snmp) {

		Map<String, Integer> vulncount = new HashMap<String, Integer>();

		try {
			if (snmp != null) {
				if (!snmp.isEmpty()) {
					for (SonarMapPojo sn : snmp) {

						if (vulncount.containsKey(sn.getSeverity())) {
							int i = vulncount.get(sn.getSeverity());
							vulncount.put(sn.getSeverity(), i + 1);
						} else {
							vulncount.put(sn.getSeverity(), 1);
						}
					}
				}
			}
		} catch (Exception e) {
			vulncount.put("CRITICAL", 0);
			vulncount.put("BLOCKER", 0);
			vulncount.put("MAJOR", 0);

			return vulncount;
		}
		return vulncount;
	}

	/**
	 * @return
	 */
	private String getBuildStatus(Map<String, Integer> vulnCount, Map<String, Integer> sonar) {

		int errorCount = (vulnCount.get("Error") == null ? 0 : vulnCount.get("Error"));
		int crtical = (sonar.get("CRITICAL") == null ? 0 : sonar.get("CRITICAL"));
		int blocker = (sonar.get("BLOCKER") == null ? 0 : sonar.get("BLOCKER"));
		int major = (sonar.get("MAJOR") == null ? 0 : sonar.get("MAJOR"));

		if (errorCount > 2 || (blocker > 1 || crtical > 2 || major > 5)) {

			return "The Build is not good to deploy.";
		} else {
			return "The Build is good to deploy.";
		}

	}

	/**
	 * @param acspojo
	 * @return
	 */
	private Map<String, Integer> getVulnerabilityCount(AccesibilityPojo acspojo) {

		Map<String, Integer> vulncount = new HashMap<>();

		if (acspojo != null) {
			for (CodeSniffer cd : acspojo.getAllCodeSnifferDetails()) {

				if (vulncount.containsKey(cd.getCategory())) {
					int i = vulncount.get(cd.getCategory());
					vulncount.put(cd.getCategory(), i + 1);
				} else {
					vulncount.put(cd.getCategory(), 1);
				}
			}
		}
		return vulncount;
	}

	/**
	 * @param acspojo
	 * @return
	 */
	private Map<String, Integer> getAccessibilityCount(AccesibilityPojo acspojo) {

		Map<String, Integer> vulncount = new HashMap<>();

		if (acspojo != null) {
			for (CodeSniffer cd : acspojo.getAllCodeSnifferDetails()) {

				if (vulncount.containsKey(cd.getTestCategoty())) {
					int i = vulncount.get(cd.getTestCategoty());
					vulncount.put(cd.getTestCategoty(), i + 1);
				} else {
					vulncount.put(cd.getTestCategoty(), 1);
				}
			}
		}
		return vulncount;
	}

	/**
	 * @return
	 */
	private StringBuffer getReportPageNavigation() {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<body>\r\n" + "      <div class=\"nav-tabs-color\">\r\n"
				+ "        <ul class=\"nav nav-tabs tabs\" role=\"tablist\">\r\n"
				+ "          <li class=\"nav-item nav-link-align in-tabs\">\r\n" + "            <a\r\n"
				+ "              class=\"nav-link active link\"\r\n" + "              data-toggle=\"tab\"\r\n"
				+ "              href=\"#home\"\r\n" + "              >Report Objective\r\n" + "            </a>\r\n"
				+ "          </li>\r\n" + "          <li class=\"nav-item nav-link-align in-tabs\">\r\n"
				+ "            <a class=\"nav-link link\" data-toggle=\"tab\"  href=\"#tab2\" \r\n"
				+ "              >Sonar Violations Details</a>\r\n" + "			 \r\n" + "          </li>          \r\n"
				+ "          <li class=\"nav-item nav-link-align in-tabs\">\r\n"
				+ "            <a class=\"nav-link item-content\" data-toggle=\"tab\" href=\"#tab4\" id=\"menu3\"\r\n"
				+ "              >Accessibility Report</a>\r\n" + "          </li>\r\n"
				+ "		  <li class=\"nav-item nav-link-align in-tabs\">\r\n"
				+ "            <a class=\"nav-link item-content\" data-toggle=\"tab\" href=\"#tab5\" id=\"menu4\"\r\n"
				+ "              >Unit Test Report</a>\r\n" + "          </li>\r\n"
				+ "		    <li class=\"nav-item nav-link-align in-tabs\">\r\n"
				+ "            <a class=\"nav-link item-content\" data-toggle=\"tab\" href=\"#tab6\" id=\"menu5\"\r\n"
				+ "              >Regression Test Report</a>\r\n" + "          </li>\r\n" + "        </ul>\r\n"
				+ "      </div>");
		return sbuf;
	}

	/**
	 * @return
	 */
	private StringBuffer getHeader() {
		StringBuffer sbuf = new StringBuffer();
		sbuf.append("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "  <head>\r\n"
				+ "    <meta charset=\"UTF-8\" />\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\r\n" + "   \r\n"
				+ "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/reset.css\" />\r\n" + "   \r\n"
				+ "    <link\r\n" + "      rel=\"stylesheet\"\r\n"
				+ "      href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "    />\r\n" + "   \r\n" + "    <link\r\n"
				+ "      href=\"https://fonts.googleapis.com/css?family=Open+Sans&display=swap\"\r\n"
				+ "      rel=\"stylesheet\"\r\n" + "    />\r\n" + "   \r\n"
				+ "    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/custom.css\" />\r\n"
				+ "    <title>NFR Report</title>\r\n" + "	<script>\r\n" + "\r\n" + "function myFunction1() {\r\n"
				+ "   $('a[href=\"#tab2\"]').click();\r\n" + "	\r\n" + "	}\r\n" + "function myFunction2() {\r\n"
				+ "\r\n" + "    $('a[href=\"#tab3\"]').click();\r\n" + "}\r\n" + "function myFunction3() {\r\n" + "\r\n"
				+ "   $('a[href=\"#tab4\"]').click();\r\n" + "}\r\n" + "	</script>\r\n" + "<style>\r\n"
				+ "        body {\r\n" + "  font-family: \"Open Sans\", Semi-bold;\r\n"
				+ "  background-color: #f5f5f5;\r\n" + "}\r\n" + " \r\n" + ".nav-tabs-color {\r\n"
				+ "  background-color: #0068e0;\r\n" + "  \r\n" + "}\r\n" + "\r\n" + ".nav-link-align {\r\n"
				+ "  width: 250px;\r\n" + "  font-size: 15px;\r\n" + "}\r\n" + ".main_button{\r\n" + "border: none;\r\n"
				+ "color: white;\r\n" + "font-weight: bold;\r\n" + "background-color: #007bfe;\r\n" + "\r\n" + "}\r\n"
				+ ".item-content {\r\n" + "  padding-top: 1.25em;\r\n" + "  color: #fff;\r\n" + "  Width: 105%;\r\n"
				+ "  height: 65px;\r\n" + "  padding-left: 2em;\r\n" + "  width: 115%;\r\n" + "}\r\n" + "\r\n"
				+ ".tabs {\r\n" + "  height: 65px;\r\n" + "  border: none;\r\n" + "  font-weight: 600;\r\n"
				+ "  width:1300px;\r\n" + "  margin: 0 auto;\r\n" + "}\r\n" + "\r\n" + ".in-tabs {\r\n"
				+ "  text-align: center;\r\n" + "}\r\n" + ".tabs .in-tabs .active {\r\n"
				+ "  background-color: #0883f8;\r\n" + "  color: #fff;\r\n" + "}\r\n" + "\r\n"
				+ ".tabs .in-tabs .link:focus,.tabs .in-tabs .item-content:focus {\r\n"
				+ "  background-color: #0883f8;\r\n" + "}\r\n" + "\r\n"
				+ ".tabs .in-tabs .link,.tabs .in-tabs .item-content {\r\n" + "  border: none;\r\n" + "}\r\n" + "\r\n"
				+ ".tabs .in-tabs .link,.item-content:hover {\r\n" + "  color: #fff;\r\n" + "}\r\n" + "\r\n"
				+ ".link {\r\n" + "  padding-top: 1.25em;\r\n" + "  color: #fff;\r\n" + "  Width: 105%;\r\n"
				+ "  height: 65px;\r\n" + "}\r\n" + "\r\n" + ".nav1-content {\r\n" + "  background-color: #fff;\r\n"
				+ "  height: 129px;\r\n" + "  margin: 0 auto;\r\n" + "  width: 1300px;\r\n" + "\r\n" + "}\r\n" + "\r\n"
				+ ".p-align {\r\n" + "  padding-top: 48px;\r\n" + "  padding-left: 6.3em;\r\n"
				+ "  font-size: 15px;\r\n" + "  font-weight: 600;\r\n" + "}\r\n" + "\r\n" + ".nav2-content {\r\n"
				+ "  height: 2.5em;\r\n" + "  background-color: #404040;\r\n" + "}\r\n" + "\r\n"
				+ ".content-align {\r\n" + "  color: #fff;\r\n" + "  font-size: 20px;\r\n" + "  text-align: center;\r\n"
				+ "  font-weight: bold;\r\n" + "  padding-top: 0.3em;\r\n" + "  margin-bottom: 0px;\r\n" + "}\r\n"
				+ "\r\n" + ".chart-content {\r\n" + "  height: 20em;\r\n" + "  background-color: #fff;\r\n"
				+ "  z-index: 1;\r\n" + "}\r\n" + "\r\n" + ".chart {\r\n" + "  background-color: #fff;\r\n"
				+ "  height: 20em;\r\n" + "  width: 100%;\r\n" + "  position: relative;\r\n" + "}\r\n" + "\r\n"
				+ ".content {\r\n" + "  font-weight: bold;\r\n" + "  font-size: 17.5px;\r\n"
				+ "  padding-top: 30px;\r\n" + "  padding-left: 3em;\r\n" + "}\r\n" + "\r\n" + ".primary-dot {\r\n"
				+ "  height: 21px;\r\n" + "  width: 21px;\r\n" + "  border-radius: 50%;\r\n"
				+ "  background-color: #a5f58d;\r\n" + "  display: inline-block;\r\n" + "  margin-top: 3em;\r\n"
				+ "  margin-left: 2.5em;\r\n" + "}\r\n" + ".color {\r\n" + "  background: black;\r\n" + "}\r\n"
				+ ".pri-label {\r\n" + "  margin-top: -1.85em;\r\n" + "  padding-left: 5.5em;\r\n"
				+ "  font-size: 14px;\r\n" + "  font-weight: 600;\r\n" + "}\r\n" + ".secondary-dot {\r\n"
				+ "  height: 21px;\r\n" + "  width: 21px;\r\n" + "  border-radius: 50%;\r\n"
				+ "  background-color: #ff8757;\r\n" + "  display: inline-block;\r\n" + "  margin-top: 1em;\r\n"
				+ "  margin-left: 2.5em;\r\n" + "}\r\n" + "\r\n" + ".sec-label {\r\n" + "  padding-left: 5.5em;\r\n"
				+ "  margin-top: -2em;\r\n" + "  font-size: 14px;\r\n" + "  font-weight: 600;\r\n" + "}\r\n" + "\r\n"
				+ ".row-width {\r\n" + "  width: 105%;\r\n" + "  display: flex;\r\n" + "  margin-left: -2.5%;\r\n"
				+ "}\r\n" + "\r\n" + ".chart-component {\r\n" + "  position: absolute;\r\n" + "  left: 6.2em;\r\n"
				+ "  padding-top: 2em;\r\n" + "  width: 45em !important;\r\n" + "  height: 250px !important;\r\n"
				+ "}\r\n" + "\r\n" + ".heads {\r\n" + "  background-color: #404040;\r\n" + "  color: #fff;\r\n"
				+ "}\r\n" + "\r\n" + ".table-width {\r\n" + "  width: 105%;\r\n" + "  margin: 0 auto;\r\n"
				+ "  margin-left: -2.5%;\r\n" + "}\r\n" + "\r\n" + ".head-space {\r\n" + "  padding-top: 1.3em;\r\n"
				+ "  padding-bottom: 1.3em;\r\n" + "  font-size: 18px;\r\n" + "  font-weight: 600;\r\n"
				+ "  text-align: center;\r\n" + "  vertical-align: middle;\r\n" + "}\r\n" + "\r\n" + ".info td {\r\n"
				+ "  padding: 1.3em;\r\n" + "  text-align: center;\r\n" + "  vertical-align: middle;\r\n"
				+ "  border-left: 1px dashed #566a6a;\r\n" + "  font-size: 14px;\r\n" + "  font-weight: 600;\r\n"
				+ "  height: 200px;\r\n" + "  background-color: #fff;\r\n" + "  word-wrap: break-word;\r\n" + "}\r\n"
				+ "\r\n" + ".align {\r\n" + "  padding-top: 1.3em;\r\n" + "  padding-bottom: 1.3em;\r\n"
				+ "  font-size: 17.5px;\r\n" + "  font-weight: 600;\r\n" + "  text-align: center;\r\n"
				+ "  vertical-align: middle;\r\n" + "  padding-right: 1.5em;\r\n" + "}\r\n" + "\r\n"
				+ ".head-align {\r\n" + "  padding-top: 1.3em;\r\n" + "  padding-bottom: 1.3em;\r\n"
				+ "  font-size: 17.5px;\r\n" + "  font-weight: 600;\r\n" + "  text-align: center;\r\n"
				+ "  vertical-align: middle;\r\n" + "  padding-left: 1.2em;\r\n" + "}\r\n" + "\r\n"
				+ ".content-width {\r\n" + "  height: 20em;\r\n" + "  width: 55%;\r\n" + "  background-color: #fff;\r\n"
				+ "  display: inline-block;\r\n" + "}\r\n" + "\r\n" + ".dchart-component {\r\n"
				+ "  position: absolute;\r\n" + "  padding-top: 2em;\r\n" + "  left: 23em;\r\n"
				+ "  height: 250px !important;\r\n" + "  width: 32em !important;\r\n" + "}\r\n" + ".bgcol {\r\n"
				+ "  background-color: #fff;\r\n" + "  width: 113.3%;\r\n" + "  margin: 0 auto;\r\n"
				+ "  margin-top: 0.3em;\r\n" + "  position: relative;\r\n" + "  margin-left: -6.5%;\r\n" + "\r\n"
				+ "}\r\n" + "\r\n" + ".terms {\r\n" + "  background-color: #fff;\r\n" + "  width: 20%;\r\n"
				+ "  display: inline-block;\r\n" + "  position: absolute;\r\n" + "  left: 1.5em;\r\n" + "}\r\n" + "\r\n"
				+ ".terms-title {\r\n" + "  font-weight: bold;\r\n" + "  font-size: 17.5px;\r\n"
				+ "  margin-top: 3em;\r\n" + "  padding-left: 3em;\r\n" + "  margin-bottom: 2em;\r\n" + "}\r\n" + "\r\n"
				+ ".firstpt {\r\n" + "  height: 21px;\r\n" + "  width: 21px;\r\n" + "  border-radius: 50%;\r\n"
				+ "  background-color: #89e16f;\r\n" + "  position: absolute;\r\n" + "  margin-left: 3em;\r\n" + "}\r\n"
				+ "\r\n" + ".secondpt {\r\n" + "  height: 21px;\r\n" + "  width: 21px;\r\n"
				+ "  border-radius: 50%;\r\n" + "  background-color: #ec7b4e;\r\n" + "  position: absolute;\r\n"
				+ "  margin-left: 3em;\r\n" + "}\r\n" + "\r\n" + ".thirdpt {\r\n" + "  height: 21px;\r\n"
				+ "  width: 21px;\r\n" + "  border-radius: 50%;\r\n" + "  background-color: #f5f684;\r\n"
				+ "  position: absolute;\r\n" + "  margin-left: 3em;\r\n" + "}\r\n" + "\r\n" + ".firstterm {\r\n"
				+ "  padding-left: 7em;\r\n" + "  font-size: 14px;\r\n" + "  font-weight: 600;\r\n" + "}\r\n" + "\r\n"
				+ ".secondterm {\r\n" + "  padding-left: 7em;\r\n" + "  font-size: 14px;\r\n"
				+ "  font-weight: 600;\r\n" + "}\r\n" + "\r\n" + ".thirdterm {\r\n" + "  padding-left: 7em;\r\n"
				+ "  font-size: 14px;\r\n" + "  font-weight: 600;\r\n" + "}\r\n" + "\r\n" + ".chart-values {\r\n"
				+ "  background-color: #fff;\r\n" + "  width: 20%;\r\n" + "  position: relative;\r\n"
				+ "  display: inline-block;\r\n" + "  bottom: 4em;\r\n" + "  left: 15em;\r\n" + "}\r\n" + "\r\n"
				+ ".point1 {\r\n" + "  height: 21px;\r\n" + "  width: 21px;\r\n" + "  border-radius: 50%;\r\n"
				+ "  background-color: #8CDCE8;\r\n" + "  position: absolute;\r\n" + "  top: 4em;\r\n"
				+ "  left: 3.5em;\r\n" + "}\r\n" + "\r\n" + ".point2 {\r\n" + "  height: 21px;\r\n"
				+ "  width: 21px;\r\n" + "  border-radius: 50%;\r\n" + "  background-color: #f2adf0;\r\n"
				+ "  position: absolute;\r\n" + "  top: 6.2em;\r\n" + "  left: 3.5em;\r\n" + "}\r\n" + "\r\n"
				+ ".point3 {\r\n" + "  height: 21px;\r\n" + "  width: 21px;\r\n" + "  border-radius: 50%;\r\n"
				+ "  background-color: #FFC29C;\r\n" + "  position: absolute;\r\n" + "  top: 8.5em;\r\n"
				+ "  left: 3.5em;\r\n" + "}\r\n" + "\r\n" + ".point4 {\r\n" + "  height: 21px;\r\n"
				+ "  width: 21px;\r\n" + "  border-radius: 50%;\r\n" + "  background-color: #8D95FF;\r\n"
				+ "  position: absolute;\r\n" + "  top: 11em;\r\n" + "  left: 3.5em;\r\n" + "}\r\n" + "\r\n"
				+ ".point5 {\r\n" + "  height: 21px;\r\n" + "  width: 21px;\r\n" + "  border-radius: 50%;\r\n"
				+ "  background-color: #F9CD6A;\r\n" + "  position: absolute;\r\n" + "  top: 13.2em;\r\n"
				+ "  left: 3.5em;\r\n" + "}\r\n" + "\r\n" + ".point1-value {\r\n" + "  padding-left: 7em;\r\n"
				+ "  font-size: 14px;\r\n" + "  font-weight: 600;\r\n" + "  padding-top: 4.5em;\r\n" + "}\r\n"
				+ ".point2-value {\r\n" + "  padding-left: 7em;\r\n" + "  font-size: 14px;\r\n"
				+ "  font-weight: 600;\r\n" + "}\r\n" + ".point3-value {\r\n" + "  padding-left: 7em;\r\n"
				+ "  font-size: 14px;\r\n" + "  font-weight: 600;\r\n" + "}\r\n" + ".point4-value {\r\n"
				+ "  padding-left: 7em;\r\n" + "  font-size: 14px;\r\n" + "  font-weight: 600;\r\n" + "}\r\n"
				+ ".point5-value {\r\n" + "  padding-left: 7em;\r\n" + "  font-size: 14px;\r\n"
				+ "  font-weight: 600;\r\n" + "}\r\n" + "\r\n" + ".box-width {\r\n" + "  width: 1257px;\r\n"
				+ "  margin-left: -6.5%;\r\n" + " word-wrap: break-word; \r\n" + "  table-layout: fixed;\r\n" + "\r\n"
				+ "}\r\n" + ".data-align {\r\n" + "  padding-top: 1.3em;\r\n" + "  padding-bottom: 1.3em;\r\n"
				+ "  font-size: 17.5px;\r\n" + "  font-weight: 600;\r\n" + "  text-align: center;\r\n"
				+ "  vertical-align: middle;\r\n" + "}\r\n" + "\r\n" + ".url-width {\r\n" + "  width: 8%;\r\n" + "}\r\n"
				+ "\r\n" + ".code-width {\r\n" + "  width: 30%;\r\n" + "}\r\n" + ".code-width1 {\r\n"
				+ "  table-layout: fixed;\r\n" + "}\r\n" + "\r\n" + ".table-data {\r\n" + "  width: 1300px;\r\n"
				+ "  margin: 0 auto;\r\n" + "  margin-top: 5em;\r\n" + "}\r\n" + "\r\n" + ".table-data table th {\r\n"
				+ "  background-color: #0883f8;\r\n" + "  color: #fff;\r\n" + "  font-weight: 600;\r\n"
				+ "  font-size: 16px;\r\n" + "  \r\n" + "}\r\n" + ".table-data table td {\r\n"
				+ "  background-color: #FFF;\r\n" + "  color: #000;\r\n" + "  font-size: 14px;\r\n"
				+ " word-wrap: break-word;\r\n" + "}\r\n" + ".report,.report1,.report2,.report3{\r\n"
				+ "  display: inline;\r\n" + "}\r\n" + "\r\n" + "/* .report > th, td {\r\n"
				+ "  border: 1px solid black;\r\n" + " \r\n" + "} */\r\n" + ".report {\r\n"
				+ "  margin-left: 5.8em;\r\n" + "}\r\n" + ".report th, td {\r\n" + "  padding: 10px 35px;\r\n"
				+ "  text-align: center;  \r\n" + "}\r\n" + "/* .report1 table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n" + "  \r\n" + "} */\r\n" + ".report1 th, td {\r\n"
				+ "  padding: 10px 35px; \r\n" + "  text-align: center; \r\n" + "}\r\n" + ".report1 {\r\n"
				+ "  margin-left: 34em;\r\n" + "}\r\n" + "/* .report2 table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n" + "} */\r\n" + ".report2 {\r\n" + "  position: relative;\r\n"
				+ "  top: 8em;\r\n" + "  margin-left: 5.8em;\r\n" + "}\r\n" + ".report2 th, td {\r\n"
				+ "  padding: 10px 35px; \r\n" + "  text-align: center; \r\n" + "}\r\n"
				+ "/* .report3 table, th, td {\r\n" + "  border: 1px solid black;\r\n" + "} */\r\n"
				+ ".report3 th, td {\r\n" + "  padding: 10px 35px; \r\n" + "  text-align: center; \r\n" + "}\r\n"
				+ ".report3 {\r\n" + "  margin-left: 38.5em;\r\n" + "  position: relative;\r\n" + "  top: 8em;\r\n"
				+ "}\r\n" + ".report4 th, td {\r\n" + "  padding: 10px 35px; \r\n" + "  text-align: center; \r\n"
				+ "}\r\n" + ".report4 {\r\n" + "  margin-left: 33em;\r\n" + "    top: -20.6em;\r\n"
				+ "    position: relative;\r\n" + "}\r\n" + ".report5 th, td {\r\n" + "  padding: 10px 35px; \r\n"
				+ "  text-align: center; \r\n" + "}\r\n" + ".report5 {\r\n" + "  margin-left: 32em;\r\n"
				+ "    position: relative;\r\n" + "    top: -7.7em;\r\n" + "  \r\n" + "}\r\n" + ".report-status {\r\n"
				+ "  color: blue;\r\n" + "}\r\n" + "\r\n" + ".report-availability {\r\n" + "  color: red;\r\n"
				+ "}    </style>  </head>");
		return sbuf;
	}
}
