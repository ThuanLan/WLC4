package mobio.services.pageUIs;

public class SvWlcCounterPageUI {
    public static final String SOCIAL_MSG_NUMBER_LBL = "//div[contains(@class,'mo-lib-z-index-1')]//mo-libs-shared-components-tooltip[contains(text(),'Tin nhắn')]/ancestor::mo-libs-shared-components-tab-item//mo-libs-shared-components-circle_and_number/span";
    public static final String SOCIAL_TAB_BTN = "//div[contains(@class,'mo-lib-z-index-1')]//div[@key='message']//mo-libs-shared-components-tooltip[contains(text(),'%s')]";
    public static final String SOCIAL_TAB_NUMBER_LBL = "//div[contains(@class,'mo-lib-z-index-1')]//mo-libs-shared-components-tooltip[contains(text(),'%s')]/ancestor::mo-libs-shared-components-tab-item//mo-libs-shared-components-circle_and_number/span";
    public static final String FB_REPLY_IFRAME = "//iframe";
    public static final String FB_REPLY_MSG_IFRAME = "//mo-libs-social-share-chat_reply-content-conversation//iframe";
    public static final String FB_REPLY_TXTA = "//body//textarea";

    public static final String FB_ADD_PICTURE_BTN = "//button/i[contains(@class,'mo-icn-upload-photos')]";
    public static final String MSG_ADD_TAG_REPLY_BTN = "//mo-libs-social-share-chat_reply-content-reply_box//mo-libs-shared-components-button//i[contains(@class,'mo-icn-add-job-tag')]";
    public static final String ADD_TAG_LBL = "//div[@class='mo-lib-modal-wrapper-header']//div[contains(@class,'d-flex align-items-center')]";
    public static final String TAG_NAME_ITEM = "//mo-libs-shared-components-list_view//mo-libs-shared-components-tooltip[contains(text(),'%s')]";
    public static final String COLUMN1_TAG_ICON = "//div[contains(@class,'mo-libs-social-share-chat-reply-assignment-item-selected')]//i[contains(@class,'mo-icn-post-tag')]";
    public static final String COLUMN1_TAG_CONTENT_LBL = "//div[text()='Tag phân loại công việc:']/parent::div//span[contains(text(),'%s')]";
    
    public static final String FB_ADD_TAG_REPLY_BTN = "//mo-libs-social-share-chat_reply-content-reply_box//mo-libs-shared-components-button//i[contains(@class,'mo-icn-add-job-tag')]";
    public static final String FB_ADD_TAG_REPLY_TXT = "//mo-libs-shared-components-tooltip[text()='Tag phân loại công việc']//ancestor::mo-libs-shared-components-tags//input";
    public static final String FB_ADD_TAG_AUTO_REPLY_TXT = "//input[@class='mo-lib-tags-input']";
    public static final String FB_ALL_TAG_NAME_ITEM = "//mo-libs-shared-components-list_view-templates-checkbox//mo-libs-shared-components-checkbox//mo-libs-shared-components-tooltip";
    public static final String COLUMN2_TAG_ICON = "//mo-libs-social-share-chat_reply-content-header//mo-libs-shared-components-tooltip//i[contains(@class,'mo-icn-post-tag')]";
    public static final String COLUMN2_TAG_CONTENT_LBL = "//div[text()='Tag phân loại công việc:']/parent::div//span[contains(text(),'%s')]";
    public static final String FB_FORWARD_REPLY_BTN = "//mo-libs-social-share-chat_reply-content-news-facebook//button/i[contains(@class,'mo-icn-forward-to')]";
    public static final String ASSIGNED_DROP = "//mo-libs-shared-components-tooltip[text()='Chọn người tiếp nhận']";
    public static final String ASSIGNED_ALL_ITEMS_DROP = "//mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip";
      
    public static final String MSG_FORWARD_REPLY_BTN = "//mo-libs-social-share-chat_reply-content-conversation//button/i[contains(@class,'mo-icn-forward-to')]";

    public static final String SOCIAL_ITEM_NOT_REPLY = "(//div[@class='mo-lib-color-ff5454']//ancestor::mo-libs-social-share-chat_reply-assignment-item)";

