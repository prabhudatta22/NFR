package org.TA.TANFR.accessibility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.TA.TANFR.testutils.Constants;
import org.jsoup.Jsoup;

/**
 * @author nikulkarni Singleton, package protected class; could have used Guice
 *         but want to keep it DI library agnostic so that others can use this
 *         library
 */
class JsFactory {

	private static JsFactory INSTANCE = null;
	private String accessibility_content = null;
	private Properties configProperty = null;

	private String jquery_content = null;

	private JsFactory() {
		try {
			FileInputStream fi = new FileInputStream(new File(
					System.getProperty(Constants.ROOT_DIR) + "/src/test/resources/PropertyFiles/config.properties"));

			configProperty = new Properties();
			configProperty.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized static JsFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new JsFactory();
			INSTANCE.load();
		}
		return INSTANCE;
	}

	@SuppressWarnings("deprecation")
	private void load() {
		try {
			jquery_content = Jsoup.connect(configProperty.getProperty("jquerycdnurl")).ignoreContentType(true).execute()
					.body();
			accessibility_content = Jsoup.connect(configProperty.getProperty("applicationcdnurl"))
					.validateTLSCertificates(false).ignoreContentType(true).execute().body();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String getAccessibility_content() {
		return accessibility_content;
	}

	String getJquery_content() {
		return jquery_content;
	}

}
