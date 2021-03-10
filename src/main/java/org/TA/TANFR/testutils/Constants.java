/**
 ******************************************************************************
 * 							  	STAYING SHARP
 *  							CONFIDENTIAL
 *							
 * *****************************************************************************
 */

package org.TA.TANFR.testutils;

/**
 * The Class Constants.
 */
public class Constants {

	/**
	 * Instantiates a new constants.
	 */
	private Constants() {
	}

	/** The Constant ROOT_DIR. */
	/*
	 * -------------------------------------------------------------------------
	 * FRAMEWORK CONSTANTS
	 * --------------------------------------------------------------
	 */
	public static final String ROOT_DIR = "user.dir";

	/** The Constant SCREENSHOTS_FOLDER. */
	public static final String SCREENSHOTS_FOLDER = "\\screenshots\\";

	/** The Constant AUTHOR1. */
	public static final String AUTHOR1 = "maruthip";

	/** The Constant AUTHOR2. */
	public static final String AUTHOR2 = "akhilap";

	/** The Constant REGRESSION_CATEGORY. */
	public static final String REGRESSION_CATEGORY = "Regression";

	/** The Constant SMOKE_CATEGORY. */
	public static final String SMOKE_CATEGORY = "Smoke";

	/** The Constant ACCEPTANCE_CATEGORY. */
	public static final String ACCEPTANCE_CATEGORY = "Acceptance";

	/** The Constant EXECUTION_ENV. */
	/*
	 * -------------------------------------------------------------- SONARQUBE
	 * CONSTANTS --------------------------------------------------------------
	 */
	public static final String EXECUTION_ENV = "executionEnvironment";

	/** The Constant BROWSER. */
	public static final String BROWSER = "browser";

	/** The Constant PLATFORM. */
	public static final String PLATFORM = "platform";

	/** The Constant VERSION. */
	public static final String VERSION = "version";

	/** The Constant OS_VERSION. */
	public static final String OS_VERSION = "os_version";

	/** The Constant CHROME. */
	public static final String CHROME = "CHROME";

	/** The Constant IE. */
	public static final String IE = "IE";

	/** The Constant OR_ACTUAL_TITLE. */
	/*
	 * -------------------------------------------------------------- REPORTING
	 * CONSTANTS --------------------------------------------------------------
	 */
	public static final String OR_ACTUAL_TITLE = "Actual Title: ";

	/** The Constant OR_START_FONT_TAG. */
	public static final String OR_START_FONT_TAG = "<font color=";

	/** The Constant OR_END_FONT_TAG. */
	public static final String OR_END_FONT_TAG = "</font>";

	/*
	 * -------------------------------------------------------------------------
	 * LOCATORS --------------------------------------------------------------
	 */

	/** The Constant DRIVER_TIME_OUT. */
	/* Base Page */
	public static final int DRIVER_TIME_OUT = 50;

	/** The Constant OR_ALLTOPICCARDSCOUNT. */
	public static final String OR_ALLTOPICCARDSCOUNT = "h2";

	public static final String OR_VIEW_ALL_COMPLETED_ITEMS_COMPONENT = "/html/body/section/div/div/div[2]/div[2]";

	public static final String OR_MY_PLAN_PAGE_URL_EXPECTED_TEXT = "my-list";

	public static final String OR_CONTENTTILES_COUNT = "h3";

	public static final String OR_VIEW_ALL_COMPLETED = "View All Completed";

	// public static final String
	// OR_DATE_FORMAT_COMPLETEDITEMS="//span[contains(text(),'Done on')]";
	public static final String OR_DATE_FORMAT_COMPLETEDITEMS = "//li/div/div/span[2]";

	public static final String OR_CONTENTTILES_COMPONENTONE_DETAILS = "//body[contains(@class,'sharp-js-authenticated-home')]//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div//div[contains(@class,'backgroundParsys')]//section[contains(@class,'sharp-c-background--center')]//div[contains(@class,'sharp-o-container__body sharp-c-background-content')]//div//div[contains(@class,'grid')]//div[1]//div[1]//div[1]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENTTWO_DETAILS = "//body[contains(@class,'sharp-js-authenticated-home')]//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div//div[contains(@class,'backgroundParsys')]//section[contains(@class,'sharp-c-background--center')]//div[contains(@class,'sharp-o-container__body sharp-c-background-content')]//div//div[contains(@class,'grid')]//div[2]//div[1]//div[1]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENTTHREE_DETAILS = "//body[contains(@class,'sharp-js-authenticated-home')]//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div//div[contains(@class,'backgroundParsys')]//section[contains(@class,'sharp-c-background--center')]//div[contains(@class,'sharp-o-container__body sharp-c-background-content')]//div//div[contains(@class,'grid')]//div[3]//div[1]//div[1]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENT = "/html/body/section/div/div[4]/section/div/div/div[2]";
	// "//div//div[4]//section[1]//div[1]//div[1]//div[1]//section[1]";
	// "//div[@class='topicCards section']";
	// "//*[@id=\"_content_staying-sharp_en_home_authenticated_jcr_content_par_backgroundparsys_1828581543_bg-parsys_default\"]/div";

	/** The Constant OR_ALLTOPICCARDS. */
	public static final String OR_ALLTOPICCARDS = "//div[contains(@class,'sharp-o-flex-blocks--tiles@laptop-large')]";

	/** The Constant OR_ACTIVITIES. */
	public static final String OR_ACTIVITIES = "//h2[contains(text(),'Activities')]";

	/** The Constant OR_ARTICILES. */
	public static final String OR_ARTICILES = "//h2[contains(text(),'Articles')]";

	/** The Constant OR_GAMES. */
	public static final String OR_GAMES = "//h2[contains(text(),'Games')]";

	/** The Constant OR_RECIPIES. */
	public static final String OR_RECIPIES = "//h2[contains(text(),'Recipes')]";

	/** The Constant OR_MYPLAN_TOPICCARD. */
	public static final String OR_MYPLAN_TOPICCARD = "//h2[contains(text(),'My Plan')]";

	/** Header locators. */
	/** The Constant OR_ARTICLES_IMAGES. */
	public static final String OR_ARTICLES_IMAGES = "//div[@role='img']";

