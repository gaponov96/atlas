package com.gaponov.jira.workflow;

import com.riadalabs.jira.plugins.insight.channel.external.api.facade.ObjectFacade;
import com.riadalabs.jira.plugins.insight.services.model.ObjectBean;

public class MyPluginResource {


    private final ObjectFacade objectFacade;


    public MyPluginResource(final ObjectFacade objectFacade) {
        this.objectFacade = objectFacade;
    }

    public ObjectBean getInsightObject(String key) throws Exception {
        return objectFacade.loadObjectBean(key);
    }

}
