package com.stone.util;

import org.apache.commons.lang.StringUtils;




/**
 * 网段信息对象
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  Administrator
 * @version  [版本号, 2013-9-22]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class CUIPUtil
{
    //TODO 需完善: 暂时只接受联通号码为合法号码
    private static final String[] VALID_UNI_IP_PREFIX = new String[] {"122.194.0", "122.194.1", "122.194.2",
        "122.194.3", "122.194.35", "122.194.36", "122.194.37", "122.194.38", "122.194.39", "122.194.40" };

    
    /**
     * 网段匹配
     * 根据参数值，匹配网段池中的数据，如果网段池中找到匹配记录，则返回true，否则返回false
     * @param ip
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean validIP(String ip) {
        
        if (!StringUtils.isEmpty(ip))
        {
            ip = ip.substring(0, ip.lastIndexOf("."));
            for (String cuJS : VALID_UNI_IP_PREFIX)
            {
                if (ip.equals(cuJS))
                    return true;
            }
        }
        
        return false;
    }
}