	/** The Constant OR_ACTIVITIES_IMAGES. */
	public static final String OR_ACTIVITIES_IMAGES = "//div[@role='img']";

	/** The Constant OR_GAMES_IMAGES. */
	public static final String OR_GAMES_IMAGES = "//div[@role='img']";

	/** The Constant OR_RECIPES_IMAGES. */
	public static final String OR_RECIPES_IMAGES = "//div[@role='img']";

	/** The Constant OR_TOP_5_TOPICS_ARTICLES. */
	public static final String OR_TOP_5_TOPICS_ARTICLES = "//*[@id='staying-sharp-recommendations-articles-top-5']/div/div";

	/** The Constant OR_TOP_5_TOPICS_ACTIVITES. */
	public static final String OR_TOP_5_TOPICS_ACTIVITES = "//*[@id='staying-sharp-recommendations-activities-top-5']/div/div";

	/** The Constant OR_TOP_5_TOPICS_GAMES. */
	public static final String OR_TOP_5_TOPICS_GAMES = "//*[@id='staying-sharp-recommendations-games-top-5']/div/div";

	/** The Constant OR_TOP_5_TOPICS_RECIPES. */
	public static final String OR_TOP_5_TOPICS_RECIPES = "//*[@id='staying-sharp-recommendations-recipes-top-5']/div/div";

	/** The Constant OR_TOP_5_TOPICS_ALL_CATEGORIES. */
	public static final String OR_TOP_5_TOPICS_ALL_CATEGORIES = "//*[@id='staying-sharp-recommendations-all-categories-top-5']/div/div";

	/** The Constant OR_WHAT_IS_STAYING_SHARP. */
	public static final String OR_WHAT_IS_STAYING_SHARP = "//a[contains(text(), 'What is Staying Sharp?')]";

	/** The Constant OR_WHAT_DO_I_GET. */
	public static final String OR_WHAT_DO_I_GET = "//a[contains(text(), 'What Do I Get?')]";

	/** The Constant OR_OUR_APPROACH. */
	public static final String OR_OUR_APPROACH = "//a[contains(text(), 'Our Approach')]";

	public static final String OR_THE_SCIENCE = "//a[contains(text(), 'The Science')]";

	public static final String OR_GET_STARTED_BUTTON = "//html/body/header/div[1]/section/div[3]/ul/li[4]/a";

	/** The Constant OR_PRICING_LINK. */
	public static final String OR_PRICING_LINK = "Pricing";

	/** The Constant OR_ARTICLES_LINK. */
	public static final String OR_ARTICLES_LINK = "//html/body/header/div[2]/div/div/section/div[3]/ul[1]/li[15]/a";

	/** The Constant OR_ACTIVITIES_LINK. */
	public static final String OR_ACTIVITIES_LINK = "//html/body/header/div[2]/div/div/section/div[3]/ul[1]/li[16]/a";

	/** The Constant OR_GAMES_LINK. */
	public static final String OR_GAMES_LINK = "//html/body/header/div[2]/div/div/section/div[3]/ul[1]/li[17]/a";

	/** The Constant OR_RECIPES_LINK. */
	public static final String OR_RECIPES_LINK = "//html/body/header/div[2]/div/div/section/div[3]/ul[1]/li[18]/a";

	/** The Constant OR_ASSESSMENT_RESULTS_LINK. */
	public static final String OR_ASSESSMENT_RESULTS_LINK = "//html/body/header/div[2]/div/div/section/div[3]/ul[1]/li[19]/a";

	/** The Constant OR_RECOMMENDATIONS_LINK. */
	public static final String OR_RECOMMENDATIONS_LINK = "//html/body/header/div[2]/div/div/section/div[3]/ul[1]/li[20]/a";

	/** The Constant OR_MY_PLAN_LINK. */
	public static final String OR_MY_PLAN_LINK = "//html/body/header/div[2]/div/div/section/div[3]/ul[1]/li[21]/a";

	/** The Constant OR_VIEW_RECOMMENDATIONS_BUTTON. */
	public static final String OR_VIEW_RECOMMENDATIONS_BUTTON = "//a[contains(text(), 'View Recommendations')]";

	public static final String OR_LIFESTYLE_RECEIVED_MARKS = "//*[@id='received-marks-lifestyle']";

	public static final String OR_COGNITIVE_RECEIVED_MARKS = "//*[@id='received-marks-cognitive']";

	public static final String OR_MOVE_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/label[1]";

	public static final String OR_DISCOVER_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/label[2]";

	public static final String OR_RELAX_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/label[3]";

	public static final String OR_NOURISH_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/label[4]";

	public static final String OR_CONNECT_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/label[5]";

	public static final String OR_MOVE_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/div[1]/div/div[1]/section/div/span[2]/span[1]";

	public static final String OR_DISCOVER_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/div[2]/div/div[1]/section/div/span[2]/span[1]";

	public static final String OR_RELAX_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/div[3]/div/div[1]/section/div/span[2]/span[1]";

	public static final String OR_NOURISH_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/div[4]/div/div[1]/section/div/span[2]/span[1]";

	public static final String OR_CONNECT_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/div[5]/div/div[1]/section/div/span[2]/span[1]";

	public static final String OR_PROCESSING_SPEED_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/label[1]";

	public static final String OR_SUSTAINED_ATTENTION_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/label[2]";

	public static final String OR_WORKING_MEMORY_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/label[3]";

	public static final String OR_COGNITIVE_FLEXIBILITY_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/label[4]";

	public static final String OR_RECOGNITION_MEMORY_TAB = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/label[5]";

	public static final String OR_PROCESSING_SPEED_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/div[1]/div/div[1]/section/div/span[2]/span[1]";

	public static final String OR_SUSTAINED_ATTENTION_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/div[2]/div/div[1]/section/div/span[2]/span[1]";

	public static final String OR_WORKING_MEMORY_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/div[3]/div/div[1]/section/div/span[2]/span[1]";

	public static final String OR_COGNITIVE_FLEXIBILITY_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/div[4]/div/div[1]/section/div/span[2]/span[1]";

	public static final String OR_RECOGNITION_MEMORY_SCORE = "//html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/div[5]/div/div[1]/section/div/span[2]/span[1]";

