package net.ttddyy.dsproxy.r2dbc.core;

import net.ttddyy.dsproxy.r2dbc.support.LastExecutionAwareListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * @author Tadaya Tsuyukubo
 */
public class CompositeProxyExecutionListenerTest {

    private LastExecutionAwareListener listener1;
    private LastExecutionAwareListener listener2;

    private CompositeProxyExecutionListener compositeListener;

    @BeforeEach
    void setUp() {
        this.listener1 = new LastExecutionAwareListener();
        this.listener2 = new LastExecutionAwareListener();

        this.compositeListener = new CompositeProxyExecutionListener(this.listener1, this.listener2);
    }

    @Test
    void onQueryExecution() {

        QueryExecutionInfo executionInfo = new QueryExecutionInfo();
        executionInfo.setProxyEventType(ProxyEventType.BEFORE_QUERY);

        this.compositeListener.onQueryExecution(executionInfo);

        assertSame(executionInfo, this.listener1.getBeforeQueryExecutionInfo());
        assertSame(executionInfo, this.listener2.getBeforeQueryExecutionInfo());


        executionInfo.setProxyEventType(ProxyEventType.AFTER_QUERY);
        this.compositeListener.onQueryExecution(executionInfo);

        assertSame(executionInfo, this.listener1.getAfterQueryExecutionInfo());
        assertSame(executionInfo, this.listener2.getAfterQueryExecutionInfo());

    }

    @Test
    void onMethodExecution() {

        MethodExecutionInfo executionInfo = new MethodExecutionInfo();
        executionInfo.setProxyEventType(ProxyEventType.BEFORE_METHOD);

        this.compositeListener.onMethodExecution(executionInfo);

        assertSame(executionInfo, this.listener1.getBeforeMethodExecutionInfo());
        assertSame(executionInfo, this.listener2.getBeforeMethodExecutionInfo());


        executionInfo.setProxyEventType(ProxyEventType.AFTER_METHOD);
        this.compositeListener.onMethodExecution(executionInfo);

        assertSame(executionInfo, this.listener1.getAfterMethodExecutionInfo());
        assertSame(executionInfo, this.listener2.getAfterMethodExecutionInfo());

    }

    @Test
    void beforeMethod() {

        MethodExecutionInfo executionInfo = new MethodExecutionInfo();
        executionInfo.setProxyEventType(ProxyEventType.BEFORE_METHOD);

        this.compositeListener.beforeMethod(executionInfo);

        assertSame(executionInfo, this.listener1.getBeforeMethodExecutionInfo());
        assertSame(executionInfo, this.listener2.getBeforeMethodExecutionInfo());

    }

    @Test
    void afterMethod() {

        MethodExecutionInfo executionInfo = new MethodExecutionInfo();
        executionInfo.setProxyEventType(ProxyEventType.AFTER_METHOD);

        this.compositeListener.afterMethod(executionInfo);

        assertSame(executionInfo, this.listener1.getAfterMethodExecutionInfo());
        assertSame(executionInfo, this.listener2.getAfterMethodExecutionInfo());

    }

    @Test
    void beforeQuery() {

        QueryExecutionInfo executionInfo = new QueryExecutionInfo();
        executionInfo.setProxyEventType(ProxyEventType.BEFORE_QUERY);

        this.compositeListener.beforeQuery(executionInfo);

        assertSame(executionInfo, this.listener1.getBeforeQueryExecutionInfo());
        assertSame(executionInfo, this.listener2.getBeforeQueryExecutionInfo());

    }

    @Test
    void afterQuery() {

        QueryExecutionInfo executionInfo = new QueryExecutionInfo();
        executionInfo.setProxyEventType(ProxyEventType.AFTER_QUERY);

        this.compositeListener.afterQuery(executionInfo);

        assertSame(executionInfo, this.listener1.getAfterQueryExecutionInfo());
        assertSame(executionInfo, this.listener2.getAfterQueryExecutionInfo());

    }

    @Test
    void eachQueryResult() {

        QueryExecutionInfo executionInfo = new QueryExecutionInfo();
        executionInfo.setProxyEventType(ProxyEventType.EACH_QUERY_RESULT);

        this.compositeListener.eachQueryResult(executionInfo);

        assertSame(executionInfo, this.listener1.getEachQueryResultExecutionInfo());
        assertSame(executionInfo, this.listener2.getEachQueryResultExecutionInfo());

    }


}
