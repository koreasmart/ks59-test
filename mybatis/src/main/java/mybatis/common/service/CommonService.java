package mybatis.common.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import mybatis.common.dto.CommonCode;
import mybatis.common.mapper.CommonMapper;

@Service
@RequiredArgsConstructor
public class CommonService {

	private final CommonMapper commonMapper;
	
	@Transactional
	public List<CommonCode> getCommonCodeListByGroupCode(String groupCode){
		return commonMapper.findAllByGroupCode(groupCode);
	}
}







