package mybatis.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import mybatis.common.dto.CommonCode;

@Mapper
public interface CommonMapper {

	// 공통코드조회
	List<CommonCode> findAllByGroupCode(@Param("groupCode") String groupCode);
}










