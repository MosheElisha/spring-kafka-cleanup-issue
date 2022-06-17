package org.example.tests;

import org.example.MarkDirtyExecutionListener;
import org.example.TestConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = TestConfiguration.class)
@TestExecutionListeners( // comment this line to see that things are not cleaned up by default
        value = MarkDirtyExecutionListener.class,
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS
)
class SpringKafkaTest {

    @Test
    void simpleTest() {
    }

    @KafkaListener(topics = "someTopic", groupId = "someGroup")
    public void listenToSomeTopic(@Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY) String messageKey) {
    }

}
