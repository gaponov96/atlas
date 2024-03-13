package com.gaponov.jira.workflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.issue.Issue;
import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.workflow.Validator;
import com.opensymphony.workflow.InvalidInputException;
import java.util.Map;

public class MyWorkflowValidator implements Validator
{
    public void validate(Map transientVars, Map args, PropertySet ps) throws InvalidInputException
    {
        String word = "привет";
        Issue issue = (Issue)transientVars.get("issue");
        String description = issue.getDescription();

        if (description == null || !description.contains(word)) {
            throw new InvalidInputException("Issue must contain the word '" + word + "' in the description");
        }
    }
}
