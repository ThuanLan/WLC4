package mobio.services.pageUIs;

public class ServicesPageUI {
	
	// Elements phân công hỗ trợ
	public static final String ACTIVE_CONFIG_TOGGLE = "//div[@class='content-container']//mo-libs-shared-components-button-toggle//div[contains(@class,'mo-lib-toggle-circle-active')]";
	public static final String SUPPORT_TEAM = "//mo-libs-social-chat_and_reply_assignment-internal_team-filter//mo-libs-shared-components-tooltip[contains(text(),'%s')]";
	public static final String RULE_OPTION = "//mo-libs-shared-components-radio//mo-libs-shared-components-tooltip[contains(text(),'%s')]";
	public static final String ASSIGNMENT_CONFIG_TAB = "//mo-libs-shared-components-tab//div[contains(@class,'mo-lib-z-index-1')]//mo-libs-shared-components-tooltip[contains(text(),'%s')]";
	public static final String CLOSE_TAG_MEMBER_ICON = "//mo-libs-shared-components-tags// div[@class='mo-lib-tags-item']//i[contains(@class,'mo-icn-close-popup')]";
	public static final String RECALL_LAW_TOGGLE = "//mo-libs-shared-components-tooltip[contains(text(),'Sử dụng luật thu hồi')]//preceding-sibling::mo-libs-shared-components-button-toggle";
	public static final String RECALL_LAW_ACTIVE_TOGGLE = "//mo-libs-shared-components-tooltip[contains(text(),'Sử dụng luật thu hồi')]//preceding-sibling::mo-libs-shared-components-button-toggle//div[contains(@class,'mo-lib-toggle-circle-active')]";

	public static final String RECALL_TIME_TXT = "//mo-libs-shared-components-tooltip[text()='Thời gian thu hồi Comment']//ancestor::mo-lib-components-label//following-sibling::div//input";
	public static final String ASSIGN_RECALL_TIME_TXT = "//mo-libs-shared-components-tooltip[text()='Thời gian']//ancestor::mo-lib-components-label//following-sibling::div//input";
	public static final String RECALL_ASSIGN_MEMBER_DROP = "//mo-libs-shared-components-tooltip[text()='Thành viên được phân công']//ancestor::mo-lib-components-drop_down//div[@class='mo-lib-drop_down']";

	public static final String SELECTED_TYPE_ASSIGNMENT_LBL = "//mo-libs-social-chat_and_reply_assignment-internal_team-rule-assign//mo-libs-shared-components-tooltip[text()='Phân chia cho tất cả các thành viên trong Team']";
	public static final String ASSIGN_RULE_TOGGLE = "//div[contains(text(),'%s')]//preceding-sibling::mo-libs-shared-components-button-toggle";

	public static final String TEAM_NAME_DROP = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::div[contains(@class,'row')]//div[contains(@class,'col-3')]";

	public static final String MEMBER_ACC_DROP = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::div[contains(@class,'row')]//div[contains(@class,'col-4')]";

	public static final String LIST_OF_TEAM = "//mo-libs-shared-components-checkbox//mo-libs-shared-components-tooltip[contains(.,'%s')]";
	public static final String LIST_OF_TEAM_CHECKED_ITEM = "//mo-libs-shared-components-tooltip[contains(.,'%s')]/preceding-sibling::div[@class='mo-icn-checkbox']";

	public static final String LIST_OF_ACC = "//mo-libs-shared-components-checkbox//mo-libs-shared-components-tooltip[contains(.,'%s')]";
	public static final String LIST_OF_ACC_CHECKED_ITEM = "//mo-libs-shared-components-tooltip[contains(.,'%s')]/preceding-sibling::div[@class='mo-icn-checkbox']";

	// Danh sách mạng xã hội trong phân công team hỗ trợ
	public static final String SOCIAL_NAME = "//div[contains(@class,'teams-menu_socials-list-page')]//div[text()='%s']";
	public static final String LIST_SOCIAL_PAGE_NAME_CHECKED_ITEM = "//div[text()='%s']//ancestor::div[contains(@class,'-internal_team-social_support-list-page')]//div[@class='mo-icn-checkbox']//ancestor::div[contains(@class,'assignment-internal_team-social_support-list-page-item')]//mo-libs-shared-components-content_view_more/div";
	public static final String SOCIAL_PAGE_NAME_ITEM = "//mo-libs-social-chat_and_reply_assignment-between_teams-rule//mo-libs-shared-components-tooltip[contains(text(),'%s')]";

