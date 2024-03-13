package com.gaponov.jira.jql;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.comments.Comment;
import com.atlassian.jira.issue.comments.CommentManager;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.query.clause.Clause;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.atlassian.jira.JiraDataType;
import com.atlassian.jira.JiraDataTypes;
import com.atlassian.jira.jql.operand.QueryLiteral;
import com.atlassian.jira.jql.query.QueryCreationContext;
import com.atlassian.jira.plugin.jql.function.AbstractJqlFunction;
import com.atlassian.jira.util.MessageSet;
import com.atlassian.query.clause.TerminalClause;
import com.atlassian.query.operand.FunctionOperand;
import com.google.common.collect.Iterables;
import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public class LastCommentJql extends AbstractJqlFunction
{
    // Добавляем необходимые зависимости
    private final CommentManager commentManager;
    private final JiraAuthenticationContext authenticationContext;

    public LastCommentJql(CommentManager commentManager, JiraAuthenticationContext authenticationContext) {
        this.commentManager = commentManager;
        this.authenticationContext = authenticationContext;
    }

    @Nonnull
    @Override
    public MessageSet validate(ApplicationUser applicationUser, @Nonnull FunctionOperand functionOperand, @Nonnull TerminalClause terminalClause) {
        return null;
    }

    public List<QueryLiteral> getValues(QueryCreationContext queryCreationContext, FunctionOperand operand, TerminalClause terminalClause)
    {
        QueryObjectModel qom = queryCreationContext.toQueryObjectModel();
        Clause[] clauses = qom.getClauses();
        QueryObjectNode mainNode = clauses[0];

        String jqlString = mainNode.toString();
        int indexStart = jqlString.indexOf('"') + 1;
        int indexEnd = jqlString.lastIndexOf('"');
        String jqlId = jqlString.substring(indexStart, indexEnd);

        Issue issue = findIssueByJqlId(jqlId);
        ApplicationUser user = authenticationContext.getLoggedInUser();

        // Получаем последний комментарий к задаче
        Comment lastComment = commentManager.getLastComment(issue, user);

        if (lastComment != null) {
            // Возвращаем текст последнего комментария в виде QueryLiteral
            return Collections.singletonList(new QueryLiteral(operand, lastComment.getBody()));
        } else {
            return Collections.emptyList();
        }
    }

    public int getMinimumNumberOfExpectedArguments()
    {
        return 0; // Можно изменить на 0, если функция должна работать без аргументов
    }

    public JiraDataType getDataType()
    {
        return JiraDataTypes.TEXT;
    }

    private Issue findIssueByJqlId(String jqlId) {
        SearchContext searchContext = new SearchContextImpl();
        SearchRequest searchRequest = SearchFactory.getSearchFactory(searchContext).createSearchRequest();
        searchRequest.setJql(jqlId);
        searchRequest.setMaxResults(1);

        SearchResult result = searchRequest.execute();
        if (!result.getErrors().hasNext()) {
            Collection<Issue> issues = result.getIssues();
            if (!issues.isEmpty()) {
                return issues.iterator().next();
            }
        }
        throw new RuntimeException("Unable to find issue by given JQL");
    }
}}