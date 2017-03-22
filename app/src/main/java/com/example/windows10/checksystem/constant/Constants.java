package com.example.windows10.checksystem.constant;

/**
 * Created by Windows10 on 2017/2/28.
 */
public class Constants {

    //接口请求示例  http://192.168.12.xxx:8090/admin/appCarUser/appLogin.shtml?phone=13688999999&password=111111
//    http://localhost:8090/admin/appOBD/appTestData.shtml?id=1&detectionTime=20170308001&testData=0142,0143,0144
    public static String BASE_URL;

    //用来存储IP地址的键名
    public static final String IP_CONFIG = "ip_config";

    public static final String DEFAULT_URL = "http://";

    public static final String DEFAULT_IP = "192.168.12.158";

    public static final String DEFAULT_PORT = "8090";

    //记录蓝牙连接状态的变量
    public static final int BLUE_TOOTH_IS_CLOSED = 0;
    public static final int BLUE_TOOTH_CONNECT_FAILED = 1;
    public static final int BLUE_TOOTH_NOT_SUPPORT = 2;
    public static final int BLUE_TOOTH_CONNECT_SUCCESS = 3;


    //接口名称的字符串
    public static final String APP_INTERFACE_LASTED = ".shtml";
    public static final String APP_INTERFACE_LOGIN = "appCarUser/appLogin" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_REGIST = "appCarUser/appCarUserRegister" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_UPLOAD = "appOBD/appTestData" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_EASY_DESTROY = "appSpareParts/appVulnerablePartQuery" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_LINGJIAN_DETAILS = "appSpareParts/getAppPartId" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_SYSTEM_CONFIG = "appSystem/getAppSystem" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_CHECK_RESULT = "appOBD/appTestData" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_REQUEST_RESULT = "appOBD/appResultData" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_RECOMMENT_FACTORY = "appCarRepairFactory/getAppRecommendFactory" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_OTHER_FACTORY = "appCarRepairFactory/getAppOtherFactory" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_ALL_MODELS = "appCarUser/modelsAll" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_ALL_BRAND = "appCarUser/brandAll" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_DETAILS_CHECK_ALL = "appProblem/getAppProblemAll" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_KNOWLEDGE_ALL = "appKnowledgeBase/getAppAllKnowledgeBase" + APP_INTERFACE_LASTED;
    public static final String APP_INTERFACE_KNOWLEDGE_ID = "appKnowledgeBase/getAppKnowledgeBaseId" + APP_INTERFACE_LASTED;

    //activity跳转的requestCode
    public static final int TO_REGIST_CODE = 100;


    //activity跳转的resultCode
    public static final int RESULT_REGIST_CODE = 1001;


    //请求接口的参数的字段
    public static final String BRAND_ID = "modeId";
    public static final String USERINFO_NAME = "name";
    public static final String USERINFO_PASSWORD = "password";
    public static final String USERINFO_AGE = "age";
    public static final String USERINFO_CHARACTERS = "characters";
    public static final String USERINFO_SEX = "sex";
    public static final String USERINFO_PHONE = "phone";
    public static final String USERINFO_HOBBY = "hobby";
    public static final String USERINFO_ADDRESS = "address";
    public static final String USERINFO_BLUETOOTH = "bluetooth";
    public static final String USERINFO_BRANDID = "brandId";
    public static final String USERINFO_MODELSID = "modelsId";
    public static final String USERINFO_YEARS = "years";
    public static final String USERINFO_COLOR = "carColour";
    public static final String USERINFO_MILEAGE = "mileage";
    public static final String USERINFO_CARNUMBER = "carNumber";
    //上传检测文件的接口的字段
    public static final String UPLOAD_DETECTIONTIME = "detectionTime";
    public static final String ID = "id";
    public static final String UPLOAD_TESTDATA = "testData";
    //轮询检测服务器端文件的时间间隔
    public static final long LOOP_TIME = 5000;
    public static final String CHECK_FILE_NAME = "fileName";
    public static final String CHECK_CHECK_DATA = "checkData";
    //推荐汽修厂参数对应的字段(经纬度)
    public static final String LATTITUDE = "latitude";
    public static final String LONGITUDE = "longitude";


    //检查页面fragment对应的编号
    public static final int FRAGMENT_CHECKING = 0;
    public static final int FRAGMENT_HASPROBLEM = 1;
    public static final int FRAGMENT_NOPROBLEM = 2;
    public static final int FRAGMENT_NOBLUETOOTH = 3;

    //蓝牙设备的UUID
    public static final String DEVICE_UUID = "00001101-0000-1000-8000-00805F9B34FB";

    //Intent传递数据的key值
    public static final String INTENT_KEY_LINGJIAN_ID = "lingjian_id";
    public static final String INTENT_KEY_VIDEO = "video";
    public static final String INTENT_FACTORY_INFO = "intent_factory_info";
    public static final String INTENT_GUIDE = "intent_guide";
    public static final String INTENT_PARTS_ID = "intent_parts_id";
    public static final String INTENT_LATTITUDE = "intent_lattitude";
    public static final String INTENT_LONGITUDE = "intent_longitude";
    public static final String INTENT_DETAILS_CHECK_ALL = "intent_details_check_all";
    public static final String INTENT_KNOWLEDGE_DETAILS = "intent_knowledge_details";


    //给OBD发送的消息
    public static final String OBD_MSG_07 = "07";
    public static final String OBD_MSG_010C = "010C";


}
