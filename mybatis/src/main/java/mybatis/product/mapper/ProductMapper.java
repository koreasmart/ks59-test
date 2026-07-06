package mybatis.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mybatis.product.domain.Product;

@Mapper
public interface ProductMapper {
	// 상품삭제
	int deleteProductByProductCode(String productCode);
	
	// 상품정보수정
	// 매개변수 갯수가 2개 이상일 경우 반드시 @Param 작성해야한다.
	int modifyProduct(@Param("product") Product product, @Param("productCode") String productCode);
	
	// 상품정보조회
	Product findByCode(String productCode);
	
	// 상품목록조회
	List<Product> findAll();

	// 상품등록
	int addProduct(Product product);
}
