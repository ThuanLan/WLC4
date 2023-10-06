package mobio.services.pageUIs;

public class SvWlcFilterPageUI {

    public static final String FILTER_BTN = "//mo-libs-social-share-chat_reply-filter//mo-libs-shared-components-button[@classiconleft='mo-icn-social_filter']//button";
    public static final String FILTER_COLLAPSE_LINK = "//mo-libs-shared-components-tooltip[text()='Bộ lọc']";
    public static final String FILTER_TOOLTIP = "//div[contains(text(),'Bộ lọc')]";
    public static final String FILTER_SEARCH_TXT = "//mo-libs-social-share-chat_reply-filter//mo-libs-shared-components-input//input[@placeholder = 'Nhập tên']";
    public static final String FILTER_NO_LIST = "//mo-libs-social-share-chat_reply-filter//span[contains(text(),'Tạm thời chưa có công việc nào để bạn xử lý vào lúc này')]";

    public static final String SUPPORT_LBL = "//mo-libs-shared-components-dropdown//mo-libs-shared-components-tooltip[text()='Hỗ trợ bởi']";
    public static final String SUPPORT_DROP = "//mo-libs-social-share-chat_reply-filter//mo-libs-shared-components-tooltip[contains(text(),'Hỗ trợ bởi')]//ancestor::mo-libs-shared-components-label/following-sibling::mo-libs-shared-components-tooltip[@mode='click-toggle']";

    public static final String SUPPORT_ONE_ITEM_DROP = "//div[contains(@class,'mo-lib-dropdown ')]//mo-libs-shared-components-tooltip[contains(text(),'%s')]";
    public static final String SUPPORT_ALLITEM_DROP = "(//mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip)";
    public static final String SUPPORT_SEARCH_TXT = "//mo-libs-shared-components-tooltip-content//mo-libs-shared-components-input-search//input";

    public static final String PAGE_LBL = "//mo-libs-shared-components-label//mo-libs-shared-components-tooltip[text()='Danh sách các trang mạng xã hội']";
    public static final String PAGE_DROP = "//mo-libs-social-share-chat_reply-filter//mo-libs-shared-components-tooltip//div[contains(@class,'mo-lib-tags ')]";

    public static final String PAGE_ALLITEM_DROP = "//mo-libs-shared-components-tooltip-content//div[contains(@class,'d-flex mo-lib-list-view-template-checkbox-item')]//mo-libs-shared-components-tooltip[contains(@class,' mo-lib-ellipsis ')]";

    public static final String PROCESSING_STATUS_LBL = "//mo-libs-shared-components-tooltip[text()='Trạng thái xử lý']";
    //
    public static final String NOT_DONE_RADIO = "//div[@class='mo-lib-radio']//mo-libs-shared-components-tooltip[text()='Chưa hoàn tất']";
    public static final String DONE_RADIO = "//div[@class='mo-lib-radio']//mo-libs-shared-components-tooltip[text()='Đã hoàn tất']";

    public static final String REPLY_STATUS_LBL = "//mo-libs-shared-components-tooltip[text()='Trạng thái trả lời']";
    public static final String NOT_REPLY_CHECKBOX = "//mo-libs-shared-components-tooltip[contains(text(),'Chưa trả lời')]";
    public static final String NOT_REPLY_CHECKED_CHECKBOX = "//mo-libs-shared-components-tooltip[contains(text(),'Chưa trả lời')]/preceding-sibling::div[@class='mo-icn-checkbox']";
    public static final String REPLY_CHECKBOX = "//mo-libs-shared-components-tooltip[contains(text(),'Đã trả lời')]";
    public static final String REPLY_CHECKED_CHECKBOX = "//mo-libs-shared-components-tooltip[contains(text(),'Đã trả lời')]/preceding-sibling::div[@class='mo-icn-checkbox']";

    public static final String STATUS_LBL = "//mo-libs-shared-components-tooltip[text()='Trạng thái trả lời']";
    public static final String POSITIVE_CHECKBOX = "//mo-libs-shared-components-tooltip[contains(text(),'Tích cực')]/preceding-sibling::div[@class='mo-icn-box']";
    public static final String NEUTRAL_CHECKBOX = "//mo-libs-shared-components-tooltip[contains(text(),'Trung lập')]/preceding-sibling::div[@class='mo-icn-box']";
    public static final String NEGATIVE_CHECKBOX = "//mo-libs-shared-components-tooltip[contains(text(),'Tiêu cực')]/preceding-sibling::div[@class='mo-icn-box']";


    public static final String APPLY_BTN = "//mo-libs-shared-components-button//mo-libs-shared-components-tooltip[text()='Áp dụng bộ lọc']";

