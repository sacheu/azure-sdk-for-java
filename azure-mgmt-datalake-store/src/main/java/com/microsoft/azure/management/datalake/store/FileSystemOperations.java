/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.datalake.store;

import com.microsoft.azure.CloudException;
import com.microsoft.azure.management.datalake.store.models.AclStatusResult;
import com.microsoft.azure.management.datalake.store.models.AppendModeType;
import com.microsoft.azure.management.datalake.store.models.ContentSummaryResult;
import com.microsoft.azure.management.datalake.store.models.FileOperationResult;
import com.microsoft.azure.management.datalake.store.models.FileStatusesResult;
import com.microsoft.azure.management.datalake.store.models.FileStatusResult;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

/**
 * An instance of this class provides access to all the operations defined
 * in FileSystemOperations.
 */
public interface FileSystemOperations {
    /**
     * Appends to the specified file. This method supports multiple concurrent appends to the file. NOTE: Concurrent append and normal (serial) append CANNOT be used interchangeably. Once a file has been appended to using either append option, it can only be appended to using that append option.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param filePath The Data Lake Store path (starting with '/') of the file to which to append using concurrent append.
     * @param streamContents The file contents to include when appending to the file.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> concurrentAppend(String accountName, String filePath, byte[] streamContents) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Appends to the specified file. This method supports multiple concurrent appends to the file. NOTE: Concurrent append and normal (serial) append CANNOT be used interchangeably. Once a file has been appended to using either append option, it can only be appended to using that append option.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param filePath The Data Lake Store path (starting with '/') of the file to which to append using concurrent append.
     * @param streamContents The file contents to include when appending to the file.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall concurrentAppendAsync(String accountName, String filePath, byte[] streamContents, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Appends to the specified file. This method supports multiple concurrent appends to the file. NOTE: Concurrent append and normal (serial) append CANNOT be used interchangeably. Once a file has been appended to using either append option, it can only be appended to using that append option.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param filePath The Data Lake Store path (starting with '/') of the file to which to append using concurrent append.
     * @param streamContents The file contents to include when appending to the file.
     * @param appendMode Indicates the concurrent append call should create the file if it doesn't exist or just open the existing file for append. Possible values include: 'autocreate'
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> concurrentAppend(String accountName, String filePath, byte[] streamContents, AppendModeType appendMode) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Appends to the specified file. This method supports multiple concurrent appends to the file. NOTE: Concurrent append and normal (serial) append CANNOT be used interchangeably. Once a file has been appended to using either append option, it can only be appended to using that append option.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param filePath The Data Lake Store path (starting with '/') of the file to which to append using concurrent append.
     * @param streamContents The file contents to include when appending to the file.
     * @param appendMode Indicates the concurrent append call should create the file if it doesn't exist or just open the existing file for append. Possible values include: 'autocreate'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall concurrentAppendAsync(String accountName, String filePath, byte[] streamContents, AppendModeType appendMode, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Checks if the specified access is available at the given path.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param path The Data Lake Store path (starting with '/') of the file or directory for which to check access.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> checkAccess(String accountName, String path) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Checks if the specified access is available at the given path.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param path The Data Lake Store path (starting with '/') of the file or directory for which to check access.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall checkAccessAsync(String accountName, String path, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Checks if the specified access is available at the given path.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param path The Data Lake Store path (starting with '/') of the file or directory for which to check access.
     * @param fsaction File system operation read/write/execute in string form, matching regex pattern '[rwx-]{3}'
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> checkAccess(String accountName, String path, String fsaction) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Checks if the specified access is available at the given path.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param path The Data Lake Store path (starting with '/') of the file or directory for which to check access.
     * @param fsaction File system operation read/write/execute in string form, matching regex pattern '[rwx-]{3}'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall checkAccessAsync(String accountName, String path, String fsaction, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Creates a directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param path The Data Lake Store path (starting with '/') of the directory to create.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FileOperationResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FileOperationResult> mkdirs(String accountName, String path) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Creates a directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param path The Data Lake Store path (starting with '/') of the directory to create.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall mkdirsAsync(String accountName, String path, final ServiceCallback<FileOperationResult> serviceCallback) throws IllegalArgumentException;

    /**
     * Concatenates the list of source files into the destination file, removing all source files upon success.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param destinationPath The Data Lake Store path (starting with '/') of the destination file resulting from the concatenation.
     * @param sources A list of comma seperated Data Lake Store paths (starting with '/') of the files to concatenate, in the order in which they should be concatenated.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> concat(String accountName, String destinationPath, List<String> sources) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Concatenates the list of source files into the destination file, removing all source files upon success.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param destinationPath The Data Lake Store path (starting with '/') of the destination file resulting from the concatenation.
     * @param sources A list of comma seperated Data Lake Store paths (starting with '/') of the files to concatenate, in the order in which they should be concatenated.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall concatAsync(String accountName, String destinationPath, List<String> sources, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Concatenates the list of source files into the destination file, deleting all source files upon success. This method accepts more source file paths than the Concat method. This method and the parameters it accepts are subject to change for usability in an upcoming version.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param msConcatDestinationPath The Data Lake Store path (starting with '/') of the destination file resulting from the concatenation.
     * @param streamContents A list of Data Lake Store paths (starting with '/') of the source files. Must be in the format: sources=&lt;comma separated list&gt;
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> msConcat(String accountName, String msConcatDestinationPath, byte[] streamContents) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Concatenates the list of source files into the destination file, deleting all source files upon success. This method accepts more source file paths than the Concat method. This method and the parameters it accepts are subject to change for usability in an upcoming version.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param msConcatDestinationPath The Data Lake Store path (starting with '/') of the destination file resulting from the concatenation.
     * @param streamContents A list of Data Lake Store paths (starting with '/') of the source files. Must be in the format: sources=&lt;comma separated list&gt;
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall msConcatAsync(String accountName, String msConcatDestinationPath, byte[] streamContents, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Concatenates the list of source files into the destination file, deleting all source files upon success. This method accepts more source file paths than the Concat method. This method and the parameters it accepts are subject to change for usability in an upcoming version.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param msConcatDestinationPath The Data Lake Store path (starting with '/') of the destination file resulting from the concatenation.
     * @param streamContents A list of Data Lake Store paths (starting with '/') of the source files. Must be in the format: sources=&lt;comma separated list&gt;
     * @param deleteSourceDirectory Indicates that as an optimization instead of deleting each individual source stream, delete the source stream folder if all streams are in the same folder instead. This results in a substantial performance improvement when the only streams in the folder are part of the concatenation operation. WARNING: This includes the deletion of any other files that are not source files. Only set this to true when source files are the only files in the source directory.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> msConcat(String accountName, String msConcatDestinationPath, byte[] streamContents, Boolean deleteSourceDirectory) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Concatenates the list of source files into the destination file, deleting all source files upon success. This method accepts more source file paths than the Concat method. This method and the parameters it accepts are subject to change for usability in an upcoming version.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param msConcatDestinationPath The Data Lake Store path (starting with '/') of the destination file resulting from the concatenation.
     * @param streamContents A list of Data Lake Store paths (starting with '/') of the source files. Must be in the format: sources=&lt;comma separated list&gt;
     * @param deleteSourceDirectory Indicates that as an optimization instead of deleting each individual source stream, delete the source stream folder if all streams are in the same folder instead. This results in a substantial performance improvement when the only streams in the folder are part of the concatenation operation. WARNING: This includes the deletion of any other files that are not source files. Only set this to true when source files are the only files in the source directory.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall msConcatAsync(String accountName, String msConcatDestinationPath, byte[] streamContents, Boolean deleteSourceDirectory, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Get the list of file status objects specified by the file path, with optional pagination parameters.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param listFilePath The Data Lake Store path (starting with '/') of the directory to list.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FileStatusesResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FileStatusesResult> listFileStatus(String accountName, String listFilePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Get the list of file status objects specified by the file path, with optional pagination parameters.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param listFilePath The Data Lake Store path (starting with '/') of the directory to list.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listFileStatusAsync(String accountName, String listFilePath, final ServiceCallback<FileStatusesResult> serviceCallback) throws IllegalArgumentException;
    /**
     * Get the list of file status objects specified by the file path, with optional pagination parameters.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param listFilePath The Data Lake Store path (starting with '/') of the directory to list.
     * @param listSize Gets or sets the number of items to return. Optional.
     * @param listAfter Gets or sets the item or lexographical index after which to begin returning results. For example, a file list of 'a','b','d' and listAfter='b' will return 'd', and a listAfter='c' will also return 'd'. Optional.
     * @param listBefore Gets or sets the item or lexographical index before which to begin returning results. For example, a file list of 'a','b','d' and listBefore='d' will return 'a','b', and a listBefore='c' will also return 'a','b'. Optional.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FileStatusesResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FileStatusesResult> listFileStatus(String accountName, String listFilePath, Integer listSize, String listAfter, String listBefore) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Get the list of file status objects specified by the file path, with optional pagination parameters.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param listFilePath The Data Lake Store path (starting with '/') of the directory to list.
     * @param listSize Gets or sets the number of items to return. Optional.
     * @param listAfter Gets or sets the item or lexographical index after which to begin returning results. For example, a file list of 'a','b','d' and listAfter='b' will return 'd', and a listAfter='c' will also return 'd'. Optional.
     * @param listBefore Gets or sets the item or lexographical index before which to begin returning results. For example, a file list of 'a','b','d' and listBefore='d' will return 'a','b', and a listBefore='c' will also return 'a','b'. Optional.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall listFileStatusAsync(String accountName, String listFilePath, Integer listSize, String listAfter, String listBefore, final ServiceCallback<FileStatusesResult> serviceCallback) throws IllegalArgumentException;

    /**
     * Gets the file content summary object specified by the file path.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param getContentSummaryFilePath The Data Lake Store path (starting with '/') of the file for which to retrieve the summary.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the ContentSummaryResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<ContentSummaryResult> getContentSummary(String accountName, String getContentSummaryFilePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Gets the file content summary object specified by the file path.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param getContentSummaryFilePath The Data Lake Store path (starting with '/') of the file for which to retrieve the summary.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getContentSummaryAsync(String accountName, String getContentSummaryFilePath, final ServiceCallback<ContentSummaryResult> serviceCallback) throws IllegalArgumentException;

    /**
     * Get the file status object specified by the file path.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param getFilePath The Data Lake Store path (starting with '/') of the file or directory for which to retrieve the status.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FileStatusResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FileStatusResult> getFileStatus(String accountName, String getFilePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Get the file status object specified by the file path.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param getFilePath The Data Lake Store path (starting with '/') of the file or directory for which to retrieve the status.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getFileStatusAsync(String accountName, String getFilePath, final ServiceCallback<FileStatusResult> serviceCallback) throws IllegalArgumentException;

    /**
     * Appends to the specified file. This method does not support multiple concurrent appends to the file. NOTE: Concurrent append and normal (serial) append CANNOT be used interchangeably. Once a file has been appended to using either append option, it can only be appended to using that append option. Use the ConcurrentAppend option if you would like support for concurrent appends.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to which to append.
     * @param streamContents The file contents to include when appending to the file.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> append(String accountName, String directFilePath, byte[] streamContents) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Appends to the specified file. This method does not support multiple concurrent appends to the file. NOTE: Concurrent append and normal (serial) append CANNOT be used interchangeably. Once a file has been appended to using either append option, it can only be appended to using that append option. Use the ConcurrentAppend option if you would like support for concurrent appends.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to which to append.
     * @param streamContents The file contents to include when appending to the file.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall appendAsync(String accountName, String directFilePath, byte[] streamContents, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Creates a file with optionally specified content.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to create.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> create(String accountName, String directFilePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Creates a file with optionally specified content.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to create.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall createAsync(String accountName, String directFilePath, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Creates a file with optionally specified content.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to create.
     * @param streamContents The file contents to include when creating the file. This parameter is optional, resulting in an empty file if not specified.
     * @param overwrite The indication of if the file should be overwritten.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> create(String accountName, String directFilePath, byte[] streamContents, Boolean overwrite) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Creates a file with optionally specified content.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to create.
     * @param streamContents The file contents to include when creating the file. This parameter is optional, resulting in an empty file if not specified.
     * @param overwrite The indication of if the file should be overwritten.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall createAsync(String accountName, String directFilePath, byte[] streamContents, Boolean overwrite, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Opens and reads from the specified file.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to open.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<InputStream> open(String accountName, String directFilePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Opens and reads from the specified file.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to open.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall openAsync(String accountName, String directFilePath, final ServiceCallback<InputStream> serviceCallback) throws IllegalArgumentException;
    /**
     * Opens and reads from the specified file.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to open.
     * @param length the Long value
     * @param offset the Long value
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the InputStream object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<InputStream> open(String accountName, String directFilePath, Long length, Long offset) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Opens and reads from the specified file.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param directFilePath The Data Lake Store path (starting with '/') of the file to open.
     * @param length the Long value
     * @param offset the Long value
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall openAsync(String accountName, String directFilePath, Long length, Long offset, final ServiceCallback<InputStream> serviceCallback) throws IllegalArgumentException;

    /**
     * Sets the Access Control List (ACL) for a file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setAclFilePath The Data Lake Store path (starting with '/') of the file or directory on which to set the ACL.
     * @param aclspec The ACL spec included in ACL creation operations in the format '[default:]user|group|other::r|-w|-x|-'
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> setAcl(String accountName, String setAclFilePath, String aclspec) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Sets the Access Control List (ACL) for a file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setAclFilePath The Data Lake Store path (starting with '/') of the file or directory on which to set the ACL.
     * @param aclspec The ACL spec included in ACL creation operations in the format '[default:]user|group|other::r|-w|-x|-'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall setAclAsync(String accountName, String setAclFilePath, String aclspec, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Modifies existing Access Control List (ACL) entries on a file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param modifyAclFilePath The Data Lake Store path (starting with '/') of the file or directory with the ACL being modified.
     * @param aclspec The ACL specification included in ACL modification operations in the format '[default:]user|group|other::r|-w|-x|-'
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> modifyAclEntries(String accountName, String modifyAclFilePath, String aclspec) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Modifies existing Access Control List (ACL) entries on a file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param modifyAclFilePath The Data Lake Store path (starting with '/') of the file or directory with the ACL being modified.
     * @param aclspec The ACL specification included in ACL modification operations in the format '[default:]user|group|other::r|-w|-x|-'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall modifyAclEntriesAsync(String accountName, String modifyAclFilePath, String aclspec, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Removes existing Access Control List (ACL) entries for a file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param removeAclFilePath The Data Lake Store path (starting with '/') of the file or directory with the ACL being removed.
     * @param aclspec The ACL spec included in ACL removal operations in the format '[default:]user|group|other'
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> removeAclEntries(String accountName, String removeAclFilePath, String aclspec) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Removes existing Access Control List (ACL) entries for a file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param removeAclFilePath The Data Lake Store path (starting with '/') of the file or directory with the ACL being removed.
     * @param aclspec The ACL spec included in ACL removal operations in the format '[default:]user|group|other'
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall removeAclEntriesAsync(String accountName, String removeAclFilePath, String aclspec, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Removes the existing Access Control List (ACL) of the specified file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param aclFilePath The Data Lake Store path (starting with '/') of the file or directory with the ACL being removed.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> removeAcl(String accountName, String aclFilePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Removes the existing Access Control List (ACL) of the specified file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param aclFilePath The Data Lake Store path (starting with '/') of the file or directory with the ACL being removed.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall removeAclAsync(String accountName, String aclFilePath, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Gets Access Control List (ACL) entries for the specified file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param aclFilePath The Data Lake Store path (starting with '/') of the file or directory for which to get the ACL.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the AclStatusResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<AclStatusResult> getAclStatus(String accountName, String aclFilePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Gets Access Control List (ACL) entries for the specified file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param aclFilePath The Data Lake Store path (starting with '/') of the file or directory for which to get the ACL.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall getAclStatusAsync(String accountName, String aclFilePath, final ServiceCallback<AclStatusResult> serviceCallback) throws IllegalArgumentException;

    /**
     * Deletes the requested file or directory, optionally recursively.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param filePath The Data Lake Store path (starting with '/') of the file or directory to delete.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FileOperationResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FileOperationResult> delete(String accountName, String filePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Deletes the requested file or directory, optionally recursively.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param filePath The Data Lake Store path (starting with '/') of the file or directory to delete.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteAsync(String accountName, String filePath, final ServiceCallback<FileOperationResult> serviceCallback) throws IllegalArgumentException;
    /**
     * Deletes the requested file or directory, optionally recursively.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param filePath The Data Lake Store path (starting with '/') of the file or directory to delete.
     * @param recursive The optional switch indicating if the delete should be recursive
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FileOperationResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FileOperationResult> delete(String accountName, String filePath, Boolean recursive) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Deletes the requested file or directory, optionally recursively.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param filePath The Data Lake Store path (starting with '/') of the file or directory to delete.
     * @param recursive The optional switch indicating if the delete should be recursive
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall deleteAsync(String accountName, String filePath, Boolean recursive, final ServiceCallback<FileOperationResult> serviceCallback) throws IllegalArgumentException;

    /**
     * Rename a file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param renameFilePath The Data Lake Store path (starting with '/') of the file or directory to move/rename.
     * @param destination The path to move/rename the file or folder to
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the FileOperationResult object wrapped in {@link ServiceResponse} if successful.
     */
    ServiceResponse<FileOperationResult> rename(String accountName, String renameFilePath, String destination) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Rename a file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param renameFilePath The Data Lake Store path (starting with '/') of the file or directory to move/rename.
     * @param destination The path to move/rename the file or folder to
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall renameAsync(String accountName, String renameFilePath, String destination, final ServiceCallback<FileOperationResult> serviceCallback) throws IllegalArgumentException;

