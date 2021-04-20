// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storageimportexport.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.storageimportexport.fluent.models.LocationInner;

/** An instance of this class provides access to all the operations defined in LocationsClient. */
public interface LocationsClient {
    /**
     * Returns a list of locations to which you can ship the disks associated with an import or export job. A location
     * is a Microsoft data center region.
     *
     * @throws com.azure.resourcemanager.storageimportexport.models.ErrorResponseException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return locations response.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LocationInner> list();

    /**
     * Returns a list of locations to which you can ship the disks associated with an import or export job. A location
     * is a Microsoft data center region.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.storageimportexport.models.ErrorResponseException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return locations response.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<LocationInner> list(Context context);

    /**
     * Returns the details about a location to which you can ship the disks associated with an import or export job. A
     * location is an Azure region.
     *
     * @param locationName The name of the location. For example, West US or westus.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.storageimportexport.models.ErrorResponseException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return provides information about an Azure data center location.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    LocationInner get(String locationName);

    /**
     * Returns the details about a location to which you can ship the disks associated with an import or export job. A
     * location is an Azure region.
     *
     * @param locationName The name of the location. For example, West US or westus.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.resourcemanager.storageimportexport.models.ErrorResponseException thrown if the request is
     *     rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return provides information about an Azure data center location.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<LocationInner> getWithResponse(String locationName, Context context);
}