	// public static final String OR_START_ASSESSMENT = "//a[contains(text(),
	// 'Start Assessment')]";

	public static final String OR_ASSESSMENT_BUTTON = "//html/body/section/div/div[1]/section/div/div/div/div/div[1]/div/div[2]/div/div/div/div/div/a";

	// public static final String OR_CONTINUE_ASSESSMENT = "//a[contains(text(),
	// 'Continue Assessment')]";

	public static final String OR_CONFIRM_BUTTON = "//button[@type='submit']";

	public static final String OR_WELCOME_BACK = "//h1[contains(text(), 'Welcome Back')]";

	public static final String OR_NO = "//button[contains(text(), 'No')]";

	public static final String OR_PERSONAL_DETAILS_TEXT = "//*[@id=\"app\"]/div/div/form/div[1]/fieldset/h1";

	public static final String OR_YEAR_OF_BIRTH = "yob";

	public static final String OR_YEAR_OF_EDUCATION = "edu";

	public static final String OR_SELECT_FEMALE_GENDER = "//div[contains(text(),'Female')]";

	public static final String OR_SELECT_MALE_GENDER = "//div[contains(text(),'Male')]";

	public static final String OR_SELECT_LEFT_DOMINANT_HAND = "//div[contains(text(),'Left')]";

	public static final String OR_SELECT_RIGHT_DOMINANT_HAND = "//div[contains(text(),'Right')]";

	public static final String OR_CHOICE_REACTION_TIME_SPEED_TEXT = "//*[@id='app']/div/div/div/h1";

	public static final String OR_START_BUTTON_CHOICE_REACTION_TIME_SPEED = "//*[@id='app']/div/div/div/button";

	public static final String OR_MEMORY_RECOGNITION_PART_1_TEXT = "//*[@id='app']/div/div/div/h1";

	public static final String OR_START_BUTTON_MEMORY_RECOGNITION_PART_1 = "//*[@id='app']/div/div/div/button";

	public static final String OR_GET_READY_TEXT = "//*[@id='app']/div/div/div/h1";

	public static final String OR_START_BUTTON_GET_READY = "//*[@id='app']/div/div/div/button";

	public static final String OR_MEMORY_RECOGNITION_PART_2_TEXT = "//*[@id='app']/div/div/div/h1";

	public static final String OR_START_BUTTON_MEMORY_RECOGNITION_PART_2 = "//*[@id='app']/div/div/div/button";

	public static final String OR_CONTINUOUS_PERFORMANCE_TEXT = "//*[@id='app']/div/div/div/h1";

	public static final String OR_CONTINUOUS_PERFORMANCE = "//*[@id='app']/div/div/div/button";

	public static final String OR_DIGIT_SPAN_TEXT = "//*[@id='app']/div/div/div/h1";

	public static final String OR_DIGIT_SPAN = "//*[@id='app']/div/div/div/button";

	public static final String OR_SWITCHING_ATTENTION_TEXT = "//*[@id='app']/div/div/div/h1";

	public static final String OR_SWITCHING_ATTENTION = "//*[@id='app']/div/div/div/button";

	public static final String OR_MEMORY_RECOGNITION_PART_3_TEXT = "//*[@id='app']/div/div/div/h1";

	public static final String OR_WELLDONE_TEXT_ASSESSMENT_QUESTIONNAIRE_START_TEXT = "//*[@id='_content_staying-sharp_en_home_assessment_lifestyle-questionnaire_start_jcr_content_par_backgroundparsys_cop_bg-parsys_alignment_align-parsys_textimage_copy']/div/main/article/p[2]/span";

	public static final String OR_WELLDONE_TEXT_ASSESSMENT_QUESTIONNAIRE_START_BUTTON = "//*[@id='_content_staying-sharp_en_home_assessment_lifestyle-questionnaire_start_jcr_content_par_backgroundparsys_cop_bg-parsys_alignment_align-parsys_textimage_copy']/div/main/article/p[4]/a";

	public static final String OR_DATE = "div.sharp-o-dropdown.sharp-c-timestamp__dropdown > span.sharp-o-dropdown__select.sharp-c-timestamp__dropdown-select.sharp-u-border-radius";

	public static final String OR_MOVEQUESTION_PART1 = "//*[@id='sharp-c-lifestyle-questionaire__form']/ul/li[";

	public static final String OR_MOVEQUESTION_PART2 = "]/p";

	public static final String OR_MOVEQUESTIONS_OPTION_PART1 = "//*[@id='sharp-c-lifestyle-questionaire__form']/ul/li[";

	public static final String OR_MOVEQUESTIONS_OPTION_PART2 = "]/label[";

	public static final String OR_MOVEQUESTIONS_OPTION_PART3 = "]/span";

	public static final String OR_MOVEQUESTIONS_OPTION1_PART1_TEXT = "//*[@id='sharp-c-lifestyle-questionaire__form']/ul/li[";

	public static final String OR_MOVEQUESTIONS_OPTION1_PART2_TEXT = "]/label[";

	public static final String OR_MOVEQUESTIONS_OPTION1_PART3_TEXT = "]";

	public static final String OR_MOVEQUESTIONS_CONTINUE_BUTTON = "//*[@id='sharp-c-lifestyle-questionaire__form']/button[2]";

	public static final String OR_MEMORY_RECOGNITION_PART_3 = "//*[@id='app']/div/div/div/button";

	public static final String OR_WELL_DONE = "//span[@class='sharp-u-typography--double-pica-itp sharp-u-color--utility-mine-shaft']";

	/** The Constant OR_VIEW_ALL_TOPICS. */
	public static final String OR_VIEW_ALL_TOPICS = "View All Topics";

	/** The Constant OR_HOW_TO_GET_STARTED. */
	public static final String OR_HOW_TO_GET_STARTED = "a.sharp-c-button.sharp-js-lightbox-videoPlayer";

	/** The Constant OR_HOW_TO_GET_STARTED_VIDEO_CLOSE_BUTTON. */
	public static final String OR_HOW_TO_GET_STARTED_VIDEO_CLOSE_BUTTON = "//a[contains(@class,'aarp-c-modal__close-button sharp-c-lightbox__close-button')]";