    public static final String FINISHED_RADIO = "//mo-libs-shared-components-tooltip[contains(text(),'Đã hoàn tất')]/preceding-sibling::div[contains(@class,'mo-icn-radio')]";


    public static final String TAG_LBL = "//mo-libs-shared-components-tooltip[text()='Tag phân loại công việc']";
    public static final String ADD_NEW_TAG_BTN = "//mo-libs-shared-components-button//mo-libs-shared-components-tooltip[contains(text(),'Thêm tag')]";
    public static final String FILTER_TAG_NAME_ALL_ITEM = "//mo-libs-shared-components-list_view-templates-checkbox//mo-libs-shared-components-tooltip";
    public static final String ACCOUNT_SEARCH_BOX_DROP = "//div[@class='scrollable-content']//div[contains(@class,'d-flex flex-column')]//mo-libs-shared-components-tooltip[contains(text(),'%s')]";
    public static final String CHOSE_TAG_ITEM = "//mo-libs-shared-components-tags//div[@class='mo-lib-tags-item']";
    public static final String CLOSE_TAGNAME_ITEM = "//mo-lib-components-tags-item//span[@class='text-break' and text()='%s']/following-sibling::div[@class='mo-icn-close-popup']";
    public static final String All_SELECTED_TAG_ITEM = "//mo-libs-shared-components-tags//mo-libs-shared-components-tooltip//div[@class='mo-lib-tags']";
    public static final String FORWARD_TAG_TXT = "//mo-lib-components-tags-social-assign/div//input[@class='mo-lib-tags-input']";
    
    // Search
    public static final String SEARCH_COLUMN2_BTN = "//button/i[contains(@class,'mo-icn-Search1')]";
    public static final String SEARCH_COLUMN2_TXT = "//mo-libs-social-share-chat_reply-content-conversation//mo-libs-shared-components-input-search//mo-libs-shared-components-input//input";
    public static final String SEARCH_RESULT_LBL = "//div[contains(@class,'mo-libs-social-share-chat_reply-content-conversation-template-search')]//div[@class='d-flex align-items-center']/div[1]";
    public static final String NO_RESULT_SEARCH_LBL = "//div[contains(text(),'Không có kết quả')]";

    
    // Search
    public static final String SEARCH_BOX_TXT = "//div[@key and @style ='display: flex;']// mo-libs-shared-components-input-search//input";
    public static final String SEARCH_CONTENT_TXT = "//div[@class='position-relative d-flex']//input";
    public static final String SEARCH_STYLE_DROP = "//div[@key and @style ='display: flex;']//mo-libs-shared-components-dropdown//i[contains(@class,'mo-icn-collapsed1')]";
    public static final String SEARCH_STYLE_AlL_ITEM_DROP = "//mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip";
    
    
    
    // weblive chat UI

    public static final String WLC_WEB_NAME = "autowlc00";

    public static final String ACTIVE_STATUS_ICON_COLUMN1 = "//mo-libs-social-share-chat_reply-assignment-item//div[contains(@class,'mo-lib-border-general')]";
    public static final String ACTIVE_STATUS_ICON_COLUMN2 = "//mo-libs-social-share-chat_reply-content-header//div[@class='position-relative']//div[contains(@class,'mo-lib-border-general')]";

    //Thông tin duyệt web
    public static final String INFOR_WEB_ACCESS_VERSION_COLUMN1 = "//mo-libs-shared-components-tooltip-content//mo-libs-shared-components-tooltip[text()='Lượt truy cập']";
    public static final String INFOR_WEB_ACCESS_PAGE_COLUMN1 = "//mo-libs-shared-components-tooltip-content//div[text()='Trang truy cập hiện tại']";
    public static final String INFOR_WEB_ACCESS_TIME_COLUMN1 = "//mo-libs-shared-components-tooltip-content//div[contains(text(),'Thời lượng lượt truy cập trên trang hiện tại')]";
    public static final String INFOR_WEB_ACCESS_BUTTON = "//i[contains(@class,'mo-icn-live_chat_info')]";
    public static final String INFOR_WEB_ACCESS_VERSION_COLUMN2 = "//mo-libs-shared-components-tooltip[text()='Lượt truy cập']";
    public static final String INFOR_WEB_ACCESS_PAGE_COLUMN2 = "//mo-libs-shared-components-tooltip[text()='Lượt chat']";
    public static final String INFOR_WEB_ACCESS_TIME_COLUMN2 = "//mo-libs-shared-components-tooltip[text()='Tổng thời lượng trên website']";
	
}
