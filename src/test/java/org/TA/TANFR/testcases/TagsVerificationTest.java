/**
 * 
 */
package org.TA.TANFR.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.TA.TANFR.setup.TestSetUp;
import org.TA.TANFR.testutils.DriverManager;
import org.TA.TANFR.testutils.TestUtils;
import org.testng.annotations.Test;

/**
 * @author Prabhudatta.C
 *
 */
public class TagsVerificationTest extends TestSetUp {

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dpone")
	public void verifyTags(Hashtable<String, String> data) throws IOException {

		DriverManager.getDriver().get(data.get("url"));
		String pageSource = DriverManager.getDriver().getPageSource();
		System.out.println(pageSource);
	}
}
