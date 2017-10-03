import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.Stack;
import java.time.format.*;
import java.io.*;
/**
 * Created by YuebinYang on 9/27/17.
 */
import java.util.*;
public class validFormat {
    public Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {
        List<String> result = new ArrayList<String>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

        boolean inRange = false;
        for(String line: logLines)
        {
            String[] input = line.split("\\s+");
            try
            {
                LocalTime time = LocalTime.parse(input[0], formatter);

                String s1 = startDate.toString();
                String s = time.toString();
                if(s.equals(s1) || (time.isAfter(startDate) && time.isBefore(endDate)))
                {
                    inRange = true;
                    result.add(line);
                }
                else
                {
                    inRange = false;
                }
            }
            catch(Exception e)
            {
                if(inRange) result.add(line);
            }

        }
        return result;
    }

    public static void main (String argv[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("good.txt"));
        //String line;
        //while ((line = br.readLine()) != null) {
        //    String[] tokens = line.split(",");
        //
        //    System.out.println(tokens.length);
        //    for (int i = 0; i < tokens.length; i++) {
        //        System.out.println(i + "  " + tokens[i].trim());
        //    }
        //
        //}
        StringBuilder path = new StringBuilder();
        //BufferedWriter bw = new BufferedWriter(new FileWriter("good.txt"));
        ////String line;
        //while (!System.in.equals("end")) {
        //    System.out.println("good");
        //}
    }

    //public static void main(String[] args) throws IOException {
    //    File f = new File("good.txt");
    //    FileOutputStream f_out = new FileOutputStream(f);
    //    OutputStreamWriter writer = new OutputStreamWriter(f_out,"UTF-8");
    //    writer.append("hello girl");
    //    //File f = new File("a.txt");
    //    //FileOutputStream fop = new FileOutputStream(f);
    //    //// 构建FileOutputStream对象,文件不存在会自动新建
    //    //
    //    //OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
    //    //// 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
    //
    //    writer.append("中文输入");
    //    // 写入到缓冲区
    //
    //    writer.append("\r\n");
    //    //换行
    //
    //    writer.append("English");
    //    // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
    //
    //    writer.close();
    //    //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
    //
    //    //fop.close();
    //    // 关闭输出流,释放系统资源
    //
    //    FileInputStream fip = new FileInputStream(f);
    //    // 构建FileInputStream对象
    //
    //    InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
    //    // 构建InputStreamReader对象,编码与写入相同
    //
    //    StringBuffer sb = new StringBuffer();
    //    while (reader.ready()) {
    //        sb.append((char) reader.read());
    //        // 转成char加到StringBuffer对象中
    //    }
    //    System.out.println(sb.toString());
    //    reader.close();
    //    // 关闭读取流
    //
    //    fip.close();
    //    // 关闭输入流,释放系统资源
    //}
}
