package com.gaponov.jira.workflow;
import java.sql.Timestamp;
import java.util.Map;
import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.workflow.function.issue.AbstractJiraFunctionProvider;
import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.module.random.Test;
import com.opensymphony.workflow.WorkflowException;
import com.atlassian.jira.component.ComponentAccessor;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.inject.Inject;

/**
 * This is the post-function class that gets executed at the end of the transition.
 * Any parameters that were saved in your factory class will be available in the transientVars Map.
 */

public class CreateWord extends AbstractJiraFunctionProvider
{
    private static final Logger log = LoggerFactory.getLogger(CreateWord.class);
    public static final String FIELD_MESSAGE = "messageField";
    TestBean testBean;

    @Inject
    public CreateWord(TestBean testBean) {
        this.testBean = testBean;
        log.error("G%%%% {}", testBean);
    }

    public void execute(Map transientVars, Map args, PropertySet ps) throws WorkflowException
    {
        System.out.println(testBean + "text");
        log.error("G%%%% {}", testBean);
        log.error("tv {}", transientVars);
        log.error("args = {}", args);
        log.error("ps = {}", ps);

        MutableIssue issue = getIssue(transientVars);
        String message = (String)transientVars.get(FIELD_MESSAGE);

        if (null == message) {
            message = "test";
        }

        CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager();
        CustomField customField = customFieldManager.getCustomFieldObject("customfield_10000");
        CustomField customField1 = customFieldManager.getCustomFieldObject("customfield_10001");
        CustomField customField2 = customFieldManager.getCustomFieldObject("customfield_10000");
        System.out.println(customField);
/*        if (issue.getDescription() != null) {
            issue.setDescription(issue.getDescription()  + issue.getReporterId() + "\n ID проекта = " + issue.getProjectObject().getKey().toString() + "\n \n Дата " + customField.getValue(issue)
                    + " \n Селект лист = " + customField1.getValue(issue) + "\n Текстовое = " + customField2.getValue(issue));
        } else {
            issue.setDescription(issue.getReporterId() + "\n ID проекта = " + issue.getProjectObject().getKey().toString() + " Дата " + customField.getValue(issue)
                    + "\n Селект лист = " + customField1.getValue(issue) + "\n Текстовое = " + customField2.getValue(issue));
        }*/

        System.out.println(customField.getCustomFieldType());

        Object customFieldValue = issue.getCustomFieldValue(customField);
        System.out.println(customFieldValue.getClass());

        if (customFieldValue != null && customFieldValue instanceof Timestamp) {
            Timestamp timestamp = (Timestamp) customFieldValue; //downcasting
            issue.setDescription(String.valueOf(timestamp.getTime()));
        }
    }
}