package data;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JasonReader {
     public String productName,expectedResult;
    public void jasonReader() throws IOException, ParseException {
        String jasonFilePath="E:\\project\\framework\\dataFiles\\jason.jason";
        File srcFile= new File(jasonFilePath);
        JSONParser parser =new JSONParser();
        //for read data
        JSONArray jsonArray=(JSONArray) parser.parse(new FileReader(srcFile));
        //for loop on data
        for (Object jsonObject:jsonArray)
        {
            JSONObject person=(JSONObject)jsonObject;

            productName = (String) person.get("docName");      //enter the column name
            System.out.println(productName);

        }
    }
}
