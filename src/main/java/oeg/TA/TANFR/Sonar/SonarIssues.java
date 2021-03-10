package oeg.TA.TANFR.Sonar;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.TA.TANFR.setup.TestSetUp;
import org.apache.commons.lang3.StringUtils;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Hello world!
 *
 */
public class SonarIssues {

	String GET_ISSUES = "/api/issues/search";
	public String vDatetype1 = "ddMMMyyyy_HHmmss";
	public String dateFormat1 = "YYYY-MM-dd'T'HH:mm:ss+0000";
	public String dateFormat2 = "YYYY-MM-dd";

	public String getDateFormat() {

		Date vDate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(vDatetype1);
		return sdf.format(vDate);

	}

	@SuppressWarnings("rawtypes")
	public List<Map> getAllIssues() {

		String authString = "prabhudatta.c" + ":" + "Welcome$123";
		String encodedString = Base64.encode(authString.getBytes(), 0);

		HashMap<String, String> credentials = new HashMap<String, String>();
		credentials.put("username", "prabhudatta.c");//
		credentials.put("password", "Welcome$123");//

		Response res = (Response) given().contentType("application/x-www-form-urlencoded")
				.header("Authorization", "Basic " + encodedString)
				.config(RestAssured.config()
						.encoderConfig(RestAssured.config().getEncoderConfig().encodeContentTypeAs("application/json",
								ContentType.JSON)))
				.when().get("http://staticreview.techaspect.com" + GET_ISSUES).then().extract();

		System.out.println(res.asString() + res.getStatusCode());
		List<Map> jso = res.jsonPath().get("issues");
		return jso;
	}

	@SuppressWarnings("rawtypes")
	public List<Map> getAllDatedIssues(List<Map> jso) {
		Date endDate = getEndDate();
		List<Map> updatedjso = new CopyOnWriteArrayList<Map>();
		for (Map m : jso) {
			LocalDateTime ldt = LocalDateTime.parse(m.get("creationDate").toString().replace("+0000", ""));
			Date date = Date.from(ldt.toInstant(ZoneOffset.UTC));

			if (isWithinRange(date, endDate)) {
				updatedjso.add(m);
			}
		}

		return updatedjso;
	}

	public Date getEndDate() {
		int dateRange = 0;
		if (StringUtils.isNotEmpty(TestSetUp.configProperty.getProperty("DateRange"))) {
			dateRange = (~(Integer.parseInt(TestSetUp.configProperty.getProperty("DateRange")) - 1));
		}

		Calendar c = Calendar.getInstance();
		try {
			c.setTime(new Date());
			c.add(Calendar.DATE, dateRange);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c.getTime();
	}

	boolean isWithinRange(Date testDate, Date endDate) {

		return testDate.getTime() >= endDate.getTime() && testDate.getTime() <= new Date().getTime();
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] arg) {

		SonarIssues app = new SonarIssues();
		List<Map> jso = app.getAllIssues();
		List<SonarMapPojo> snmp = app.processAllIssues(jso);
		app.writeToNotePad(snmp);

	}

	public void writeToNotePad(List<SonarMapPojo> snmp) {

		String folderPath = System.getProperty("user.dir") + "/Reports";
		File dir = new File(folderPath);

		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		File file = new File(dir, new SonarIssues().getDateFormat() + "_SonarViolations.txt");

		try {
			FileWriter archivo = new FileWriter(file);

			StringBuffer sbuf = new StringBuffer();
			sbuf.append(" Severity " + "\t\t" + " Violation Type " + "\t\t\t\t\t" + " Violation Details "
					+ "\t\t\t\t\t\t" + " Component " + "\t\t\t\t\t\t\t\t\t" + " line No " + "\t\t" + "Author \r\n");

			for (SonarMapPojo sn : snmp) {
				sbuf.append(sn.getSeverity() + "\t\t" + sn.getType() + "\t\t" + sn.getViolation_details().trim()
						+ "\t\t" + sn.getComponent().trim() + "\t\t" + sn.getLineNo() + "\t\t" + sn.getAuthor()
						+ "\r\n");
			}

			archivo.write(sbuf.toString());
			archivo.flush();
			archivo.close();
			sbuf = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("rawtypes")
	public List<SonarMapPojo> processAllIssues(List<Map> jso) {

		List<SonarMapPojo> majorViolationList = new CopyOnWriteArrayList<SonarMapPojo>();
		if (jso != null) {

			for (Map js : jso) {

				System.out.println(js.get("severity").toString());
				System.out.println(js.get("project").toString());
				System.out.println(TestSetUp.configProperty.getProperty("projectName"));
				if (js.get("project").toString()
						.equalsIgnoreCase(TestSetUp.configProperty.getProperty("projectName"))) {
					if (!js.get("severity").toString().equalsIgnoreCase("MINOR")
							&& !js.get("severity").toString().equalsIgnoreCase("INFO")) {
						SonarMapPojo snmp = new SonarMapPojo();
						snmp.setAuthor(String.valueOf(js.get("author")));
						snmp.setComponent(
								js.get("component").toString().replaceAll("/", ".").replaceAll("\\s", "_").trim());
						snmp.setLineNo(String.valueOf(js.get("line")));
						snmp.setSeverity(js.get("severity").toString());
						snmp.setViolation_details(
								js.get("message").toString().replaceAll("/", ".").replaceAll("\\s", "_").trim());
						snmp.setType(js.get("type").toString());
						majorViolationList.add(snmp);
					}
				}
			}
		}

		return majorViolationList;

	}
}