	public static final String HANDLE_PRIORITY_RADIO = "//div[contains(text(),'%s')]/ancestor::div[contains(@class,'justify-content-between')]//div[text()='%s']//ancestor::div[contains(@class,'between_teams-rule-team')]//div[contains(@class,'mo-icn-radio')]";
	public static final String HANDLE_PRIORITY_CHECKED_RADIO = "//div[contains(text(),'%s')]/ancestor::div[contains(@class,'justify-content-between')]//div[text()='%s']//ancestor::div[contains(@class,'between_teams-rule-team')]//div[contains(@class,'mo-icn-radio-check')]";
	public static final String SAVE_HANDLE_PRIORITY_BTN = "//button[not(contains(@class,'mo-lib-disable'))]//mo-libs-shared-components-tooltip[text()='Lưu']";
	public static final String SELECT_MEMBER_DROP = "//mo-libs-social-chat_and_reply_assignment-internal_team-rule-general//mo-libs-shared-components-input//input";
	public static final String LIST_MEMBER_DROP = "//mo-libs-shared-components-checkbox//mo-libs-shared-components-tooltip";
	public static final String ASSIGNMENT_TYPE_DROP = "//mo-libs-social-chat_and_reply_assignment-internal_team-rule-assign//mo-libs-shared-components-tooltip[@mode='click-toggle']";
	public static final String LIST_ASSIGNMENT_TYPE_DROP = "//mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip";
	public static final String ASSIGNMENT_CONFIG_SAVE_BTN = "//mo-libs-shared-components-tab//button[not(contains(@class,'mo-lib-disable'))]//mo-libs-shared-components-tooltip[text()='Lưu']";

	public static final String ACTIVE_RULE = "//mo-lib-components-button-toggle";
	public static final String SEARCH_SOCIAL_PAGE_TXT = "//mo-libs-shared-components-modal//mo-libs-shared-components-input-search//input[@placeholder='Tìm theo tên trang mạng xã hội']";
	public static final String CLOSE_DISPLAY_PAGE_BTN = "//mo-libs-shared-components-modal//mo-libs-shared-components-card//i[contains(@class,'mo-icn-close-popup')]";
	public static final String NEW_POST_CONTENT = "(//mo-social-dashboard-box-news-content//div[contains(@class,'mo-social-dashboard-box-news-content-info')])[1]";
	public static final String POST_3DOT_BTN = "//mo-social-dashboard-box-news-content//mo-lib-component-menu_dropdown[not(contains(@class,'d-none'))]/span";
	public static final String POST_EDIT_BTN = "//mo-lib-components-menu_dropdown-list//i[@class='mo-icn-menu-sua']";
	public static final String COMMON_REPLY_MSG = "Auto reply comment: We will reply you as soon as possible.";
	public static final String SOCIAL_ARROW_ICON = "//div[contains(@class,'teams-menu_socials-list-page')]//div[text()='%s']/parent::div/i[contains(@class,'mo-icn-up-arrow')]";
//	    
	public static final String BOARD_CHECKBOX = "//mo-libs-shared-components-tooltip[contains(text(),'%s')]/parent::div//div[@class='mo-icn-box']";
	public static final String BOARD_CHECKED_CHECKBOX = "//mo-libs-shared-components-tooltip[contains(text(),'%s')]/parent::div//div[@class='mo-icn-checkbox']";
	public static final String BACK_TO_THE_CONTENT_ICON = "//mo-libs-shared-components-layout-menu-left//i[contains(@class,'mo-svg-font-arrow-left')]";

	public static final String CHOSE_AN_ITEM = "//mo-libs-shared-components-tags//div[@class='mo-lib-tags-item']//span";
	public static final String All_SELECTED_ITEMS = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::mo-libs-shared-components-label//following-sibling::mo-libs-dynamic_field-template_cms-template-tag//mo-libs-shared-components-tags//div[@class='mo-lib-tags']";
	public static final String INPUT_TAG_TXT = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::mo-libs-shared-components-label//following-sibling::mo-libs-dynamic_field-template_cms-template-tag//mo-libs-shared-components-input//input";

	public static final String TAG_NEW_TXT = "//mo-libs-tags-job_classification-add_edit//input[@placeholder ='Nhập nội dung']";

	public static final String ADD_TAG_BTN = "//mo-social-share-assign-layout-content-news-facebook//mo-lib-component-menu_dropdown//i[contains(@class,'mo-icn-add-job-tag')]";
	public static final String ADD_TAG_TXT = "//mo-lib-components-tooltip[text()='Tag phân loại công việc']//ancestor::mo-ticket-assisted-automation-detail-action-tag//input";
	public static final String ALL_TAG_NAME_ITEM = "//mo-libs-shared-components-checkbox//mo-libs-shared-components-tooltip";
	public static final String SAVE_NEW_TAG_BTN = "//mo-libs-tags-job_classification-add_edit//button//mo-libs-shared-components-tooltip[text()='Lưu']";
	public static final String WORK_TAG_LBL = "//mo-libs-shared-components-label//mo-libs-shared-components-tooltip[text()='Tag phân loại công việc']";
}
