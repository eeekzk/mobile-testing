package eeetests;

import elements.ElementsUtils;
import eeetests.steps.ShoppingSteps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public ShoppingSteps steps;
    public ElementsUtils elements;

    @BeforeClass
    public void ConfigureAppium() {
        //Appium code -> Appium Server -> Mobile
        this.service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        this.service.start();

        try {
            Map<String, String> typedMap = new ObjectMapper().readValue(
                    getClass().getClassLoader().getResourceAsStream("capabilities.json"), new TypeReference<Map<String, String>>() {});
            UiAutomator2Options options = new UiAutomator2Options(typedMap);
            this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        this.steps = new ShoppingSteps(this.driver);
        this.elements = new ElementsUtils(this.driver);
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
        this.service.stop();
    }
}
