/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.resourcemover.v2021_01_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Summary item.
 */
public class Summary {
    /**
     * Gets the count.
     */
    @JsonProperty(value = "count")
    private Integer count;

    /**
     * Gets the item.
     */
    @JsonProperty(value = "item")
    private String item;

    /**
     * Get gets the count.
     *
     * @return the count value
     */
    public Integer count() {
        return this.count;
    }

    /**
     * Set gets the count.
     *
     * @param count the count value to set
     * @return the Summary object itself.
     */
    public Summary withCount(Integer count) {
        this.count = count;
        return this;
    }

    /**
     * Get gets the item.
     *
     * @return the item value
     */
    public String item() {
        return this.item;
    }

    /**
     * Set gets the item.
     *
     * @param item the item value to set
     * @return the Summary object itself.
     */
    public Summary withItem(String item) {
        this.item = item;
        return this;
    }

}
