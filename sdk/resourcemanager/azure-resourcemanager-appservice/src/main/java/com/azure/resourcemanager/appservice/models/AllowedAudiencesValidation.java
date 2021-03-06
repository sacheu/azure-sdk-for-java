// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.JsonFlatten;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The AllowedAudiencesValidation model. */
@JsonFlatten
@Fluent
public class AllowedAudiencesValidation extends ProxyOnlyResource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(AllowedAudiencesValidation.class);

    /*
     * The allowedAudiences property.
     */
    @JsonProperty(value = "properties.allowedAudiences")
    private List<String> allowedAudiences;

    /**
     * Get the allowedAudiences property: The allowedAudiences property.
     *
     * @return the allowedAudiences value.
     */
    public List<String> allowedAudiences() {
        return this.allowedAudiences;
    }

    /**
     * Set the allowedAudiences property: The allowedAudiences property.
     *
     * @param allowedAudiences the allowedAudiences value to set.
     * @return the AllowedAudiencesValidation object itself.
     */
    public AllowedAudiencesValidation withAllowedAudiences(List<String> allowedAudiences) {
        this.allowedAudiences = allowedAudiences;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public AllowedAudiencesValidation withKind(String kind) {
        super.withKind(kind);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
