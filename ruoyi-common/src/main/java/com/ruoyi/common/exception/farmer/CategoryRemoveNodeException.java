package com.ruoyi.common.exception.farmer;

/**
 * 分类节点异常
 * @author huixh
 */
public class CategoryRemoveNodeException extends CategoryNodeException{
    public CategoryRemoveNodeException() {
        super("farmer.products.hasNode", null, null);
    }
}
