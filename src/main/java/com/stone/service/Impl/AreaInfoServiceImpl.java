/**
 * 
 */
package com.stone.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.stone.dao.AreaInfoDao;
import com.stone.pojo.AreaInfo;
import com.stone.pojo.ScenicAreaInfo;
import com.stone.service.AreaInfoService;

/**
 * @author  冯亚军
 * @version  [版本号, 2016-4-26]
 */
@Service("AreaInfoService")
public class AreaInfoServiceImpl implements AreaInfoService {
	
	private static final Log log = LogFactory.getLog(AreaInfoServiceImpl.class);
	
	@Resource(name="AreaInfoDao")
	private AreaInfoDao areaInfoDao;

	@Override
	public List<AreaInfo> queryAreaInfo() {
		List<AreaInfo> list = null;
		try {
			list = areaInfoDao.queryAreaInfo();
		} catch (Exception e) {
			// TODO: handle exception
			if (log.isErrorEnabled()) {
				log.error(
						String.format("query unsuccessfully: %s",
								e.getMessage()), e);
			}
		}
		return list;
	}

	@Override
	public List<ScenicAreaInfo> queryScenicAreaInfo() {
		List<ScenicAreaInfo> list = null;
		try {
			list = areaInfoDao.queryScenicAreaInfo();
		} catch (Exception e) {
			// TODO: handle exception
			if (log.isErrorEnabled()) {
				log.error(
						String.format("query unsuccessfully: %s",
								e.getMessage()), e);
			}
		}
		return list;
	}

}
