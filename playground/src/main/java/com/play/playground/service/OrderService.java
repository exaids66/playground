package com.play.playground.service;

import com.play.playground.util.Result;
import com.play.playground.vo.AttendVO;
import com.play.playground.vo.OrderVO;

public interface OrderService {

    Result order(OrderVO orderVO);

    Result attend(AttendVO attendVO);


}
