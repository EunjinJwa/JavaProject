package jinny.study.junit;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CustomerExtension implements AfterEachCallback, BeforeEachCallback {
    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " " + extensionContext.getDisplayName() + " has started" );
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " " + extensionContext.getDisplayName() + " has finished");
    }
}
