package jksj.wangzeng.modeling.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author swsm
 * @date 2020/12/19
 */
public class DynamicProxyHandler implements InvocationHandler {
    
    private Object proxiedObject;
    
    public DynamicProxyHandler(Object proxiedObject) {
        this.proxiedObject = proxiedObject;
    }
    
    public static Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        final DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, dynamicProxyHandler);
    }
    
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = null;
        if (method.getName().equals("see")) {
            System.out.println("我先看看一下");
            res = method.invoke(proxiedObject, args);
            System.out.println("我看完了");
            return res;
        }
        return method.invoke(proxiedObject, args);
    }
}