    public static final String SOCIAL_ITEM_CONTENT_NOT_REPLY = "(//div[@class='mo-lib-color-ff5454']//ancestor::mo-libs-social-share-chat_reply-assignment-item//span)";
//    public static final String SOCIAL_ITEM_ALL_ITEM = "(//div[contains(@class,'d-flex flex-column mo-lib-border-right-general')]//div[@class='mo-lib-tab-content-container']//div[@class='mo-lib-ellipsis'])";
    public static final String SOCIAL_ITEM_ALL_ITEM = "(//div[@key='message']//mo-libs-social-share-chat_reply-assignment-item)";
    public static final String SOCIAL_ITEM_CONTENT_ALL_ITEM = "(//div[@key='message']//mo-libs-social-share-chat_reply-assignment-item//span)";
    public static final String SOCIAL_ITEM_CONTENT_ITEM = "//div[contains(@class,'d-flex flex-column mo-lib-border-right-general')]//div[@class='mo-lib-tab-content-container']//div[@class='mo-lib-ellipsis']//span[text()='%s']";
    public static final String SOCIAL_ITEM_CONTENT_FOCUSED_ITEM = "//div[contains(@class,'d-flex flex-column mo-lib-border-right-general')]//div[@class='mo-lib-tab-content-container']//div[contains(@class,'mo-libs-social-share-chat-reply-assignment-item-selected')]//div[@class='mo-lib-ellipsis']/span";
    public static final String SOCIAL_ITEM_REPLIED_SUCCESS = "(//i[contains(@class,'mo-icn-create-successful')]//ancestor::mo-libs-social-share-chat_reply-assignment-item)";

    public static final String SOCIAL_LOADING_ICON = "//mo-libs-shared-components-tooltip//img[contains(@class,'mo-lib-tooltip-image')]";
    public static final String SOCIAL_ITEM_PIN_ICON = "(//i[@class='mo-icn-not_pin mo-lib-color-009cdb']//ancestor::mo-libs-social-share-chat_reply-assignment-item)";
    public static final String SOCIAL_ITEM_3DOTS_ICON = "//mo-libs-shared-components-tab//mo-libs-social-share-chat_reply-assignment-item//div[not(contains(@class,'d-none'))]/mo-libs-shared-components-dropdown//i[contains(@class,'mo-icn-dots')]";
    public static final String SOCIAL_ITEM_PIN_TOOLTIP = "//button//mo-libs-shared-components-tooltip[contains(text(),'Ghim tin nhắn')]";
    public static final String SOCIAL_MESSAGE_REMOVE_PIN_TOOLTIP = "//button//mo-libs-shared-components-tooltip[contains(text(),'Bỏ ghim tin nhắn')]";
    public static final String SOCIAL_ITEM_ALL_CONTENT_PIN_ITEM = "(//i[@class='mo-icn-not_pin mo-lib-color-009cdb']//ancestor::mo-libs-social-share-chat_reply-assignment-item//div[@class='mo-lib-ellipsis']/span)";
//    public static final String TAIL_ALL_CONTENT_PIN_ITEM = "(//i[@class='mo-icn-not_pin mo-lib-color-009cdb']//ancestor::mo-libs-social-share-chat_reply-assignment-item//div[@class='mo-lib-ellipsis']/span)";
//    public static final String TAIL_UNANSWER_NO_PIN_ITEM = "(//div[@class='mo-lib-color-ff5454']//ancestor::mo-libs-social-share-chat_reply-assignment-item[not(.//i[@class='mo-icn-not_pin mo-lib-color-009cdb'])]//div[@class='mo-lib-ellipsis']/span)";
//    public static final String TAIL_ANSWERED_NO_PIN_ITEM = "(//i[contains(@class,'mo-icn-create-successful')]//ancestor::mo-libs-social-share-chat_reply-assignment-item[not(.//i[@class='mo-icn-not_pin mo-lib-color-009cdb'])]//div[@class='mo-lib-ellipsis']/span)";
    public static final String TAIL_UNANSWER_PIN_ITEM = "[(.//i[contains(@class,'mo-icn-not_pin')])]//div[@class='mo-lib-color-ff5454']//ancestor::mo-libs-shared-components-tooltip//span";
    public static final String TAIL_ANSWERED_PIN_ITEM = "[(.//i[contains(@class,'mo-icn-not_pin')])]//i[contains(@class,'mo-icn-create-successful')]//ancestor::mo-libs-shared-components-tooltip//span";
    public static final String TAIL_UNANSWER_NO_PIN_ITEM = "[not(.//i[contains(@class,'mo-icn-not_pin')])]//div[@class='mo-lib-color-ff5454']//ancestor::mo-libs-shared-components-tooltip//span";
    public static final String TAIL_ANSWERED_NO_PIN_ITEM = "[not(.//i[contains(@class,'mo-icn-not_pin')])]//i[contains(@class,'mo-icn-create-successful')]//ancestor::mo-libs-shared-components-tooltip//span";
    // Sort
    public static final String FB_SORT_MENU = "//mo-libs-shared-components-dropdown//span[contains(@class,'mo-icn-sort_list')]";
   
