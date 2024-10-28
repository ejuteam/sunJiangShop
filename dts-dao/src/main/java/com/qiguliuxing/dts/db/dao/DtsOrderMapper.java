package com.qiguliuxing.dts.db.dao;

import com.qiguliuxing.dts.db.domain.DtsOrder;
import com.qiguliuxing.dts.db.domain.DtsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DtsOrderMapper {
    List<DtsOrder> queryOrderList(@Param("dtsOrder") DtsOrder dtsOrder, @Param("orderStatusArray") List<Short> orderStatusArray);

    void updateOrderStatusById (DtsOrder order);
}