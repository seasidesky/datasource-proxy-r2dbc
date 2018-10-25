package net.ttddyy.dsproxy.r2dbc.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Copy from datasource-proxy
 * @author Tadaya Tsuyukubo
 */
public class CompositeProxyExecutionListener implements ProxyExecutionListener {
    private List<ProxyExecutionListener> listeners = new ArrayList<>();

    @Override
    public void beforeMethod(MethodExecutionInfo executionInfo) {
        this.listeners.forEach(listener -> listener.beforeMethod(executionInfo));
    }

    @Override
    public void afterMethod(MethodExecutionInfo executionInfo) {
        this.listeners.forEach(listener -> listener.afterMethod(executionInfo));
    }

    @Override
    public void beforeQuery(QueryExecutionInfo execInfo) {
        this.listeners.forEach(listener -> listener.beforeQuery(execInfo));
    }

    @Override
    public void afterQuery(QueryExecutionInfo execInfo) {
        this.listeners.forEach(listener -> listener.afterQuery(execInfo));
    }

    public boolean add(ProxyExecutionListener listener) {
        return this.listeners.add(listener);
    }

    public boolean addAll(Collection<ProxyExecutionListener> listeners) {
        return this.listeners.addAll(listeners);
    }

    public List<ProxyExecutionListener> getListeners() {
        return this.listeners;
    }

//    public void setListeners(List<ProxyExecutionListener> listeners) {
//        this.listeners = listeners;
//    }

}