    public static final String FB_SORT_NEWEST_ITEM = "//virtual-scroller//mo-libs-shared-components-tooltip[contains(text(),'Từ mới đến cũ')]";
    public static final String FB_SORT_OLDEST_ITEM = "//virtual-scroller//mo-libs-shared-components-tooltip[contains(text(),'Từ cũ đến mới')]";
    public static final String MSG_FINISH_BTN = "//mo-libs-social-share-chat_reply-content-conversation//mo-libs-shared-components-button/mo-libs-shared-components-tooltip/button[contains(@class,'mo-lib-button mo-lib-button-blue-solid')]";
    public static final String SAVE_NEW_TAG_BTN = "//mo-libs-shared-components-tooltip[text()='Tên tag phân loại công việc']//ancestor::mo-libs-tags-job_classification-add_edit//mo-libs-shared-components-button//mo-libs-shared-components-tooltip[text()='Lưu']";

    public static final String FB_EL_NO_PIN = "//mo-libs-shared-components-tab//mo-libs-social-share-chat_reply-assignment-item[not(.//mo-libs-shared-components-tooltip//i[@class='mo-icn-not_pin mo-lib-color-009cdb'])]";

    // Socket
    public static final String MESSAGE_POSTED_IMG = "//mo-libs-social-share-chat_reply-content-conversation-message//div[contains(@class,'social-share-chat-reply-content-conversation-message-attachment')]//img[1]";
    public static final String NO_ZOOM_IMG = "//mo-libs-shared-components-modal//div[contains(@class,'align-items-center justify-content-center')]//img";
    public static final String ZOOM_IMG = "//mo-libs-shared-components-modal//img[contains(@style,'cursor: zoom-in')]";

    public static final String RECIPIENT_GROUP_DROP = "//mo-libs-shared-components-tooltip[text()='Nhóm tiếp nhận']//ancestor::mo-libs-shared-components-dropdown//mo-libs-shared-components-tooltip[@mode]";
    public static final String FORWARD_HEADER = "//mo-libs-shared-components-modal//div[@class='mo-lib-modal-wrapper-header']";
    public static final String FORWARD_GROUP_DEFAULT_DROP = "//mo-libs-shared-components-tooltip[text()='Nhóm tiếp nhận']//ancestor::mo-libs-shared-components-dropdown//mo-libs-shared-components-tooltip[@mode]//mo-libs-shared-components-tooltip";
    public static final String LIST_FORWARD_GROUP_DROP = "//mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip";
    public static final String LIST_FORWARD_MEMBER_DROP = "//mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip";
    public static final String ASSIGN_HISTORY_BTN = "//mo-libs-shared-components-button//button//i[contains(@class,'mo-icn-Order')]";

    public static final String ASSIGNED_HISTORY_ITEM = "//div[@class='mo-lib-overflow-hidden mo-lib-tooltip-content-inner']//div[contains(text(),'%s')]";

