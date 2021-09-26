package com.intrum.tests.stepDefinitions;

import com.intrum.tests.browser.BrowserBuilder;
import com.intrum.tests.helpers.TestCaseContext;
import com.intrum.tests.helpers.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.intrum.tests.helpers.TestCaseContext.*;
import static org.openqa.selenium.OutputType.BYTES;
import static org.slf4j.LoggerFactory.getLogger;

public class Hooks {

    private static final Logger LOGGER = getLogger(Hooks.class);

    private static final String SIMPLE_DATE_FORMAT = "yyyy.MM.dd.HH.mm.ss";

    private static final String MEDIA_TYPE_BROWSER_LOG = "text/plain";

    private static final String MEDIA_TYPE_IMAGE = "image/png";

    @Before
    public void Before() {
        LOGGER.info("Starting browser");
        BrowserBuilder builder = new BrowserBuilder();
        builder.setBrowserName(getCONFIG().getBrowserName());

        LOGGER.info("Adding browser to test case TestCaseContext");
        setBrowser(builder.build());

        LOGGER.info("Generate User for tests purposes");
        User testUser = new User();
        setUser(testUser);
    }

    @After
    public void After(Scenario scenario) {
        LOGGER.info("Closing browser");
        if (scenario.isFailed()) {
            String timeStamp = new SimpleDateFormat(SIMPLE_DATE_FORMAT).format(new Date());
            saveBrowserLogsForScenario(scenario, timeStamp);
            saveScreenshotsForScenario(scenario, timeStamp);
        }
        getBrowser().close();
    }

    private void saveBrowserLogsForScenario(Scenario scenario, String timeStamp) {
        LOGGER.info("Saving browser log on failure");
        List<LogEntry> logEntries = getBrowser().manage().logs().get(LogType.BROWSER).getAll();
        List<String> logMessages = logEntries.stream().map(LogEntry::getMessage).collect(Collectors.toList());
        scenario.attach(logMessages.toString(), MEDIA_TYPE_BROWSER_LOG, "browser_log_" + timeStamp);
    }

    private void saveScreenshotsForScenario(final Scenario scenario, String timeStamp) {
        LOGGER.info("Saving screenshot on failure");
        final byte[] screenshot = ((TakesScreenshot) getBrowser()).getScreenshotAs(BYTES);
        scenario.attach(screenshot, MEDIA_TYPE_IMAGE, "image_" + timeStamp);
    }
}
