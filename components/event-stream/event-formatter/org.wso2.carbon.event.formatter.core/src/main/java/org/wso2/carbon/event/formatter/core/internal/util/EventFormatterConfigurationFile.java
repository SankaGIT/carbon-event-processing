/*
*  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.event.formatter.core.internal.util;

import org.apache.axis2.engine.AxisConfiguration;

/**
 * To create objects of event adaptor file details
 */
public class EventFormatterConfigurationFile {

    private String fileName;

    private String eventFormatterName;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public enum Status {DEPLOYED, WAITING_FOR_DEPENDENCY, WAITING_FOR_STREAM_DEPENDENCY, ERROR}

    //Deployed, Waiting for Dependency, Error
    private Status status;

    private String dependency;

    //private boolean success;

    private String deploymentStatusMessage = "";

    private AxisConfiguration axisConfiguration;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDependency() {
        return dependency;
    }

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    public String getDeploymentStatusMessage() {
        return deploymentStatusMessage;
    }

    public void setDeploymentStatusMessage(String deploymentStatusMessage) {
        this.deploymentStatusMessage = deploymentStatusMessage;
    }

    public AxisConfiguration getAxisConfiguration() {
        return axisConfiguration;
    }

    public void setAxisConfiguration(AxisConfiguration axisConfiguration) {
        this.axisConfiguration = axisConfiguration;
    }

    public String getEventFormatterName() {
        return eventFormatterName;
    }

    public void setEventFormatterName(String eventFormatterName) {
        this.eventFormatterName = eventFormatterName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