    // Column 2
    public static final String NOTIFY_ICON = "//mo-libs-shared-components-layout-menu-right-notification//mo-libs-shared-components-icons-notification-new";
    public static final String NEW_COMMENT_CONTENT = "//mo-libs-shared-components-layout-menu-right-notification-popup//mo-libs-shared-components-content_view_more//div[text()='%s']";
    public static final String SECOND_COMMENT_HEADER = "//mo-libs-social-share-view-comment//mo-libs-social-share-view-comment//div[contains(@class,'mo-lib-font-head-4s')]/mo-libs-shared-components-tooltip";
    
    public static final String NOTIFY_COMMENT_CONTENT = "(//mo-libs-shared-components-layout-menu-right-notification-popup//mo-libs-shared-components-content_view_more//div[contains(@class,'mo-lib-content-view-more-content')])[1]";
    public static final String CONTENT_IN_COLUMN2_LBL = "//mo-libs-social-share-chat_reply//mo-libs-social-share-chat_reply-content-conversation-message//div[contains(@class,'text-break')]";
    public static final String TEMPLATE_REPLY_BTN = "//mo-libs-shared-components-button//button[contains(@class,'mo-lib-button-text')]/i[contains(@class,'mo-icn-sms')]";

    public static final String QUICK_REPLY_ONE_ITEM = "//div[text()='%s']//ancestor::div[@class='d-flex']//img";
    public static final String QUICK_REPLY_TXT = "//div[@class='d-flex']//div[contains(@class,'text-break') and text()='%s']";

    // Column 3
    public static final String BLOCK_CONTACT_BTN = "//div[contains(@class,'mo-lib-border-left-general')]//mo-libs-shared-components-dropdown[@class='']//span";
    public static final String BLOCK_CONTACT_MENU = "//mo-lib-components-menu_dropdown-list//div[@class='position-relative ']/span[text()='Chặn liên hệ']";
    public static final String BEHAVIOR_TAG = "//mo-libs-cdp-box-components-tags_activity//mo-libs-shared-components-list_view-templates-tag//span[text()='%s']";
    public static final String SEARCH_BEHAVIOR_TAG = "//div[contains(@class,'mo-lib-border-left-general') and not(contains(@class,'d-none'))]//mo-libs-shared-components-input-search//input";
    public static final String DISABLED_BEHAVIOR_TAG = "//div[contains(@class,'mo-lib-border-left-general') and not(contains(@class,'d-none'))]//div[@class='mo-lib-disable mo-lib-pointer-events-none']";
    public static final String ADD_TAG_PROFILE_BTN = "//div[contains(@class,'mo-lib-border-left-general') and not(contains(@class,'d-none'))]//button//mo-libs-shared-components-tooltip[contains(text(),'Gắn tag profile')]";
    public static final String BEHAVIOR_TAG_ICON = "//mo-social-share-assign-layout-content-news-facebook//mo-libs-shared-components-tooltip//i[contains(@class,'mo-icn-customer-tag')]";
    public static final String BEHAVIOR_TAG_MSG_ICON = "//mo-libs-shared-components-tooltip//i[contains(@class,'mo-icn-customer-tag')]";
    public static final String BEHAVIOR_TAG_NAME_OVERLAY = "//mo-libs-shared-components-tooltip-content//div[text()='Tag hành vi:']/parent::div//div[contains(text(),'%s')]";
    public static final String EDIT_PROFILE_BTN = "//div[contains(@class,'mo-lib-border-left-general') and not(contains(@class,'d-none'))]//span[contains(@class,'mo-icn-sua')]";
    public static final String REDIRECT_PROFILE_BTN = "//mo-libs-shared-components-tab//span[contains(@class,'mo-icn-leave-page')]";
    public static final String EDIT_PROFILE_EMAIL_TXT = "//mo-libs-shared-components-tooltip[text()='E-mail']//ancestor::div[@style='display: block;']/following-sibling::div[1]//input";
    public static final String EDIT_PROFILE_PHONE_TXT = "//mo-libs-shared-components-tooltip[text()='Số điện thoại']//ancestor::div[@style='display: block;']/following-sibling::div[1]//input";
    public static final String UPDATED_PROFILE_PHONE_TXT = "//mo-libs-shared-components-tooltip[contains(text(),'Số điện thoại')]//ancestor::mo-libs-cdp-profiling-detail-left//mo-libs-shared-components-tooltip[contains(text(),'%s')]";
    public static final String UPDATED_PROFILE_EMAIL_TXT = "//mo-libs-shared-components-tooltip[contains(text(),'E-mail')]//ancestor::mo-libs-cdp-profiling-detail-left//mo-libs-shared-components-tooltip[contains(text(),'%s')]";
    public static final String COLUMN3_PROFILE_EMAIL_LBL = "//mo-libs-shared-components-tooltip[contains(text(),'%s')]";

