package mobio.services.pageUIs;

public class SvOtherFunctionsPageUI {
    public static final String VALUE_DYNAMIC_DROPDOWN = "//mo-lib-components-tooltip[text()='%s']";

    //Order
    public static final String DYNAMIC_ADD_BUTTON = "//i[contains(@class,'add-new')]//following-sibling::mo-libs-shared-components-tooltip[text()='%s']";

    //Ticket
    public static final String DYNAMIC_TEXTBOX = "//mo-libs-shared-components-tooltip[text()='%s']//ancestor::mo-libs-shared-components-input-valid//mo-libs-shared-components-input//input";
    public static final String DYNAMIC_DROPDOWN_TICKET = "//mo-lib-components-tooltip[contains(@class,'lib-font-head') and contains(text(),'%s')]/ancestor::div[contains(@class,'row')]//mo-lib-components-tooltip[contains(.,'Chọn')]";

    public static final String ADD_STAFF_IN_CHARGE_DROP = "//mo-libs-shared-components-tooltip[text()='%s']/ancestor::mo-libs-shared-components-label/following-sibling::mo-libs-dynamic_field-template_cms-template-multi_optional_field//mo-libs-shared-components-dropdown//mo-libs-shared-components-tooltip[text()='%s']";
    public static final String ADD_NEW_SEARCH_TXT = "//mo-libs-shared-components-tooltip-content//mo-libs-shared-components-input-search//input";
	
	public static final String ADD_CHILD_LIST_DROP = "//mo-libs-shared-components-list_view-templates-text//mo-libs-shared-components-tooltip";
	
    public static final String NOTE_TEXTA = "//mo-libs-popup_action-note-content//div[contains(@class,'ql-editor')]";

    public static final String DYNAMIC_TAB = "//mo-libs-shared-components-tab//div[contains(@class,'mo-lib-z-index-1')]//mo-libs-shared-components-tab-item//div[contains(@key, '%s')]//i";

    public static final String PROFILE_DROPDOWN_TICKET = "//mo-lib-components-tags-profile_item//input";

    
    public static final String ADD_TICKET_MENU = "//div[@class='mo-lib-tooltip-content-inner']//li//span[text()='%s']";
	
	public static final String ADD_NEW_LBL = "//mo-libs-shared-components-label//mo-libs-shared-components-tooltip[text()='%s']";
	public static final String ADD_NEW_STAFF_IN_CHARGE_DROP = "//mo-libs-shared-components-tooltip[text()='Nhân viên phụ trách']/ancestor::mo-libs-shared-components-label/following-sibling::mo-libs-dynamic_field-template_cms-template-multi_optional_field//mo-libs-shared-components-dropdown//mo-libs-shared-components-tooltip[text()='Chọn thông tin']";
	public static final String ADD_NEW_ROLE_DROP = "//mo-libs-shared-components-tooltip[text()='Nhân viên phụ trách']/ancestor::mo-libs-shared-components-label/following-sibling::mo-libs-dynamic_field-template_cms-template-multi_optional_field//mo-libs-shared-components-dropdown//mo-libs-shared-components-tooltip[text()='%s']";
	
	public static final String ADD_PARENT_DROP = "//mo-libs-shared-components-tooltip[text()='%s']/ancestor::mo-libs-shared-components-label/following-sibling::mo-libs-dynamic_field-template_cms-template-single_dropdown//mo-libs-shared-components-dropdown//mo-libs-shared-components-tooltip[text()='%s']";
	public static final String ADD_STAFF_PROFILE_DROP = "//mo-libs-shared-components-tooltip[text()='%s']/ancestor::mo-libs-shared-components-label/following-sibling::mo-libs-dynamic_field-template_cms-template-tag//mo-libs-shared-components-input//input[contains(@placeholder,'%s')]";
	public static final String ADD_CHILD_LIST_CHECKBOX = "//mo-libs-shared-components-checkbox//mo-libs-shared-components-tooltip";
	public static final String ADD_MEDIA_FILE = "//input[@type='file']";
	public static final String TABLE_TICKET_NAME_ITEM = "//mo-libs-shared-components-table//mo-libs-shared-components-tooltip/span[text()='%s']";
}
	

