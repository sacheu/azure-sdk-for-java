// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.servicebus;

import com.azure.messaging.servicebus.models.ServiceBusReceiveMode;
import org.junit.jupiter.api.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * Demonstrates how to receive messages from a named session.
 */
public class ReceiveNamedSessionAsyncSample {
    /**
     * Main method to invoke this demo on how to receive messages from a session with id "greetings" in an Azure Service
     * Bus Queue.
     *
     * @param args Unused arguments to the program.
     *
     * @throws InterruptedException If the program is unable to sleep while waiting for the operations to complete.
     */
    public static void main(String[] args) throws InterruptedException {
        ReceiveNamedSessionAsyncSample sample = new ReceiveNamedSessionAsyncSample();
        sample.run();
    }

    /**
     * Method to invoke this demo on how to receive messages from a session with id "greetings" in an Azure Service
     * Bus Queue.
     *
     * @throws InterruptedException If the program is unable to sleep while waiting for the operations to complete.
     */
    @Test
    public void run() throws InterruptedException {

        // The connection string value can be obtained by:
        // 1. Going to your Service Bus namespace in Azure Portal.
        // 2. Go to "Shared access policies"
        // 3. Copy the connection string for the "RootManageSharedAccessKey" policy.

        // We are reading 'connectionString/queueName' from environment variable. Your application could read it from
        // some other source. The 'connectionString' format is shown below.
        // 1. "Endpoint={fully-qualified-namespace};SharedAccessKeyName={policy-name};SharedAccessKey={key}"
        // 2. "<<fully-qualified-namespace>>" will look similar to "{your-namespace}.servicebus.windows.net"
        // 3. "queueName" will be the name of the Service Bus queue instance you created
        //    inside the Service Bus namespace.

        String connectionString = System.getenv("AZURE_SERVICEBUS_NAMESPACE_CONNECTION_STRING");
        String queueName = System.getenv("AZURE_SERVICEBUS_SAMPLE_SESSION_QUEUE_NAME");

        // Create a receiver.
        ServiceBusSessionReceiverAsyncClient sessionReceiver = new ServiceBusClientBuilder()
            .connectionString(connectionString)
            .sessionReceiver()
            .receiveMode(ServiceBusReceiveMode.PEEK_LOCK)
            .queueName(queueName)
            .buildAsyncClient();

        // Receiving messages that have the sessionId "greetings-id" set. This can be set via
        // ServiceBusMessage.setMessageId(String) when sending a message.

        // The Mono completes successfully when a lock on the session is acquired, otherwise, it completes with an
        // error.
        Mono<ServiceBusReceiverAsyncClient> receiverMono = sessionReceiver.acceptSession("greetings-id");

        // If the session is successfully accepted, begin receiving messages from it.
        // Flux.usingWhen is used to dispose of the receiver after consuming messages completes.
        Disposable subscription = Flux.usingWhen(receiverMono,
            receiver -> receiver.receiveMessages(),
            receiver -> Mono.fromRunnable(() -> receiver.close()))
            .subscribe(message -> {
                // Process message.
                System.out.printf("Session: %s. Sequence #: %s. Contents: %s%n", message.getSessionId(),
                    message.getSequenceNumber(), message.getBody());

                // When this message function completes, the message is automatically completed. If an exception is
                // thrown in here, the message is abandoned.
                // To disable this behaviour, toggle ServiceBusSessionReceiverClientBuilder.disableAutoComplete()
                // when building the session receiver.
            }, error -> System.err.println("Error occurred: " + error));

        // Subscribe is not a blocking call so we sleep here so the program does not end.
        TimeUnit.SECONDS.sleep(10);

        // Disposing of the subscription will cancel the receive() operation.
        subscription.dispose();

        // Close the receiver.
        sessionReceiver.close();
    }
}