	/** The Constant OR_VIDEO_PLAY_BUTTON. */
	public static final String OR_VIDEO_PLAY_BUTTON = "//*[@id='brightcove-player']/button";

	public static final String OR_TAKE_VIDEO_TOUR_CLOSE_BUTTON = "//a[contains(@class,'aarp-c-modal__close-button sharp-c-lightbox__close-button')]";

	/** Footer locators. */
	/** The Constant OR_WHAT_IS_STAYING_SHARP_FOOTER_LINK. */
	public static final String OR_WHAT_IS_STAYING_SHARP_FOOTER_LINK = "a.sharp-c-inline-nav__item";

	/** The Constant OR_HELP_FOOTER_LINK. */
	public static final String OR_HELP_FOOTER_LINK = ".sharp-o-list-inline__item:nth-child(2) > .sharp-c-inline-nav__item";

	/** The Constant OR_FAQ_FOOTER_LINK. */
	public static final String OR_FAQ_FOOTER_LINK = "FAQ";

	/** The Constant OR_SYSTEM_REQUIREMENTS_FOOTER_LINK. */
	public static final String OR_SYSTEM_REQUIREMENTS_FOOTER_LINK = "System Requirements";

	/** The Constant OR_RELEASE_NOTES_FOOTER_LINK. */
	public static final String OR_RELEASE_NOTES_FOOTER_LINK = "Release Notes";

	/** The Constant OR_PRIVACY_POLICY_FOOTER_LINK. */
	public static final String OR_PRIVACY_POLICY_FOOTER_LINK = "Privacy Policy";

	/** The Constant OR_TERMS_OF_SERVICE_FOOTER_LINK. */
	public static final String OR_TERMS_OF_SERVICE_FOOTER_LINK = "Terms of Service";

	/** The Constant OR_FOOTER. */
	/* HomePage */

	public static final String OR_LOGO = ".sharp-c-header__logo";

	/** The Constant OR_FOOTER. */
	public static final String OR_FOOTER = "//html/body/footer";

	/** The Constant OR_SEARCH_ICON. */
	public static final String OR_SEARCH_ICON = ".sharp-js-search-trigger";

	/** The Constant OR_SEARCH_FIELD. */
	public static final String OR_SEARCH_FIELD = "input[name='search']";

	/** The Constant OR_SEARCH. */
	public static final String OR_SEARCH = "input.sharp-c-search-menu__submit.sharp-js-search-menu__submit";

	/** The Constant OR_ASSESSMENT_RESULTS_HEADER1. */
	public static final String OR_ASSESSMENT_RESULTS_HEADER1 = "//span[contains(text(), 'Your Brain Health Report')]";

	/** The Constant OR_ASSESSMENT_RESULTS_HEADER2. */
	public static final String OR_ASSESSMENT_RESULTS_HEADER2 = "//b[contains(text(), 'What We Measure')]";

	/** The Constant OR_ASSESSMENT_RESULTS_HEADER3. */
	public static final String OR_ASSESSMENT_RESULTS_HEADER3 = "//h3[contains(text(), 'Your Brain Health Score')]";

	/** The Constant OR_LIFESTYLE_TAB. */
	public static final String OR_LIFESTYLE_TAB = "//div[contains(text(), 'Lifestyle')]";

	/** The Constant OR_TABS_OF_LIFESTYLE. */
	public static final String OR_TABS_OF_LIFESTYLE = "//html/body/section/div/div[4]/section/div/div/div/div/div[1]/div/section/label";

	/** The Constant OR_COGNITIVE_TAB. */
	public static final String OR_COGNITIVE_TAB = "//div[contains(text(), 'Cognitive')]";

	/** The Constant OR_TABS_OF_COGNITIVE. */
	public static final String OR_TABS_OF_COGNITIVE = "/html/body/section/div/div[4]/section/div/div/div/div/div[2]/div/section/label";

	/** The Constant OR_LOGIN_LINK. */
	public static final String OR_LOGIN_LINK = "Login";

	public static final String OR_TAKE_VIDEO_TOUR = "Take Video Tour";

	/** The Constant OR_LOGIN_BUTTON. */
	public static final String OR_LOGIN_BUTTON = "//a[@class='sharp-c-button sharp-c-link'][contains(text(),'Login')]";

	/** The Constant OR_BUYNOW_LINK. */
	public static final String OR_BUYNOW_LINK = "//a[@class='sharp-c-link'][contains(text(),'Buy Staying Sharp for $35.99')]";

	/** The Constant OR_GET_STARTED. */
	public static final String OR_GET_STARTED = "//*[@id='_content_staying-sharp_en_home_jcr_content_par_backgroundparsys_bg-parsys_alignment_align-parsys_button']/div/a";

	/** The Constant OR_CREATE_AN_ACCOUNT. */
	/* Pricing Page */
	public static final String OR_CREATE_AN_ACCOUNT = "//a[contains(text(), 'Create an account')]";

	/** The Constant OR_REG_EMAIL. */
	/* Registration Page */
	public static final String OR_REG_EMAIL = "registeremail"; // ID

	/** The Constant OR_REG_CONFIRM_EMAIL. */
	public static final String OR_REG_CONFIRM_EMAIL = "emailConfirm"; // ID

	/** The Constant OR_REG_PASSWORD. */
	public static final String OR_REG_PASS = "password";

	/** The Constant OR_REG_FIRSTNAME. */
	public static final String OR_REG_FIRSTNAME = "firstName"; // ID

	/** The Constant OR_REG_LASTNAME. */
	public static final String OR_REG_LASTNAME = "lastName"; // ID

	/** The Constant OR_REG_COUNTRY. */
	public static final String OR_REG_COUNTRY = "country"; // ID SENDKEYS USA

	/** The Constant OR_REG_ZIPCODE. */
	public static final String OR_REG_ZIPCODE = "postalCode"; // ID

	/** The Constant OR_REG_DOB_MONTH. */
	public static final String OR_REG_DOB_MONTH = "dob_month"; // ID SENDKEYS

	/** The Constant OR_REG_DOB_DATE. */
	public static final String OR_REG_DOB_DATE = "dob_date"; // ID SENDKEYS

