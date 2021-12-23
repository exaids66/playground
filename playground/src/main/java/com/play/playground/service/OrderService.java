package com.play.playground.service;

import com.play.playground.util.Result;
import com.play.playground.vo.AttendVO;
import com.play.playground.vo.OrderResultVO;
import com.play.playground.vo.OrderSearchVO;
import com.play.playground.vo.OrderVO;

import java.util.List;

public interface OrderService {

    Result order(OrderVO orderVO);

    Result attend(AttendVO attendVO);

    List<OrderResultVO> searchOrder(OrderSearchVO orderSearchVO);
}
