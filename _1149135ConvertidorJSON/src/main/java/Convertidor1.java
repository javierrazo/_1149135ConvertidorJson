import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.XML;

public class Convertidor1 {



    public String convertirClaseToJson(String clase){

        try {
            String[] parts = clase.split(", ");
            Alumno al = new Alumno(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
            Gson gson=new Gson();
            return gson.toJson(al);
        }catch (java.lang.ArrayIndexOutOfBoundsException e){
            return "1";
        }catch (java.lang.NumberFormatException e) {
            return "1";
        }
    }

    public String convertirXmlToJson(String clase){
        JSONObject xmlJSONObj = XML.toJSONObject(clase);
        String jsonPrettyPrintString = xmlJSONObj.toString();
        return jsonPrettyPrintString;
    }

}
