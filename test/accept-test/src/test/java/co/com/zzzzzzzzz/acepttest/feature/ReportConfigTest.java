package co.com.bancolombia.acepttest.feature;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@KarateOptions(tags = {"~@ignore"})
public class PaymentOrderTest {
	
	private static final int CUATRO = 4;
	private static final int CERO = 0;
	private static final String TEXTO_1 = "json";
	private static final String TEXTO_2 = "target";
	private static final String TEXTO_3= "Modulo xxx-xxx";

	
    @Test
    public void testParallel() {
        Results results = Runner.parallel(getClass(), CUATRO);
        generateReport(results.getReportDir());
        Assert.assertTrue(results.getErrorMessages(), results.getFailCount() == CERO);
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{TEXTO_1}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File(TEXTO_2), TEXTO_3);
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}
