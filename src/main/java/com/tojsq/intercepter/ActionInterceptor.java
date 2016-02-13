/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tojsq.intercepter;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;



/**
 *
 * @author tanglin
 */
@Action
@Interceptor
public class ActionInterceptor implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @AroundInvoke
    public Object exec(final InvocationContext ctx) throws Exception {
        try {
            return ctx.proceed();
        } catch (Throwable t) {
            throw t;
        } finally {
        }
    }
}
