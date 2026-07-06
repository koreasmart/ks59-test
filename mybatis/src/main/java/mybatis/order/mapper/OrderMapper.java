package mybatis.order.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

	// 상품번호로 주문상세 삭제
	int deleteOrderItemsByProductCode(String productCode);
	
	// 주문상세 데이터가 없는 주문번호 삭제
	int deleteOrderIsNotExistsOrderItems();
	
}
