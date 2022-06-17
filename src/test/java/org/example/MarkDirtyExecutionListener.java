
package org.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@ExtendWith({SpringExtension.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class MarkDirtyExecutionListener extends AbstractTestExecutionListener {

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        testContext.getApplicationContext()
                .getAutowireCapableBeanFactory()
                .autowireBean(this);
        testContext.markApplicationContextDirty(DirtiesContext.HierarchyMode.EXHAUSTIVE);
    }
}