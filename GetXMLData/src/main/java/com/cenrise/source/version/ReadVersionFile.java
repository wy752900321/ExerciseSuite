package com.cenrise.source.version;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Properties;

import com.cenrise.util.Const;
import com.cenrise.util.Const;

/**
 *
 *
 * @author lichao
 * @since 2012-july-11
 */
public class ReadVersionFile {

    private static ReadVersionFile readVersionFile;
    //2012-09-07,added by jiayf , 增加kettle安装目录属性。#TIETL-1110
    public final static String KETTLE_DIR = "KETTLE_DIR";

    /**
     * @return the instance of the ReadVersionFile singleton
     */
    public static final ReadVersionFile getInstance() {
        if (readVersionFile != null) {
            return readVersionFile;
        }

        readVersionFile = new ReadVersionFile();

        return readVersionFile;
    }
    private String productName;
    private String productVersion;
    private String prodcutRelease;
    private String companyInfo;
    private String companyWebSite;
    private static final String DEFAULT_TI_VER_DAT_NAME = "tietl_ver.dat";
    private static String pathEndWithSeparator = null; // 以分隔符("/"或"\")结尾的目录路径
    private static String tiVerDatName = null; // 系统版本信息文件的名称

    private ReadVersionFile() {
        Properties properties = new Properties();

        try {
            //2012-09-07,modified by jiayf , 修改加载文件的位置。#TIETL-1110
            pathEndWithSeparator = getPathEndWithSeparator(getEnv(KETTLE_DIR));
            tiVerDatName = DEFAULT_TI_VER_DAT_NAME;
            String tiVerDatFullPath = pathEndWithSeparator
                    + (tiVerDatName == null ? DEFAULT_TI_VER_DAT_NAME
                    : tiVerDatName);

            
            InputStream inputStream = new BufferedInputStream(
                    new FileInputStream(tiVerDatFullPath));
            InputStreamReader isd = new InputStreamReader(inputStream, "utf-8");
            try {
            	properties.load(isd);
                productName = properties.getProperty("TI_Product_Name");
                productVersion = properties.getProperty("TI_Product_Version");
                prodcutRelease = properties.getProperty("TI_Product_Release");
                companyInfo = properties.getProperty("TI_Company_Info");
                companyWebSite = properties.getProperty("TI_Company_WebSite");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            	if (isd!=null){
            		isd.close();
            	}
            	if (inputStream!=null){
            		inputStream.close();
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static boolean isWindows() {
        String osName = System.getProperty("os.name").toLowerCase(Locale.US);
        return osName.indexOf("windows") > -1;
    }

    /**
     * Normalizes the path to cater for Windows and other platforms
     */
    public static String normalizePath(String path) {
        // special handling for Windows where we need to convert / to \\
        if (path != null && isWindows() && path.indexOf('/') >= 0) {
            return path.replace('/', '\\');
        }
        return path;
    }

    private static String getPathEndWithSeparator(String path) {
        String t = path.substring(path.length() - 1);
        if (!"\\".equals(t) && !"/".equals(t)) {
            path += File.separator;
        }
        path = normalizePath(path);
        return path;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productVersion
     */
    public String getProductVersion() {
        return productVersion;
    }

    /**
     * @param productVersion the productVersion to set
     */
    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    /**
     * @return the prodcutRelease
     */
    public String getProdcutRelease() {
        return prodcutRelease;
    }

    /**
     * @param prodcutRelease the prodcutRelease to set
     */
    public void setProdcutRelease(String prodcutRelease) {
        this.prodcutRelease = prodcutRelease;
    }

    /**
     * @return the companyInfo
     */
    public String getCompanyInfo() {
        return companyInfo;
    }

    /**
     * @param companyInfo the companyInfo to set
     */
    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    /**
     * @return the companyWebSite
     */
    public String getCompanyWebSite() {
        return companyWebSite;
    }

    /**
     * @param companyWebSite the companyWebSite to set
     */
    public void setCompanyWebSite(String companyWebSite) {
        this.companyWebSite = companyWebSite;
    }

    // 2012-09-06,added by jiayf ，获取环境变量
    public static String getEnv(String key) throws IOException {
        String value = null;
        if (key == null || key.length() < 1) {
            return null;
        } else {
            String s = null;
            value = System.getProperty(key);
            if (s == null) {
                String OS = System.getProperty("os.name").toLowerCase();
                Process p = null;
                if (OS.indexOf("windows") > -1) {
                    p = Runtime.getRuntime().exec("cmd /c set"); // Windows系列
                } else if (OS.indexOf("linux") > -1 || OS.indexOf("aix") > -1
                        || OS.indexOf("unix") > -1) {
                    p = Runtime.getRuntime().exec("/bin/sh -c set"); // Unix系列
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        p.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    int i = line.indexOf("=");
                    if (i > -1) {
                        if (key.equalsIgnoreCase(line.substring(0, i))) {
                            value = line.substring(i + 1);
                            break;
                        }
                    }
                }
            }

        }

        //Ubuntu Linux中获取的环境变量带引号，如'.'，这里去掉引号  add by liuxu 2014-03-05 ETL-778
        if (!Const.isEmpty(value) && value.length() >= 2 && value.startsWith("'") && value.endsWith("'")) {
            value = value.substring(1, value.length() - 1);
        }
        return value;
    }
}
