package commons;

// TODO: Auto-generated Javadoc

/**
 * The Class GlobalConstants.
 */
public class GlobalConstants {

    /**
     * The Constant PROJECT_PATH.
     */
    public static final String PROJECT_PATH = System.getProperty("user.dir");

    /**
     * The Constant DEV_URL.
     */
    public static final String DEV_URL = "https://www.facebook.com/";

    /**
     * The Constant TEST_URL.
     */
    //public static final String TEST_URL = "https://test1.mobio.vn";

//    public static final String UAT_URL = "https://test2.mobio.vn/";
//    public static final String UAT_LOGIN_URL = "https://test2.mobio.vn//login";
//    public static final String SOCIAL_LINK = "https://test2.mobio.vn/social/chat/facebook";
    public static final String UAT_URL = "https://uat.mobio.vn";
    public static final String UAT_LOGIN_URL = "https://uat.mobio.vn/login";
    public static final String SOCIAL_LINK = "https://uat.mobio.vn/social/chat/web-live-chat";
    public static final String AUTO_REPLY_LINK = "https://uat.mobio.vn/setting/tenant/social/auto-reply";
    public static final String SOCIAL_SETTINGS_LINK = "https://uat.mobio.vn/setting/tenant/social/assignment-and-answer";
    /**
     * The Constant PASSWORD.
     */
    public static final String PASSWORD = "Mobio123";

    public static final String PROFILE_NAME = "Bao Chau";
    public static final String FB_ACCOUNT_NAME = "Ngoc Lan";

    /**
     * The Constant SHORT_TIMEOUT.
     */
    public static final int SHORT_TIMEOUT = 10;

    /**
     * The Constant LONG_TIMEOUT.
     */
    public static final int LONG_TIMEOUT = 30;

    public static final int MID_TIMEOUT = 30;

    public static final String DOWNLOAD_FOLDER = PROJECT_PATH + "";

//    public static final String REQUEST_URL_TO_DELETE_DATA = "https://test1.mobio.vn/social/api/v1.0/merchant/{merchantID}/remove-data-assign-by-merchant?social_type={socialTypeID}&object_type={objectTypeID}";
//    public static final String MERCHAN_ID = "564efc46-71be-44df-b8c7-0198082b3555";
    public static final String FB_SOCIAL_TYPE_ID = "1";
    
    public static final String REQUEST_URL_TO_DELETE_DATA = "https://api-uat.mobio.vn/social/api/v1.0/merchant/{merchantID}/remove-data-assign-by-merchant?social_type={socialTypeID}&object_type={objectTypeID}";
    public static final String MERCHAN_ID = "564efc46-71be-44df-b8c7-0198082b3555";
//  public static final String ZALO_SOCIAL_TYPE_ID = "2";
//	public static final String INSTAGRAM_SOCIAL_TYPE_ID = "3";
//	public static final String YOUTUBE_SOCIAL_TYPE_ID = "4";
//	public static final String APP_SOCIAL_TYPE_ID = "5";
//	public static final String LINE_SOCIAL_TYPE_ID = "6";
    public static final String WEBLIVECHAT_SOCIAL_TYPE_ID = "7";
    public static final String COMMENT_OBJECT_TYPE_ID = "1";
    public static final String MESSAGE_OBJECT_TYPE_ID = "2";
//	public static final String RATING_OBJECT_TYPE_ID = "3";

    // WLC link
	public static final String WLC_SITE_0001 = "https://test2.mobio.vn/landing-pages/chat-tool/testautowlc0001/";
	public static final String WLC_SITE_0002 = "https://test2.mobio.vn/landing-pages/chat-tool/testautowlc0002/";
	public static final String WLC_SITE_0003 = "https://test2.mobio.vn/landing-pages/chat-tool/testautowlc0003/";
	public static final String WLC_SITE_0004 = "https://test2.mobio.vn/landing-pages/chat-tool/testautowlc0004/";
	public static final String WLC_SITE_0005 = "https://test2.mobio.vn/landing-pages/chat-tool/testautowlc0005/";


//    public static final String WLC_SITE_0001 = "https://test2.mobio.vn/landing-pages/chat-tool/test01/";
//    public static final String WLC_SITE_0002 = "https://test2.mobio.vn/landing-pages/chat-tool/test02/";
//    public static final String WLC_SITE_0003 = "https://test2.mobio.vn/landing-pages/chat-tool/test03/";
//    public static final String WLC_SITE_0004 = "https://test2.mobio.vn/landing-pages/chat-tool/test04/";
//    public static final String WLC_SITE_0005 = "https://test2.mobio.vn/landing-pages/chat-tool/test05/";


    //Behavior tag
    public static final String BH_TAG_NAME = "0_BT_001";

	


}
