package de.fraunhofer.iem;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.api.FuzzerSecurityIssueMedium;

public class TaintFuzzer {

    public static void fuzzerTestOneInput(FuzzedDataProvider data) throws Exception {
        String input = data.consumeRemainingAsString();

        try {
            TaintExample.main(new String[]{input});
            //check code coverage

        } catch (Exception ignored) {
            throw new FuzzerSecurityIssueMedium("taint value found");
        }

    }
}
