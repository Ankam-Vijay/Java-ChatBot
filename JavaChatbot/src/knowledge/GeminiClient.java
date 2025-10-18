package knowledge;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import org.json.*;
import org.json.JSONObject;
import java.net.URL;

public class GeminiClient {
    // ... (API_KEY loading stays the same)

    
     public static String fetchAnswer(String prompt) {
    try {
        URL url = new URL("https://generativelanguage.googleapis.com/v1alpha/models/gemini-1.5-flash:generateContent?key=" + "AIzaSyByxSf2FnBcTWgweNsGv_I_47T4zT4aWHU");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);

        String payload = "{ \"contents\": [ { \"parts\": [ { \"text\": \"" + prompt.replace("\"", "\\\"") + "\" } ] } ] }";
        try (OutputStream os = conn.getOutputStream()) {
            os.write(payload.getBytes("UTF-8"));
        }

        int status = conn.getResponseCode();
        if (status != 200) {
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            StringBuilder errorMsg = new StringBuilder();
            String line;
            while ((line = errorReader.readLine()) != null) errorMsg.append(line);
            errorReader.close();
            return "Gemini API call failed: HTTP " + status + " → " + errorMsg.toString();
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) response.append(line);
        in.close();

        return response.toString();
    } catch (Exception e) {
        return "Gemini API call failed: " + e.getClass().getSimpleName() + " → " + e.getMessage();
    }
}
    private static String escapeJson(String text) {
        return text.replace("\"", "\\\"").replace("\n", "\\n");
    }
  
}