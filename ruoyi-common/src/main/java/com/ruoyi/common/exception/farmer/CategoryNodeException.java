package com.ruoyi.common.exception.farmer;

import com.ruoyi.common.exception.base.BaseException;
import com.ruoyi.common.exception.user.UserException;

/**
 * 分类节点异常
 * @author huixh
 */
public class CategoryNodeException extends BaseException {
    public CategoryNodeException(String code, Object[] args,String defaultMessage)
    {
        super("farmer",code, args,defaultMessage);
    }
}
