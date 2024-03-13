package com.gaponov.jira.webwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.web.action.JiraWebActionSupport;

public class VideoWorkerAction extends JiraWebActionSupport
{
    private static final Logger log = LoggerFactory.getLogger(VideoWorkerAction.class);

    @Override
    public String execute() throws Exception {
        System.out.println("привет");
        return super.execute(); //returns SUCCESS
    }
}
