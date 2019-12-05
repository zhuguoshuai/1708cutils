package com.bw.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Java璇诲彇鏂囦欢宸ュ叿绫烩�斺�擨O
 * <璇锋浛鎹㈡垚鍔熻兘鎻忚堪> <br>
 * <璇锋浛鎹㈡垚璇︾粏鎻忚堪>
 * @author caizh
 * @since [1.0.0]
 * @version [1.0.0,2017骞�2鏈�6鏃
 */
public class IOToFileUtils {

    /**
     * 浠ュ瓧鑺備负鍗曚綅璇诲彇鏂囦欢锛屽父鐢ㄤ簬璇诲彇浜岃繘鍒舵枃浠讹紝濡傦細鍥剧墖銆佸０闊炽�佸奖鍍忕瓑
     * <璇锋浛鎹㈡垚鍔熻兘鎻忚堪> <br>
     * <璇锋浛鎹㈡垚璇︾粏鎻忚堪>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017骞�2鏈�6鏃
     */
    public static void readFileByBytes(String fileName){
        File file = new File(fileName);
        InputStream in = null;
        try{
            System.out.println("浠ュ瓧鑺備负鍗曚綅璇诲彇鏂囦欢鍐呭锛屼竴娆¤涓�涓瓧鑺傦細");
            //涓�娆¤鍙栦竴涓瓧鑺�
            in = new FileInputStream(file);
            int tempbyte;
            while((tempbyte=in.read())!= -1){
                System.out.write(tempbyte);
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
        try{
            System.out.println("浠ュ瓧鑺備负鍗曚綅璇诲彇鏂囦欢鍐呭锛屼竴娆¤鍙栧涓瓧鑺傦細");
            //涓�娆¤鍙栧涓瓧鑺�
            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            in = new FileInputStream(fileName);
            showAvailableBytes(in);
            //璇诲叆澶氫釜瀛楄妭鍒板瓧鑺傛暟缁勪腑锛宐yteread涓轰竴娆¤鍏ョ殑瀛楄妭鏁�
            while((byteread=in.read(tempbytes))!= -1){
                System.out.write(tempbytes, 0, byteread);;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 浠ュ瓧绗︿负鍗曚綅璇诲彇鏂囦欢锛屽父鐢ㄤ簬璇诲彇鏂囨湰锛屾暟瀛楃瓑绫诲瀷鐨勬枃浠�
     * <璇锋浛鎹㈡垚鍔熻兘鎻忚堪> <br>
     * <璇锋浛鎹㈡垚璇︾粏鎻忚堪>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017骞�2鏈�6鏃
     */
    public static void readFileByChars(String fileName){
        File file = new File(fileName);
        Reader reader = null;
        try{
            System.out.println("浠ュ瓧绗︿负鍗曚綅璇诲彇鏂囦欢鍐呭锛屼竴娆¤鍙栦竴涓瓧绗︼細");
            //涓�娆¤鍙栦竴涓瓧绗�
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while((tempchar=reader.read())!= -1){
                //瀵逛簬window涓嬶紝/r/n杩欎袱涓瓧绗﹀湪涓�璧锋椂锛岃〃绀轰竴涓崲琛屻��
                //浣嗗鏋滆繖涓や釜瀛楃鍒嗗紑鏄剧ず鏄紝浼氭崲涓ゆ琛屻��
                //鍥犳锛屽睆钄芥帀/r,鎴栬�呭睆钄�/n銆傚惁鍒欙紝灏嗕細澶氬嚭寰堝绌鸿
                if(((char)tempchar)!= '\r'){
                    System.out.print((char)tempchar);
                }
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();  
        }
        try{
            System.out.println("浠ュ瓧绗︿负鍗曚綅璇诲彇鏂囦欢鍐呭锛屼竴娆¤鍙栧涓瓧绗︼細");
            //涓�娆¤鍙栧涓瓧绗�
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            //璇诲彇澶氫釜瀛楃鍒板瓧绗︽暟缁勪腑锛宑harread涓轰竴娆¤鍙栧瓧绗︽暟
            while((charread=reader.read(tempchars))!=-1){
                //灞忚斀鎺�/r涓嶆樉绀�
                if((charread == tempchars.length) && (tempchars[tempchars.length-1]!='\r')){
                    System.out.print(tempchars);
                }else{
                    for(int i=0;i<charread;i++){
                        if(tempchars[i] == '\r'){
                            continue;
                        }else{
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 浠ヨ涓哄崟浣嶈鍙栨枃浠讹紝甯哥敤浜庤鍙栭潰鍚戣鐨勬牸寮忓寲鏂囦欢
     * <璇锋浛鎹㈡垚鍔熻兘鎻忚堪> <br>
     * <璇锋浛鎹㈡垚璇︾粏鎻忚堪>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017骞�2鏈�6鏃
     */
    public static void readFileByLines(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;
        try{
            System.out.println("浠ヨ涓哄崟浣嶈鍙栨枃浠跺唴瀹癸紝涓�娆¤鍙栦竴鏁磋锛�");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //涓�娆¤鍏ヤ竴琛岋紝鐩村埌璇诲叆null涓烘枃浠剁粨鏉�
            while((tempString = reader.readLine())!=null){
                //鏄剧ず琛屽彿
                System.out.println("line "+line+":"+tempString);
                line++;
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static List<String> readFileByLinesList(String fileName){
        File file = new File(fileName);
        BufferedReader reader = null;
        List<String> list=new ArrayList<String>();
        try{
            System.out.println("浠ヨ涓哄崟浣嶈鍙栨枃浠跺唴瀹癸紝涓�娆¤鍙栦竴鏁磋锛�");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
           // int line = 1;
            //涓�娆¤鍏ヤ竴琛岋紝鐩村埌璇诲叆null涓烘枃浠剁粨鏉�
            while((tempString = reader.readLine())!=null){
                //鏄剧ず琛屽彿
               // System.out.println("line "+line+":"+tempString);
               // line++;
            	list.add(tempString);
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
		return list;
    }

    /**
     * 闅忔満璇诲彇鏂囦欢鍐呭
     * <璇锋浛鎹㈡垚鍔熻兘鎻忚堪> <br>
     * <璇锋浛鎹㈡垚璇︾粏鎻忚堪>
     * @param fileName
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017骞�2鏈�6鏃
     */
    public static void readFileByRandomAccess(String fileName){
        RandomAccessFile randomFile = null;
        try{
            System.out.println("闅忔満璇诲彇涓�娈垫枃浠跺唴瀹癸細");
            //鎵撳紑涓�涓殢鏈鸿闂枃浠舵祦锛屾寜鍙鏂瑰紡
            randomFile = new RandomAccessFile(fileName,"r");
            //鏂囦欢闀垮害锛屽瓧鑺傛暟
            long fileLength = randomFile.length();
            //璇绘枃浠剁殑璧峰浣嶇疆
            int beginIndex = (fileLength>4)?4:0;
            //灏嗚鍙栨枃浠剁殑寮�濮嬩綅缃Щ鍒癰eginIndex鐨勪綅缃笂
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            //涓�娆¤鍙�10涓瓧鑺傦紝濡傛灉鏂囦欢鍐呭涓嶈冻10涓瓧鑺傦紝鍒欒鍙栧墿涓嬬殑瀛楄妭銆�
            //灏嗕竴娆¤鍙栫殑瀛楄妭鏁拌祴缁檅yteread
            while((byteread = randomFile.read(bytes))!= -1){
                System.out.write(bytes,0,byteread);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(randomFile!=null){
                try {
                    randomFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 鏄剧ず杈撳叆娴佷腑杩樺墿鐨勫瓧鑺傛暟
     * <璇锋浛鎹㈡垚鍔熻兘鎻忚堪> <br>
     * <璇锋浛鎹㈡垚璇︾粏鎻忚堪>
     * @param in
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017骞�2鏈�6鏃
     */
    public static void showAvailableBytes(InputStream in){
        try{
            System.out.println("褰撳墠瀛楄妭杈撳叆娴佷腑鐨勫瓧鑺傛暟涓猴細"+in.available());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 灏嗗唴瀹硅拷鍔犲埌鏂囦欢灏鹃儴  A鏂规硶锛氫娇鐢≧andomAccessFile
     * <璇锋浛鎹㈡垚鍔熻兘鎻忚堪> <br>
     * <璇锋浛鎹㈡垚璇︾粏鎻忚堪>
     * @param fileName 鍖呭惈瀹屾暣璺緞鐨勬枃浠跺悕
     * @param content 瑕佽拷鍔犵殑鍐呭
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017骞�2鏈�6鏃
     */
    public static void appendToFile_A(String fileName,String content){
        try{
            //鎵撳紑涓�涓殢鏈鸿闂殑鏂囦欢娴侊紝鎸夎鍐欐柟寮�
            RandomAccessFile randomFile = new RandomAccessFile(fileName,"rw");
            //鏂囦欢闀垮害锛屽瓧鑺傛暟
            long fileLength = randomFile.length();
            //灏嗗啓鏂囦欢鎸囬拡绉诲埌鏂囦欢灏鹃儴
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 灏嗗唴瀹硅拷鍔犲埌鏂囦欢灏鹃儴  B鏂规硶锛氫娇鐢‵ileWriter
     * <璇锋浛鎹㈡垚鍔熻兘鎻忚堪> <br>
     * <璇锋浛鎹㈡垚璇︾粏鎻忚堪>
     * @param fileName
     * @param content
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017骞�2鏈�6鏃
     */
    public static void appendToFile_B(String fileName,String content){
        try{
            //鎵撳紑涓�涓啓鏂囦欢鍣紝鏋勯�犲嚱鏁颁腑鐨勭浜屼釜鍙傛暟true琛ㄧず浠ヨ拷鍔犲舰寮忓啓鏂囦欢
            FileWriter writer = new FileWriter(fileName,true);            
            writer.write(content);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 灏嗗唴瀹硅拷鍔犲埌鏂囦欢灏鹃儴 C鏂规硶锛氫娇鐢˙ufferedWriter
     * <璇锋浛鎹㈡垚鍔熻兘鎻忚堪> <br>
     * <璇锋浛鎹㈡垚璇︾粏鎻忚堪>
     * @param fileName
     * @param content
     * @author caizh
     * @since [1.0.0]
     * @version [1.0.0,2017骞�2鏈�10鏃
     */
    public static void appendToFile_C(String fileName,String content){

        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName,true)));
            out.write(content);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                out.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