    public static final String COLUMN3_PROFILE_PHONE_LBL = "//mo-libs-shared-components-tooltip[contains(text(),'%s')]";

    public static final String DEAL_TITLE_TXT = "//mo-libs-shared-components-modal//mo-libs-shared-components-tooltip[text()='Tên đơn hàng']//ancestor::mo-libs-shared-components-label//following-sibling::div//input";
    public static final String DEAL_VALUE_TXT = "//mo-libs-shared-components-modal//mo-libs-shared-components-tooltip[text()='Giá trị đơn hàng']//ancestor::mo-libs-shared-components-label//following-sibling::div//input";
    public static final String DEAL_PROFILE = "//mo-libs-shared-components-tooltip[text()='Profile']/ancestor::mo-libs-shared-components-label/following-sibling::div/mo-libs-dynamic_field-template_cms-template-tag//input[contains(@placeholder,' e-mail')]";
    public static final String DEAL_PROFILE_ITEM = "//mo-libs-shared-components-checkbox//mo-libs-shared-components-tooltip";
    public static final String DEAL_PROFILE_SEARCH_TXT = "//mo-lib-components-tags-profile_item//input";

    public static final String DEAL_STATE_DROP = "//mo-libs-shared-components-tooltip[text()='Trạng thái đơn hàng']/ancestor::mo-libs-shared-components-label/following-sibling::div/mo-libs-dynamic_field-template_cms-template-single_dropdown//mo-libs-shared-components-dropdown//mo-libs-shared-components-tooltip[text()='Chọn thông tin']";
    public static final String DEAL_ALL_STATE_DROP = "//mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip";
    public static final String DEAL_REDIRECT_DETAIL_PAGE = "//mo-libs-cdp-box-components-deal//mo-libs-shared-components-tooltip[text()='%s']//ancestor::div[contains(@class,'mo-lib-border-general')]//i[contains(@class,'mo-icn-New-page')]";

//    public static final String DEAL_STATUS_LBL = "//mo-libs-cdp-box//div[text()='Trạng thái đơn hàng']/following-sibling::div[text()='%s']";
//    public static final String DEAL_VALUE_LBL = "//mo-libs-cdp-box//div[text()='Giá trị đơn hàng']/following-sibling::div[text()='%s']";
    public static final String DEAL_STATUS_LBL = "//div[not(contains(@class,' d-none'))]/div[contains(@class,' mo-lib-right')]//div[text()='Trạng thái Cơ hội bán']/following-sibling::div[text()='%s']";
    public static final String DEAL_VALUE_LBL = "//div[not(contains(@class,' d-none'))]/div[contains(@class,' mo-lib-right')]//div[text()='Giá trị Cơ hội bán']/following-sibling::div[text()='1.000.000 VNĐ']";
    public static final String DEAL_DETAIL_FORM = "//div[contains(@class,'mutil-page-right-box') and not(contains(@class,'d-none'))]//mo-cdp-block-right-item-deal//span[text()='%s']";

    public static final String DELETE_BTN = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::div[contains(@class,'mo-lib-border-general')]//i[@class='mo-icn-close-popup']";

