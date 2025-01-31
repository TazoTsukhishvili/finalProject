

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class ApiTests {

    private final String BASE_URL = "https://reqres.in/api";

    @BeforeClass
    public void disableSSLVerification() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager[] trustManagers = new TrustManager[]{
                    new X509TrustManager() {
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {}

                        public void checkServerTrusted(X509Certificate[] chain, String authType) {}

                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };
            sslContext.init(null, trustManagers, new java.security.SecureRandom());
            RestAssured.useRelaxedHTTPSValidation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUsers() {
        Response response = RestAssured.get(BASE_URL + "/users?page=2");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John\", \"job\": \"Tester\" }";

        Response response = RestAssured
                .given()
                .relaxedHTTPSValidation()  // Bypasses SSL Verification
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(BASE_URL + "/users");

        Assert.assertEquals(response.getStatusCode(), 201);
    }
}