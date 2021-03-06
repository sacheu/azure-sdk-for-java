// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.labservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Payload to get the status of an operation. */
@Fluent
public final class OperationBatchStatusPayload {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(OperationBatchStatusPayload.class);

    /*
     * The operation url of long running operation
     */
    @JsonProperty(value = "urls", required = true)
    private List<String> urls;

    /**
     * Get the urls property: The operation url of long running operation.
     *
     * @return the urls value.
     */
    public List<String> urls() {
        return this.urls;
    }

    /**
     * Set the urls property: The operation url of long running operation.
     *
     * @param urls the urls value to set.
     * @return the OperationBatchStatusPayload object itself.
     */
    public OperationBatchStatusPayload withUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (urls() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property urls in model OperationBatchStatusPayload"));
        }
    }
}
