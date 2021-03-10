/**
 * 
 */
package org.TA.TANFR.accessibility;

/**
 * @author Prabhudatta.C
 *
 */
import java.nio.charset.StandardCharsets;

import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;

/**
 * A simple example showing how to use the API to spider and active scan a site
 * and then retrieve and print out the alerts.
 *
 * <p>
 * ZAP must be running on the specified host and port for this script to work
 */
public class ZAPScan {

	private static final String ZAP_ADDRESS = "192.168.2.92";
	private static final int ZAP_PORT = 8090;
	private static final String ZAP_API_KEY = "changeme1234";

	private static final String TARGET = "https://qahrm.techaspect.com/symfony/web/index.php";

	public static void main(String[] args) {
		ClientApi api = new ClientApi(ZAP_ADDRESS, ZAP_PORT, ZAP_API_KEY);

		try {
			// Start spidering the target
			System.out.println("Spider : " + TARGET);
			// It's not necessary to pass the ZAP API key again, already set
			// when creating the
			// ClientApi.

			ApiResponse resp = api.spider.scan(ZAP_API_KEY, TARGET, null, null, null, null);
			String scanid;
			int progress;

			// The scan now returns a scan id to support concurrent scanning
			scanid = ((ApiResponseElement) resp).getValue();

			// Poll the status until it completes
			while (true) {
				Thread.sleep(1000);
				progress = Integer.parseInt(((ApiResponseElement) api.spider.status(scanid)).getValue());
				System.out.println("Spider progress : " + progress + "%");
				if (progress >= 100) {
					break;
				}
			}
			System.out.println("Spider complete");

			// Give the passive scanner a chance to complete
			Thread.sleep(2000);

			System.out.println("Active scan : " + TARGET);
			resp = api.ascan.scan(TARGET, "True", "False", null, null, null);

			// The scan now returns a scan id to support concurrent scanning
			scanid = ((ApiResponseElement) resp).getValue();

			// Poll the status until it completes
			while (true) {
				Thread.sleep(5000);
				progress = Integer.parseInt(((ApiResponseElement) api.ascan.status(scanid)).getValue());
				System.out.println("Active Scan progress : " + progress + "%");
				if (progress >= 100) {
					break;
				}
			}
			System.out.println("Active Scan complete");

			System.out.println("Alerts:");
			System.out.println(new String(api.core.xmlreport(), StandardCharsets.UTF_8));

		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
