package com.sky.task;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 定时任务类，定时处理订单状态
 */

@Component
@Slf4j
public class OrderTask {

    @Autowired
    private OrderMapper orderMapper;

    /**
     *  handle overtime order
     */
    @Scheduled(cron = "0 * * * * ?")
    public void processTimeOutOrder() {
        log.info("定时处理超时订单: {}", LocalDateTime.now());

        LocalDateTime time = LocalDateTime.now().plusMinutes(-15);

        List<Orders> ordersList = orderMapper.getByStatusAndOrderTimeLT(Orders.PENDING_PAYMENT, time);

        if(ordersList.size()>0 && ordersList!=null) {
            for (Orders orders : ordersList) {
                orders.setStatus(Orders.CANCELLED);
                orders.setCancelReason("订单超时，自动取消");
                orders.setCancelTime(LocalDateTime.now());
                //TODO add update method
//                orderMapper.update(orders);
            }

        }




    }
}
