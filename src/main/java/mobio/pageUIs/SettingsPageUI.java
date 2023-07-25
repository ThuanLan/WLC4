package mobio.pageUIs;

public class SettingsPageUI {

	public static final String SETTING_BTN = "//mo-libs-shared-components-layout-menu-left_temp//span[contains(@class,'mo-icn-setting')]";
	public static final String SETTING_SOCIAL_DOWN_ARROW = "//mo-libs-tenant_setting-display_type-social//div[contains(text(),'Online & mạng xã hội')]/parent::div//i[contains(@class,'mo-icn-down-arrow')]";
	public static final String SETTING_SOCIAL_LINK = "//mo-libs-tenant_setting-display_type-social//div[contains(text(),'Online & mạng xã hội')]";

	public static final String SETTING_SOCIAL_FORM = "//mo-libs-tenant_setting-display_type-social//div[contains(@class,'mo-libs-tenant_setting-display_type-social-content')]";
	public static final String SETTING_EDIT_SOCIAL_BTN = "//mo-libs-tenant_setting-display_type-social//i[contains(@class,'mo-icn-menu-sua')]";
	public static final String CHECK_COUNT_NOTREPLY_SOCIAL_CHECKBOX = "//div[@class='mo-lib-radio']//mo-libs-shared-components-tooltip[text()='Hiển thị số lượng chưa trả lời']/preceding-sibling::div[contains(@class,'mo-icn-radio-check')]";
	public static final String UNCHECK_COUNT_NOTREPLY_SOCIAL_CHECKBOX = "//div[@class='mo-lib-radio']//mo-libs-shared-components-tooltip[text()='Hiển thị số lượng chưa trả lời']/preceding-sibling::div[contains(@class,'mo-icn-radio')]";
	public static final String CHECK_COUNT_NOTREAD_SOCIAL_CHECKBOX = "//mo-libs-shared-components-tooltip[text()='Hiển thị số lượng chưa đọc']/preceding-sibling::div[contains(@class,'mo-icn-radio-check')]";
	public static final String UNCHECK_COUNT_NOTREAD_SOCIAL_CHECKBOX = "//mo-libs-shared-components-tooltip[text()='Hiển thị số lượng chưa đọc']/preceding-sibling::div[contains(@class,'mo-icn-radio')]";

	public static final String SETTING_UP_ARROW = "//i[@class='mo-lib-font-size-10px mo-icn-up-arrow']";
	public static final String SAVE_SETTINGS = "//div[contains(@class,'mo-libs-tenant_setting-display_type-social-content')]//mo-libs-shared-components-button[@label='i18n_save']//mo-libs-shared-components-tooltip[text()='Lưu']";
	
}