	/** The Constant OR_REG_DOB_YEAR. */
	public static final String OR_REG_DOB_YEAR = "dob_year"; // ID SENDKEYS

	/** The Constant OR_REG_AGREE. */
	public static final String OR_REG_AGREE = "tos";

	/** The Constant OR_REG_BUTTON. */
	public static final String OR_REG_BUTTON = "submit-btn";

	/** The Constant OR_EMAIL. */
	/* Login Page */
	public static final String OR_EMAIL = "email";

	/** The Constant OR_PASSWORD. */
	public static final String OR_PASS = "password";

	public static final String OR_CAPTCHA = "nucaptcha-answer";

	/** The Constant OR_LOGIN_BTN. */
	public static final String OR_LOGIN_BTN = "btn-login";

	public static final String OR_ALERT_CLOSE = "//html/body/footer/section/div/div[2]/div/a";

	public static final String OR_PRIVACY_POLICY = "//a[contains(text(), 'Privacy Policy')]";

	public static final String OR_PRIVACY_POLICY_EXPECTED_TITLE = "Our Privacy Policy, Your Privacy Rights";

	public static final String OR_TERMS_OF_SERVICE = "Terms of Services";

	public static final String OR_TERMS_OF_SERVICE_EXPECTED_TITLE = "AARP Terms of Service";

	public static final String OR_COPYRIGHT_INFO = "Copyright Information";

	public static final String OR_COPYRIGHT_EXPECTED_TITLE = "AARP Website Copyright Information";

	public static final String OR_HELP = "Help";

	public static final String OR_HELP_EXPECTED_TITLE = "AARP Help";

	/** The Constant OR_LOGIN_BTN. */
	public static final String OR_LOGOUT = "Logout";

	/** The Constant OR_LOGIN_MESSAGE. */
	public static final String OR_LOGIN_MESSAGE = "welcome-heading";

	/** The Constant OR_CONTENTTILECOMPONENTS_COUNT. */
	/* Recommendations page */
	public static final String OR_CONTENTTILECOMPONENTS_COUNT = "//span[contains(@class,'sharp-c-pillar-name sharp-c-pillar-name@tablet sharp-js-pillar-name')]";

	/** The Constant OR_TOP_5_TOPICS_ACTIVITIES. */
	public static final String OR_TOP_5_TOPICS_ACTIVITIES = "//div[@class='sharp-c-top-5-topics']";

	/** The Constant OR_ACTIVITIES. */

	public static final String OR_ACTIVITYDETAILSPAGE_COMPONENT = "//*[@id='outbrain_widget_0']/div";

	/** The Constant OR_ACTIVITYDETAILSPAGE_COMPONENT_LINKS. */
	public static final String OR_ACTIVITYDETAILSPAGE_COMPONENT_LINKS = "//*[@id='outbrain_widget_0']/div/div[1]/ul/li/a";

	/** The Constant OR_GAMES. */

	public static final String OR_GAMEDETAILSPAGE_COMPONENT = "//*[@id='outbrain_widget_0']/div";

	/** The Constant OR_GAMEDETAILSPAGE_COMPONENT_LINKS. */
	public static final String OR_GAMEDETAILSPAGE_COMPONENT_LINKS = "//*[@id='outbrain_widget_0']/div/div[1]/ul/li/a";

	/** The Constant OR_RECIPES. */

	public static final String OR_RECIPEDETAILSPAGE_COMPONENT = "//*[@id='outbrain_widget_0']/div";

	/** The Constant OR_RECIPEDETAILSPAGE_COMPONENT_LINKS. */
	public static final String OR_RECIPEDETAILSPAGE_COMPONENT_LINKS = "//*[@id='outbrain_widget_0']/div/div[1]/ul/li/a";

	/** The Constant OR_HI_USER. */
	/* Dashboard Page */
	public static final String OR_HI_USER = "//html/body/header/div[2]/div/div/section/div[3]/ul[2]/li[1]/a";
	// "//a[@title='hi user']/span[2]";

	/** The Constant OR_MY_ACCOUNT. */
	public static final String OR_MY_ACCOUNT = "My Account";

	/** The Constant OR_FAQS. */
	public static final String OR_FAQS = "FAQs";

	/** The Constant OR_AARP_DOT_ORG. */
	public static final String OR_AARP_DOT_ORG = "AARP.org";

	/** The Constant OR_AARP_DOT_ORG_TITLE. */
	public static final String OR_AARP_DOT_ORG_TITLE = "AARP® Official Site - Join & Explore the Benefits";

	/** The Constant OR_ARTICLES. */
	public static final String OR_ARTICLES = "Articles";

	/** The Constant OR_ARTICLEDETAILSPAGE_COMPONENT. */
	public static final String OR_ARTICLEDETAILSPAGE_COMPONENT = "//*[@id='outbrain_widget_0']/div";

	/** The Constant OR_ARTICLEDETAILSPAGE_COMPONENT_LINKS. */
	public static final String OR_ARTICLEDETAILSPAGE_COMPONENT_LINKS = "//*[@id='outbrain_widget_0']/div/div[1]/ul/li/a";

	/** The Constant OR_ARTICLE_NAME. */
	public static final String OR_ARTICLE_NAME = "6 Types of Normal Memory Lapses and Why You Needn't Worry About Them";

	/** The Constant OR_ARTICLE. */
	public static final String OR_ARTICLE = "//*[@id='staying-sharp-recommendations-articles-top-5']/div/div/ul/li[1]/a";

	/** The Constant OR_ACTIVITY. */
	public static final String OR_ACTIVITY = "//*[@id='staying-sharp-recommendations-activities-top-5']/div/div/ul/li[1]/a";

	/** The Constant OR_GAME. */
	public static final String OR_GAME = "//*[@id='staying-sharp-recommendations-games-top-5']/div/div/ul/li[1]/a";

	/** The Constant OR_RECIPE. */
	public static final String OR_RECIPE = "//*[@id='staying-sharp-recommendations-recipes-top-5']/div/div/ul/li[1]/a";
	/** The Constant OR_ADDTOPLAN. */
	public static final String OR_ADDTOPLAN = "//span[contains(text(), 'Add to plan')]";

