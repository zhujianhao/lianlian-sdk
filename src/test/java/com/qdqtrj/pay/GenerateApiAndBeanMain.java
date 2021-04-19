package com.qdqtrj.pay;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class GenerateApiAndBeanMain {

    /**
     * *********************************************************************************************************
     * *********************************************************************************************************
     * *********************************************************************************************************
     * fixme  重要：生成dto可能会造成原有代码被覆盖，如果非必须，请不要将 IS_GEN_DTO 修改为 true
     * *********************************************************************************************************
     * *********************************************************************************************************
     * *********************************************************************************************************
     */
    private static final boolean IS_GEN_DTO = false;

    /**
     * TODO 直接运行前，唯一需要修改的：项目在本机的绝对路径
     */
    private static final String PROJECT_ROOT_ABSOLUTE_PATH = "/Users/yinbin/workspace/lianlianpay-accp-sdk/";
    private static final String TEMPLATE_PATH = PROJECT_ROOT_ABSOLUTE_PATH + "src/test/resources/templates";
    private static final String CLASS_PATH_TRADE = "src/main/java/com/qdqtrj/pay/api/trade/";

    /**
     * 中划线转驼峰
     *
     * @param param
     * @return
     */
    private static String midlelineToCamel(String param) {
        if (null == param || "".equals(param)) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = Character.toLowerCase(param.charAt(i));
            if (c == '-') {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 解析guanli.txt jiaoyi.txt纯文本到java对象并返回，方便后续绑定到freemark模板
     * guanli.txt jiaoyi.txt的生成参考：
     * http://172.16.120.88:18090/yinbin/auto-fil-form-script/tree/master/parse-pdf-to-txt
     *
     * @param pathname
     * @return
     * @throws IOException
     */
    private static List<Map> getData(String pathname) throws IOException {
        String guanliStr = FileUtils.readFileToString(new File(pathname));
//        System.out.println(guanliStr);
        String[] split = guanliStr.split("######");
        Iterator<Map> stringStream = Arrays.stream(split).map((apiStr) -> {
            apiStr = apiStr.trim();
            System.out.println("\n\n\n---------------------------------------------------------------------\n\n\n");
            System.out.println(apiStr);

            String[] lines = apiStr.split("\n");
            StringBuffer reqStr = new StringBuffer();
            int reqStartIdx = 0;
            int reqEndIdx = 0;
            int resStartIdx = 0;
            int resEndIdx = 0;
            int notifyStartIdx = 0;
            int notifyEndIdx = lines.length - 1;
            boolean isHaveNotify = false;
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
//                System.out.println("===============" + line);
                if ("请求参数".equals(line.trim())) {
                    reqStartIdx = i + 2;
                }
                if ("响应参数".equals(line.trim())) {
                    reqEndIdx = i - 1;
                    resStartIdx = i + 2;
                }
//                if ("异步通知".equals(line.trim())) {
                if (line.trim().contains("接口上送的notify_url地址")) {
                    resEndIdx = i - 1;
                    isHaveNotify = true;
                    notifyStartIdx = i + 2;
                }
            }
            if (!isHaveNotify) {
                resEndIdx = lines.length - 1;
            }

            // 地址
            String url = lines[1];
            // 注释
            String desc = lines[0] + lines[1];

            // 预处理字段数据，得到对应bean的字段列表
            String[] reqLines = Arrays.copyOfRange(lines, reqStartIdx, reqEndIdx + 1);
            String[] resLines = Arrays.copyOfRange(lines, resStartIdx, resEndIdx + 1);
            String[] notifyLines = new String[]{};
            if (isHaveNotify) {
                notifyLines = Arrays.copyOfRange(lines, notifyStartIdx, notifyEndIdx + 1);
            }

            Map m = new TreeMap();
            m.put("url", url);
            m.put("desc", desc);
            String className = url.substring(url.lastIndexOf("/") + 1);
            m.put("constantUrl", className.replace("-", "_").toUpperCase());
            m.put("constantUrlLower", url.substring(url.indexOf(".com") + 4));
            String reqClassName = midlelineToCamel("Req-" + className);
            m.put("methodName", midlelineToCamel(className));
            m.put("reqClassName", reqClassName.substring(0, 1).toUpperCase() + reqClassName.substring(1));
            String resClassName = midlelineToCamel("Res-" + className);
            m.put("resClassName", resClassName.substring(0, 1).toUpperCase() + resClassName.substring(1));
            if (isHaveNotify) {
                String notifyClassName = midlelineToCamel("Notify-" + className);
                m.put("notifyClassName", notifyClassName.substring(0, 1).toUpperCase() + notifyClassName.substring(1));
            }
            m.put("isHaveNotify", isHaveNotify);

            List<Map> reqFieldList = new ArrayList<>();
            for (String reqLine : reqLines) {
                Map reqFeild = new TreeMap();
                String[] farr = reqLine.split("  ");
                String fieldName = farr[0];
                String fieldDesc = String.join(",", farr);
                reqFeild.put("fieldName", fieldName);
                reqFeild.put("fieldDesc", fieldDesc);
                reqFieldList.add(reqFeild);
            }
            m.put("reqFieldList", reqFieldList);

            List<Map> resFieldList = new ArrayList<>();
            for (String reqLine : resLines) {
                Map reqFeild = new TreeMap();
                String[] farr = reqLine.split("  ");
                String fieldName = farr[0];
                String fieldDesc = String.join(",", farr);
                reqFeild.put("fieldName", fieldName);
                reqFeild.put("fieldDesc", fieldDesc);
                resFieldList.add(reqFeild);
            }
            m.put("resFieldList", resFieldList);

            List<Map> notifyFieldList = new ArrayList<>();
            for (String reqLine : notifyLines) {
                Map reqFeild = new TreeMap();
                String[] farr = reqLine.split("  ");
                String fieldName = farr[0];
                String fieldDesc = String.join(",", farr);
                reqFeild.put("fieldName", fieldName);
                reqFeild.put("fieldDesc", fieldDesc);
                notifyFieldList.add(reqFeild);
            }
            m.put("notifyFieldList", notifyFieldList);

            return m;
        }).iterator();

        Iterable<Map> stringIterable = () -> stringStream;
        List<Map> stringList = StreamSupport.stream(stringIterable.spliterator(), false).collect(Collectors.toList());
        return stringList;
    }

    /**
     * 生成api代码方法
     *
     * @param dataPath        guanli.txt或jiaoyi.txt path
     * @param reqDtoFtl       请求报文bean 对应 freemarker 模板 path
     * @param resDtoFtl       响应报文bean 对应 freemarker 模板 path
     * @param notifyDtoFtl    异步报文bean 对应 freemarker 模板 path
     * @param apiFtl          API接口 对应 freemarker 模板 path
     * @param apiImplFtl      API接口实现 对应 freemarker 模板 path
     * @param CLASS_PATH      生成目录 target path
     * @param packageName     生成java类中的包名
     * @param apiFileName     生成API接口的名称
     * @param apiImplFileName 生成API默认接口实现类的名称
     * @throws IOException
     */
    private static void genCode(String dataPath, String reqDtoFtl, String resDtoFtl, String notifyDtoFtl,
                                String apiFtl, String apiImplFtl, String CLASS_PATH, String packageName,
                                String apiFileName, String apiImplFileName) throws IOException {
        List<Map> apiDataList = getData(dataPath);
        if (IS_GEN_DTO) {
            for (Map mapData : apiDataList) {
                // 生成req dto bean
                if (null != mapData.get("reqClassName")) {
                    mapData.put("packageName", "package com.qdqtrj.pay.api." + packageName + ".dto.request;");
                    mapData.put("fileName", "/request/" + mapData.get("reqClassName"));
                    genClass(CLASS_PATH, "dto", reqDtoFtl, mapData);
                }
                // 生成res dto bean
                if (null != mapData.get("resClassName")) {
                    mapData.put("packageName", "package com.qdqtrj.pay.api." + packageName + ".dto.response;");
                    mapData.put("fileName", "/response/" + mapData.get("resClassName"));
                    genClass(CLASS_PATH, "dto", resDtoFtl, mapData);
                }
                // 生成notify callback dto bean
                if (null != mapData.get("notifyClassName")) {
                    mapData.put("packageName", "package com.qdqtrj.pay.api." + packageName + ".dto.callback;");
                    mapData.put("fileName", "/callback/" + mapData.get("notifyClassName"));
                    genClass(CLASS_PATH, "dto", notifyDtoFtl, mapData);
                }
            }
        }

        Map apiMap = new HashMap();
        apiMap.put("apiMethodList", apiDataList);
        apiMap.put("packageName", "package com.qdqtrj.pay.api." + packageName + ";");
        apiMap.put("fileName", apiFileName);

        // 生成接口
        genClass(CLASS_PATH, "", apiFtl, apiMap);

        // 生成实现类
        apiMap.put("packageName", "package com.qdqtrj.pay.api." + packageName + ".impl;");
        apiMap.put("fileName", apiImplFileName);
        genClass(CLASS_PATH, "", apiImplFtl, apiMap);
    }

    private static void genClass(String classPath, String packageName, String ftlFileName, Map<String, Object> dataMap) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step4 加载模版文件
            Template template = configuration.getTemplate(ftlFileName);
            // step5 生成数据

            String fileName = classPath + packageName + "/" + dataMap.get("fileName") + ".java";
            File docFile = new File(fileName);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            template.process(dataMap, out);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^" + fileName + " 文件创建成功 !");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * 接口生成器 入口方法
     *
     * @throws Exception
     */
    @Test
    public void gen() throws Exception {
//        通用配置，dto生成模版
        String manageReqDtoFtl = "reqdto.ftl";
        String manageResDtoFtl = "resdto.ftl";
        String manageNotifyDtoFtl = "notifydto.ftl";

//        生成管理类api
        String dataPath = PROJECT_ROOT_ABSOLUTE_PATH + "src/test/resources/guanli.txt";
        String manageApiFtl = "manageclient.ftl";
        String manageApiImplFtl = "manageclientimpl.ftl";
        String classPath = "src/main/java/com/qdqtrj/pay/api/manage/";
        String packageName = "manage";
        genCode(dataPath, manageReqDtoFtl, manageResDtoFtl, manageNotifyDtoFtl, manageApiFtl, manageApiImplFtl,
                classPath, packageName, "/IAccpManagePayClient", "/impl/AccpManagePayClientImpl");

//        生成交易类api
        dataPath = PROJECT_ROOT_ABSOLUTE_PATH + "src/test/resources/jiaoyi.txt";
        manageApiFtl = "tradeclient.ftl";
        manageApiImplFtl = "tradeclientimpl.ftl";
        classPath = "src/main/java/com/qdqtrj/pay/api/trade/";
        packageName = "trade";
        genCode(dataPath, manageReqDtoFtl, manageResDtoFtl, manageNotifyDtoFtl, manageApiFtl, manageApiImplFtl,
                classPath, packageName, "/IAccpTradePayClient", "/impl/AccpTradePayClientImpl");
    }

}
