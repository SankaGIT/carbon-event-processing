/*
*  Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.carbon.event.input.adapter.email;

import org.wso2.carbon.event.input.adapter.core.*;
import org.wso2.carbon.event.input.adapter.core.MessageType;
import org.wso2.carbon.event.input.adapter.core.Property;
import org.wso2.carbon.event.input.adapter.email.internal.util.EmailEventAdapterConstants;

import java.util.*;

public class EmailEventAdapterFactory extends InputEventAdapterFactory {

    private ResourceBundle resourceBundle = ResourceBundle.getBundle
            ("org.wso2.carbon.event.input.adapter.email.i18n.Resources", Locale.getDefault());

    @Override
    public String getType() {
        return EmailEventAdapterConstants.ADAPTER_TYPE_EMAIL;
    }

    @Override
    public List<String> getSupportedMessageFormats() {
        List<String> supportInputMessageTypes = new ArrayList<String>();

        supportInputMessageTypes.add(MessageType.XML);
        supportInputMessageTypes.add(MessageType.JSON);
        supportInputMessageTypes.add(MessageType.MAP);
        supportInputMessageTypes.add(MessageType.TEXT);

        return supportInputMessageTypes;
    }

    @Override
    public List<Property> getPropertyList() {
        List<Property> propertyList = new ArrayList<Property>();

        // set receiving mail address
        Property emailAddress = new Property(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_ADDRESS);
        emailAddress.setDisplayName(
                resourceBundle.getString(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_ADDRESS));
        emailAddress.setRequired(true);
        emailAddress.setHint(resourceBundle.getString(
                EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_ADDRESS_HINT));
        propertyList.add(emailAddress);

        // set receiving mail protocol
        Property protocol = new Property(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_PROTOCOL);
        protocol.setDisplayName(
                resourceBundle.getString(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_PROTOCOL));

        protocol.setOptions(new String[]{"pop3", "imap"});
        protocol.setDefaultValue("imap");
        protocol.setHint(resourceBundle.getString(
                EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_PROTOCOL_HINT));
        propertyList.add(protocol);

        // set receiving mail poll interval
        Property pollInterval = new Property(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_POLL_INTERVAL);
        pollInterval.setDisplayName(
                resourceBundle.getString(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_POLL_INTERVAL));
        pollInterval.setRequired(true);
        pollInterval.setHint(resourceBundle.getString(
                EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_POLL_INTERVAL_HINT));
        propertyList.add(pollInterval);

        // set receiving mail host
        Property host = new Property(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_PROTOCOL_HOST);
        host.setDisplayName(
                resourceBundle.getString(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_PROTOCOL_HOST));
        host.setRequired(true);
        propertyList.add(host);

        // set receiving mail host
        Property port = new Property(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_PROTOCOL_PORT);
        port.setDisplayName(
                resourceBundle.getString(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_PROTOCOL_PORT));
        port.setRequired(true);
        propertyList.add(port);

        // set receiving mail username
        Property userName = new Property(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_USERNAME);
        userName.setDisplayName(
                resourceBundle.getString(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_USERNAME));
        userName.setRequired(true);
        propertyList.add(userName);

        // set receiving mail password
        Property password = new Property(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_PASSWORD);
        password.setDisplayName(
                resourceBundle.getString(EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_PASSWORD));
        password.setRequired(true);
        password.setSecured(true);
        propertyList.add(password);

        // set receiving mail socket factory class
        Property socketFactoryClass = new Property(
                EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_SOCKET_FACTORY_CLASS);
        socketFactoryClass.setDisplayName(
                resourceBundle.getString(
                        EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_SOCKET_FACTORY_CLASS));
        socketFactoryClass.setRequired(true);
        propertyList.add(socketFactoryClass);

        // set receiving mail socket factory fallback
        Property socketFactoryFallback = new Property(
                EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_SOCKET_FACTORY_FALLBACK);
        socketFactoryFallback.setDisplayName(
                resourceBundle.getString(
                        EmailEventAdapterConstants.ADAPTER_CONF_RECEIVING_EMAIL_SOCKET_FACTORY_FALLBACK));
        socketFactoryFallback.setRequired(true);
        socketFactoryFallback.setOptions(new String[]{"true", "false"});
        socketFactoryFallback.setDefaultValue("false");
        propertyList.add(socketFactoryFallback);

        // set incoming email subject
        Property subject = new Property(EmailEventAdapterConstants.ADAPTER_MESSAGE_RECEIVING_EMAIL_SUBJECT);
        subject.setDisplayName(
                resourceBundle.getString(EmailEventAdapterConstants.ADAPTER_MESSAGE_RECEIVING_EMAIL_SUBJECT));
        subject.setRequired(true);
        subject.setHint(resourceBundle.getString(
                EmailEventAdapterConstants.ADAPTER_MESSAGE_RECEIVING_EMAIL_SUBJECT_HINT));

        propertyList.add(subject);


        return propertyList;
    }

    @Override
    public InputEventAdapter createEventAdapter(InputEventAdapterConfiguration eventAdapterConfiguration,
                                                Map<String, String> globalProperties) {
        return new EmailEventAdapter(eventAdapterConfiguration, globalProperties);
    }
}
