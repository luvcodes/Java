package cn.itcast.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ryanw
 */ // 确定过滤器的顺序，数字越小，优先级越高
//@Order(-1)
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 1. 获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        // 2. 获取参数中的authorization参数
        MultiValueMap<String, String> params = request.getQueryParams();
        String auth = params.getFirst("authorization");
        // 3. 判断参数值是否等于admin
        if ("admin".equals(auth)) {
            // 4. 是，放行
            // 这里的filter方法就是通过GatewayFilterChain找到下一个过滤器，找到下一个过滤器，调用下一个过滤器的filter方法，等于放行了。
            return chain.filter(exchange);
        }
        // 5. 否，拦截
        // 5.1 设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        // 5.2 拦截并返回结果
        return exchange.getResponse().setComplete();
    }


    // 跟在类上面用Ordered注解效果完全一样
    @Override
    public int getOrder() {
        return -1;
    }
}