    /**
     * Sets the owner of a file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setOwnerFilePath The Data Lake Store path (starting with '/') of the file or directory for which to set the owner.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> setOwner(String accountName, String setOwnerFilePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Sets the owner of a file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setOwnerFilePath The Data Lake Store path (starting with '/') of the file or directory for which to set the owner.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall setOwnerAsync(String accountName, String setOwnerFilePath, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Sets the owner of a file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setOwnerFilePath The Data Lake Store path (starting with '/') of the file or directory for which to set the owner.
     * @param owner The AAD Object ID of the user owner of the file or directory. If empty, the property will remain unchanged.
     * @param group The AAD Object ID of the group owner of the file or directory. If empty, the property will remain unchanged.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> setOwner(String accountName, String setOwnerFilePath, String owner, String group) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Sets the owner of a file or directory.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setOwnerFilePath The Data Lake Store path (starting with '/') of the file or directory for which to set the owner.
     * @param owner The AAD Object ID of the user owner of the file or directory. If empty, the property will remain unchanged.
     * @param group The AAD Object ID of the group owner of the file or directory. If empty, the property will remain unchanged.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall setOwnerAsync(String accountName, String setOwnerFilePath, String owner, String group, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

    /**
     * Sets the permission of the file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setPermissionFilePath The Data Lake Store path (starting with '/') of the file or directory for which to set the permission.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> setPermission(String accountName, String setPermissionFilePath) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Sets the permission of the file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setPermissionFilePath The Data Lake Store path (starting with '/') of the file or directory for which to set the permission.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall setPermissionAsync(String accountName, String setPermissionFilePath, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;
    /**
     * Sets the permission of the file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setPermissionFilePath The Data Lake Store path (starting with '/') of the file or directory for which to set the permission.
     * @param permission A string representation of the permission (i.e 'rwx'). If empty, this property remains unchanged.
     * @throws CloudException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponse} object if successful.
     */
    ServiceResponse<Void> setPermission(String accountName, String setPermissionFilePath, String permission) throws CloudException, IOException, IllegalArgumentException;

    /**
     * Sets the permission of the file or folder.
     *
     * @param accountName The Azure Data Lake Store account to execute filesystem operations on.
     * @param setPermissionFilePath The Data Lake Store path (starting with '/') of the file or directory for which to set the permission.
     * @param permission A string representation of the permission (i.e 'rwx'). If empty, this property remains unchanged.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link ServiceCall} object
     */
    ServiceCall setPermissionAsync(String accountName, String setPermissionFilePath, String permission, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException;

}
