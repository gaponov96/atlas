package com.gaponov.jira.workflow;

import com.opensymphony.workflow.loader.AbstractDescriptor;
import com.opensymphony.workflow.loader.ValidatorDescriptor;
import com.atlassian.jira.plugin.workflow.AbstractWorkflowPluginFactory;
import com.atlassian.jira.plugin.workflow.WorkflowPluginValidatorFactory;
import java.util.HashMap;
import java.util.Map;

public class MyWorkflowValidatorFactory extends AbstractWorkflowPluginFactory implements WorkflowPluginValidatorFactory
{
    public static final String FIELD_WORD="word";
   // public static final String FIELD_TWO_WORD="twoword";

    protected void getVelocityParamsForInput(Map velocityParams)
    {
        //the default message
        //velocityParams.put(FIELD_WORD, "test");
        //velocityParams.put(FIELD_TWO_WORD, "test2");
    }

    protected void getVelocityParamsForEdit(Map velocityParams, AbstractDescriptor descriptor)
    {
        getVelocityParamsForInput(velocityParams);
        getVelocityParamsForView(velocityParams, descriptor);
    }

    protected void getVelocityParamsForView(Map velocityParams, AbstractDescriptor descriptor)
    {
        if (!(descriptor instanceof ValidatorDescriptor))
        {
            throw new IllegalArgumentException("Descriptor must be a ValidatorDescriptor.");
        }

        ValidatorDescriptor validatorDescriptor = (ValidatorDescriptor)descriptor;

       /* velocityParams.put(FIELD_WORD, validatorDescriptor.getArgs().get(FIELD_WORD));*/
        //velocityParams.put(FIELD_TWO_WORD, validatorDescriptor.getArgs().get(FIELD_TWO_WORD));
    }

    public Map getDescriptorParams(Map validatorParams)
    {
        // Process The map
        Map params = new HashMap();
       // params.put(FIELD_WORD, extractSingleParam(validatorParams, FIELD_WORD));
        //params.put(FIELD_TWO_WORD, extractSingleParam(validatorParams, FIELD_TWO_WORD));
        return params;
    }
}
