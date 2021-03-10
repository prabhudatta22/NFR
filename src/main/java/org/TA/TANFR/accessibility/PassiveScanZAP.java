/**
 * 
 */
package org.TA.TANFR.accessibility;

/**
 * @author Prabhudatta.C
 *
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

public class PassiveScanZAP {

	private ClientApi zapClientAPI;
	private static final String API_KEY = "changeme1234";
	private String url = "https://192.168.2.92";

	public static void main(String[] args)
			throws UnsupportedEncodingException, ClientApiException, InterruptedException {

		new PassiveScanZAP().spider();
	}

	public PassiveScanZAP() {

		zapClientAPI = new ClientApi("192.168.2.92", 8090, API_KEY, true);

	}

	public void spider() throws ClientApiException, UnsupportedEncodingException, InterruptedException {

		String contextName = "ZAPtest";// name of the Context to be create
		String contextURL = "https://qahrm.techaspect.com/symfony/web/index.php";
		String contextId = "1";// context id
		String loginUrl = "https://qahrm.techaspect.com/symfony/web/index.php";
		String loginRequestData = "username={%techadmin%}&password={%TechAspectTiBa&$1234%}";
		String userId = "0";
		String asacnURL = "https://qahrm.techaspect.com/symfony/web/index.php";
		// auth details
		String username = "techadmin";
		String password = "TechAspectTiBa&$1234";
		// logged in idicator
		String loggedInIndicator = "\\Q<a href=\"../admin/logout_action.jsp\">Sign-out</a>\\E";

		contextId = extractontextId(zapClientAPI.context.newContext(contextName));
		System.out.println("context " + contextName + " created");
		/*
		 * * zapClientAPI.context.includeInContext(API_KEY, contextName,
		 * contextURL); System.out.println("URL " + contextURL + " added to " +
		 * contextName);
		 */
		// set authentication mathod

		// Prepare the configuration in a format similar to how URL parameters
		// are formed. This
		// means that any value we add for the configuration values has to be
		// URL encoded.
		StringBuilder formBasedConfig = new StringBuilder();
		formBasedConfig.append("loginUrl=").append(URLEncoder.encode(loginUrl, "UTF-8"));
		formBasedConfig.append("&loginRequestData=").append(URLEncoder.encode(loginRequestData, "UTF-8"));

		zapClientAPI.authentication.setAuthenticationMethod(API_KEY, contextId, "formBasedAuthentication",
				formBasedConfig.toString());

		// end set auth method
		System.out.println("Form Based Authentication added to context : " + contextName);

		// add logged in idicator
		zapClientAPI.authentication.setLoggedInIndicator(API_KEY, contextId, loggedInIndicator);
		System.out.println("Logged in indicator added to context : " + contextName);

		// add new user and authentication details
		// Make sure we have at least one user
		// extract user id method is maualy edied one (above)
		userId = extractUserId(zapClientAPI.users.newUser(API_KEY, contextId, "admin"));

		// Prepare the configuration in a format similar to how URL parameters
		// are formed. This
		// means that any value we add for the configuration values has to be
		// URL encoded.
		StringBuilder userAuthConfig = new StringBuilder();
		userAuthConfig.append("username=").append(URLEncoder.encode(username, "UTF-8"));
		userAuthConfig.append("&password=").append(URLEncoder.encode(password, "UTF-8"));
		String authCon = userAuthConfig.toString();

		zapClientAPI.users.setAuthenticationCredentials(API_KEY, contextId, userId, authCon);

		System.out.println("New user added.");

		zapClientAPI.users.setUserEnabled(API_KEY, contextId, userId, "true");
		System.out.println("User : admin is now Enabled");

		// Method signature : scanAsUser(String apikey, String url, String
		// contextid, String userid, String maxchildren) throws
		// ClientApiException
		System.out.println("Start spider as enabled user");

		zapClientAPI.spider.scanAsUser(API_KEY, url, contextId, userId, "1000", null);

		// Wait for complete spidering (equal to 100)
		// Method signature : status(String scanId)
		while (statusToInt(zapClientAPI.spider.status("")) < 100) {
			System.out.println("Status spider = " + statusToInt(zapClientAPI.spider.status("")) + "%");
			System.out.println("Alerts number = " + zapClientAPI.core.numberOfAlerts("").toString(2));
			Thread.sleep(1000);
		}

		System.out.println("Spider finished");
	}

	/**
	 * Converts the ZAP API status response to an integer
	 *
	 * @param response
	 *            the ZAP API response code
	 * @return the integer status of the ApiResponse
	 */
	private int statusToInt(final ApiResponse response) {
		return Integer.parseInt(((ApiResponseElement) response).getValue());
	}

	/**
	 * get user id
	 * 
	 * @param response
	 *            the ZAP API response code
	 * @return the user ID of the user
	 *
	 */
	private String extractUserId(ApiResponse response) {
		return ((ApiResponseElement) response).getValue();
	}

	/**
	 * get user id
	 * 
	 * @param response
	 *            the ZAP API response code
	 * @return the user ID of the context
	 *
	 */
	private String extractontextId(ApiResponse response) {
		return ((ApiResponseElement) response).getValue();
	}

	/// ascan
	/**
	 * get user id
	 * 
	 * @param url
	 *            url to br attack
	 * @param policyName
	 *            selected policy name
	 * @return the user ID of the context
	 *
	 */
	public void scanURL(final String url, String policyName) throws ClientApiException, InterruptedException {
		// url must be "https://localhost:9443/"

		// Method signature : scan(String apikey, String url, String recurse,
		// String inscopeonly, String scanpolicyname, String method, String
		// postdata)
		// Use a default policy if chosenPolicy is null or empty
		zapClientAPI.ascan.scan(API_KEY, url, "true", "false", policyName, null);

		// Wait for complete scanning (equal to 100)
		// Method signature : status(String scanId)
		while (statusToInt(zapClientAPI.ascan.status("")) < 100) {
			System.out.println("Status scan = " + statusToInt(zapClientAPI.ascan.status("")) + "%");
			System.out.println("Alerts number = " + zapClientAPI.core.numberOfAlerts("").toString(2));
			System.out.println("Messages number = " + zapClientAPI.core.numberOfMessages("").toString(2));
			Thread.sleep(5000);
		}
	}

	// report

	public void savereport() throws IOException, ClientApiException {

		FileOutputStream fos = new FileOutputStream("/home/thilinam/test.html");
		fos.write(zapClientAPI.core.htmlreport(API_KEY));
		fos.close();
	}

	public void stop() throws ClientApiException {

		// zapClientAPI.core.shutdown(API_KEY);

		if (zapClientAPI != null) {
			System.out.println("Shutdown ZAProxy");
			// throw new ClientApiException("Exception lancee dans stopZAP");
			zapClientAPI.core.shutdown(API_KEY);
		} else {
			System.out.println("No shutdown of ZAP (zapClientAPI==null)");
		}

	}
}

// main class