	/** The Constant OR_ADDTOPLAN_OPTIONS. */
	public static final String OR_ADDTOPLAN_OPTIONS = ".sharp-c-list-button__text";

	/** The Constant OR_REMOVE_FROM_PLAN. */
	public static final String OR_REMOVE_FROM_PLAN = "//html/body/section/div/section/aside/div/div/div[1]/div[2]/ul/li[3]";

	public static final String OR_REMOVE_FROM_PLAN_WHEN_ADDED = ".sharp-c-list-button__menu-list__content:nth-child(3)";

	/** The Constant OR_ADDTOPLAN_DROPDOWN. */
	public static final String OR_ADDTOPLAN_DROPDOWN = ".sharp-c-list-button__dropdown-icon";
	/** The Constant OR_ADDTOPLAN_OPTION. */
	public static final String OR_ADDTOPLAN_OPTION = "//li[contains(text(), 'Add to plan')]";

	/** The Constant OR_ADD_BUTTON. */
	public static final String OR_ADD_BUTTON = ".sharp-c-list-button__menu-list__content:nth-child(1)";

	/** The Constant OR_TOP_5_TOPIC_LABEL. */
	public static final String OR_TOP_5_TOPIC_LABEL = "//h4[contains(text(), 'Top 5 Topics')]";

	/** The Constant OR_ARTICLES_BUTTON. */
	public static final String OR_ARTICLES_BUTTON = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/span";

	/** The Constant OR_ARTICLES_REMOVE. */
	public static final String OR_ARTICLES_REMOVE = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/ul/li[2]";

	public static final String OR_ARTICLES_COMPLETE = "//ul[contains(@class,'sharp-c-content-tile__menu-list sharp-c-content-tile__menu-list--open sharp-js-content-tile__menu-list sharp-u-box-shadow')]//li[3]";

	/** The Constant OR_ARTICLES_ADD. */
	public static final String OR_ARTICLES_ADD = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/ul/li[1]";

	/** The Constant OR_FIRST_ARTICLE. */
	public static final String OR_FIRST_ARTICLE = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[2]/div/h3";

	/** The Constant OR_ADDEDTOPLAN. */
	public static final String OR_ADDEDTOPLAN = "//span[contains(text(), 'Added to plan')]";

	/** The Constant OR_ISARTICLEADDED. */
	public static final String OR_ISARTICLEADDED = "//html/body/section/div/section/aside/div/div/div[1]/div[2]/div/span[2]";

	/** The Constant OR_ACTIVITIES_BUTTON. */
	public static final String OR_ACTIVITIES_BUTTON = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/span";

	/** The Constant OR_ACTIVITIES_REMOVE. */
	public static final String OR_ACTIVITIES_REMOVE = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/ul/li[2]";

	/** The Constant OR_ACTIVITIES_ADD. */
	public static final String OR_ACTIVITIES_ADD = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/ul/li[1]";

	/** The Constant OR_FIRST_ACTIVITY. */
	public static final String OR_FIRST_ACTIVITY = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[2]/div/h3";

	public static final String OR_ACTIVITIES_COMPLETE = "//ul[contains(@class,'sharp-c-content-tile__menu-list sharp-c-content-tile__menu-list--open sharp-js-content-tile__menu-list sharp-u-box-shadow')]//li[3]";

	/** The Constant OR_ISACTIVITYADDED. */
	public static final String OR_ISACTIVITYADDED = "//html/body/section/div/section/aside/div/div/div[1]/div[2]/div/span[2]";

	/** The Constant OR_GAMES_BUTTON. */
	public static final String OR_GAMES_BUTTON = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/span";

	/** The Constant OR_GAMES_REMOVE. */
	public static final String OR_GAMES_REMOVE = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/ul/li[2]";

	/** The Constant OR_GAMES_ADD. */
	public static final String OR_GAMES_ADD = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/ul/li[1]";

	/** The Constant OR_FIRST_GAME. */
	public static final String OR_FIRST_GAME = "html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[2]/div/h3";

	/** The Constant OR_ISGAMEADDED. */
	public static final String OR_ISGAMEADDED = "//html/body/section/div/section/aside/div/div/div[1]/div[2]/div/span[2]";

	public static final String OR_GAMES_COMPLETE = "//html/body/section/div/div[2]/section/div/div/div/section/div/div/div/section/div/div/div/section/div/div/div/a/div/div[2]/ul/li[3]";

	/** The Constant OR_RECIPES_BUTTON. */
	public static final String OR_RECIPES_BUTTON = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/span";

	/** The Constant OR_RECIPES_REMOVE. */
	public static final String OR_RECIPES_REMOVE = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/ul/li[2]";

	/** The Constant OR_RECIPES_ADD. */
	public static final String OR_RECIPES_ADD = "//html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[1]/div[2]/ul/li[1]";

	/** The Constant OR_FIRST_RECIPE. */
	public static final String OR_FIRST_RECIPE = "html/body/section/div/div[2]/section/div/div/div/section/div[1]/div/div/section/div[2]/div/div/section/div[1]/div/div/a/div[2]/div/h3";

	public static final String OR_RECIPES_COMPLETE = "//html/body/section/div/div[2]/section/div/div/div/section/div/div/div/section/div[2]/div/div/section/div/div/div/a/div/div[2]/ul/li[3]";

	public static final String OR_COMPLETE_FROM_PLAN_DROP_DOWN_OPTION = "//html/body/section/div/section/aside/div/div/div/div[2]/ul/li[4]";
	/** The Constant OR_ISRECIPEADDED. */
	public static final String OR_ISRECIPEADDED = "//html/body/section/div/section/aside/div/div/div[1]/div[2]/div/span[2]";

	/** The Constant OR_ADD_TO_PLAN_DROP_DOWN. */
	public static final String OR_ADD_TO_PLAN_DROP_DOWN = "//html/body/section/div/section/aside/div/div/div[1]/div[2]/div/span[3]/i";

	/** The Constant OR_ADD_TO_PLAN_DROP_DOWN_OPTION. */
	public static final String OR_ADD_TO_PLAN_DROP_DOWN_OPTION = "//html/body/section/div/section/aside/div/div/div[1]/div[2]/ul/li[1]";