    // Note
    public static final String COLUMN3_NOTE_ICON = "//div[contains(@class,'mutil-page-right-box') and not(contains(@class,'d-none'))]//div[contains(@class,'mo-icn-cancelling-note')]";
    public static final String NOTE_EDIT_BTN = "//mo-libs-cdp-box-note[contains(@class,'d-flex')]//div[text()='%s']//ancestor::div[contains(@class,'m-0 p-0')]//span[contains(@class,'mo-icn-menu-sua btn-edit-note')]";
    public static final String NOTE_DELETE_BTN = "//mo-libs-cdp-box-note[contains(@class,'d-flex')]//div[text()='%s']//ancestor::div[contains(@class,'m-0 p-0')]//span[contains(@class,'mo-icn-menu-xoa')]";
    public static final String NOTE_ITEM_C3_LBL = "//mo-libs-cdp-box-note//div[contains(@class,'note-description')]//div[text()='%s']";
    public static final String NOTE_TITLE_C3_LBL = "//div[contains(@class,'mutil-page-right-box') and not(contains(@class,'d-none'))]//mo-cdp-box-note//mo-libs-shared-components-tooltip[text()='Ghi chú']";
    // Config feature in column3
    
    public static final String COLUMN3_CONFIG_ICON = "//div[contains(@class,'mo-lib-border-left-general') and not(contains(@class,'d-none'))]//button/i[contains(@class,'mo-icn-setting')]";
    public static final String CONFIG_INFO_RADIO = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::div[contains(@class,'row')]//div[contains(@class,'mo-icn-radio')]";
    static int tabColumn3First =1;
    public static final String CONFIG_SORT_ORDER = "(//mo-libs-cdp-box//mo-libs-shared-components-tab//mo-libs-shared-components-tab-item)[" + tabColumn3First + "]/div[@key]/mo-libs-shared-components-tooltip/i";
    public static final String REPLY_ITEM_OWNER = "//div[contains(text(),'Trả lời bởi')]//span[text()='%s']";
    public static final String COLUMN2_CONTENT_HEADER = "//mo-libs-social-share-chat_reply-content-header";

    public static final String TICKETL_REDIRECT_DETAIL_PAGE = "//mo-libs-cdp-box-components-ticket//mo-libs-shared-components-tooltip[text()='%s']//ancestor::div[contains(@class,'mo-lib-border-general')]//i[contains(@class,'mo-icn-New-page')]";
    public static final String TICKET_STATUS_LBL = "//mo-libs-cdp-box//span[text()='Trạng thái xử lý']/parent::div[contains(.,'%s')]";
    public static final String TICKET_TITLE_LBL = "//mo-libs-cdp-box//mo-libs-cdp-box-components-ticket//mo-libs-shared-components-button//i[contains(@class,'mo-icn-up-arrow')]//following-sibling::mo-libs-shared-components-tooltip";
    public static final String TICKET_DETAIL_FORM = "//mo-libs-cdp-box//mo-cdp-box-ticket//span[text()='Order 19785']";
    public static final String RIGHT_BOX_TITLE_ITEM = "//mo-libs-cdp-box//mo-libs-shared-components-tooltip//mo-libs-shared-components-tooltip[text()='%s']";

    public static final String CONTENT_ITEM_COLUMN2_LBL = "//mo-libs-social-share-chat_reply-content-conversation//mo-libs-social-share-chat_reply-content-conversation-message//div[contains(text(),'%s')]";

    public static final String PAGE_NAME_DYNAMIC = "//mo-libs-social-dashboard-box-conversation//mo-libs-shared-components-tooltip[contains(text(),'%s')]";

    public static final String MESSAGE_TEXT_IN_COLUMN2_LBL = "(//div[contains(@class,'mo-lib-overflow')]//mo-libs-social-share-chat_reply-content-conversation-message)[last()]//div[contains(@class,'text-break')]";
    public static final String ZOOM_VIDEO = "//mo-lib-components-modal//div[contains(@class,'align-items-center justify-content-center')]//video";
    public static final String SOCIAL_CONTENT_TOP_ITEM = "(//div[contains(@class,'d-flex flex-column mo-lib-border-right-general')]//div[@class='mo-lib-tab-content-container']//div[@class='mo-lib-ellipsis'])[1]//span";
    public static final String SORT_NEWEST_LBL = "//div[@key='message']//mo-libs-social-share-chat_reply-filter//div[text()=' Từ mới đến cũ ']";
    public static final String SORT_OLDEST_LBL = "//div[@key='message']//mo-libs-social-share-chat_reply-filter//div[text()=' Từ cũ đến mới ']";

}
