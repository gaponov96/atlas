package com.gaponov.jira.workflow;

import com.atlassian.jira.plugin.workflow.AbstractWorkflowPluginFactory;
import com.atlassian.jira.plugin.workflow.WorkflowPluginFunctionFactory;
import com.atlassian.jira.workflow.JiraWorkflow;
import com.atlassian.jira.workflow.WorkflowManager;
import com.opensymphony.workflow.loader.*;
import webwork.action.ActionContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the factory class responsible for dealing with the UI for the post-function.
 * This is typically where you put default values into the velocity context and where you store user input.
 */

public class CreateWordFactory extends AbstractWorkflowPluginFactory implements WorkflowPluginFunctionFactory
{
    public static final String FIELD_MESSAGE = "messageField";


    public CreateWordFactory() {

    }

    @Override
    protected void getVelocityParamsForInput(Map<String, Object> velocityParams) {
        Map<String, String[]> myParams = ActionContext.getParameters();

        System.out.println("777getVelocityParamsForInput");


    }

    @Override
    protected void getVelocityParamsForEdit(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
        getVelocityParamsForInput(velocityParams);
        getVelocityParamsForView(velocityParams, descriptor);
        System.out.println("777getVelocityParamsForEdit");
    }

    @Override
    protected void getVelocityParamsForView(Map<String, Object> velocityParams, AbstractDescriptor descriptor) {
        System.out.println("777getVelocityParamsForView");
        if (!(descriptor instanceof FunctionDescriptor)) {
            throw new IllegalArgumentException("Descriptor must be a FunctionDescriptor.");
        }

        FunctionDescriptor functionDescriptor = (FunctionDescriptor)descriptor;
        String message = (String)functionDescriptor.getArgs().get(FIELD_MESSAGE);

        if (message == null) {
            message = "No Message";
        }

        velocityParams.put(FIELD_MESSAGE,message);
    }


    public Map<String,?> getDescriptorParams(Map<String, Object> formParams) {
        System.out.println("777getDescriptorParams");
        Map params = new HashMap();

        // Process The map
        String message = extractSingleParam(formParams,FIELD_MESSAGE);
        params.put(FIELD_MESSAGE,message);

        return params;
    }

}