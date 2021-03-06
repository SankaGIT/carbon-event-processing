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
package org.wso2.carbon.event.input.adaptor.websocket.local.internal.ds;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.event.input.adaptor.core.InputEventAdaptorFactory;
import org.wso2.carbon.event.input.adaptor.websocket.local.WebsocketLocalEventAdaptorFactory;
import org.wso2.carbon.event.input.adaptor.websocket.local.WebsocketLocalInputService;

/**
 * @scr.component name="input.websocketInputService.component" immediate="true"
 */
public class WebsocketEventAdaptorServiceDS {

    private static final Log log = LogFactory.getLog(WebsocketEventAdaptorServiceDS.class);

    /**
     * initialize the agent service here.
     *
     * @param context
     */
    protected void activate(ComponentContext context) {
        try {
            InputEventAdaptorFactory websocketLocalEventAdaptorFactory = new WebsocketLocalEventAdaptorFactory();
            context.getBundleContext().registerService(InputEventAdaptorFactory.class.getName(), websocketLocalEventAdaptorFactory, null);
            if (log.isDebugEnabled()) {
                log.debug("Successfully deployed the input websocket adaptor service");
            }
        } catch (RuntimeException e) {
            log.error("Can not create the input websocket adaptor service ", e);
        }
        try {
            WebsocketLocalInputService websocketLocalInputService = new WebsocketLocalInputService();
            context.getBundleContext().registerService(WebsocketLocalInputService.class.getName(), websocketLocalInputService, null);
            if (log.isDebugEnabled()) {
                log.debug("Successfully deployed the input Websocket Input Service");
            }
        } catch (RuntimeException e) {
            log.error("Can not create Websocket Input Service ", e);
        }
    }
}
