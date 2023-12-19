package mobio.pageUIs;

public class CommonPageUI {
	
 // Menu link
 	public static final String DYNAMIC_MENU_LINK = "//mo-libs-shared-components-layout-menu-left-item//mo-libs-shared-components-tooltip[contains(text(),'%s')]";

 	// Child menu link
 	public static final String DYNAMIC_CHILD_MENU_LINK = "//mo-libs-shared-components-layout-menu-left-item//a[contains(text(),'%s')]";
 	
 	//Label
 	public static final String DYNAMIC_LBL = "//mo-libs-shared-components-label//mo-libs-shared-components-tooltip[contains(text(),'%s')]";

 	// Textbox
 	public static final String DYNAMIC_TEXTBOX = "//input[@placeholder ='%s']";
 	public static final String DYNAMIC_MODAL_TXT = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::mo-libs-shared-components-label/parent::div//input";

 	// Text Area
 	public static final String DYNAMIC_TEXTAREA = "//textarea[@placeholder ='%s']";

 	// Button
 	public static final String DYNAMIC_BUTTON = "//button//span[contains(text(),'%s')]";
 	public static final String DYNAMIC_BASIC_BUTTON = "//button//mo-libs-shared-components-tooltip[contains(text(),'%s')]";

 	public static final String HOME_MENU = "//mo-libs-shared-components-icons-dashboard";

 	// Right side bar
 	public static final String ACCOUNT_AVATAR_BTN = "//mo-libs-shared-components-layout-menu-top-profile//img";
 	public static final String ACCOUNT_LOGOUT_MENU = "//div[contains(@class,'mo-lib-layout-menu-top-logout')]//span[contains(text(),'Đăng xuất')]";
 	public static final String LOGIN_ACCOUNT_LBL = "//mo-libs-shared-components-tooltip-content//div[contains(text(),'%s')]";
 	public static final String WEBSITE_ACCOUNT_LBL = "//mo-libs-shared-components-tooltip-content//div[@data-overlayscrollbars-viewport='scrollbarHidden']//div[contains(@class,'mo-lib-border-bottom-general')]//div[contains(text(),'@')]";

 	public static final String CLOSE_BTN = "//mo-libs-shared-components-modal//i[contains(@class,'mo-icn-close-popup')]";
 	public static final String CLOSE_DIALOG_TEAM_BTN = "//mo-libs-shared-components-modal//i[contains(@class,'mo-lib-modal-wrapper-header-icon-remove')]";
 	public static final String RIGHT_SIDER_BAR = "//mo-libs-shared-components-layout-menu-left//img";

 	// Settings
 	public static final String SETTINGS_ICON = "//mo-libs-shared-components-layout-menu-left//mo-libs-shared-components-icons-setting";
 	public static final String SETTINGS_BRANCH_MENU = "//div[@class='mo-layout-menu-left-popup']//span[text()='%s']";

 	public static final String WEBSITE_VERSION_LBL = "//div[@data-overlayscrollbars-viewport='scrollbarHidden']/div/div[contains(@class,'mo-lib-font-head')]";
 	public static final String LOADING_ICON = "//mo-libs-shared-components-spinner//div[@class='mo-lib-spinner']";
 	public static final String MAIN_IFRAME = "//iframe";

 	public static final String ADD_NEW_BTN = "//mo-libs-shared-components-list_view//i[contains(@class,'mo-icn-add-new')]";	

 	public static final String ITEM_DROP = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::mo-libs-shared-components-label/parent::div//mo-libs-shared-components-tooltip[@mode='click-toggle']";
 	public static final String ITEM_SEARCH_DROP = "//mo-libs-shared-components-tooltip-content//mo-libs-shared-components-input-search//input";
 	public static final String ALL_ITEM_DROP = "//mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip";

 	public static final String CHECKBOX_DROP = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::mo-libs-shared-components-label/parent::div//input";	
 	public static final String ALL_ITEM_CHECKBOX_DROP = "//virtual-scroller//mo-libs-shared-components-checkbox//mo-libs-shared-components-tooltip";
 	
 	public static final String ITEM_CHECKBOX_DROP = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::mo-libs-shared-components-checkbox";
}
