package co.soft.anonsms.service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class SmsService {

    private static final String URI = "https://textbelt.com/text";

    public String sendAnonymousSms(String toPhoneNumber, String messageText, String key) throws IOException {
        final NameValuePair[] data = {
          new BasicNameValuePair("phone", toPhoneNumber),
          new BasicNameValuePair("message", messageText),
          new BasicNameValuePair("key", key)
        };
        
        CloseableHttpClient httpClient = HttpClients.createMinimal();
        HttpPost httpPost = new HttpPost(URI);
        httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(data)));
        HttpResponse httpResponse = httpClient.execute(httpPost);
        String responseString = EntityUtils.toString(httpResponse.getEntity());

        JSONObject response = new JSONObject(responseString);

        return response.toString();

    }
}