	/** The Constant OR_ADD_BACK_TO_PLAN_DROP_DOWN_OPTION. */
	public static final String OR_ADD_BACK_TO_PLAN_DROP_DOWN_OPTION = "//html/body/section/div/section/aside/div/div/div[1]/div[2]/ul/li[2]";
	/** The Constant OR_REMOVEFROMPLAN. */
	public static final String OR_REMOVEFROMPLAN = "//div/div[2]/ul/li[3]";

	/** The Constant OR_MYPLAN. */
	public static final String OR_MYPLAN = "My Plan";

	/** The Constant OR_PRICING. */
	public static final String OR_PRICING = "Pricing";

	/** The Constant OR_JOINNOW. */
	public static final String OR_JOINNOW = "Join AARP Now for $16";

	/** The Constant OR_ADDRESS1. */
	public static final String OR_ADDRESS1 = "street_number";

	/** The Constant OR_ADDRESS2. */
	public static final String OR_ADDRESS2 = "route";

	/** The Constant OR_CITY. */
	public static final String OR_CITY = "locality";

	/** The Constant OR_STATE. */
	public static final String OR_STATE = "administrative_area_level_1";

	/** The Constant OR_ZIPCODE. */
	public static final String OR_ZIPCODE = "postal_code";

	/** The Constant OR_TERMS_AND_CONDITIONS. */
	public static final String OR_TERMS_AND_CONDITIONS = "ar-terms-and-conditions-checkbox";

	/** The Constant OR_CONTINUE_TO_BILLING_BTN. */
	public static final String OR_CONTINUE_TO_BILLING_BTN = "Continue to billing";

	/** The Constant OR_CARDNUMBER. */
	public static final String OR_CARDNUMBER = "cardNumber";

	/** The Constant OR_CVV. */
	public static final String OR_CVV = "cvvCode";

	/** The Constant OR_EXPDATE. */
	public static final String OR_EXPDATE = "expDate";

	/** The Constant OR_JOIN. */
	public static final String OR_JOIN = "//*[@id='mem-billing-form']/span[1]";

	/** The Constant OR_REGISTRATIONPAGE_TEXT. */
	public static final String OR_REGISTRATIONPAGE_TEXT = "//*[@id='heading']/h1";

	/** The Constant OR_LOGINPAGE_TEXT. */
	public static final String OR_LOGINPAGE_TEXT = "//h1[@class='welcome-heading']";

	/** The Constant OR_JOINAARPPAGE_TEXT. */
	public static final String OR_JOINAARPPAGE_TEXT = "//h1[@class='form-head']";

	public static final String OR_CONTENTTILES_COMPONENT_ONE_DETAILS_RECOMMENDATIONSPAGE = "//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div[2]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENT_TWO_DETAILS_RECOMMENDATIONSPAGE = "//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div[2]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[2]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENT_THREE_DETAILS_RECOMMENDATIONSPAGE = "//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div[2]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[3]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENT_FOUR_DETAILS_RECOMMENDATIONSPAGE = "//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div[3]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENT_FIVE_DETAILS_RECOMMENDATIONSPAGE = "//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div[3]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[2]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENT_SIX_DETAILS_RECOMMENDATIONSPAGE = "//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div[3]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[3]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENT_SEVEN_DETAILS_RECOMMENDATIONSPAGE = "//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div[4]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENT_EIGHT_DETAILS_RECOMMENDATIONSPAGE = "//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div[4]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[2]//a[1]//div[2]//div";

	public static final String OR_CONTENTTILES_COMPONENT_NINE_DETAILS_RECOMMENDATIONSPAGE = "//section[contains(@class,'sharp-c-landing-page-container sharp-c-landing-page-container@desktop')]//div[4]//section[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[3]//a[1]//div[2]//div";

	/** Pagination constants */

	public static final String OR_PAGINATION = "//div[@class='pagination']/section/div[1]/div/a";

	// ** Next button in pagination btn_next */
	public static final String OR_NEXT_BUTTON = "//a[@id='btn_next']";

	// btn_prev */
	public static final String OR_PREVIOUS_BUTTON = "//a[@id='btn_prev']";

	// 2nd Link */
	public static final String OR_SECONDLINK = "//a[contains(text(),'2')]";

	public static final String OR_SECONDLINK_ACTIVE = "//a[@class='sharp-c-pagination__pagination-anchor sharp-js-pagination__pagination-anchor sharp-c-pagination__pagination-anchor@mobile sharp-c-pagination__pagination-anchor@tablet sharp-c-pagination__pagination-anchor@laptop-large sharp-c-pagination__pagination-anchor--active']";

	public static final String OR_ACTIVITIES_PRINT = "//button[@title='print']";

	public static final String OR_MARKALLCOMPLETE_LINK = "Mark All Complete";

	public static final String OR_WELLDONE_TEXT = "//*[@id='_content_staying-sharp_en_home_my-list_jcr_content_par_mylist_empty-list-parsys_textimage']/div/main/article/p[4]/span/b";

	public static final String OR_PART1OF2_TEXT = "//*[@id='_content_staying-sharp_en_home_assessment_lifestyle-questionnaire_start_jcr_content_par_backgroundparsys_cop_bg-parsys_alignment_align-parsys_textimage_copy']/div/main/article/p[2]/span";
	public static final String OR_PART1OF2_DESCRIPTION = "//*[@id='_content_staying-sharp_en_home_assessment_lifestyle-questionnaire_start_jcr_content_par_backgroundparsys_cop_bg-parsys_alignment_align-parsys_textimage_copy']/div/main/article/p[3]/span";

	public static final String OR_PART1OF2_START = "//*[@id='_content_staying-sharp_en_home_assessment_lifestyle-questionnaire_start_jcr_content_par_backgroundparsys_cop_bg-parsys_alignment_align-parsys_textimage_copy']/div/main/article/p[4]/a";

	public static final String WELLDONE_TEXT = "Well done, you completed your plan!";

	public static final String OR_DESCRIPTION_TEXT = "//*[@id='_content_staying-sharp_en_home_my-list_jcr_content_par_mylist_empty-list-parsys_textimage']/div/main/article/p[5]/span";

