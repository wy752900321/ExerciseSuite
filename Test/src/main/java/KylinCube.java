
import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/*
 * auth  : lidan20
 * email : 754768903@qq.com
 * comp  : baidu
 * info  : http://kylin.apache.org/docs15/howto/howto_use_restapi.html#get-job-status
 * run   : java -jar KylinInterface.jar CUBE_NAME 20160806 20160807 BUILD
 */
public class KylinCube {


    public static void main(String[] args) {

        String AUTH = "ADMIN:KYLIN";

        String cubename = args[0]; //参数一 cubename like  'CUBE_DWD_PAY_USER_DETAIL_DF_DETAIL'

        String starttime = getTime(args[1]);                  //参数二 starttime like  'yyyyMMdd'

        String endtime = getTime(args[2]);                    //参数三 endtime like  'yyyyMMdd'

        String oper = args[3];                       //参数四 bulidtype like  'BUILD|MERGE|REFRESH'


        String PARAMS = "{\"startTime\": " + starttime + ",\"endTime\": " + endtime + ",\"buildType\": \"" + oper + "\"}";

        System.out.print(PARAMS);
        String PATH = "http://ip:7070/kylin/api/cubes/" + cubename + "/rebuild";


        //System.out.print(cubename+starttime+endtime+oper);
        System.out.println(Put(AUTH, PATH, PARAMS));
    }

    public static String getTime(String strdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long unixtime = 0;
        try {
            unixtime = sdf.parse(strdate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(unixtime);
    }

    public static String Put(String auth, String addr, String params) {
        String result = "";
        try {
            URL url = new URL(addr);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            //String auth = ACCOUNT + ":" + PWD;
            String code = new String(new Base64().encode(auth.getBytes()));
            connection.setRequestProperty("Authorization", "Basic " + code);
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.write(params);
            out.close();
            BufferedReader in;
            try {
                in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
            } catch (FileNotFoundException exception) {
                java.io.InputStream err = ((HttpURLConnection) connection).getErrorStream();
                if (err == null)
                    throw exception;
                in = new BufferedReader(new InputStreamReader(err));
            }
            StringBuffer response = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null)
                response.append(line + "\n");
            in.close();
            result = response.toString();
        } catch (MalformedURLException e) {
            System.err.println(e.toString());
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        return result;
    }
}