	public static final String DESCRIPTION_TEXT = "Feel free to add more articles, activities, recipes, videos and games to your plan.";

	public static final String OR_BROWSETOPICS_BUTTON = "//*[@id='_content_staying-sharp_en_home_my-list_jcr_content_par_mylist_empty-list-parsys_textimage']/div/main/article/p[6]/a";

	public static final String OR_GAMES_DECIPHERGAME_CLICK = "//div[@class='sharp-o-ratio__content']";

	public static final String OR_GAMES_THINKBALANCE_CLICK = "//div[@class='sharp-o-ratio__content']";

	public static final String RECIPE_LINK_TEXT = "Massaged Broccoli Rabe Salad";

	public static final String OR_EMAIL_ICON = "a.sharp-c-socialshare__button.sharp-c-socialshare__button-email";

	public static final String EMAIL_SCREENSHOTS = "\\src\\test\\resources\\lib\\emailScreenshots\\";

	public static final String OR_PRINT_ICON = "button.sharp-c-socialshare__button.sharp-c-socialshare__button-print";

	public static final String OR_ADDCOMMENT_BUTTON = "//span[@class='add-comment-text aarp-u-reset-color']";

	public static final String OR_ADDCOMMENT_TEXT = "//div[@role='textbox']";

	public static final String OR_COMMENTTEXT = "Automation Test Comment";

	public static final String OR_POSTCOMMENT = "//div[@class='goog-inline-block fyre-button-right-inner-box']";

	public static final String OR_ADDEDCOMMENT_TEXT = "//p[contains(text(),'Automation Test Comment')]";

	public static final String OR_DELETECOMMENT_BUTTON = "//a[@title='Delete']";

	public static final String OR_BUTTON_ASSESSMENT_PART1 = "//*[@id='app']/div/div/div/button[";

	public static final String OR_BUTTON_ASSESSMENT_PART2 = "]";

	/** Constants for Future */
	public static final String OR_ARTICLES_INVITE_FRIEND = "//html/body/div[1]/section/div/div/div[3]/a";

	public static final String OR_EMAIL_INPUT = "guideContainer-rootPanel-guidetextbox___widget";

	public static final String OR_NOTE_TEXT = "guideContainer-rootPanel-guidetextbox_360983998___widget";

	public static final String OR_SEND_INVITES_BUTTON = "guideContainer-rootPanel-submit___widget";

	public static final String OR_INVITE_FRIENDS_WELCOME_TEXT = "//html/body/section/div/div[2]/section/div/div/div/main/article/p[2]/span";

	public static final String OR_NO_RECOMMENDATIONS = "/html/body/section/div/div[5]/section/div/div/div/main/article/p[2]";

	public static final String OR_INVITE_FRIENDS_IMAGE = "/html/body/section/div/div[1]/section/div/div/div/div/div/div/section/div[2]/div/div/div/div/div/main/a/div[1]/div";

	public static final String OR_PERSONALIZE_RECOMMENDATIONS = "//b[contains(text(),'Personalized Recommendations')]";

	public static final String OR_VIEW_RECOMMENDATIONS = "//p[contains(text(),'View your Recommendations')]";

	public static final String OR_VIEW_RECOMMENDATIONS_TEXT = "//div[contains(@class,'sharp-o-aligner sharp-o-aligner--content sharp-o-aligner--left')]";

	public static final String OR_RECOMMENDATIONS_BUTTON = "//a[@class='sharp-c-button']";

	public static final String CHROME_PLATFORM = "Windows 10";
	public static final String CHROME_VERSION = "67.0";
	public static final String FIREFOX_PLATFORM = "Windows 10";
	public static final String FIREFOX_VERSION = "57.0";
	public static final String IE_PLATFORM = "Windows 7";
	public static final String SAUCE_USERNAME = "ram.pushpala";
	public static final String SAUCE_ACCESS_KEY = "b177d05e-599d-48d4-bb13-59df1b24b42c";
	public static final String SAUCE_URL = "http://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY
			+ "@ondemand.saucelabs.com:80/wd/hub";
	public static final String SAUCE_TAGS = "SauceTest";
	public static final String BROWSERSTACK_USERNAME = "techaspect2";
	public static final String BROWSERSTACK_ACCESS_KEY = "QRo4dhjzZ7CzopFGJKZH";
	public static final String BROWSERSTACK_URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	public static final String BROWSERSTACK_TAGS = "BrowserStackTest";
	public static final String BROWSERSTACK_OS = "Windows";
	public static final String BROWSERSTACK_OS_VERSION = "10";
	public static final String BROWSERSTACK_IE_VERSION = "17.0";
	public static final String BROWSERSTACK_NETWORK_LOGS = "browserstack.networkLogs";
	public static final String BROWSERSTACK_DEBUG = "browserstack.debug";
	public static final String BROWSERSTACK_LOCAL = "browserstack.local";
	public static final String BROWSERSTACK_LOCAL_VALUE_FALSE = "false";
	public static final String BROWSERSTACK_LOCAL_VALUE_TRUE = "true";
	public static final String SEETEST_USERNAME = "maruthip@techaspect.com";
	public static final String SEETEST_PASS = "Testing@123";
	public static final String SEETEST_ACCESS_KEY = "eyJ4cC51IjoxMDg2NDM3LCJ4cC5wIjoxMDg2NDM2LCJ4cC5tIjoiTVRVek16azVOemc0Tmprd09RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4NDkzNTc4ODgsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.L17fidN9BxB5dk1Le5LZn6XhDlvdeQeSYww03voDW80";
	public static final String SEETEST_CHROME_VERSION = "66";
	public static final String SEETEST_CHROME_PLATFORM = "WIN10";
	public static final String SEETEST_FIREFOX_PLATFORM = "WIN10";
	public static final String SEETEST_FIREFOX_VERSION = "57.0.2";
	public static final String SEETEST_IE_PLATFORM = "WIN10";
	public static final String SEETEST_IE_VERSION = "11";

	public static final String FIREFOX = "FIREFOX";
	public static final String GRID_URL = "http://localhost:4444/wd/hub"; // 192.168.2.92
	public static final String SAUCE_IE_VERSION = "15.15063";
}
